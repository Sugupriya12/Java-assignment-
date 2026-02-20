package java_assignment1;
import java.io.Serializable;

	public class staffs implements Serializable {

	    private int staffId;
	    private String fullName;
	    private double baseAmount;

	    public staffs(int staffId, String fullName, double baseAmount) {
	        this.staffId = staffId;
	        this.fullName = fullName;
	        this.baseAmount = baseAmount;
	    }

	    public double computePay() {
	        return computePay(0.20, 0.10);
	    }

	    public double computePay(double houseAllowanceRate, double dearnessAllowanceRate) {
	        double houseAllowance = baseAmount * houseAllowanceRate;
	        double dearnessAllowance = baseAmount * dearnessAllowanceRate;
	        return baseAmount + houseAllowance + dearnessAllowance;
	    }

	    public int getStaffId() {
	        return staffId;
	    }

	    public void printInfo() {
	        System.out.println(
	            staffId + " | " +
	            fullName + " | " +
	            baseAmount + " | " +
	            computePay()
	        );
	    }
	}

	