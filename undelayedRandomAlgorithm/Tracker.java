package undelayedRandomAlgorithm;
/** 
 * The MIT License (MIT)
 *  
 * Copyright (c) 2016 "Vivek Mangla"
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
/**
 *
 * @author Vivek Mangla
 */

/**
 * Tracker class <br>
 * It is needed to find the First and Last index in Partial contiguous stored data.<br>
 * It is necessary in order to reduce Search Time during insertion and deletion of data.<br>
 * 
 * Partial Contiguous Stored Data is the data that is contiguous not fully.<br>
 * For example:: data stored at indexes:: 0,34,35,36,78,89,90,91,92,93,94,95,96,97,...138,189,201,590,591... 
 * and so on.
 * 
 * So in above partial contiguous stored data , last indexes are::0,36,138,189,201,591...
 * And hence Tracker will store in it as pairs of::<br>
 * {(0,0),(34,36),(78,138),(189,189),(201,201),(590,591),...}
 * 
 * The below implementation of Tracker Class is in AVL TREE form.<br>
 * You can implement it in your own way ,eg.: HashTable,Array etc.<br>
 * But I found AVL TREE as suitable because of it's Almost Fixed Time Complexity,i.e. O(log n),<br>
 * n=Number of Min-Max pairs .<br>
 * NOTE::Maximum number of Min-Max pairs are will be only (LastIndexInserted)/2 .
 */
public class Tracker {
    

     TrackerNode pROOT,tmp2,VMROOT,nTS;
     int l,r,bf;
    
    
     TrackerNode Find(long node,TrackerNode p){
        pROOT=p;
        return Findd(node,p);
    }   
    
    /**
     * Find and return the tracking node having an index in between it's min and max values.
     * <br>TimeComplexity:: O(log m)
     */
     TrackerNode Findd(long index,TrackerNode p){
        if((p==null)||(VMROOT==null))return null;
        else if((index>=p.min)&&(index<=p.max)){ return p; }
        else if(index<p.min){pROOT=p;return Find(index,p.left);}
        else{pROOT=p; return Find(index,p.right);}
        
    }
    
    /**
     * For Debug purpose.<br>
     * Print All of the Tracking Nodes with their data.
     */
     void printAll(TrackerNode root){
        if(root!=null){
            printAll(root.getLeft());
            System.out.println(" min = "+root.min+" max = "+root.max);
            printAll(root.right);
        }
        
    }
    
     /**
      * Delete the Min-Max pairs.<br>
      * Currently it's implementation is separate than in Delete.java because of different
      * searching conditions.<br>
      * T=O(log m),m=Number Of pairs present.<br>
      * NOTE::Maximum Number of pairs will always be less than n/2,n=Last indexed element in BaseStructure.
      */
     void delete(UraInstantiator uraI,TrackerNode p,TrackerNode p1,TrackerNode root){
        if(p1!=null){
            if(p==p1){
               uraI.getDelete().goForDeletion(uraI,p1,root,VMROOT);
            }
            else if(p.min<p1.min){delete(uraI,p,p1.left,p1);}
            else delete(uraI,p,p1.right,p1);
            uraI.getBaseStructure().checkForUnbalancing(uraI,p1,root);
        }
        else System.out.println("DATA min="+p.min+" max="+p.max+"  NOT FOUND");
    }
    
    /**
     * Insert tracker node.
     */
     void insert(UraInstantiator uraI,TrackerNode tmp){
        tmp2=tmp;
       if(VMROOT==null){
           VMROOT=new TrackerNode();
           VMROOT.left=tmp2;
       }
       else insertTree(uraI,VMROOT.left,VMROOT);
        
    }
    
    /**
     * Insert in O(log m),m=Number Of pairs.
     */
     void insertTree(UraInstantiator uraI,TrackerNode p,TrackerNode root){
          if((tmp2.min<p.min)){
               if(p.left!=null)
               insertTree(uraI,p.left,p);
               else {
                   p.left=tmp2;
               }
           }
           else{
                  if(p.right!=null)insertTree(uraI,p.right,p);
                  else {
                      p.right=tmp2;
                  }
           }
          uraI.getBaseStructure().checkForUnbalancing(uraI,p,root);
      
    }

  
}
