
package proj4orderedlist;

/**
 * Node: generic Node class used in the OrderedList class. Each node contains
 * an item and a link to the next node in the list.
 * @author Laura Josuweit
 */
public class Node<T>
{
    private T item;
    private Node<T> next;
    /**
     * CONSTRUCTOR
     */
    public Node() 
    {
    }
    /**
     * Constructor
     * @param item item for this node.
     * @param next pointer to the next node.
     */
    public Node(T item, Node next) 
    {
        this.item = item;
        this.next = next;
    }
    /**
     * Returns item in this node.
     * @return item in this node.
     */
    public T getItem() 
    {
        return item;
    }
    /**
     * Returns pointer to next node in the list.
     * @return pointer to next node in the list.
     */
    public Node getNext() 
    {
        return next;
    }

    /**
     * Changes the item this node holds.
     * @param item new item for this node.
     */
    public void setItem(T item) 
    {
        this.item = item;
    }
    /**
     * Sets what this node points to, a.k.a. the next node in the list.
     * @param next what this node will now point to.
     */
    public void setNext(Node next) 
    {
        this.next = next;
    }
    /**
     * toString.
     * @return string version of this node, which is just the toString of
     * the item in the node.
     */
    @Override
    public String toString() 
    {
        return item.toString();
    }
    
    
    
}
