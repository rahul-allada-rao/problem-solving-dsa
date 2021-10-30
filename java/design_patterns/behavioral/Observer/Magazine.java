package design_patterns.behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class Magazine implements Publisher {

    private List<Subscriber> subscriberList = new ArrayList<>();

    @Override
    public void addSubscriber(Subscriber subscriber)
    {
        System.out.println("Reader : " + subscriber.getName() + " has subscribed to our newsletter!");
        subscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber)
    {
        System.out.println("Reader : " + subscriber.getName() + " has unsubscribed!");
        subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscriber()
    {
        System.out.println("This month's newsletter has been delivered!");
        subscriberList.forEach(subscriber -> subscriber.update());
    }
}
