package undelayedRandomAlgorithm;

import client.ClientData;

/**
 *
 * @author Vivek Mangla
 */
/**
 * Insert is to insert data at a particular index.<br>
 * It inserts data with a property that if the index is preoccupied , data over here 
 * will be shifted ahead and new data will be stored at this position and so on for 
 * the data on rest of the indexes untill the next_incremented index is empty.
 * <br>
 * In normal scenario, for above property to be fulfilled ,time complexity may reach O(n)<br>
 * but URA(UnDelayed Random Algorithm) does above work in same time complexity as
 * in case of normal insert(insert on empty position) by underlying data structure.
 * But there are few restrictions on to which data structure can be used .<br>For the time being ,
 * it can be said that due to it's path traversal property ,it will work on AVL_TREE ,
 * Linked List , Binary Trees .Among these I have implemented URA on AVL TREE and checked
 * for it's feasibility on Linked List ,Binary Trees on Paper.<br><br>
 * 
 * In below AVL TREE as base implementation ,Time Complexity is Non-Amortized O(log n) in every case, where <br>
 * n=Number of elements present for the time being and not the last index .
 * 
 */
public class Insert {
    
     long lastIndex=-1l;/*Track the last Index inseted.-1 means nothing has been inserted till now.*/
     long numberOfElements=0l;/*Total number of elements inserted till now.-1 if none.*/
     private boolean insertFlag=false;/*Sets to true when index to be filled is preoccupied.*/
     /**
      * Sets to true during rectification of indexes beyond currently inserted index's 
      * tracking node's max value.<br>
      * It is set to true if index equivalent to that  max. value is found in Base Structure.
      * Else means a bug.<br>
      * This flag is kept as private so as outsiders cannot manipulate it anyhow.
      */
     private boolean maxFlag=false;
     /**
      * vMFlag :: The main difference b/w vMFlag and maxFlag is that vMFlag is used to increment
      * the indexes beyond currently inserted node's Tracking node's max value but maxFlag is used to
      * rectify over_incremented indexes.<br>
      * <br>
      * The purpose of vMFlag can be understood as ::<br>
      * In AVL TREE , vMFlag is set to true after processing complete right part ,whenever algorithm reaches
      * over there from any node.Now as we know ,In AVL TREE left part(child) of node is less
      * in index and right part is more.So when Algorithm returns from right part of a node's left child eg.,<br>
      *         C<br>
      *        /  \<br>
      *       A    D<br>
      *        \    <br>
      *         B <br>...A,B,C,D are the indexes.<br>
      * In above Case ,when algorithm will return from index B and suppose new insertion was made for pre occupied
      * index B,then vMFlag and insertFlag will be found true at C and hence index of C and it's vMFactor
      * will be incremented.<br>
      * Hope you will enjoy this algorithm.<br>
      * This flag is kept as private so as outsiders cannot manipulate it anyhow.
      */
     private boolean vMFlag=false; 
     BaseNode rootTREE=null;/*ROOT of Base Structure(AVL TREE.)*/
     BaseNode tmp2;/*To be inserted in BaseStructure.*/
    
