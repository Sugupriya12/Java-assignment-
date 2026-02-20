package java_assignment1;

public class Main {
	 public static void main(String[] args) throws Exception {
	        staffs firststaff = new staffs(301, "ranni", 20000);
	        staffs secondstaff = new staffs(201, "Asha", 25000);
            staffs thirdstaff = new staffs(400, "Nanda", 50000);
	        payroll.storeStaff(firststaff);
	        payroll.storeStaff(secondstaff);
	        payroll.storeStaff(thirdstaff);

	        System.out.println("Fetching details for Staff ID 400:");
	        payroll.findStaff(400);
}
}