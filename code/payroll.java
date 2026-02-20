package java_assignment1;

import java.io.*;

public class payroll {

    private static final String DATA_STORE = "staff_data.bin";

    public static void storeStaff(staffs staffObj) throws Exception {

        boolean fileExists = new File(DATA_STORE).exists();

        FileOutputStream fos = new FileOutputStream(DATA_STORE, true);
        ObjectOutputStream oos;

        if (fileExists) {
            oos = new ObjectOutputStream(fos) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset(); // prevents header corruption
                }
            };
        } else {
            oos = new ObjectOutputStream(fos);
        }

        oos.writeObject(staffObj);
        oos.close();
    }

    public static void findStaff(int searchId) throws Exception {

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(DATA_STORE)
        );

        boolean found = false;

        try {
            while (true) {
                staffs staffObj = (staffs) ois.readObject();
                if (staffObj.getStaffId() == searchId) {
                    staffObj.printInfo();
                    found = true;
                    break;
                }
            }
        } catch (EOFException e) {
            // End of file reached
        }

        if (!found) {
            System.out.println("No matching staff record available.");
        }

        ois.close();
    }
}