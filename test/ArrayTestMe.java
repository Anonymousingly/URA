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
 * This defines the test cases of Array i.e. Best,Worst and Average.<br>
 * When I tested these test cases on URA with AVL_TREE as base , results were like<br>
 * In best case::Array was fast by log(n) factor::URA took 7.4 sec. but Array took 0.97 sec. for 10^7 elements.<br>
 * In worst case ::URA was faster as URA took 0.65 sec. but Array took 2876.73 sec. (47.94 minutes) for 10^6 elements.<br>
 * In average cases :: URA was faster as URA took .04 sec. but Array took 7.8 sec. for 10^5 elements.<br>
 * <<------------------------------>><br>
 * Above tests were done on::<br>
 * intel Core i3 Processor.<br>
 * Laptop was on Battery.<br>
 * Performance was Balanced.<br>
 * O.S. ::Windows 7 Home Premium.
 * Compiler :: JDK(1.7).
 * <<------------------------------->>
 */
public class ArrayTestMe {
    /**This class is NOT_THREAD_SAFE.*/
    
    static long t=0,min=0,max=0,L[],H[],A[],start=0,sum=0;
    static int m=1,index=0;
    
    static ClientCommunicator ccm;
    
    public static void main(String[] arg){
        int times=4;long looptime=5l;m=1000;
        L=new long[times];H=new long[times];A=new long[times];
        ccm=new ClientCommunicator();
        for(int i=0;i<times;i++){
           // if(i==6){m*=5;}
            //else 
            m*=10;
            t=max=0l;
            min=999999999999999999L;
            best(arg);
            t+=(sum);
            min=max=sum;
            for(int j=0;j<looptime-1;j++){
                best(arg);
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
        start=sum=0l;
        ccm.reset();
        ThreadMXBean bean=ManagementFactory.getThreadMXBean();
        long id=Thread.currentThread().getId();
        if(!bean.isThreadCpuTimeSupported()){System.out.println("Unsupported.");return;}
        start=bean.getThreadCpuTime(id);
        ccm.insert(m-1,new ClientData(2));
        for(int i=0;i<m-1;i++){
            ccm.insert(i,new ClientData(i*2+9));
        }
        sum+=bean.getThreadCpuTime(id)-start;
    }
    
    static void worst(String[] arg){
        start=sum=0;
        ccm.reset();
        ThreadMXBean bean=ManagementFactory.getThreadMXBean();
        long id=Thread.currentThread().getId();
        if(!bean.isThreadCpuTimeSupported())return;
        start=bean.getThreadCpuTime(id);
        for(int i=0;i<m;i++){
            ccm.insert(i,new ClientData(i*2+9));
        }
        sum+=bean.getThreadCpuTime(id)-start;
    }
    
    static void average(String[] arg){
        long time=0L;
        ccm.reset();
        time=time+(long)((avgifunc1(m/2)));
        ccm.reset();
        time=time+(long)((avgifunc2(m/2)));
        ccm.reset();
        time=time+(long)((avgifunc3(m/2)));
        ccm.reset();
        time=time+(long)((avgifunc4(m/2)));
        ccm.reset();
        sum=(long)(time/4L);
    }
    
    static long avgifunc1(int limit1){
        start=sum=0;
        ThreadMXBean bean=ManagementFactory.getThreadMXBean();
        long id=Thread.currentThread().getId();
        if(!bean.isThreadCpuTimeSupported()){System.exit(0);}
        start=bean.getThreadCpuTime(id);
        for(int i=0;i<limit1;i++){
            ccm.insert(i,new ClientData(i*2+9));
        }
        for(int i=limit1;i<m;i++){
            ccm.insert(i,new ClientData(i*2+9));
        }
        sum+=bean.getThreadCpuTime(id)-start;
        return sum;
    }
    
    static long avgifunc2(int limit1){
        start=sum=0;
        ThreadMXBean bean=ManagementFactory.getThreadMXBean();
        long id=Thread.currentThread().getId();
        if(!bean.isThreadCpuTimeSupported()){System.exit(0);}
        start=bean.getThreadCpuTime(id);
        for(int i=0;i<limit1;i++){
            ccm.insert(i,new ClientData(i*2+9));
        }
        for(int i=limit1;i<m;i++){
            ccm.insert(i,new ClientData(i*2+9));
        }
        sum+=bean.getThreadCpuTime(id)-start;
        return sum;
    }
    
    static long avgifunc3(int limit1){
        start=sum=0;
        ThreadMXBean bean=ManagementFactory.getThreadMXBean();
        long id=Thread.currentThread().getId();
        if(!bean.isThreadCpuTimeSupported()){System.exit(0);}
        start=bean.getThreadCpuTime(id);
        for(int i=0;i<limit1;i++){
            ccm.insert(i,new ClientData(i*2+9));
        }
        for(int i=limit1;i<m;i++){
            ccm.insert(i,new ClientData(i*2+9));
        }
        sum+=bean.getThreadCpuTime(id)-start;
        return sum;
    }
    
    static long avgifunc4(int limit1){
        start=sum=0;
        ThreadMXBean bean=ManagementFactory.getThreadMXBean();
        long id=Thread.currentThread().getId();
        if(!bean.isThreadCpuTimeSupported()){System.exit(0);}
        start=bean.getThreadCpuTime(id);
        for(int i=limit1;i<m;i++){
            ccm.insert(i,new ClientData(i*2+9));
        }
        for(int i=0;i<limit1;i++){
            ccm.insert(i,new ClientData(i*2+9));
        }
        sum+=bean.getThreadCpuTime(id)-start;
        return sum;
    }
}
