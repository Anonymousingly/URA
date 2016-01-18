package undelayedRandomAlgorithm;

/**
 * @author: Vivek Mangla
 */

/**
 * BaseStructure , here is AVL TREE.I also call it as VM_LAZY ARRAY.<br>
 * AVL TREE is being used here because it performs insert,delete,retrieve data on basis of index
 * in O(log n),n=No. Of Element.<br>
 * This structure is being used here because the algorithm depends upon underlying structure's
 * time complexity in normal case of insert,delete,retrieve.<br>
 * Also , Currently Array cannot be used because algorithm depends upon path traversal properties but in
 * array path is not there (as directly we can insert,delete,retrieve an element from it's index)
 */
public class BaseStructure {

    int bf=0;/*BalancedFactor*/
    int l=0;/*l for left Child's height*/
    int r=0;/*r for right Child's height*/
     
    /**
     * For debug purpose.
     */
    public static void main(String[] arg){
        /*For Testing Purpose. Uncomment Below Single Line Comment To Proceed.*/
        /*
        UraInstantiator uraI=new UraInstantiator();
        Service serve=new Service();
        */
        /*Insert at (clientfactoryObject,index,Data)*/
        /*
        serve.insert(uraI,5l,new ClientData(0));
        serve.insert(uraI,5l,new ClientData(1));
        serve.insert(uraI,4l,new ClientData(2));
        serve.insert(uraI,5l,new ClientData(3));
        serve.insert(uraI,2l,new ClientData(4));
        serve.insert(uraI,17l,new ClientData(5));
        serve.insert(uraI,5l,new ClientData(54));
        serve.insert(uraI,82l,new ClientData(63));
        serve.insert(uraI,5l,new ClientData(31));
        serve.printAll(uraI);
        System.out.println();
        serve.insert(uraI,83l,new ClientData(45));
        serve.printAll(uraI);
        System.out.println();
        serve.insert(uraI,90l,new ClientData(899));
        serve.insert(uraI,170l,new ClientData(903));
        serve.insert(uraI,5l,new ClientData(811));
        serve.insert(uraI,1l,new ClientData(12));
        serve.insert(uraI,17l,new ClientData(13));
        serve.delete(uraI, 2l);
        serve.delete(uraI,7l);
        serve.insert(uraI,5l,new ClientData(82929292));
        serve.printAll(uraI);
        System.out.println();
        */
    }
    
    /**
     * Reset all the variables.<br>
     * This should be called before processing an object for the first time.
     */
     void reset(UraInstantiator uraI){
        uraI.getInsert().reset();
        bf=l=r=0;
        uraI.getMinMax().tmp2=uraI.getMinMax().VMROOT=uraI.getMinMax().nTS=null;
        uraI.getMinMax().l=uraI.getMinMax().r=uraI.getMinMax().bf=0;
        uraI.getDelete().delindex=false;
        uraI.getDelete().NODE=0;uraI.getDelete().nTS=null;
     }

     /**
      * Traverse base structure.<br>
      * This function is designed and can be modified also for debugging purpose.
      */
     BaseNode traverse(BaseNode p1,long node1){
        while(p1!=null){
            if(node1<p1.nodeIndex){p1=p1.left;}
            else if(node1==p1.nodeIndex){break;}
            else{node1-=p1.vMFactor;p1=p1.right;}
        }
        return p1;
    }
    
     /**
      * Check whether tree is balanced or not from p's height point of view.
      */
    void checkForUnbalancing(UraInstantiator uraI,Common p,Common root){
       p.setHeight(findHeight(p));
       bf=l-r;
       if((bf>1)||(bf<-1)){
           BalanceTree(uraI,p,root);
       } 
    }

     /**
      * Determine the type of rotation needed to balance the tree using wc variable.
      */
     void BalanceTree(UraInstantiator uraI,Common root,Common ROOT){

       int wC;

       if(root.getRight()==null)
       {
           if(root.getLeft().getLeft()==null)
           {wC=3;}
           else wC=1;
       }
       else if(root.getLeft()==null)
       {
           if(root.getRight().getRight()==null)
           wC=4;
           else wC=2;
       }
       else{
           if(root.getLeft().getHeight()>root.getRight().getHeight()){
               if(root.getLeft().getRight()==null)wC=1;
               else if(root.getLeft().getLeft()==null){wC=3;}
               else{
                   if(root.getLeft().getLeft().getHeight()>=root.getLeft().getRight().getHeight())wC=1;
                   else {wC=3;}
               }
           }
           else{
               if(root.getRight().getLeft()==null)wC=2;
               else if(root.getRight().getRight()==null)wC=4;
               else{
                   if(root.getRight().getRight().getHeight()>=root.getRight().getLeft().getHeight()){wC=2;}
                   else wC=4;
               }
           }

       }
       switch(wC){
           case 1:{
                  doLL(uraI,root,ROOT);
               break;
           }
           case 2:{
               doRR(uraI,root,ROOT);
               break;
           }
           case 3:{
               doLR(uraI,root,ROOT);
               break;
           }
           case 4:{
               doRL(uraI,root,ROOT);
               break;
           }
           default:{System.out.println("CouldNOt Modify wC(whichCASE)");}
       }

    }

     /**
      * LL unbalanced.
      */
    void doLL(UraInstantiator uraI,Common root,Common ROOT){
        Common tmp;
        BaseNode tmpr;
        long k1,k2=0l;
        if(root instanceof BaseNode){
            tmpr=(BaseNode)root;
            k1=tmpr.vMFactor;
            k2=tmpr.left.vMFactor;
        }    
        tmp=root.getLeft();
        uraI.getDelete().changeRootChild(ROOT, root,tmp);
        root.setLeft(tmp.getRight());
        tmp.setRight(root);
        root.setHeight(findHeight(root));
        tmp.setHeight(findHeight(tmp));
        if(root instanceof BaseNode){
            tmpr=(BaseNode)root;
            tmpr.vMFactor-=k2; tmpr.nodeIndex-=k2;
        }
    }

     /**
      * RR unbalanced.
      */
     void doRR(UraInstantiator uraI,Common root,Common ROOT){

        Common tmp;
        BaseNode tmpr;
        long k1=0l,k2=0l;
        if(root instanceof BaseNode){
            tmpr=(BaseNode)root;
            k1=tmpr.vMFactor;
            k2=tmpr.right.vMFactor;
        }
        tmp=root.getRight();
        uraI.getDelete().changeRootChild(ROOT, root, tmp);
        root.setRight(tmp.getLeft());
        tmp.setLeft(root);
        root.setHeight(findHeight(root));
        tmp.setHeight(findHeight(tmp));
        if(root instanceof BaseNode){
            tmpr=(BaseNode)tmp;
            tmpr.nodeIndex+=k1; tmpr.vMFactor=k1+k2;
        }
    }

     /**
      * LR Unbalanced
      */
     void doLR(UraInstantiator uraI,Common root,Common ROOT){
        doRR(uraI,root.getLeft(),root);
        doLL(uraI,root,ROOT);
    }

     /**
      * RL Unbalanced
      */
     void doRL(UraInstantiator uraI,Common root,Common ROOT){
        doLL(uraI,root.getRight(),root);
        doRR(uraI,root,ROOT);
    }

     /**
      * Find the height of node from it's children.
      */
     int findHeight(Common node){
        l=r=0;   
        if(node.getLeft()!=null)l=1+node.getLeft().getHeight();
        if(node.getRight()!=null)r=1+node.getRight().getHeight();
        return ((l>r)?l:r);
    }
    
}
