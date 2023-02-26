/**
 * @author Ido Gutman
 * @authorID 329200216
 * @description <p>
 * Maman 15
 * </p>
 */
public class IntNode
{
    private int _value;
    private IntNode _next;
    public IntNode(int v, IntNode n) //Constructor
    {
        _value = v;
        _next = n;
    }
    public int getValue() {
        return _value;
    }
    public IntNode getNext() {
        return _next;
    }
    public void setValue(int v) {
        _value = v;
    }
    public void setNext(IntNode n) {
        _next = n;
    }
}