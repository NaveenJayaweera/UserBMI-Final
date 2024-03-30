import java.util.ArrayList;
import java.util.Scanner;

public class UserBmiApp {

    private ArrayList<UserBmi> users = new ArrayList<>();
    private static final int MAX_USERS = 5;

    public static void main(String[] args) {
        UserBmiApp app = new UserBmiApp();
        app.run();
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = getUserChoice();
            if (choice == 5) {
                break;
            } else if (users.size() >= MAX_USERS && choice != 4) {
                System.out.println("Maximum users reached. Please delete some before adding new ones.");
                continue;
            }
            performAction(choice);
        }
    }

    public void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add user");
        System.out.println("2. Show BMI data for all users");
        System.out.println("3. Show BMI data for a specific user");
        System.out.println("4. Delete all users");
        System.out.println("5. Exit");
    }

    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void performAction(int choice) {
        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                showAllBmiData();
                break;
            case 3:
                showSpecificUserData();
                break;
            case 4:
                deleteAllUsers();
                break;
            case 5:
                exitApp();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void addUser() {
        Scanner scanner = new Scanner(System.in);
        if (users.size() >= MAX_USERS) {
            System.out.println("Maximum users reached. Please delete some before adding new ones.");
            return;
        }
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter birth year: ");
        int birthYear = scanner.nextInt();
        System.out.print("Enter height (cm): ");
        int height = scanner.nextInt();
        System.out.print("Enter weight (kg): ");
        int weight = scanner.nextInt();

        if (height <= 0 || weight <= 0) {
            System.out.println("Height and weight must be positive values.");
            return;
        }

        UserBmi user = new UserBmi(id, name, birthYear, height, weight);
        users.add(user);
        System.out.println("User added successfully.");
    }

    public void showAllBmiData() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("BMI Data:");
            for (UserBmi user : users) {
                user.displayInfo();
            }
        }
    }

    public void showSpecificUserData() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter user ID: ");
            int id = scanner.nextInt();
            boolean found = false;
            for (UserBmi user : users) {
                if (user.getId() == id) {
                    user.displayInfo();
                    System.out.println("Age: " + user.calculateAge(2024));
                    String category = user.getCategory();
                    if (category.equals("Underweight")) {
                        System.out.println("Recommendation: Increase calorie intake and focus on nutrient-rich foods.");
                    } else if (category.equals("Overweight") || category.equals("Obese")) {
                        System.out.println("Recommendation: Consult a doctor or nutritionist for a personalized weight management plan.");
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("User not found.");
            }
        }
    }

    public void deleteAllUsers() {
        users.clear();
        System.out.println("All users deleted.");
    }

    public void exitApp() {
        System.out.println("Exiting application.");
        System.exit(0);
    }
}
