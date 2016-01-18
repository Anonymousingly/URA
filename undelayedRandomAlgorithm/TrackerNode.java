package undelayedRandomAlgorithm;


/**
 * 
 * @author Vivek Mangla
 */

/*
 * TrackerNode.java is a node of Tracker class to track all inserted nodes.<br>
 * min,max values are used for tracking.
 */
public class TrackerNode implements Common{
    long min=0,max=0;
    /*Below Variables are for AVL TREE form*/
    TrackerNode left=null,right=null;
    int height=0;
    
    @Override
    public TrackerNode getLeft(){return left;}
    
    @Override
    public void setLeft(Common l){left=(TrackerNode)l;}
    @Override
    public TrackerNode getRight(){return right;}
    @Override
    public void setRight(Common r){right=(TrackerNode)r;}
    @Override
    public int getHeight(){return height;}
    @Override
    public void setHeight(int h){height=h;}
    
    
}
