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

    public dataClass<T> getHead()
    {
        return (head);
    }
    public dataClass<T> getTail()
    {
        return (tail);
    }
    public void addNodeEnd(T nodeData)
    {
        tail.next = new dataClass<>(nodeData);
        tail = tail.next;
    }

    public static void main(String[] args) {
        iteratorImpl<String> myAdt = new iteratorImpl<>(new dataClass<String>("Intro DSA"));
        myAdt.addNodeEnd("Nestah");
        myAdt.addNodeEnd("@paNthera..!");

        /**
         * System.out.println(myAdt.getTail().data);
         *
         */
        while (myAdt.hasNext())
        {
            System.out.println(myAdt.next());
        }
        System.out.println(myAdt.next());
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
