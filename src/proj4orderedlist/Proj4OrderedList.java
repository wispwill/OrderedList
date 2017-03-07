
package proj4orderedlist;

/**
 * Testing Class for OrderedList.
 * @author Laura Josuweit
 */
public class Proj4OrderedList
{
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        OrderedList<Integer> intlist = new OrderedList<>();
        //TESTING INSERT, ISEMPTY, GETLENGTH, AND TOSTRING
        System.out.println(intlist);
        System.out.println("Is intlist empty?: "+intlist.isEmpty());
        
        intlist.insert(6);
        System.out.println(intlist);
        intlist.insert(5);
        System.out.println(intlist);
        intlist.insert(90);
        System.out.println(intlist);
        intlist.insert(1);
        System.out.println(intlist);
        intlist.insert(2);
        System.out.println(intlist);
        
        System.out.println("Length: "+intlist.getLength());
        System.out.println("Is intlist empty?: "+intlist.isEmpty());
        
        //TESTING REMOVE METHOD
        System.out.println("Removing 90 Successful? "+intlist.remove(90));
        System.out.println(intlist);
        System.out.println("Length: "+intlist.getLength());
        
        System.out.println("Removing 1 Successful? "+intlist.remove(1));
        System.out.println(intlist);
        System.out.println("Length: "+intlist.getLength());
        
        System.out.println("Removing 5 Successful? "+intlist.remove(5));
        System.out.println(intlist);
        System.out.println("Length: "+intlist.getLength());

        System.out.println("Removing 90 Successful? "+intlist.remove(90));
        System.out.println(intlist);
        System.out.println("Length: "+intlist.getLength());
        //TESTING GET METHOD
        System.out.println("Adding 15, 15, and 23...");
        intlist.insert(15);
        intlist.insert(15);
        intlist.insert(23);
        System.out.println(intlist);
        
        try
        {
            System.out.println("Item at Index 2: "+intlist.get(2));
        }
        catch(IndexOutOfListException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        try
        {
            System.out.println("Item at Index 0: "+intlist.get(0));
        }
        catch(IndexOutOfListException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        try
        {
            System.out.println("Item at Index -5: "+intlist.get(-5));
        }
        catch(IndexOutOfListException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        //TESTING GETKLARGEST METHOD
        System.out.println("Making list of 3 biggest items in intlist...");
        OrderedList<Integer> intlist2 = intlist.getkLargest(3);
        System.out.println(intlist2);
        
        //TESING ADD METHOD
        System.out.println("Adding both lists together...");
        OrderedList intlist3 = intlist.add(intlist2);
        System.out.println(intlist3);
        System.out.println(intlist3.getLength());
        
        OrderedList<Integer> emptyl = new OrderedList<>();
        
        System.out.println("Adding an empty list to that...");
        OrderedList<Integer> intlist4 = intlist3.add(emptyl);
        System.out.println(intlist4);
        System.out.println(intlist4.getLength());
        
        System.out.println("Adding that to an empty list...");
        OrderedList<Integer> intlist5 = emptyl.add(intlist4);
        System.out.println(intlist5);
        System.out.println(intlist5.getLength());
        
        
        OrderedList<String> strlist = new OrderedList<>();
        
        strlist.insert("Yo");
        strlist.insert("Hi");
        strlist.insert("Pineapple");
        
        System.out.println(strlist);
        

    }
    
}
