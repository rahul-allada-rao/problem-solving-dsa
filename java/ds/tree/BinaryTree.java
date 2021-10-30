package ds.tree;

/**
 * tree
 ----
         6    <-- root
        /  \
       4    8
      / \  / \
     3  5  7  9
 */

class Node
{
    int data;
    Node left, right;

    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}
public class BinaryTree
{
    private Node root;

    public Node getRoot()
    {
        return root;
    }

    public BinaryTree(Node root)
    {
        this.root = root;
    }

    public BinaryTree()
    {
        root =  null;
    }

    public Node addRecursive(Node current, int value)
    {
        if (current == null)
        {
            return new Node(value);
        }
        else if (value < current.data)
        {
            current.left = addRecursive(current.left, value);
        }
        else if (value > current.data)
        {
            current.right = addRecursive(current.right, value);
        }
        else
        {
            return current;
        }

        return current;
    }

    public void add(int value)
    {
        root = addRecursive(root, value);
    }

    /**
     * Depth First Traversals:
     (a) Inorder (Left, Root, Right) : 4 2 5 1 3
     (b) Preorder (Root, Left, Right) : 1 2 4 5 3
     (c) Postorder (Left, Right, Root) : 4 5 2 3 1
     */

    public static void main(String[] args)
    {
        // create root
        /**
         * tree
         ----
         6    <-- root
         /  \
         4    8
         / \  / \
         3  5 7  9
         */
        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.add(6);
        binaryTree1.add(4);
        binaryTree1.add(8);
        binaryTree1.add(3);
        binaryTree1.add(5);
        binaryTree1.add(7);
        binaryTree1.add(9);
        
        BinaryTree binaryTree2 = new BinaryTree();
        binaryTree2.add(6);
        binaryTree2.add(4);
        binaryTree2.add(8);
        binaryTree2.add(3);
        binaryTree2.add(5);
        binaryTree2.add(7);
        binaryTree2.add(9);

        if (areTreesEqual(binaryTree1.root, binaryTree2.root))
        {
            System.out.println("Both trees are identical!");
        }
        else
        {
            System.out.println("Trees are not same!");
        }

//        printTraversals(binaryTree);
        
    }

    public static boolean areTreesEqual(Node node1, Node node2)
    {
        if (node1 == null && node2 == null)
        {
            return true;
        }

        if (node1 != null && node2 != null)
        {
            return node1.data == node2.data
                    && areTreesEqual(node1.left, node2.left)
                    && areTreesEqual(node1.right, node2.right);
        }

        return false;
    }

    public static void printTraversals(BinaryTree binaryTree)
    {
        System.out.println("\n");
        System.out.println("PreOrder");
        printPreOrder(binaryTree.getRoot());

        System.out.println("\n");
        System.out.println("PostOrder");
        printPostOrder(binaryTree.getRoot());

        System.out.println("\n");
        System.out.println("In-Order");
        printInOrder(binaryTree.getRoot());
    }

    /**
     * Pre-Ro-Le-Ri
     */
    public static void printPreOrder(Node root)
    {

        if (root != null)
        {
            System.out.println(root.data + ", ");
            printPreOrder(root.left);
            printPreOrder(root.right);
            //6, 4, 3, 5, 8, 7, 9
        }
    }

    /**
     * Po-Le-Ri-Ro
     * Postorder (Left, Right, Root)
     * * tree
     ----
          6    <-- root
        /  \
       4    8
      / \  / \
     3  5 7  9
     *
     * @param root
     */
    public static void printPostOrder(Node root)
    {
        if (root != null)
        {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.println(root.data + ", ");
            //3,5,4,7,9,8,6
        }
    }

    /**
     * Inorder (Left, Root, Right)
     * ----
            6    <-- root
          /  \
         4    8
        / \  / \
       3  5 7  9
     * @param root
     */
    public static void printInOrder(Node root)
    {
        if (root != null)
        {
            printInOrder(root.left);
            printInOrder(root.right);
            System.out.println(root.data + ", ");
        }
        // 3,5,4,7,9,8,6
    }

    public static void constructBSTWithGivenPreOrderTraversal()
    {

    }

}
