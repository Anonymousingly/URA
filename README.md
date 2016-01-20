# URA-UnDelayed-Random-Algorithm-
                                          Under MIT Licence
                                    Copyright (c) 2016 "Vivek Mangla"
A small algorithm for different types of random insert , delete , retrieve data along with that's implementation on AVL TREE.<br>
A substitute for ArrayList , Array  , OBST , AVL TREE , Self Balancing Trees and few other collections in the cases if index/key collision ocuurs data shifting is required.<br>
Performs faster  in cases where during insertion on pre-occupied index , previous data has to be shifted instead of replacement.<br>
-----------------
<b>I like this user name "Anonymousingly" that's why using this & not to hide myself.</b><br><br>
-----------------
<b>To see how to use , read <i>Client.java</i> file in <i>client</i> package.</b><br><br>
<b>Read <i>summmaryOfAlgorithm</i> package to know about algorithm</b><br><br>
<b>Do study summaryOfAlgorithm package to understand it's limitations.</b><br>

<b>::</b>This API is <b>Thread Safe except test package </b>,if client uses <b><i>ClientCommunicator.java</i></b> as in <b><i>Client.java</i></b> .<br><br>
This API is <b>Not Thread Safe if </b>client directly calls functions provided by <b><i>Service.java</i></b> .

<b>I will give $4 per bug for 1st 15 technical bugs within next 168 hours (7 days) ,if reported one is realy a bug.</b>Time starts at 12:50 AM ,18th January IST. 

<b>::</b><b>Why I created this API ?</b><br>
When you insert data in ,say array, and let us say the index was pre occupied .
For example::<br>
Data was present at indexes 3,4,5,6,7,8,12,234,3000... then <br>
Insert at 4 means new indexes will be 3,4,5,6,7,8,9,12,234,3000. i.e. data at 4,5,6,7,8 are being shifted ahead.<br>
Other Exapmles::<br>
eg.:Say data is present at 0,1,2,10,11,56,65,100,2000,2001,2002.<br>
So insert at   0 ,new array will contain data at 0,1,2,3,10,11,56,65,100,2000,2001,2002.<br>
Insert at 56 ,new array will contain data at 0,1,2,3,10,11,56,57,65,100,2000,2001,2002.<br>
Insert at 2002 , new array will contain data at 0,1,2,3,10,11,56,57,65,2000,2001,2002,2003.<br>
Insert at 2004 ,new array will contain data at 0,1,2,3,10,11,56,57,65,2000,2001, 2002,2003,2004.<br>

Also  this type of insertion can  be somewhere in between MOST of the times  and at ends i.e. at 0th index or at LAST index the LEAST.<br>

<b>::</b>To solve such type of insertion problems along with few other different types(will be available in future releases) in less possible time(without much delay other than that of Base Data Structure),URA has been designed.<br><br>

URA with AVL TREE as base can be used as an alternative to ArrayList , Array  , AVL TREE , Self Balancing Trees and few other collections .<br>

<b>::</b>When I tested URA with AVL TREE as base in different cases of Array and OBST(Ordered Binary Search Tree) ,I found it to be faster than both of them in all cases except for one case of Array and that was due to log(n) factor of AVL_TREE <b>(infact,this algo was not designed for the case of insertion on non-repetitive indexes <i> ONLY </i>)</b>.<br>
These test cases were designed by me specifically for Array and OBST i.e. the cases favourable OR unfavourable to both of them.<br>
<b>::</b><b><i>Please read these test cases inside Info.java of test package.</i></b><br>
<b> These were best , average and worst .</b><br>
Best Cases are the ones in which Array and OBST will perform fastest among all other test cases.<br>
<b> For Array , best case is </b>::Firstly insert an element at lastIndex and then insert remaining elements in sequentially increasing order without any repetitive insertion on an index(without any insert on pre-occupied index ) uptill lastIndex-1.  and<br>
<b> For OBST ,best case is </b>::Insert all elements at sequentially increasing index from 0 to lastIndex without any repetitive insertion on an index ( without any insert on pre-occupied index ) <br>

Similarly , <b> worst cases </b> are the ones in which array and OBST will perform slowest .<br>
<b>For array </b>, one among them is ::Insert all elements on 0th index.<br>
<b>For OBST </b> , one of them is insert first element at lastIndex and insert rest elements in 2 phases:: In 1st phase , Insert at all even indexes.In 2nd phase , insert at same even indexes as before.<br>

Average case = Insert half elements as in Best case AND Insert other halves as in Worst Case and Vice-Versa.<br>

<b>::</b><b>On my laptop for 10^7 ( 10 million ) elements , URA with AVL TREE as Base proved that ::</b><br>
*It is faster than OBST in OBST's best , Worst and Average cases by 1 second ,12 seconds and 3 seconds respectively.<br>
*It is faster than Array in Array's Worst and Average Cases by 20 seconds and 7 seconds respectively merely for 10^5 elements.<br>
*It is little bit slow than Array in Array's best case by 6.5 seconds due to log(n) factor of AVL_TREE ... ( <b> remember this algo is not designed for unique insertion i.e. for insertion on non-repetitive indexes <i> ONLY </i> </b> )<br>

<b>::</b>I also named this implementation as VM's Lazy Array or VMLazy Array ,<b> just for fun </b> .<br>
This implementation on AVL TREE will give Almost Constant or Almost fixed time complexity of O(log n) in all types of insertions , deletions , retrieval of data , where n = Number of data / element present.
<br>
<b>::</b><b>Limitations ::</b>
This algorithm(URA) will work for specific data structures only .Study is going on to find exact properties of those .As this algo. depends upon path traversal properties ,so below are the ones I have concluded till now and all should be fulfilled::<br>
1.)There <b>must</b> be a unique path to reach every element.<br>
2.)There <b>should</b> be a common starting point for all paths.<br>
3.)<b><i><u>VMFactor</u></i></b> must be updated accordingly in the decision node of index collided path.<br>
DataStructures satisfying above properties and hence compatible with URA are :: LinkedList ( Single and Double ) , BST , AVL TREE .<br><br>

<b>::</b>I am also developing it further to provide further types of insertions , deletions like if insert on same index :: shift backwards OR re-trigger that insertion to some other point via some algo and much more .<br>
<br>
<b><i><u> Till Then ENJOY!! </u></i></b>
<br>---<br>
Vivek Mangla .<br>
anonymousinglyanonymous@gmail.com
