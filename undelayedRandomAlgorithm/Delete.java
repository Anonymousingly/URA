package undelayedRandomAlgorithm;


/**
 * 
 * @author: Vivek Mangla
 */
/**
 * Delete is to process deletion of data at a particular index.<br>
 * Non-Amortized Time Complexity :O(log n) , in every case.
 */
public class Delete {
     /**
      * Defines whether index has been found or not which is to be deleted.<br>
      * If true data found else not found i.e. index is not present.
      */  
    boolean delindex=false;             
    Common nTS=null;/*to be used as subustitute while deletion.*/
    long NODE=0l;/*Will Be Initialized with the Index to be Deleted.*/
    
    /**
     * As deletion will cause complete removal of data from the base structure so 
     * tracker node must also be updated i.e. it should be deleted if it contains
     * min and max value as index or updated if index is contained inside min and max values.
     */
     void manageTracker(UraInstantiator uraI,long node,BaseNode p,BaseNode root,BaseNode ROOT){
        long min,max;
        TrackerNode p1;
        p1=uraI.getMinMax().Find(node,uraI.getMinMax().VMROOT.left);
        if(p1!=null){
            delindex=true;
            /*For debug purpose, comment below if statement and let this code fragemenet's
             * delete statement be executed nearby line no. 70.
             */
            if(uraI.getInsert().numberOfElements==1){
                uraI.getBaseStructure().reset(uraI);
                return;
            }
            if(uraI.getInsert().lastIndex==node){
                if(p1.min!=p1.max){uraI.getInsert().lastIndex--;}
                else{
                    //below instruction is just a debugging one.
                    if(p1.right!=null){System.out.println("ERROR");System.exit(0);}
                    else{
                        if(p1.left!=null){
                            TrackerNode tt=p1.left;
                            while(tt.right!=null){tt=tt.right;}
                            uraI.getInsert().lastIndex=tt.max;
                        }
                        else{
                            if(uraI.getMinMax().pROOT!=p1)
                            uraI.getInsert().lastIndex=uraI.getMinMax().pROOT.max;
                            else uraI.getInsert().lastIndex=0;
                        }
                    }
                }
            }
            //delete tracker node.
            if(p1.min==p1.max){uraI.getMinMax().delete(uraI,p1,uraI.getMinMax().VMROOT.left,uraI.getMinMax().VMROOT);}
            //Update tracker node.
            else if(p1.min==node){p1.min++;}
            else if(p1.max==node){p1.max--;}
            else{
                min=p1.min;max=node-1;
                TrackerNode tmp=new TrackerNode();
                tmp.min=min;tmp.max=max;
                p1.min=node+1;
                uraI.getMinMax().insert(uraI,tmp);
            }
            delete(uraI,node,p,root,ROOT);
        }
        else {
            delindex=false;
            System.out.println("TRACKING NODE NOT FOUND\nReturning...");
            /**DEBUG STATEMENT.
             * delete(uraI,node,p,root,ROOT);
             */
        }
    }
    
     /**
      * Delete the data at index.<br>
      * BaseNode p: p is from BaseStructure point of view.p is root.left of base structure.<br>
      * BaseNode root: root is the reference to root of base structure.<br>
      * Non-Amortized Time Complexity:O(log n) , in every case.
      */
     void delMe(UraInstantiator uraI,long index,BaseNode p,BaseNode root){
        nTS=null;
        delindex=false;
        NODE=0l;
        if((index>=0)){
        NODE=index;
        manageTracker(uraI,index,p,root,root);
        }
        
    }
    
