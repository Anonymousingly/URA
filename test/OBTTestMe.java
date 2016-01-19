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

import client.ClientCommunicator;
import client.ClientData;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
/**
 *
 * @author Vivek Mangla
 */

/**
 * This defines the test cases of OBST(Ordered BinarySearchTree) i.e. Best,Worst and Average.<br>
 * When I tested these test cases on URA with AVL_TREE as base , results were like<br>
 * In best case::URA was fast :: URA took 7.244 sec. but OBST took 8.121 sec. for 10^7 elements.<br>
 * In worst case ::URA was faster as URA took 17.400 sec. but OBST took 29.162 sec. for 10^7 elements.<br>
 * In average cases :: URA was faster as URA took 8.129 sec. but OBST took 11.36 sec. for 10^7 elements.<br>
 * <<------------------------------>><br>
 * Above tests were done on::<br>
 * intel Core i3 Processor.<br>
 * Laptop was on Battery.<br>
 * Performance was Balanced.<br>
 * O.S. ::Windows 7 Home Premium.
 * Compiler :: JDK(1.7).
 * <<------------------------------->>
 */

public class OBTTestMe {
    /*This Class is NOT_THREAD_SAFE.*/
    
    static long L[],H[],A[];
    static long t=0L,looptime,min=0L,max=0L,start=0L,sum=0l;
    static int m=1,index=0;
    static int times=0;
    static ClientCommunicator ccm;
    
    public static void main(String[] arg){
        times=4;looptime=5L;
        L=new long[times];
        H=new long[times];
        A=new long[times];m=1000;
        ccm=new ClientCommunicator();
        for(int i=0;i<times;i++){
            //if(i==6)m*=5;
            //else 
            m*=10;
            t=max=0;
            min=999999999999999999L;
            average(arg);
           // MinMax.printAll(MinMax.VMROOT.left);
            ccm.reset();
            t+=(sum);
            min=max=sum;
            for(long j=0;j<looptime-1;j++){
                average(arg);
                ccm.reset();
                t+=(sum);
                if(sum>max){max=sum;}
                else if(sum<min){min=sum;}
            }
            t=t/looptime;
            L[i]=min;H[i]=max;A[i]=t;
            System.out.println("\n"+min+"\n"+""+max+"\n"+t);
               
        }
        System.out.println("L          H          A    ");
        for(int i=0;i<times;i++){
            System.out.println(L[i]+"   "+H[i]+"   "+A[i]);
        }
        
    }
    
    
    static void best(String[] arg){
        start=sum=0;
        ArrayTestMe.m=m;
        ArrayTestMe.ccm=ccm;
        ArrayTestMe.best(arg);
        sum=ArrayTestMe.sum;
    }
    
    static void worst(String[] arg){
        start=sum=0;//put m--
        ThreadMXBean bean=ManagementFactory.getThreadMXBean();
        long id=Thread.currentThread().getId();
        if(!bean.isThreadCpuTimeSupported())return;
        start=bean.getThreadCpuTime(id);
        ccm.insert(m-1,new ClientData((m-1)*2+9));
        worin(0,m-1);
        worin(0,m-2);
        //if(m%2!=0){Main.insert(0,90000);}
        sum+=bean.getThreadCpuTime(id)-start;
    }
    
    static void worin(int base1,int limit){
        int base=base1;
        while(base<limit){
            ccm.insert(base,new ClientData((base-1)*2+9));
            base+=2;
            
        }
    }
    
    
    static void average(String[] arg){
        start=sum=0;
        ThreadMXBean bean=ManagementFactory.getThreadMXBean();
        long id=Thread.currentThread().getId();
        if(!bean.isThreadCpuTimeSupported()){System.exit(0);}
        start=bean.getThreadCpuTime(id);
        avg1(0,m/2);
        avg2(m/2+1,m-1);
        avg2(0,m/2);
        avg1(m/2+1,m-1);
        sum+=bean.getThreadCpuTime(id)-start;
        sum=sum/2l;
        
    }
    
    static void avg1(int start,int end){
        for(int i=start;i<=end;i++){
            ccm.insert(i, new ClientData(i*2+9));
        }
    }
    
    static void avg2(int start,int end){
        ccm.insert(end, new ClientData(9090));
        if(start%2!=0){
            ccm.insert(start, new ClientData(20090));
            start++;
        }
        int i=start;
        while(i<end){
            ccm.insert(i,new ClientData(i*2+9));
            i+=2;
        }
        if(end%2!=0){end-=1;}
        while(i<end-1){
            ccm.insert(i,new ClientData(i*2+9));
            i+=2;
        }
    }
    
}
