class Person extends Thread {
    private boolean active = true;
    private boolean onBreak = false;

    Person(String name) {
        super(name);
    }

    public void run() {
        while (active) {
            if (onBreak) {
                System.out.println(getName() + " is resting...");
            } else {
                System.out.println(getName() + " says: Hi there!");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        System.out.println(getName() + " has left.");
    }

    public void setOnBreak(boolean onBreak) {
        this.onBreak = onBreak;
    }

    public void stopTalking() {
        active = false;
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
        john.setOnBreak(true);

        Thread.sleep(2000);

        System.out.println("John is back!");
        john.setOnBreak(false);

        Thread.sleep(2000);

        System.out.println("Time to wrap up.");
        john.stopTalking();
        emma.stopTalking();

        john.join();
        emma.join();

        System.out.println("Chat room closed.");
    }
}
