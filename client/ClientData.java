package client;

/**
 *
 * @author Vivek Mangla
 */

/**
 * Defines the data required by client.
 */
public class ClientData {
    
    long data;
    /**
     * This variable is necessary as during retrieval part if data is not found 
     * this variable will be set to true.<br>
     * Also there are some synchronization specific issues in my mind , so do not remove this variable.
     */
    public boolean dataNotFound=false;
    
    public ClientData(){
        data=0;
    }
    public ClientData(long data){
        this.data=data;
    }
    
    public long value(){
        return data;
    }
    
    @Override
    public String toString(){
        return ""+data;
    }
    
}
