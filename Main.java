import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Welcome to Sports Training Academy ===");

        UserManager userManager = new UserManager();
        AthleteManager athleteManager = new AthleteManager();
        TrainingManager trainingManager = new TrainingManager();

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    userManager.registerUser(scanner);
                    break;
                case 2:
                    User user = userManager.loginUser(scanner);
                    if (user != null) {
                        userMenu(scanner, user, athleteManager, trainingManager);
                    }
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void userMenu(Scanner scanner, User user, AthleteManager athleteManager, TrainingManager trainingManager) {
        while (true) {
            System.out.println("\n=== User Menu (" + user.getRole() + ") ===");
            System.out.println("1. Add Athlete Record");
            System.out.println("2. Update Athlete Record");
            System.out.println("3. Delete Athlete Record");
            System.out.println("4. Schedule Training Session");
            System.out.println("5. Record Performance Data");
            System.out.println("6. Monitor Attendance");
            System.out.println("7. Generate Training Report");
            System.out.println("8. Logout");

            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    if (user.getRole().equalsIgnoreCase("Administrator"))
                        athleteManager.addAthlete(scanner);
                    else
                        System.out.println("Permission denied.");
                    break;
                case 2:
                    if (user.getRole().equalsIgnoreCase("Administrator"))
                        athleteManager.updateAthlete(scanner);
                    else
                        System.out.println("Permission denied.");
                    break;
                case 3:
                    if (user.getRole().equalsIgnoreCase("Administrator"))
                        athleteManager.deleteAthlete(scanner);
                    else
                        System.out.println("Permission denied.");
                    break;
                case 4:
                    trainingManager.scheduleSession(scanner);
                    break;
                case 5:
                    trainingManager.recordPerformance(scanner);
                    break;
                case 6:
                    trainingManager.monitorAttendance(scanner);
                    break;
                case 7:
                    trainingManager.generateReport();
                    break;
                case 8:
                    return; // logout
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}