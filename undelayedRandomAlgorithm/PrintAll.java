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
