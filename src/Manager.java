import java.io.*;
import java.util.ArrayList;
import java.util.*;
public class Manager extends Employee {
    protected  String filename= "manager.txt";
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
            writer.write(managerID + "," + username + "," + password);
            writer.newLine();
            writer.flush();
            User.updateID(userlastID);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected int managerID;
    public Manager(String username, String password,int idCounter) {
        super(username,password,idCounter);
        managerID =userlastID++;


    }

    public void removeTrips(Trip trip) {
        removeTrips(trip);

    }

    public void addTrips(Trip trip) {
        addTrips(trip);
    }
    public void addVehicles(vehicle vehicle) {
        addVehicles(vehicle);
    }

    public void removeVehicles(vehicle vehicle) {
        removeVehicles(vehicle);
    }

    public static void displayManger() {
        try (BufferedReader br = new BufferedReader(new FileReader("manager.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void AssignDriver(String driverName, String trip) {
        String filename = "driver.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;


            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1 && parts[1].trim().equals(driverName)) {
                    line += "," + trip;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Driver file modified successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    public void addEmployee(String username, String password,  String PhoneNumber, String carType) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("driver.txt", true))) {
            String driverDetails = username+","+ password+","+ PhoneNumber +","+  carType;
            writer.write(driverDetails + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancelTrip(String tripName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("trips.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (!details[0].equals(tripName)) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("trips.txt"))) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}