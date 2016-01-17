package ura_Undelayed_Random_Algorithm;

/**
 *
 * @author Vivek Mangla
 */
/**
 * Print All Data .
 */
public class PrintAll {
    
    public void printIncreasingIndex(BaseNode root,long baseIndex){
        printInOrder(root,baseIndex);
    }
    
    private void printInOrder(BaseNode root,long baseIndex){
        if(root!=null){
            printInOrder(root.left,baseIndex);
            System.out.print("  "+(root.nodeIndex+baseIndex)+" ="+root.data);
            printInOrder(root.right,baseIndex+root.vMFactor);
        }
    }
    
    public void printPostOrder(BaseNode root,long baseindex){
        if(root!=null){
            printPostOrder(root.left,baseindex);
            printPostOrder(root.right,baseindex+root.vMFactor);
            System.out.print("  "+(root.nodeIndex+baseindex)+" ="+root.data);
        }
    }
    
}
