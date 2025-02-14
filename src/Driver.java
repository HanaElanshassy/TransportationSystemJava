import java.io.*;
import java.util.ArrayList;

class Driver extends Employee{
    private String phoneNumber;
    protected static int driverID;
    protected vehicle vehicle;
    protected ArrayList<Trip>AssignedTrips=new ArrayList<>();
protected String carType;
    public static ArrayList<Driver> drivers = new ArrayList<>();
    protected  String filename= "driver.txt";
public Driver(){

}
    public Driver(String username, String password, int driverID, String PhoneNumber, String carType) {
        this.username=username;
        this.password=password;
        this.driverID=driverID;
        this.phoneNumber=PhoneNumber;
        this.carType=carType;
    }

    public void saveToFile() {

        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(driverID+ "," + username + "," + password+ ","+carType);
            writer.newLine();
            writer.flush();
            User.updateID(userlastID);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Driver(String username, String password, long idCounter) {
        super(username != null ? username : "", password, idCounter);
    }


    public vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ArrayList<Trip> getAssignedTrips() {
        return AssignedTrips;
    }
    public String getUsername() {
        return this.username;
    }
    public void setAssignedTrips(ArrayList<Trip> assignedTrips) {
        this.AssignedTrips = assignedTrips;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }


    public String getName() {
        return this.username=username;
    }

    public String  getArr(){
        return AssignedTrips.toString();
    }
    public String driverDetails() {
        return "Driver{" + "Username: " + getUsername() + "your ID is "+idCounter+
                "vehicle=" + vehicle +
                ", AssignedTrips=" + getArr() +
                '}';
    }

    public static void displayDriver() {
        try (BufferedReader br = new BufferedReader(new FileReader("driver.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void displayAssignedTrips(String driverName) {
        String filename = "driver.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1 && parts[1].trim().equals(driverName)) {
                    for (int i = 2; i < parts.length; i++) {
                        if (parts[i] != null && !parts[i].isEmpty()) {
                            System.out.println(parts[i]);
                        }
                    }
                    return;
                }
            }
            System.out.println("No trips assigned to " + driverName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

}

