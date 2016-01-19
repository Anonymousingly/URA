package test;
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
public class Info {
    
    /**
     * Instead of putting my implementation of Testing phase,I am providing  
     * summarization of Test Cases.As for Array and OBST(Ordered BST) , my implementations 
     * may not be optimized ,so go ahead and implement in your own way and find out whether 
     * URA proves results attached or not.<br><br>
     * 
     * NOTE::DURING TESTING MAKE SURE TO USE INITIALIZATION CODE EXPLICITLY SO AS NOT TO DEPEND ON 
     * JAVA'S GARBAGE COLLECTOR.THAT IS NECESSARY FOR THE CASE OF ARRAY AS WE WILL GET ARRAY 
     * AS COMPLETELY INITIALIZED WITH 0.MY MOTTO IS TO SAY THAT FOR TESTING , REDESIGN MY_CODE
     * AND YOUR CODE (OF ARRAY AND OBST) AS IN C i.e. use explicit initializer.
     * <br>
     * Tests were performed by me as::<br>
     * To Prove,<br>
     *  URA,when applied on AVL TREE ,performs::<br><br>
     * 
     * 1.)Faster than Array in array's worst case of insert.<br>
     * 2.)Faster than Array in array's average case of insert.<br>
     * 3.)Not much  slow than array in array's best case of insert(infact, it was slow by a factor of log(n)).<br>
     * 
     * 4.)Fast than OBST in OBST's all cases.<br>
     * 
     * And I was successful in that part.<br>
     * In BEST case of Array , for point number 3, slowness was due to factor of log(n).<br>
     * -----------------------------------------------------------------------------------------------<br>
     * THE VARIOUS TEST CASES WERE TAKEN AS::<br>
     * :::::::::::::::::For ARRAY::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::<br>
     * 1.)Worst Case Of Array::<br>
     *                  Insert each data on 0th index.<br>
     * 2.)Average Case Of Array::<br>
     *                  (i)First Insert on [0-n/2)th index sequentially , now insert rest data on n/2th index.<br>
     *                  (ii)First Insert on [0-n/2)th index sequentially , now insert rest data on oth index.<br>
     *                  (iii)First Insert n/2 data on oth index and rest data from [n/2-n)th position onwards.<br>
     *                  (iv)First Insert n/2 data on n/2th index , now rest of the data from [0-n/2)th index.<br>
     * <br>
     * I have designed above test cases as Average=(Best+Worst) ,i.e. insert half of the data as best case and rest as worst.<br>
     * <br>
     * 3.)Best Case Of Array::<br>
     *                  Insert on [0-(n-1)]th index in sequentially increasing manner.<br>
     *                  Insert on [(n-1)-0]th index in sequentially decreasing order.<br>
     * <br>
     * ::::::::::::::::::For OBST::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::<br>
     * 1.)Worst Case Of OBST::<br>
     *                  (i)First insert a data on (n-1)th index , now ::<br>
     *                                                              a.)Insert on all even indexes.<br>
     *                                                              b.)Insert on all same even indexes again. <br>
                   
     * Above are worst cases of OBST as even indices are leaf nodes on OBST and hence it will take more time
     * to reach leaf tan non-leaf node.(For no. of elements as 10^X forAll X>=1 , even numbered index are leaf .)
     * <br><br>
     * 2.)Average Case Of OBST::<br>
     *                  (i)First insert sequentially on (0-n/2)th, now <br>
     *                                                             a.)Insert on (n-1)th index.<br>
     *                                                             b.)Insert rest data as in worst case from n/2th index.<br>
     *                  (ii)First insert on n/2th index , now insert as in worst case from [0-(n/2-1)]th index and then:: <br>
     *                                                             a.)Insert sequentially from [(n/2+1) - (n-1)]th index.<br>
     *              Above are average cases as:: BEST + WORST.<br>
     * 3.)Best Case Of Ordered BST::<br>
     *                  Insert Sequentially on [0-(n-1)]th index.<br>
     * <br>
     * <br>
     * In my implementations , when I applied URA on AVL TREE (FOR FUN I ASLO NAMED THAT AS VM_LAZY ARRAY.) , it was fast.<br>
     * It was also slow than ARRAY only in Best case of Array.<br>
     * ////////chakde phatte ENJOY!!\\\\\\<br>
     */
    
}
