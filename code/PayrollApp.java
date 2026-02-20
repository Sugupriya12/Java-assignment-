import java.util.Scanner;

public class PayrollApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Employee Payroll System =====");

        System.out.print("Enter Staff ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Staff Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Basic Pay: ");
        double pay = sc.nextDouble();
        Staff s1 = new Staff(id, name, pay);

     
        s1.writeToFile();
        s1.displaySalaryDetails();

     
        System.out.print("\nEnter ID to search: ");
        int searchId = sc.nextInt();
        Staff.searchById(searchId);

        sc.close();
    }
}