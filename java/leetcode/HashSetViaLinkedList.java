package leetcode;

public class HashSetViaLinkedList {

    public static class MyHashSet {

        private MyHashSet head;
        private MyHashSet tail;
        private int val;
        private MyHashSet next;

        public MyHashSet() {
            head = null;
            tail = null;
        }

        public void add(int key) {
            MyHashSet node = new MyHashSet();
            node.val = key;
            node.next = null;

            if (head == null){
                head = node;
                tail = node;
            }
            else{
//                MyHashSet temp = head;
//
//                while (temp != null){
//                    temp.next = node;
//                    temp = node;
//                    temp = temp.next;
//                }
                tail.next = node;
                tail = node;
            }
        }

        public void remove(int key) {
            MyHashSet temp = head;

            while (temp.next != null){
                if (temp.next.val == key){
                    temp.next = temp.next.next;
                }
            }
        }

        public boolean contains(int key) {
            MyHashSet temp = head;

            while (temp != null){
                if (temp.val == key) {
                    return true;
                }
                else {
                    temp = temp.next;
                }
            }
            return false;
        }
    }

    public static void main(String[] args)
    {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println("Contains 1? : " + myHashSet.contains(1)); // return True
        System.out.println("Contains 3? : " + myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println("Contains 2? : " + myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println("Contains 2? : " + myHashSet.contains(2)); // return False, (already removed)
    }

    /*
    ["MyHashSet","add","remove","add","remove","remove","add","add","add","add","remove"]
[[],[9],[19],[14],[19],[9],[0],[3],[4],[0],[9]]
     */
}
