package ds.linkedlist;

public class MyLL {

    private static Node head;
    private static int countUsingStaticVar = 0;

    static class Node {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
        }

        Node()
        {
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5};
        head = new Node();
        head = createLinkedList(arr);
        System.out.println("General Display ---");
        display(head);

        System.out.println("Recursive Display ---");
        displayUsingRecursion(head);
        System.out.println();

        System.out.println("Reverse Display ---");
        displayReverseUsingRecursion(head);
        System.out.println();

//        System.out.println("Reverse LL ---");
//        head = reverse(head, null);
//        display(head);
//        System.out.println();

        System.out.println("Count nodes in LL ---");
        System.out.println(coundNodes(head));
        System.out.println();

        System.out.println("Recursive Count nodes in LL ---");
        System.out.println(countNodeRecursive(head));
        System.out.println();

        System.out.println("Recursive Count nodes with StaticVariable in LL ---");
        System.out.println(countNodeRecursiveWithStaticVariable(head));
        System.out.println();

        System.out.println("SumOfAllNodes in LL ---");
        System.out.println(sumOfAllNodes(head));
        System.out.println();

        System.out.println("sumOfAllNodesRecursive in LL ---");
        System.out.println(sumOfAllNodesRecursive(head));
        System.out.println();

        System.out.println("maxElement in LL ---");
        System.out.println(maxElement(head));
        System.out.println();

        System.out.println("maxElementRecursive in LL ---");
        System.out.println(maxElementRecursive(head));
        System.out.println();

        System.out.println("minElement in LL ---");
        System.out.println(minElement(head));
        System.out.println();

        System.out.println("minElementRecursive in LL ---");
        System.out.println(minElementRecursive(head));
        System.out.println();

        System.out.println("searchForKey : " + 3 + " in LL ---");
        searchForKey(head, 3);
        System.out.println("searchForKey : " + 6 + " in LL ---");
        searchForKey(head, 6);
        System.out.println();


    }


    private static void searchForKey(Node root, int key) {
        while (root != null) {
            if (root.data == key) {
                System.out.println("Key : " + key +  " found at node : " + root);
                return;
            }
            root = root.next;
        }

        System.out.println("Key not found!");
    }

    private static int minElement(Node root)
    {
        int minElement = Integer.MAX_VALUE;
        while (root != null) {
            if (root.data < minElement) {
                minElement = root.data;
            }
            root = root.next;
        }
        return minElement;
    }

    private static int minElementRecursive(Node root)
    {
        int min = 0;
        if (root == null) {
            return 0;
        } else {
            if (root.data <= min){
                min = root.data;
            }
            min = minElementRecursive(root.next);
        }
        return min;
    }


    private static int maxElement(Node root)
    {
        int maxElement = Integer.MIN_VALUE;
        while (root != null) {
            if (root.data > maxElement) {
                maxElement = root.data;
            }
            root = root.next;
        }
        return maxElement;
    }

    private static int maxElementRecursive(Node root)
    {
        int max;
        if (root == null) {
            return 0;
        } else {
            max = maxElementRecursive(root.next);
            if (root.data > max){
                max = root.data;
            }
        }
        return max;
    }

    private static int sumOfAllNodes(Node head)
    {
        int sum = 0;
        while (head != null) {
            sum = sum + head.data;
            head = head.next;
        }
        return sum;
    }

    private static int sumOfAllNodesRecursive(Node head)
    {
        if (head == null) {
            return 0;
        } else return sumOfAllNodes(head.next) + head.data;
    }

    private static int coundNodes(Node root)
    {
        int count = 0;

        while (root != null) {
            count++;
            root = root.next;
        }
        return count;
    }

    private static int countNodeRecursive(Node root)
    {

        if (root == null) {
            return 0;
        } else return countNodeRecursive(root.next) + 1;
    }

    private static int countNodeRecursiveWithStaticVariable(Node root)
    {

        if (root == null) {
            return countUsingStaticVar;
        } else {
            countUsingStaticVar++;
            countNodeRecursiveWithStaticVariable(root.next);
        }
        return countUsingStaticVar;
    }

    private static Node reverse(Node p, Node q)
    {

        Node temp;

        if (p != null) {
            temp = reverse(p.next, p);
            p.next = q;
        } else {
            temp = q;
        }

        return temp;
    }

    private static Node createLinkedList(int[] arr)
    {
        head.data = arr[0];
        head.next = null;

        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            newNode.next = null;

            temp.next = newNode;
            temp = newNode;
        }

        return head;
    }

    public static void display(Node root)
    {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    private static void displayUsingRecursion(Node root)
    {
        if (root != null) {
            System.out.print(root.data + "\t");
            displayUsingRecursion(root.next);
        }
    }

    private static void displayReverseUsingRecursion(Node root)
    {
        if (root != null) {
            displayReverseUsingRecursion(root.next);
            System.out.print(root.data + "\t");
        }
    }
}
