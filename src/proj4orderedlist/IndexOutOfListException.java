
package proj4orderedlist;

/**
 * Exception thrown when user tries to get the value at an index not valid 
 * for a given OrderedList.
 * @author Laura
 */
public class IndexOutOfListException extends Exception
{
    @Override
    public String getMessage()
    {//an appropriate error message
        return "Error: That index is out of bounds.";
    }  
}
