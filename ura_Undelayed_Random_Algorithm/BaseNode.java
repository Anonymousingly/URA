package ura_Undelayed_Random_Algorithm;

import client.ClientData;

/**
 *
 * @author Vivek Mangla
 */
/**
 * BaseNode is defining the node of base data structure used here ,AVL TREE.<br>
 * It is implementing Common interface .The purpose of implementing a Common interface is to
 * remove code redundancy that arises  TrackerNode and BaseNode because BaseStructure
 * and Tracker are in AVL TREE FORM.
 */
public class BaseNode implements Common{
    /**
     * Index Of Node.
     */
    long nodeIndex=0l;
    /**
     * Height Of node.
     */
    int height=0;
    /**
     * Data present inside node.
     */
    ClientData data=null;
 /**
 * vMFactor:: It's a variable to track index updates with every data node and that's enough
 * to achieve different types of insertion & deletion with same time complexity as in case of underlying(base)
 * Data Structure if we normally insert , delete , get an element.I have named this variable on my name.
 * <br>VM=Vivek Mangla<br>
 * I have named it on my name cause it's an important key of URA(UnDelayed Random Algorithm).
 */
    long vMFactor=0l;
    BaseNode left=null,right=null;
    
    @Override
    public BaseNode getLeft(){return left;}
    @Override
    public void setLeft(Common l){left=(BaseNode)l;}
    @Override
    public BaseNode getRight(){return right;}
    @Override
    public void setRight(Common r){right=(BaseNode)r;}
    @Override
    public int getHeight(){return height;}
    @Override
    public void setHeight(int h){height=h;}
    
}
