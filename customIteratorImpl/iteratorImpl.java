package customIteratorImpl;

import java.util.Iterator;

public class iteratorImpl<T> implements Iterator<T> {
    dataClass<T> head,tail, currentNode;

    public iteratorImpl(dataClass<T> headNode)
    {
        tail = head = currentNode = headNode;
    }
    @Override
    public boolean hasNext() {
        return (currentNode.next != null);
    }

    @Override
    public T next() {
        T nodeData = currentNode.data;
        currentNode = currentNode.next;
        return (nodeData);
    }
    /**
     *  @Override
     *  public void remove()
     *  {}
     */
    public T getHead()
    {
        return (head.data);
    }
    public T getTail()
    {
        return (tail.data);
    }
    public void addNodeEnd(T nodeData)
    {
        tail.next = new dataClass<>(nodeData);
        tail = tail.next;
    }
    public void addNodeStart(T nodeData)
    {
        dataClass<T> tempNode = new dataClass<>(nodeData);
        tempNode.next = head;
        head = currentNode = tempNode;
    }

    public static void main(String[] args) {
        iteratorImpl<String> myAdt = new iteratorImpl<>(new dataClass<String>("Intro DSA"));
        myAdt.addNodeEnd("Intro Systems Programming");
        myAdt.addNodeEnd("Internet Application Programming");
        myAdt.addNodeStart("Object Oriented Programming");
        /**
         * System.out.println(myAdt.getTail());
         * System.out.println(myAdt.getHead());
         */
        while (myAdt.hasNext())
        {
            System.out.println(myAdt.next());
        }
        System.out.println(myAdt.getTail());
    }
}

class dataClass<T>{
    T data;
    dataClass<T> next;
    public dataClass(T nodeData)
    {
        data = nodeData;
        next = null;
    }
    public dataClass()
    {}
    public void setData(T data)
    {
        this.data = data;
    }
    public void setNext(dataClass<T> newNode)
    {
        this.next = newNode;
    }
    public T getData()
    {
        return (data);
    }
    public dataClass<T> getNext()
    {
        return (next);
    }
}
