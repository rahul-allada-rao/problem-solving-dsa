package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VaultExample {

    private static int MAX_PASSWORD = 9999;

    public static void main(String[] args)
    {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

        List<Thread> threadList = new ArrayList<>();
        AscendingHacker ascendingHacker = new AscendingHacker(vault);
        DescendingHacker descendingHacker = new DescendingHacker(vault);
        PoliceMan policeMan = new PoliceMan();

        threadList.add(ascendingHacker);
        threadList.add(descendingHacker);
        threadList.add(policeMan);

        threadList.forEach(thread -> thread.start());
    }

    public static class Vault{
        int password;

        public Vault(int password)
        {
            this.password = password;
        }

        public boolean isPasswordCorrect(int guess){

            try{
                Thread.sleep(5);
            }
            catch (InterruptedException e) {

            }
            return password == guess;
        }
    }

    public static abstract class Hacker extends Thread{
        protected Vault vault;

        public Hacker(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        public void start(){
            System.out.println("Starting thread " + this.getName());
            super.start();
        }
    }

    public static class AscendingHacker extends Hacker{

        public AscendingHacker(Vault vault) {
            super(vault);
        }

        public void run(){
            for (int i =0 ; i< MAX_PASSWORD; i++) {
                if (vault.isPasswordCorrect(i)){
                    System.out.println(this.getName() + " guessed the password!");
                    System.exit(0);
                }
            }
        }
    }

    public static class DescendingHacker extends Hacker{

        public DescendingHacker(Vault vault) {
            super(vault);
        }

        public void run(){
            for (int i =MAX_PASSWORD ; i>= 0; i--) {
                if (vault.isPasswordCorrect(i)){
                    System.out.println(this.getName() + " guessed the password!");
                    System.exit(0);
                }
            }
        }
    }

    public static class PoliceMan extends Thread{

        public void run(){
            for (int i=0 ; i<10; i++){
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                }
                System.out.println(i);
            }

            System.out.println("Game over for you hackers");
            System.exit(0);
        }
    }

}
