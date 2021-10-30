package leetcode;

public class StackUsingLinkedList {

    public class Node{
        int data;
        Node next;
    }

    Node top;

    StackUsingLinkedList(){
        top = null;
    }

    // we don't check for overflow conditions because in linked list implementations, we don't specify max stack size.
    // the list can grow/shrink dynamically
    public void push(int data){
        Node prevTop = top;
        top  = new Node();
        top.data = data;
        top.next = prevTop;
    }

    public void pop(){

        if (top == null)
        {
            System.out.println("Underflow condition!!!");
            return;
        }

        top = top.next;


    }

    public int peek(){
        if (!isEmpty())
        {
            return top.data;
        }
        else {
            System.out.println("Stack is Empty!!!");
            return -1;
        }
    }

    // we won't be able to know in LinkedList implementation of stack
//    public boolean isFull(){
//
//    }

    public boolean isEmpty(){
        return top == null;
    }


    public void displayElementsInStack(){

        Node temp = top;
        while (temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args)
    {
        StackUsingLinkedList obj = new StackUsingLinkedList();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);

        System.out.println("Original stack -- ");
        obj.displayElementsInStack();

        obj.peek();

        System.out.println("Stack after peek -- ");
        obj.displayElementsInStack();

        obj.pop();
        obj.pop();
        obj.pop();

        System.out.println("Stack after 3 pops -- ");
        obj.displayElementsInStack();

    }
}
