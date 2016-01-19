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
/**
 *
 * @author Vivek Mangla
 */

/**
 * Remember to use UraInstantiator instance with care.<br>
 * Multiple UraInstantiator instances means multiple dataObjects for performing insert,delete
 * retrieve etc .<br>
 * One UraInstantiator instance is equivalent to One Client.<br>
 * NOTE::: This Will Not Create Separate Process  in O.S. But Every Instance Will Have It's Own
 * Data So If You Choose TO Use Multiple Instances ,Make Sure That You Don't Come 
 * Across The Problem Of Unknowingly Data Alteration.<br>
 */
public class UraInstantiator {
    
    private BaseNode bn;
    private BaseStructure bs;
    private Delete d;
    private Get g;
    private Insert i;
    private Tracker mm;
    private PrintAll pa;
    private Service s;
    private TrackerNode tn;
    
    UraInstantiator(){
        
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
