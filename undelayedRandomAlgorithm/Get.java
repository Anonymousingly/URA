package undelayedRandomAlgorithm;

import client.ClientData;


/**
 * @author Vivek Mangla
 */
/**
 * Retrieve the data at a particular index.<br>
 * Time Complexity:O(log n)  in every case.
 */
public class Get {
    /**
     * Get data at a particular index using stack way .<br>
     * M=O(log n),<br>
     * Non-Amortized  T=O(log n) in every case.<br>
     * n=No. of elements/data present.
     */
     ClientData getAtStack(long index,BaseNode root){
            return getDataStack(index,root);
    }  
    
    private  ClientData getDataStack(long index,BaseNode root){
        if(root==null){
            ClientData cd=new ClientData(-1l);
            cd.dataNotFound=true;
            return cd;
        }
        else{
            if(root.nodeIndex==index){root.data.dataNotFound=false;return root.data;}
            else if(index<root.nodeIndex){
                return getDataStack(index,root.left);
            }
            else{
                return getDataStack(index-root.vMFactor,root.right);
            }
        }
    }
    /**
     * get data at index.<br>
     * use loop way.<br>
     * M=O(1).<br>
     * Non-Amortized T=O(log n) in every case.<br>
     * n= No. of elements/data present.
     */
     ClientData getAtOptimal(long index,BaseNode root){
        while(root!=null){
            if(index<root.nodeIndex){root=root.left;}
            else if(index==root.nodeIndex){break;}
            else{index-=root.vMFactor;root=root.right;}
        }
        if(root==null){
            ClientData cd=new ClientData(-1l);
            cd.dataNotFound=true;
            return cd;
        }
        /**
         * Currently dataNotFound flag is a part of ClientData's object because of some synchronization specific
         * issues in my mind.
         */
        root.data.dataNotFound=false;
        return root.data;
    }
    
}
