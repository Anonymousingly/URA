package ura_Undelayed_Random_Algorithm;
/**
 * @author Vivek Mangla
 */

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
 * URA :: UnDelayed Random Algorithm.<br>
 * This algorithm can solve different types of insertions & deletions without any extra delay for other
 * than the delay of underlying data structure but there are certain restrictions ,as of now ,to which
 * data structure can be used as base for this algorithm to yield correct results.
 * Few of them are AVL_TREE , LinkedList , BST .Still study is going on to find exact properties
 * of all data structures which can be used as underlying ones.
 * <br><br>
 * 
 * To be precise , this algorithm depends upon the time complexity of underlying Data Structure.
 * For eg:<br>
 * ---------------------------------------------------------------------------------------------
 * n=No. of elements/data present inside base data structure used and is not the MAXIMUM INDEX.<br>
 * 
 * ---------------------------------------------------------------------------------------------
 *         if we use this algorithm on AVL_TREE , time complexity will be:
 *                                      O(log n) in all cases.<br>
 * ---------------------------------------------------------------------------------------------
 *         if use with linked list,time complexity will be::
 *                                      O(n) in worst case(without CPU caching) and O(1) in best case.<br>
 * ---------------------------------------------------------------------------------------------
 * 
 * Memory =MEM( underlying data structure )+MEM( vMFactor ) + MEM(Tracker).
 * i.e. Memory in Base Structure is extra just to store vMFactor , an important part of Algorithm.
 * Memory for Tracker also depends upon underlying dataStructure being used for Tracking purpose.
 * As Here I have used AVL TREE again as Tracker,so in my case 
 * <br>MEM=O(n).<br>
 * 
 * Limitation:: As of till now This algorithm will not work with CPU Caching.This is because of it's 
 * dependency on path traversal and if it is modified to do so ,most probably it may also work with array. 
 * Kindly refer Documentation for more info.<br><br>
 * 
 * Concept is simple , use a variable(VMFactor) to track all updates with every data node and that's enough
 * to achieve different types of insertion & deletion with same time complexity as in case of underlying(base)
 * Data Structure if we normally insert , delete , get an element .That variable is named as vMFactor.
 * This factor is an important key of URA, infact ,whole URA is based on this factor and hence named as 
 * short script of my name ,VM=Vivek Mangla just for my fun.
 * NOTE:: If you are not comfortable with names in this project, do refactoring before using it ,please.
 * 
 * @author Vivek Mangla
 */

public class About {
   
}
