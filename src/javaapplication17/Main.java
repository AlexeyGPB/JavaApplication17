package javaapplication17;

public class Main {

    public static void main(String[] args) {

        FSServer server = new FSServer(".");
        server.addClient(new FSMonitor() {
            @Override
            public void event(String fName, int kind) {
                switch (kind) {
                    case FSMonitor.CREATE:
                        System.out.println("Some file's created: " + fName);
                        break;
                    case FSMonitor.REMOVE:
                        System.out.println("Some file's removed: " + fName);
                        break;
                    default:
                        System.out.println("Unknown event!");
                }
            }
        });
        server.start();
    }
}
