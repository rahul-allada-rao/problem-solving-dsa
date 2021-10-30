package design_patterns.behavioral.Observer;

public class PubSubMain {

    public static void main(String[] args)
    {
        Reader reader1 = new Reader("Rahul");
        Reader reader2 = new Reader("Namitha");
        Reader reader3 = new Reader("Adi");

        Magazine magazine = new Magazine();
        magazine.addSubscriber(reader1);
        magazine.addSubscriber(reader2);
        magazine.addSubscriber(reader3);
        System.out.println();

        magazine.notifySubscriber();
        System.out.println();

        magazine.removeSubscriber(reader1);
        magazine.removeSubscriber(reader2);

        System.out.println();
        magazine.notifySubscriber();
    }

}
