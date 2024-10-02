// Singleton pattern for database connection management (Mocked version)
class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;
    private String connection;  // Mocked connection as a simple String

    private DatabaseConnectionManager() {
        // Simulating a "connection" to a database
        this.connection = "Mocked Database Connection Established";
    }

    public static synchronized DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    public String getConnection() {
        return connection;
    }
}

// Factory Method pattern interface and implementations
interface Notification {
    void notifyUser();
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification.");
    }
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an email notification.");
    }
}

class NotificationFactory {
    public Notification createNotification(String notificationType) {
        if ("SMS".equals(notificationType)) {
            return new SMSNotification();
        } else if ("EMAIL".equals(notificationType)) {
            return new EmailNotification();
        }
        return null;
    }
}

public class AllPatternsDemo {
    public static void main(String[] args) {
        // Singleton usage
        DatabaseConnectionManager manager = DatabaseConnectionManager.getInstance();
        System.out.println("Database connection established: " + manager.getConnection());

        // Factory Method usage
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification sms = notificationFactory.createNotification("SMS");
        sms.notifyUser();
        
        Notification email = notificationFactory.createNotification("EMAIL");
        email.notifyUser();
    }
}
