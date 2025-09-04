class Person extends Thread {
    private boolean isActive = true;
    private boolean isTakingBreak = false;

    Person(String name) {
        super(name);
    }

    public void run() {
        while (isActive) {
            if (!isTakingBreak) {
                System.out.println(getName() + " says: Hi there!");
            } else {
                System.out.println(getName() + " is resting...");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println(getName() + " has left.");
    }

    public void takeBreak() {
        isTakingBreak = true;
    }

    public void comeBack() {
        isTakingBreak = false;
    }

    public void stopTalking() {
        isActive = false;
    }
}

public class multi_threading {
    public static void main(String[] args) throws InterruptedException {
        Person john = new Person("John");
        Person emma = new Person("Emma");

        john.start();
        emma.start();

        Thread.sleep(2000);

        System.out.println("John is taking a break...");
        john.takeBreak();

        Thread.sleep(2000);

        System.out.println("John is back!");
        john.comeBack();

        Thread.sleep(2000);

        System.out.println("Time to wrap up.");
        john.stopTalking();
        emma.stopTalking();

        john.join();
        emma.join();

        System.out.println("Chat room closed.");
    }
}
