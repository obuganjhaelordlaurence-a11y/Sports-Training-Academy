import java.util.ArrayList;
import java.util.Scanner;

class TrainingSession {
    String athleteName;
    String date;
    String time;
    String location;
    String performance;
    boolean attended;

    public TrainingSession(String athleteName, String date, String time, String location) {
        this.athleteName = athleteName;
        this.date = date;
        this.time = time;
        this.location = location;
        this.performance = "";
        this.attended = false;
    }
}

public class TrainingManager {
    private ArrayList<TrainingSession> sessions = new ArrayList<>();

    public void scheduleSession(Scanner scanner) {
        System.out.print("Athlete Name: ");
        String athlete = scanner.nextLine();
        System.out.print("Date: ");
        String date = scanner.nextLine();
        System.out.print("Time: ");
        String time = scanner.nextLine();
        System.out.print("Location: ");
        String location = scanner.nextLine();

        sessions.add(new TrainingSession(athlete, date, time, location));
        System.out.println("Training session scheduled!");
    }

    public void recordPerformance(Scanner scanner) {
        System.out.print("Athlete Name: ");
        String athlete = scanner.nextLine();
        for (TrainingSession session : sessions) {
            if (session.athleteName.equalsIgnoreCase(athlete)) {
                System.out.print("Performance result: ");
                session.performance = scanner.nextLine();
                System.out.print("Attended? (true/false): ");
                session.attended = Boolean.parseBoolean(scanner.nextLine());
                System.out.println("Performance recorded!");
                return;
            }
        }
        System.out.println("No session found for this athlete.");
    }

    public void monitorAttendance(Scanner scanner) {
        for (TrainingSession session : sessions) {
            System.out.println("Athlete: " + session.athleteName + ", Attended: " + session.attended);
        }
    }

    public void generateReport() {
        System.out.println("=== Training Report ===");
        for (TrainingSession session : sessions) {
            System.out.println("Athlete: " + session.athleteName + ", Date: " + session.date +
                    ", Performance: " + session.performance + ", Attended: " + session.attended);
        }
    }
}