     /**
      * If tracker node contains the index to be deleted, this function is called after updating tracker node.<br>
      * Find the appropriate index in base data structure and go for it's deletion
      */
    void delete(UraInstantiator uraI,long index,BaseNode p,BaseNode root,BaseNode ROOT){
        if(p!=null){
            if(p.nodeIndex==index){
                /*DEBUG STATEMENT
                 * if(delindex==false){
                    System.out.println("Structural error \nTracking Node at "+index+" not found\n"
                            + "but data is present at this index.");
                }*/
                delindex=true;
               goForDeletion(uraI,p,root,ROOT);
            }
            else if(index<p.nodeIndex){
                delete(uraI,index,p.left,p,ROOT);
            }
            else{
                delete(uraI,index-p.vMFactor,p.right,p,ROOT);
            }
            uraI.getBaseStructure().checkForUnbalancing(uraI,p,root);
        }
        else {
            /*DEBUG STATEMENT
             *if(delindex==true){
                System.out.println("Structural ambiguity\nData at index+"+index+"\n"
                        + "is present inside baseStructure but it's tracking node is present.");
            }
            */
            delindex=false;
            System.out.println("DATA at "+NODE+"  NOT FOUND i.e. "+index+" indexed element is EMPTY");
        }
    }
    
     void goForDeletion(UraInstantiator uraI,Common p,Common root,Common ROOT){
        if((p.getLeft()==null)&&(p.getRight()==null)){
            if((p==root.getLeft())&&(root==ROOT)){
                uraI.getInsert().rootTREE=null;
            }
            else {
                changeRootChild(root,p,null);
            }
        }
        else if(p.getLeft()==null){ 
            if(p instanceof BaseNode){
                BaseNode tmp=(BaseNode)p;
                tmp.right.nodeIndex+=tmp.vMFactor;
                //tmp=null;
            }
            changeRootChild(root,p,p.getRight());
            if(p instanceof BaseNode){
                BaseNode tmp=(BaseNode)p;
                tmp.right.vMFactor=0;
                //tmp=null;
            }
            p.setHeight(0);
            p.setRight(null);
        }
        else if(p.getRight()==null){
            changeRootChild(root,p,p.getLeft());
            if(p instanceof BaseNode){BaseNode tmp=(BaseNode)p;tmp.left.vMFactor=0;}
            p.setHeight(0);
            p.setLeft(null);
        }
        else{
            if(p.getLeft().getRight()!=null)
            {
                nTS=null;
                findAndDelete(uraI,p.getLeft(),p,0);
                nTS.setLeft(p.getLeft());
                nTS.setRight(p.getRight());
                if(p instanceof BaseNode){
                    BaseNode tmp=(BaseNode)p;
                    BaseNode nTSTmp=(BaseNode)nTS;
                    nTSTmp.vMFactor=tmp.vMFactor;
                }
                changeRootChild(root,p,nTS);
                p.setLeft(null);p.setRight(null);
                uraI.getBaseStructure().checkForUnbalancing(uraI,nTS,root);
                
            }
            else{
                p.getLeft().setRight(p.getRight());
                if(p instanceof BaseNode){BaseNode tmp=(BaseNode)p;tmp.left.vMFactor=tmp.vMFactor;}
                changeRootChild(root,p,p.getLeft());
                p.setRight(null);
                uraI.getBaseStructure().checkForUnbalancing(uraI,p.getLeft(),root);
                p.setLeft(null);
            }
        }
    }
    
     void changeRootChild(Common root,Common p,Common toReplace){
        
                    if(root.getRight()==p)root.setRight(toReplace);
                    else {root.setLeft(toReplace);}
        
    }
    
     void findAndDelete(UraInstantiator uraI,Common p,Common root,long baseindex){
        
        if(p.getRight()!=null){
            long valueIndex=0;
            if(p instanceof BaseNode){
                BaseNode tmp=(BaseNode)p;
                valueIndex=baseindex+tmp.vMFactor;
                //tmp=null;
            }
            findAndDelete(uraI,p.getRight(),p,valueIndex);
        }
        else{
            nTS=p;
            if(nTS instanceof BaseNode){
                BaseNode tmp=(BaseNode)nTS;tmp.nodeIndex+=baseindex;//tmp=null;
            }
            root.setRight(p.getLeft());
            p.setRight(null);p.setLeft(null);
        }
        uraI.getBaseStructure().checkForUnbalancing(uraI,p,root);
    }
    
     
     
}
