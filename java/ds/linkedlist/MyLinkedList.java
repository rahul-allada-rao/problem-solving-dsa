package ds.linkedlist;

public class MyLinkedList {

    public static class Node
    {
        int data;
        Node next;
    }


    public static void main(String[] args)
    {
            int[] array1 = {1,2,3,4,5};
            Node head = new Node();
            createLinkedList(array1,head);
            printNodes(head);

        System.out.println("Middle elements : \n");
        Node midNode = findMiddleNode(head);
        printNodes(midNode);
//        isLoop();
//        Node root1 = new Node();
//        Node root2 = new Node();
//        int[] array1 = {1,2,4,3,6};

//        System.out.println("\nCreating linked list using loop --- ");
//        createLinkedList(array1, root1);
//
//        System.out.println("\nBefore insertion");
//        printNodes(root1);
//
//        System.out.println("\nIsSorted? : " + isSortedList(root1));

//        int[] array2 = {1,2, 3, 4, 5};
//        createLinkedList(array2, root2);
//        printNodes(root2);
//        System.out.println("\n");

//        reverseLinkedList(root2);
//        System.out.println("\nPrint nodes after reversal -- \n");
//        printNodes(root2);
//
//        Node q = reverseListUsingSlidingPointers(root2);
//        System.out.println("\nPrint nodes after reversal -- \n");
//        printNodes(q);


//        reverseListUsingRecursion(null, root2);
//        printNodes(root2);


//        System.out.println("\nAfter Removing duplicates : ");
//        removeDuplicates(root2);
//        printNodes(root2);

//        Node newHead1 = insertAnElementInASortedList(5, root1);


//        // insert a new node at 0th position , i.e before the current head
//        Node newHead = insertNode(root, 4, 100);

//        System.out.println("\nAfter insertion");
//        printNodes(newHead1);
//
//        System.out.println("\nDelete 6th node");
//        Node newHead2 = deleteFromPosition(6, root1);
//
//        System.out.println("\nAfter deletion");
//        printNodes(newHead2);

//// ========================
//        System.out.println("\nCreating linked list using loop --- ");
//        createLinkedList(array2, root2);
//
//        System.out.println("\nBefore insertion");
//        printNodes(root2);
//
//        Node newHead2 = insertAnElementInASortedList(0, root2);
//        System.out.println("\nAfter insertion");
//        printNodes(newHead2);

        // below are the utility functions

//        System.out.println("\nNumber of nodes = " + countNumberOfNodes(root));
//        System.out.println("Number of nodes Recursively = " + countNumberOfNodesRecursively(root));
//
//
//        System.out.println("\nSum Of All Elements = " + sumOfAllElements(root));
//        System.out.println("Sum Of All Elements Recursively = " + sumOfAllElementsRecursively(root));
//
//
//        System.out.println("\nMax Of All Elements = " + findMaxElement(root));
//        System.out.println("Max Of All Elements Recursively = " + findMaxElementRecursively(root));
//
//        System.out.println("\nMin of All Elements = " + findMinElement(root));
//        System.out.println("Min of All Elements Recursively = " + findMinElementRecursively(root));
//
//        System.out.println("\nNormal print with while loop --- ");
//        printNodes(root);
//        System.out.println("\nSerial print with recursion --- ");
//        printNodesRecursively(root);
//        System.out.println("\nReverse print with recursion --- ");
//        printNodesRecursivelyInReverseOrder(root);

    }

