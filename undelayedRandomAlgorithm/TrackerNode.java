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
