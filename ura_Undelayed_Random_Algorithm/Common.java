
package ura_Undelayed_Random_Algorithm;

/**
 *
 * @author Vivek Mangla
 */

/**
 * Common interface to remove code redundancy of base structure (AVL_TREE) and Tracker(MinMax) which
 * is also in AVL TREE form.
 */
public interface Common{

    public Common getLeft();
    public Common getRight();
    public void setLeft(Common l);
    public void setRight(Common r);
    public int getHeight();
    public void setHeight(int h);
    
}