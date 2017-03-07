
package proj4orderedlist;

/**
 * OrderedList: a generic Linked List type of data structure that stores its
 * items in ascending order based on their compareTo method.
 * The type T stored in this class must implement the Comparable interface.
 * Has methods for inserting new items, retrieving items at an index, 
 * removing items, etc.
 * @author Laura Josuweit
 * @param <T> Datatype that implements the Comparable interface.
 */
public class OrderedList<T extends Comparable>
{
    private Node<T> first;
    private int length;
    /**
     * CONSTRUCTOR
     */
    public OrderedList()
    {
        first = null;
        length = 0;
    }
    /**
     * Adds a new item to this ordered list, keeping ascending order 
     * of elements.
     * @param e item to be added to list.
     */
    public void insert(T e)
    { 
        Node<T> enode = new Node(e, null);
        if(length == 0)//empty list
            first = enode;
        else
        { //if the new node is smaller than the first node
            if(e.compareTo(first.getItem()) < 1)
            {
                enode.setNext(first);
                first = enode;
            }
            
            //check if this node should be between every node pair
            //keep going down the list until we have set the node, with
            //a check for whether or not we are at the end of the list.
            else
            {
                boolean nodePlaced = false;
                for (Node<T> n = first; !nodePlaced; n = n.getNext())
                {//if you hit the end without placement, it must be the 
                    //biggest
                    if(n.getNext() == null)
                    {
                        n.setNext(enode);
                        nodePlaced = true;
                    }

                    //if bigger than this node, but smaller/equal to the 
                    //next, place node
                    else if(e.compareTo(n.getItem()) == 1 && 
                            e.compareTo(n.getNext().getItem()) < 1)
                    {
                        enode.setNext(n.getNext());
                        n.setNext(enode);
                        nodePlaced = true;
                    }
                }
            }
            
        }
        //no matter what, increment length
        length++;
    }
    /**
     * Removes first instance of an object in this list, if it is in the list,
     * and returns whether or not the remove was successful.
     * @param e object we want removed.
     * @return true if something was removed, false if nothing was removed.
     */
    public boolean remove(T e)
    {//check the first node for a match
        if(first.getItem().equals(e))
        {//if they match, we remove it
            first = first.getNext();
            length--;
            return true;
        }
        //Otherwise, go through all our nodes.
        //We are comparing e not to n, but to n.getNext(). That way if we 
        //find a match, we still have access to the last node.
        for (Node<T> n = first; n.getNext() != null; n = n.getNext())
        {//if the next node is equal to e,
            if(e.equals(n.getNext().getItem()))
            {//link it the the node after that one.
                n.setNext(n.getNext().getNext());
                length--;
                return true;
            }           
        }
        return false;
    }
    /**
     * Returns the object at the given index.
     * @param k index of item to be retrieved.
     * @return object at index k.
     * @throws IndexOutOfListException when given an index smaller than 0 or
     * bigger than or equal to the length of the list.
     */
    public T get(int k) throws IndexOutOfListException
    {
        if(k >= length || k < 0)
            throw new IndexOutOfListException();
        else
        {
            Node<T> n = first;
            for (int i = 0; i < k; i++)
            {
                n = n.getNext();
            }
            return n.getItem();
        }
    }
    /**
     * Returns number of elements in this list (aka the length.)
     * @return length of this list.
     */
    public int getLength()
    {
        return length;
    }
    /**
     * Checks if list is empty or not.
     * @return true if list is empty, false if it is not empty.
     */
    public boolean isEmpty()
    {
        return length == 0;       
    }
    /**
     * Returns an OrderedList that contains the k biggest items in this list.
     * @param k how many of the biggest items we want.
     * @return new OrderedList of the k biggest things in this list.
     */
    public OrderedList<T> getkLargest(int k)
    {// if they want more elements than we have list, assume they just want
        //the whole list.
        if(k > length)
            k = length;
        //if they want a list of length 0 or under, return empty list.
        if(k <= 0)
            return new OrderedList<>();
        
        OrderedList<T> klist = new OrderedList<>();
        Node<T> n = first;
        //traverse list until we get to the first element of our new list
        for (int i = 0; i < length - k; i++)
            n = n.getNext();
        //now that we are at the beginning of what we need, add each 
        //successive item to the new list.
        for (; n != null; n = n.getNext())
        {
            klist.insert(n.getItem());
        }
        
        return klist;
    }
    /**
     * Creates a new list by adding two OrderedLists together.
     * @param l2 the second list to be added to this one.
     * @return the new list created.
     */
    public OrderedList<T> add(OrderedList<T> l2)
    {
        OrderedList<T> newlist = new OrderedList<>();
        //add all of this list to the new list
        for (Node<T> n = first; n != null; n = n.getNext())
            newlist.insert(n.getItem());
        //add all of the second list to the new list
        //we can't access the nodes of a list individually from outside it,
        //so we will get its values this way instead (using its get method)
        for (int i = 0; i < l2.getLength(); i++)
        {
            try
            {
                newlist.insert(l2.get(i));
            }
            catch(IndexOutOfListException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        return newlist;
    }
    /**
     * toString Method.
     * @return string version of this list in the form [item1, item2, ...]
     */
    @Override
    public String toString()
    {
        if(length == 0)
            return "[]";
        String str = "[" + first.getItem();
        for (Node<T> n = first.getNext(); n != null; n = n.getNext())
        {
            str += ", "+n.getItem();
        }
        str += "]";
        return str;
    }    
}
