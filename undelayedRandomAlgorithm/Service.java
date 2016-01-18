package undelayedRandomAlgorithm;

import client.ClientData;


/**
 *
 * @author Vivek Mangla
 */
/**
 * Service file provides the client needs that are being satisfied now.<br>
 * Some of them are insert , delete , get , printAll.
 * Only Service class will have a direct interaction with Client.
 * Rest Of the details are being kept abstract from client.
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
