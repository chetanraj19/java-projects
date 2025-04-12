package org.example;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Voting System!");
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (UserDAO.loginUser(username, password)) {
            System.out.println("Login successful!");

            while (true) {
                System.out.println("\n1. Vote for Candidate\n2. View Results\n3. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Candidate ID: ");
                        int candidateId = scanner.nextInt();
                        if (VotingDAO.castVote(candidateId)) {
                            System.out.println("Vote cast successfully!");
                        } else {
                            System.out.println("Error casting vote.");
                        }
                        break;
                    case 2:
                        ElectionResults.showResults();
                        break;
                    case 3:
                        System.out.println("Thank you for using the Voting System!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } else {
            System.out.println("Invalid login!");
        }

        scanner.close();
    }
}
