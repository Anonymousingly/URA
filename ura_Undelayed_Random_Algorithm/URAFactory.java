package ura_Undelayed_Random_Algorithm;

/**
 *
 * @author Vivek Mangla
 */

/**
 * Remember to use URAFactory instance with care.<br>
 * Multiple URAFactory instances means multiple data for performing insert,delete
 * retrieve etc .<br>
 * One URAFactory instance is equivalent to One Client.<br>
 * NOTE::: This Will Not Create Separate Process  in O.S. But Every Instance Will Have It's Own
 * Data So If You Choose TO Use Multiple Instances ,Make Sure That You Don't Come 
 * Across The Problem Of Unknowingly Data Alteration.<br>
 */
public class URAFactory {
    
    private BaseNode bn;
    private BaseStructure bs;
    private Delete d;
    private Get g;
    private Insert i;
    private Tracker mm;
    private PrintAll pa;
    private Service s;
    private TrackerNode tn;
    
    URAFactory(){
        
    }
    
    public BaseNode getBaseNode(){
        return bn==null?bn=new BaseNode():bn;
    }
    
    public BaseStructure getBaseStructure(){
        return bs==null?bs=new BaseStructure():bs;
    }
    
    public Delete getDelete(){
        return d==null?d=new Delete():d;
    }
    
    public Get getGet(){
        return g==null?g=new Get():g;
    }
    
    public Insert getInsert(){
        return i==null?i=new Insert():i;
    }
    
    public Tracker getMinMax(){
        return mm==null?mm=new Tracker():mm;
    }
    
    public PrintAll getPrintAll(){
        return pa==null?pa=new PrintAll():pa;
    }
    
    public Service getService(){
        return s==null?s=new Service():s;
    }
    
    public TrackerNode getTrackerNode(){
        return tn==null?tn=new TrackerNode():tn;
    }
    
}
