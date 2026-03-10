package Project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		StudentManager manager = new StudentManager();
		Scanner sc = new Scanner(System.in);

        System.out.println("******************************************");
		System.out.println("   STUDENT RESULT MANAGEMENT SYSTEM  ");
        System.out.println("******************************************");

		boolean running = true;

		while (running) {
			printMenu();
			System.out.print("Enter your choice: ");
			if (!sc.hasNextInt()) {
				System.out.println("[ERROR] Please enter a valid integer choice.\n");
				sc.next();
				continue;
			}

			int choice = sc.nextInt();
			System.out.println();

			switch (choice) {

			case 1:
				System.out.print("Enter Roll No   : ");
				int rollNo = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Name      : ");
				String name = sc.nextLine().trim();
				System.out.print("Enter Marks 1   : ");
				double m1 = sc.nextDouble();
				System.out.print("Enter Marks 2   : ");
				double m2 = sc.nextDouble();
				System.out.print("Enter Marks 3   : ");
				double m3 = sc.nextDouble();
				System.out.println();
				manager.addStudent(rollNo, name, m1, m2, m3);
				break;

			case 2:
				manager.displayAll();
				break;

			case 3:
				System.out.print("Enter Roll No to search: ");
				int searchRoll = sc.nextInt();
				System.out.println();
				manager.searchByRollNo(searchRoll);
				break;

			case 4:
				manager.displayTopper();
				break;

			case 5:
				System.out.print("Enter Roll No to delete: ");
				int deleteRoll = sc.nextInt();
				System.out.println();
				manager.deleteStudent(deleteRoll);
				break;

			case 6:
				running = false;
				System.out.println("Thank you for using Student Result Management System. Goodbye!");
				break;

			default:
				System.out.println("[ERROR] Invalid choice. Please select 1–6.");
			}
			System.out.println();
		}

		sc.close();
	}

	private static void printMenu() {
		System.out.println("  1. Add Student");
		System.out.println("  2. Display All Students");
		System.out.println("  3. Search Student by Roll Number");
		System.out.println("  4. Display Topper");
		System.out.println("  5. Delete Student");
		System.out.println("  6. Exit");
	}
}
