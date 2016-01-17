package test;

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
     * 3.)Not much  slow than array in array's best case of insert(infact, it was slow by a factor of 3 ,log(n)).<br>
     * 
     * 4.)Fast than OBST in OBST's all cases.<br>
     * 
     * And I was successful in that part.<br>
     * In BEST case of Array , for point number 3, slowness was due to factor of log(n).<br>
     * -----------------------------------------------------------------------------------------------<br>
     * THE VARIOUS TEST CAES WERE TAKEN AS::<br>
     * :::::::::::::::::For ARRAY::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::<br>
     * 1.)Worst Case Of Array::<br>
     *                  Insert each data on 0th index.<br>
     * 2.)Average Case Of Array::<br>
     *                  (i)First Insert on [0-n/2)th index sequentially , now insert rest data on n/2th index.<br>
     *                  (ii)First Insert on [0-n/2)th index sequentially , now insert rest data on oth index.<br>
     *                  (iii)First Insert n/2 data on oth index and rest data from [n/2-n)th position onwards.<br>
     *                  (iv)First Insert n/2 data on n/2th index , now rest of the data from [0-n/2)th index.<br>
     * <br>
     * I have designed above test cases as Averge=(Best+Worst) ,i.e. insert half of the data as best case and rest as worst.<br>
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
     *                  (ii)First insert on (n-1)th index , now insert rest of data on oth index.<br>
     *        <<<<Take average of above two different worst cases>>>>                            <br>                   
     * Above are worst cases of OBST as even indices are leaf nodes on OBST and hence it will take more time
     * to reach leaf tan non-leaf node.(For no. of elements as 10^X forAll X>=1 , even numbered index are leaf .)
     * <br><br>
     * 2.)Average Case Of OBST::<br>
     *                  (i)First insert sequentially on (0-n/2)th, now <br>
     *                                                             a.)Insert on n-1th index.<br>
     *                                                             b.)Insert rest data at n/2th index.<br>
     *                  (ii)First insert sequentially on (0-n/2)th, now <br>
     *                                                             a.)Insert on n-1th index.<br>
     *                                                             b.)Insert rest data at 0th index.<br>
     *                  (iii)First insert sequentially on n-1 th, now <br>
     *                                                             a.)Insert n/2 data on [0-(n/2)]th index.<br>
     *                                                             b.)Insert rest data at n/2th index.<br>
     *                  (iv)First insert sequentially on n/2th, now <br>
     *                                                             a.)Insert n/2-1 data on 0th  index.<br>
     *                                                             b.)Insert rest data at [(n/2+1) - (n-1)]th index.<br>
     *              Above are average cases as:: BEST + AVERAGE.<br>
     * 3.)Best Case Of Ordered BST::<br>
     *                  Insert Sequentially on [0-(n-1)]th index.<br>
     * <br>
     * <br>
     * In my implementations , when I applied URA on AVL TREE (FOR FUN I ASLO NAMED THAT AS VM_LAZY ARRAY.) , it was fast.<br>
     * It was also slow than ARRAY only in Best case of Array.<br>
     * ////////chakde phatte ENJOY!!\\\\\\<br>
     */
    
}
