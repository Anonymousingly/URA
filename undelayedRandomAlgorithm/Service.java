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
import client.ClientData;


/**
 *
 * @author Vivek Mangla
 */
/**
 * Service file provides the client needs that are being satisfied now.<br>
 * Some of them are insert , delete , get , printAll.
 * Only Service class will have a direct interaction with Client.<br>
 * Rest Of the details are being kept abstract from client.<br>
 * Do not create multiple Service instances if you want to update a common object.<br>
 * Multiple Service instances means multiple Base Structures.
 */ 

public class Service {
    
    private UraInstantiator uraI;
    
    
    public Service(){
        createClient();
    }
    /**
     * Insert the data of client's object passed-by-reference in this function.
     */
    public void insert(long index,ClientData data){
        uraI.getInsert().insert(uraI,index,data,uraI.getInsert().rootTREE);
    }
    
    /**
     * Delete the data of index in a client's object passed-by-reference in this function.
     */
    public void delete(long index)throws Exception{
        uraI.getDelete().delMe(uraI,index,uraI.getInsert().rootTREE.left, uraI.getInsert().rootTREE);
        if(uraI.getDelete().delindex==false){
            throw new NotFoundException(index);
        }
    }
    /**
     * If data at index is not found i.e. index is not there in base structure,
     * it will throw an Exception but will not exit from the System.
     */
    public ClientData get(long index)throws Exception{
        ClientData data=uraI.getGet().getAtOptimal(index, uraI.getInsert().rootTREE.left);
        if(data.dataNotFound==true){
            /*For debugging also check for -1 ,i.e.
              data.value()==-1
             */
            throw new NotFoundException(index);
        }
        return data;
    }
    
    /**
     * Print All Data .
     */
    public void printAll(){
        uraI.getPrintAll().printIncreasingIndex(uraI.getInsert().rootTREE.left,0);
    }
    
    /**
     * Get the total number Of Elements Present inside Base Structure.
     */
    public long getTotalNumberOfElements(){
        return uraI.getInsert().numberOfElements;
    }
    
    /**
     * Get the Last Index at which an element is stored inside Base Structure.
     */
    public long getLastIndex(){
        return uraI.getInsert().lastIndex;
    }
    
    /**
     * Create a new Client Instance.<br>
     * <br>X Number of Service Objects will Create X different URA processing Objects .
     */
    private void createClient(){
        if(uraI==null){uraI=new UraInstantiator();}
    }
    
    /**
     * Reset the current service object .<br>
     * Will be most required during testing.
     */
    public void reset(){
        uraI.getBaseStructure().reset(uraI);
    }
    
}
