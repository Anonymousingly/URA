package client;

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
    
    ClientCommunicator(){
        createService();
    }
    synchronized private void createService(){
        serve=new Service();
    }
    
    synchronized void insert(long index,ClientData data){
        serve.insert(index, data);
    }
    
    synchronized void delete(long index)throws Exception{
        serve.delete(index);
    }
    
    synchronized ClientData get(long index)throws Exception{
        return serve.get(index);
    }
    
    synchronized long getDataCount(){
        return serve.getTotalNumberOfElements();
    }
    
    synchronized long getLastIndex(){
        return serve.getLastIndex();
    }
    
    synchronized void printAll(){
        serve.printAll();
    }
    
}
