import java.io.*;

public class Staff {
    private int staffId;
    private String staffName;
    private double basicPay;

 //this is the constructor 
    public Staff() {
        staffId = 0;
        staffName = "Not Assigned";
        basicPay = 0.0;
    }

    public Staff(int id, String name, double pay) {
        this.staffId = id;
        this.staffName = name;
        this.basicPay = pay;
    }

    
    public double getHRA() {
        return basicPay * 0.20;
    }

    public double getHRA(double percentage) {
        return basicPay * percentage / 100;
    }

    public double getDA() {
        return basicPay * 0.10;
    }

    public double getNetSalary() {
        return basicPay + getHRA() + getDA();
    }

 
    public void writeToFile() {
        try {
            FileWriter fw = new FileWriter("employee_records.txt", true);
            fw.write(staffId + "," + staffName + "," + basicPay + "\n");
            fw.close();
            System.out.println("Record saved successfully!");
        } catch (IOException e) {
            System.out.println("File writing error!");
        }
    }

    public static void searchById(int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("employee_records.txt"));
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int fileId = Integer.parseInt(data[0]);

                if (fileId == id) {
                    System.out.println("\nEmployee Found!");
                    System.out.println("ID: " + data[0]);
                    System.out.println("Name: " + data[1]);
                    System.out.println("Basic Pay: " + data[2]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

            br.close();
        } catch (IOException e) {
            System.out.println("File reading error!");
        }
    }

    public void displaySalaryDetails() {
        System.out.println("\n----- Salary Details -----");
        System.out.println("Staff ID: " + staffId);
        System.out.println("Name: " + staffName);
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("HRA (20%): " + getHRA());
        System.out.println("DA (10%): " + getDA());
        System.out.println("Net Salary: " + getNetSalary());
    }
}