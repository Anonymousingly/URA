package client;
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

import java.util.Scanner;
/**
 *
 * @author Vivek Mangla
 */

/**
 * Client is from user point of view.<br>
 * Below is how a user should use this API .
 */
public class Client {
    
    
    /**
     * Currently using single Communication instance.
     */
    static ClientCommunicator ccm=new ClientCommunicator();
    
    
    public static void main(String[] arg){
        Scanner s=new Scanner(System.in);
        byte userChoice;
        while(true){
            System.out.println("Enter 1 to insert\nEnter 2 to delete\n3 to retrieve\n4 to printAll"
                    + "\n5 to get Total Number Of Elements\n6 to get Last Index Inserted.");
            userChoice=s.nextByte();
            switch (userChoice){
                case 1:{
                    System.out.println("\nEnter the index at which to insert\n");
                    long index=s.nextLong();
                    System.out.println("\nEnter the data(in INTEGER FORM)\n");
                    long data=s.nextLong();
                    //for synchronization uncomment below.
                    //synchronized(serve){
                    ccm.insert(index, new ClientData(data));
                    //}
                    break;
                }
                case 2:{
                    System.out.println("\nEnter the index to delete\n");
                    long index=s.nextLong();
                    try{
                    ccm.delete(index);
                    }catch(Exception er){System.out.println("ERROR :: "+er);}
                    break;
                }
                case 3:{
                    System.out.println("\nEnter index to retrieve it's data\n");
                    long index=s.nextLong();
                    try{
                        System.out.println(ccm.get(index));
                    }catch(Exception er){
                        //CAN BE DUE TO DATA NOT FOUND.
                        
                        System.out.println("ERROR :: "+er);
                    }
                    break;
                }
                case 4:{
                    System.out.println("----------------------------------");
                    ccm.printAll();
                    System.out.println();
                    break;
                }
                case 5:{
                    System.out.println(ccm.getDataCount());
                    break;
                }
                case 6:{
                    System.out.println(ccm.getLastIndex());
                    break;
                }
                default:{System.out.println("Wrong Choice");}
            }
        }
    }
    
    
    
    
    
}
