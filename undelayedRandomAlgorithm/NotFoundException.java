package undelayedRandomAlgorithm;

/**
 *
 * @author Vivek Mangla
 */

/**
 * Exception::Element Not Found at the desired index.<br>
 * Can be modified to contain desired exceptions.
 */
public class NotFoundException extends Exception {
    
    public NotFoundException(long index){
        System.out.println("INDEX = "+index+" has not been found");
    }
    
}
