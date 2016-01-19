# URA-UnDelayed-Random-Algorithm-
Under MIT Licence<br>
A small algorithm for different types of random insert , delete , retrieve data along with that's implementation on AVL TREE.

<b><i>To see how to use , read ~Client.java~ file in ~client~ package.</i></b><br>
<b>Read ~summmaryOfAlgotithm~ package to know about algorithm</b><br>
This API is <b>Thread Safe </b>,if client uses ClientCommunicator as in Client.java .<br>
This API is <b>Not Thread Safe if </b>client directly calls functions provided by Service.java .

<b>I will give Rs. 200/- per bug for 1st 15 bugs within next 96 hours (4 days) ,if reported one is realy a bug.</b>Time starts at 12:50 AM ,18th January IST. 

When you insert data in ,say array, and let us say the index was pre occupied .
For example::<br>
Data was present at indexes 3,4,5,6,7,8,12,234,3000... then <br>
Insert at 4 means new indexes will be 3,4,5,6,7,8,9,12,234,3000. i.e. data at 4,5,6,7,8 are being shifted ahead.
Other Exapmles::
eg.:Say data is present at 0,1,2,10,11,56,65,100,2000,2001,2002.
So insert at   0 ,new array will contain data at 0,1,2,3,10,11,56,65,100,2000,2001,2002.
Insert at 56 ,new array will contain data at 0,1,2,3,10,11,56,57,65,100,2000,2001,2002.
Insert at 2002 , new array will contain data at 0,1,2,3,10,11,56,57,65,2000,2001,2002,2003.
Insert at 2004 ,new array will contain data at 0,1,2,3,10,11,56,57,65,2000,2001, 2002,2003,2004.

Also  this type of insertion can  be somewhere in between MOST of the times  and at ends i.e. at 0th index or at LAST index the LEAST.

To solve such type of insertion problem in less possible time(almost constant),URA has been designed.