    public static Node findMiddleNode(Node head)
    {
        // initialize fastPointer and slowPointer - both to head node
        Node slowPointer = head;
        Node fastPointer = head;

        // while fastPointer and its next is not null,
        // keep moving fastPointer by 2 nodes
        // keep moving slowPointer by 1 node
        // when fastPointer reaches the end of the list, the slowPointer will point to the middle of the list
        while (fastPointer != null && fastPointer.next != null)
        {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    public static void createLinkedList(int[] array, Node head)
    {
        Node temp;
        Node tail;
        head.data = array[0];
        head.next = null;
        tail = head;

        for (int i = 1 ; i < array.length; i++)
        {
            temp = new Node();
            temp.data = array[i];
            temp.next = null;

            tail.next = temp;
            tail = temp;
        }
    }

    /**
     * Time complexity = O(n) --> because printing is done for n number of nodes
     * Space complexity = 0 ?? --> todo: need to confirm on this.
     * @param rootNode
     */
    public static void printNodes(Node rootNode)
    {
        while (rootNode != null)
        {
            System.out.print(rootNode.data + "\t");
            rootNode = rootNode.next;
        }
    }


    /**
     * Time complexity = O(n) --> because printing is done for n number of nodes
     * Space complexity = n+1  = n --> because of recursive calls that puts the activation records in the stack for n records + node=null value as well
     * @param rootNode
     */
    public static void printNodesRecursively(Node rootNode)
    {
        if (rootNode != null) // base condition for continuity
        {
            System.out.print(rootNode.data + "\t");
            printNodesRecursively(rootNode.next);
        }
    }


    /** print Nodes Recursively In Reverse Order
     * Time complexity = O(n) --> because printing is done for n number of nodes
     * Space complexity = n+1  = n --> because of recursive calls that puts the activation records in the stack for n records + node=null value as well
     * @param rootNode
     */
    public static void printNodesRecursivelyInReverseOrder(Node rootNode)
    {
        if (rootNode != null) // base condition for continuity
        {
            printNodesRecursivelyInReverseOrder(rootNode.next);
            System.out.print(rootNode.data + "\t");
        }
    }


    /**
     * Time complexity = O(n) --> because we are traversing through the entire list
     * Space complexity = space for the parameter + space for the variable = constant space = O(1)
     * @param root
     * @return
     */
    public static int countNumberOfNodes(Node root)
    {
        int count = 0 ;
        while (root != null)
        {
            count++;
            root = root.next;
        }
        return count;
    }

    /**
     * Time complexity = O(n) --> because we are traversing through the entire list
     * Space complexity = space for the parameter + space for the variable = constant space = O(1)
     * @param root
     * @return
     */
    public static int countNumberOfNodesRecursively(Node root)
    {
        if (root == null)
            return 0;
        else
            return countNumberOfNodesRecursively(root.next) + 1;
    }


    /**
     * Time complexity = O(n) --> because we are traversing through the entire list
     * Space complexity = space for the parameter + space for the variable = constant space = O(1)
     * @param root
     * @return
     */
    public static int sumOfAllElements(Node root)
    {
        int sum = 0 ;
        while (root != null)
        {
            sum = sum + root.data;
            root = root.next;
        }
        return sum;
    }

    /**
     * Time complexity = O(n) --> because we are traversing through the entire list
     * Space complexity = space for the activation record in stack =  n+1 = O(n)
     * @param root
     * @return
     */
    public static int sumOfAllElementsRecursively(Node root)
    {
        int sum = 0 ;
        if (root == null)
        {
            return 0;
        }
        else
        {
            sum = root.data + sumOfAllElementsRecursively(root.next);
        }
        return sum;
    }

    /**
     * Time complexity = O(n) --> because we are traversing through the entire list
     * Space complexity = space for the parameter + space for the variable = constant space = O(1)
     * @param root
     * @return
     */
    public static int findMaxElement(Node root)
    {
        int maxElement = Integer.MIN_VALUE ;
        while (root != null)
        {
            if (maxElement < root.data)
            {
                maxElement = root.data;
            }
            root = root.next;
        }
        return maxElement;
    }

    public static int findMaxElementRecursively(Node root)
    {
        int maxElement = 0 ;
        if (root == null)
            return Integer.MIN_VALUE;

        maxElement = findMaxElementRecursively(root.next);
        return maxElement > root.data ? maxElement : root.data;
    }

    public static int findMinElement(Node root)
    {
        int minElement = Integer.MAX_VALUE ;
        while (root != null)
        {
            if (root.data < minElement)
            {
                minElement = root.data;
            }
            root = root.next;
        }
        return minElement;
    }

    public static int findMinElementRecursively(Node root)
    {
        int minElement = 0 ;
        if (root == null)
            return Integer.MAX_VALUE;

        minElement = findMinElementRecursively(root.next);
        return minElement < root.data ? minElement : root.data;
    }


    public static Node insertNode(Node head, int position, int value)
    {
        /** if position = 0, i.e if new node is to be added before the current head, then:
         *  1. create a new node
         *  2. set data on the new node
         *  3. set new node's next --> head , i.e.new node should next point to current head
         *  4. set current head = newly created node
         */
        if (position == 0)
        {
            Node newNode = new Node();
            newNode.data = value;
            newNode.next = head;
            head = newNode;
        }
        else if ( position > 0)
        {
            /**
             *  if new node is to be added anywhere else, then
             *  1. Take a pointer, initially pointing to head
             *  2. This pointer needs to be moved (position - 1) times, so if new node is to be added after 4th position,
             *      then the pointer needs to be moved 3 times
             *  3. Create the new node, set the data
             *  4. newNode.next = current pointer.next
             *  5. current.next = newNode
             */

            Node temp = head;

            for (int i =0 ; i < position-1 && temp != null ; i++)
            {
                temp = temp.next;
            }

            if (temp != null)
            {
                Node newNode = new Node();
                newNode.data = value;
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }

        return head;
    }

    // precondition to always add at last - tail pointer should be present
    public static void insertAtLast(Node head, Node tail, int val)
    {
        Node newNode = new Node();
        newNode.data = val;

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode; // link the current last node's next to this newly created node
            tail = newNode; // move the tail itself to point to the newly created node
        }
    }


    /**
     *  keep two pointers - head and tail
        keep moving the pointers till this node < "val" < node
        change the links; check for special conditions
     * @param val
     * @param head
     * @return
     */
    public static Node insertAnElementInASortedList(int val, Node head)
    {
        Node newNode = new Node();
        newNode.data = val;
        newNode.next = null;

        Node temp = head;
        Node tail = null;

        // check for special condition when there are no nodes at all - then head becomes the new node being created
        if (temp == null)
        {
            temp = newNode;
            return temp;
        }
        else
        {
            while (temp != null && temp.data < val)
            {
                tail = temp;
                temp = temp.next;
            }

            // we need to do this for the special case when there is only one node in the list and
            // the current element is greater than the value that needs to be inserted,
            // i.e this new value needs to be inserted to the left of the current head
            if (temp == head)
            {
                newNode.next = temp;
                temp = newNode;
                return temp;
            }
            else
            {
                newNode.next = tail.next; // as, tail.next is pointing to temp currently, so this link has to be changed to the newNode->next
                tail.next=newNode; // now, tail.next should point to the newNode being created
            }
        }

        return head;
    }

    /**
     * two nodes are required - one to move and another one to physically deallocate the memory of the node to be deleted
     * @param head
     * @return
     */
    public static Node deleteFirstNode(Node head)
    {
        Node temp = head; // initialize a temporary node with head
        head = head.next; // move the head to its next position
        temp = null;      // set temp to null -> this basically is deleting the node's memory
        return head;      // return new head
    }

    public static Node deleteFromPosition(int pos, Node head)
    {
        Node temp = head;
        Node tail = null;
        int i = 1;

        if (pos == 1)
        {
            return deleteFirstNode(head);
        }
        else
        {
            while (temp != null && i <= pos - 1)
            {
                tail = temp;
                temp = temp.next;
                i++;
            }

            if (temp != null)
            {
                tail.next = temp.next;
            }
            temp = null;
        }
        return head;
    }

    public static boolean isSortedList(Node head)
    {
        Node temp = head;
        int value = Integer.MIN_VALUE;
        while (temp != null)
        {
            if (temp.data < value) // check the condition for failure first
            {
                return false;
            }
            else
            {
                value = temp.data;
                temp = temp.next;
            }
        }
        return true;
    }

    /**
     * To remove duplicates, we need two pointers to do a comparision
     * @param head
     * @return
     */
    public static Node removeDuplicates(Node head)
    {
        Node q = head.next;
        Node temp = head;

        while (q != null)
        {
            if (temp.data != q.data)
            {
                temp = q;
                q = q.next;
            }
            else
            {
                temp.next = q.next;
                q = temp.next;
            }
        }
        return head;
    }

    /**
     * Two ways of reversing a linked list
     * 1. Reverse the elements (Nodes will remain the same)
     *      1, 2, 3, 4, 5 --> 5, 4, 3, 2, 1
     * 2. Reversing the links (Sliding pointers)
     *      1, 2, 3, 4, 5 --> 5 point to 4, 4 point to 3, 3 point to 2, 2 point to 1
     * @param head
     */
    public static Node reverseLinkedList(Node head)
    {
        // method 1 - Reverse the elements (Nodes will remain the same)
        // count the number of nodes
        // create an array with the values from above
        // reverse copy the array values into the linked list

        // step:1 --> Count the number of nodes
        Node temp = head;
        int noOfNodes = countNumberOfNodesRecursively(head);

        // step:2 --> create an array with size = number of nodes
        int[] array = new int[noOfNodes];

        // step:3 --> populate the array with the node values
        while (temp != null)
        {
            for (int i = 0; i < noOfNodes ; i++)
            {
                array[i] = temp.data;
                temp = temp.next;
            }
        }

        // step:3 --> overwrite the linked list with the array values in the reverse order
        temp = head;
        while (temp != null)
        {
            for (int j = noOfNodes-1; j >=0 ; j--)
            {
                temp.data = array[j];
                temp = temp.next;
            }
        }

        return head;
    }

    /**
     * This should be the preferred approach to reverse a linked list compared to reversing the data
     * @param head
     * @return
     */
    public static Node reverseListUsingSlidingPointers(Node head)
    {
        Node temp = head;
        Node q = null;
        Node r = null;

        while (temp != null)
        {
            r = q;
            q = temp;
            temp = temp.next;
            q.next = r;
        }
        head = q;
        return head;
    }

    public static void reverseListUsingRecursion(Node tail, Node head)
    {
        if (head != null)
        {
            reverseListUsingRecursion(head, head.next); // moving head pointer
            head.next = tail; // while coming back
        }
        else
        {
            head = tail;
        }
    }

    /**
     * Loop in a linked list exist when one of the nodes points to another node in the linked list
     * Way to detect loop is to have two pointes "p" and "q", such that
     *  p moves 1 step
     *  q moves 2 steps
     *  Analogy = two cars moving at different speed in a circular track - they are bound to meet
     *  If its a linear track then the cars will never meet because of the difference in speed (second car is moving at a greater speed)
     *
     *  This API will return TRUE if there is a loop, else FALSE which would mean that the linked list is Linear (the last node terminates with null)
     * @return boolean
     */
    public static boolean isLoop()
    {
        Node head = new Node();
        head.data = 1;

        Node node2 = new Node();
        node2.data = 2;

        Node node3 = new Node();
        node3.data = 3;

        Node node4 = new Node();
        node4.data = 4;


        Node node5 = new Node();
        node5.data = 5;


        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;


        Node p = head;
        Node q = head;

        do
        {
            p = p.next;
            q = q.next;
            q = q != null ? q.next : q; // don't blindly move q to next ; q could be null at this point, so check for this condition
        }
        while (p != null && q != null && p != q);

        if (p == q)
        {
            System.out.println("\n The given linked list is a LOOP");
        }
        else
        {
            System.out.println("\n The given linked list is LINEAR");
        }

        return p == q ? true : false;
    }
}
