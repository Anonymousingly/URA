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
import undelayedRandomAlgorithm.Service;

/**
 *
 * @author Vivek Mangla
 */

/**
 * This defines synchronized access to Services provide by undelayedRandomAlgorithm package.
 * In case client uses multi-threading ,must use this class.<br>
 * Otherwise , still use this class as it is completely removing implementation details from 
 * client.
 */
public class ClientCommunicator {
    
    Service serve;
    
    public ClientCommunicator(){
        createService();
    }
    private synchronized void createService(){
        //For synchronization purpose check if it is null or not.
        if(serve==null)serve=new Service();
    }
    
    public synchronized void insert(long index,ClientData data){
        serve.insert(index, data);
    }
    
    public synchronized void delete(long index)throws Exception{
        serve.delete(index);
    }
    
    public synchronized ClientData get(long index)throws Exception{
        return serve.get(index);
    }
    
    public synchronized long getDataCount(){
        return serve.getTotalNumberOfElements();
    }
    
    public synchronized long getLastIndex(){
        return serve.getLastIndex();
    }
    
    public synchronized void printAll(){
        serve.printAll();
    }
    
    public synchronized void reset(){
        serve.reset();
    }
    
}
