package design_patterns.behavioral.Observer;

public class Reader implements Subscriber {

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Reader(String name)
    {
        this.name = name;
    }

    @Override
    public void update()
    {
        System.out.println(name + " got the latest month's newletter!");
    }
}