    /**
     * Insert data at node_number/index in a tree having p as root.<br>
     * Time=O(log n),n=Number Of elements present.
     */
     void insert(UraInstantiator uraI, long node,ClientData data,BaseNode p){
        
        insert1(uraI,node,data,p);
        TrackerNode p1=null,p2=null,vm=new TrackerNode();
        vm.min=vm.max=node;
        
        if(insertFlag==true){
            insertFlag=false;
            p1=uraI.getMinMax().Find(node,uraI.getMinMax().VMROOT.left);
            if(lastIndex>p1.max){
                findAndCorrect((p1.max+1),rootTREE.left);
                maxFlag=false;
                p2=uraI.getMinMax().Find(p1.max+2,uraI.getMinMax().VMROOT.left);
                if(p2!=null){
                    p1.max=p2.max;
                    uraI.getMinMax().delete(uraI,p2,uraI.getMinMax().VMROOT.left,uraI.getMinMax().VMROOT);
                }
                else {p1.max++;}
            }
            else if(lastIndex==p1.max){p1.max++;lastIndex++;}
            else {System.out.println("BIG_ERROR");System.exit(0);}
        }
        else{
            if(uraI.getMinMax().VMROOT!=null){    
                if((node!=0)){
                    p1=uraI.getMinMax().Find(node-1,uraI.getMinMax().VMROOT.left);
                }
                if(node<lastIndex){//if nodeIndex>lastIndex , tracker node will not be there for nodeIndex+1 also.
                    //and if node==lastIndex , this fragement will not be processed due to insert on pre-occupied index.
                    p2=uraI.getMinMax().Find(node+1,uraI.getMinMax().VMROOT.left);
                }
                if((p1==null)&&(p2==null)){uraI.getMinMax().insert(uraI,vm);}
                else{
                    if(p1!=null){p1.max=node;}
                    if(p2!=null){
                        if(p1!=null){
                            p1.max=p2.max;
                            uraI.getMinMax().delete(uraI,p2,uraI.getMinMax().VMROOT.left,uraI.getMinMax().VMROOT);
                        }
                        else{
                            p2.min=node;
                        }
                    }
                }
            }
            else{
                uraI.getMinMax().insert(uraI,vm);
            }
            if(node>lastIndex){lastIndex=node;}
        }
        numberOfElements++;
    }
    
     void insert1(UraInstantiator uraI,long node,ClientData data,BaseNode p){
        if(node>=0){
            insertFlag=false;vMFlag=false;
            tmp2=new BaseNode();
            tmp2.nodeIndex=node;
            tmp2.data=data;
            if(rootTREE==null){
                rootTREE=new BaseNode();
                rootTREE.left=tmp2;
            }
            else{insertTree(uraI,rootTREE.left,rootTREE);}
        }
        else System.out.println(" NEGATIVE INDEX ARE NOT ACCEPTED");
    }
    
    /**
     * Rectify the indexes beyond currently inserted .<br>
     * <br>Time:: O(log n)
     */
     void findAndCorrect(long node,BaseNode tmp){
        if(tmp!=null){
            if(node<tmp.nodeIndex){
                findAndCorrect(node,tmp.left);
                if(maxFlag==true){tmp.nodeIndex--;tmp.vMFactor--;}
            }
            else if(node==tmp.nodeIndex){
                if(tmp.right!=null){tmp.vMFactor--;}
                else {tmp.vMFactor=0;}
                maxFlag=true;
            }
            else{
                findAndCorrect(node-tmp.vMFactor,tmp.right);
            }
        }
        else{
           // It's a bug.'
        }
        
    }
            /**
             * Time Complexity::O(log n),n=number of elements present.<br>
             * Memory::O(log n),for traversing stack is formed<br>
             * You can optimize it using user_defined stack.
             */
     void insertTree(UraInstantiator uraI,BaseNode p,BaseNode root){
        if((tmp2.nodeIndex<p.nodeIndex)){
            if(p.left!=null){insertTree(uraI,p.left,p);}
            else {
                p.left=tmp2;tmp2=null;
            }
            if((insertFlag==true)&&(vMFlag==true)){p.nodeIndex++;p.vMFactor++;}
        }
        else{
            long tmpnode=tmp2.nodeIndex;
            tmpnode-=p.vMFactor;
            if(tmp2.nodeIndex==p.nodeIndex){
                insertFlag=true;
                ClientData temp=p.data;
                p.data=tmp2.data;
                tmp2.data=temp;
                p.vMFactor++;
            }
            tmp2.nodeIndex=tmpnode;
            if(p.right!=null){
                insertTree(uraI,p.right,p);
            }
            else {
                p.right=tmp2;tmp2=null;
            }
            vMFlag=true;
        }
        uraI.getBaseStructure().checkForUnbalancing(uraI,p,root);
    }
    
     void reset(){
        insertFlag=maxFlag=vMFlag=false;
        rootTREE=tmp2=null;
        lastIndex=-1l;
        numberOfElements=0l;
    }
    
    
}
