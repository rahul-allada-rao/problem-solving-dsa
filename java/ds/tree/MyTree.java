//package ds.tree;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class MyTree
//{
//    class Node{
//        Node left;
//        int data;
//        Node right;
//    }
//
//    class Queue{
//        Node front =null;
//        Node rear = null
//        int[] queue ;
//        int SIZE;
//
//        public Queue(int size)
//        {
//            SIZE = size;
//            queue = new int[size];
//        }
//
//        public void enqueue(Node node)
//        {
//            if (!isFull())
//            {
//                rear = (rear + 1) % SIZE ;
//                queue[rear] = element;
//            }
//            else
//            {
//                System.out.println("Queue is full!");
//            }
//        }
//
//        public int dequeue()
//        {
//            int value = -1;
//            if (isEmpty())
//            {
//                System.out.println("Cannot delete, queue is empty !!!");
//            }
//            else
//            {
//                front = ( front + 1 ) % SIZE;
//                value = queue[front];
//            }
//
//            return value;
//        }
//
//        public boolean isEmpty()
//        {
//            return front == rear;
//        }
//    }
//
//    public Node root;
//
//    public void createTree()
//    {
//        Node root = new Node();
//        Scanner scanner = new Scanner();
//        root.data = array[0];
//        root.left = null;
//        root.right = null;
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//
//        int i=1;
//        while (!queue.isEmpty() && i <= array.length - 1)
//        {
//            Node p = new Node();
//            p.data = array[i];
//            p.left = null;
//            p.right = null;
//
//            // left child
//            Node temp = queue.remove()
//        }
//    }
//}
