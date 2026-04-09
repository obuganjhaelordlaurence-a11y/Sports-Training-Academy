import java.util.ArrayList;
import java.util.Scanner;

public class AthleteManager {
    private ArrayList<Athlete> athletes = new ArrayList<>();

    public void addAthlete(Scanner scanner) {
        System.out.print("Enter athlete name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter sport: ");
        String sport = scanner.nextLine();

        athletes.add(new Athlete(name, age, sport));
        System.out.println("Athlete added successfully!");
    }

    public void updateAthlete(Scanner scanner) {
        System.out.print("Enter athlete name to update: ");
        String name = scanner.nextLine();

        for (Athlete athlete : athletes) {
            if (athlete.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new age: ");
                athlete.setAge(Integer.parseInt(scanner.nextLine()));
                System.out.print("Enter new sport: ");
                athlete.setSport(scanner.nextLine());
                System.out.println("Athlete updated successfully!");
                return;
            }
        }
        System.out.println("Athlete not found!");
    }

    public void deleteAthlete(Scanner scanner) {
        System.out.print("Enter athlete name to delete: ");
        String name = scanner.nextLine();

        athletes.removeIf(a -> a.getName().equalsIgnoreCase(name));
        System.out.println("Athlete deleted successfully!");
    }
}