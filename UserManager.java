import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
    private ArrayList<User> users = new ArrayList<>();

    public void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (Athlete/Coach/Administrator): ");
        String role = scanner.nextLine();

        users.add(new User(username, password, role));
        System.out.println("User registered successfully!");
    }

    public User loginUser(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome " + user.getUsername());
                return user;
            }
        }
        System.out.println("Invalid credentials!");
        return null;
    }
}