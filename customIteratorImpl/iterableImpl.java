package customIteratorImpl;

import java.util.Iterator;

public class iterableImpl<T> implements Iterable<T> {
    Node<T> node;
    public iterableImpl(Node<T> node)
    {
        this.node = node;
    }
    @Override
    public Iterator<T> iterator() {
        return (new CustomIterator<>(node));
    }

    public static void main(String[] args)
    {
        iterableImpl customIterable = new iterableImpl(new Node("DSA"));
        CustomIterator myDataIterator = (CustomIterator) customIterable.iterator();
        myDataIterator.addNodeEnd("OOP");
        myDataIterator.addNodeEnd("Systems Programming");
        myDataIterator.addNodeEnd("Operating Systems I");
        myDataIterator.addNodeStart("Internet application Programming");

        //System.out.println(myDataIterator.getHead());
        //System.out.println(myDataIterator.getTail());
        for (Object node1 : customIterable)
        {
            System.out.println(node1);
        }
    }
}

class CustomIterator<T> implements Iterator<T> {
    Node<T> headNode, tailNode, currentNode;

    public CustomIterator(Node<T> node)
    {
        headNode = currentNode = tailNode = node;
    }
    @Override
    public boolean hasNext() {
        return (currentNode.nextNode != null);
    }

    @Override
    public T next() {
        T nodeData = currentNode.data;
        currentNode = currentNode.nextNode;
        return (nodeData);
    }
    public void addNodeEnd(T nodeData)
    {
        tailNode.nextNode = new Node<>(nodeData);
        tailNode = tailNode.nextNode;
    }
    public void addNodeStart(T nodeData)
    {
        Node<T> tempNode = new Node<>(nodeData);
        tempNode.nextNode = headNode;
        headNode = currentNode = tempNode;
    }
    public T getTail()
    {
        return (tailNode.data);
    }
    public T getHead()
    {
        return (headNode.data);
    }
}
class Node<T> {
    T data;
    Node<T> nextNode;

    public Node(T data)
    {
        this.data = data;
        this.nextNode = null;
    }
    public Node(){}
}
