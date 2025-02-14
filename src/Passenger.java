import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Passenger extends User {
    Trip trip;
    private String ticketType;
    protected  int passengerID = userlastID++;
    Trip newtrip =new Trip();
    ArrayList<Trip> bookedtrips=new ArrayList<>();
    protected  String filename= "passenger.txt";

    protected String username;
    protected String password;

    public Passenger(String username, String password) {
        this.username=username;
        this.password=password;
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
            writer.write(passengerID + "," + username + "," + password);
            writer.newLine();
            writer.flush();
            User.updateID(userlastID);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void bookTicket(String tripname) {

        Trip trip = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("trips.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(tripname)) {
                    // Found the trip
                    trip = new Trip(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3], parts[4],Boolean.parseBoolean(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (trip == null) {
            System.out.println("No trip found with the name " + tripname);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("bookedtrips.txt", true))) {
            writer.write(trip.getSource() + "," + trip.getDestination() +","+username);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        trip.bookSeat();
        System.out.println("Trip was successfully booked");
    }

    public void cancelBookedTicket(String username) {

        String bookedTripsFileName = "bookedtrips.txt";

        String tempFileName = "temp_booked_trips.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(bookedTripsFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {
            String line;
            String lastLine = null;
            boolean found = false;

            while ((line = reader.readLine()) != null) {

                if (line.contains(username)) {
                    lastLine = line;
                    found = true;
                } else {

                    writer.write(line);
                    writer.newLine();
                }
            }


            if (found && lastLine != null) {
                System.out.println("Last booked trip canceled for passenger: " + username);
            } else {
                System.out.println("No booked trips found for passenger: " + username);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File oldFile = new File(bookedTripsFileName);
        File newFile = new File(tempFileName);
        if (!oldFile.delete()) {
            System.out.println("Failed to delete the original booked trips file.");
            return;
        }
        if (!newFile.renameTo(oldFile)) {
            System.out.println("Failed to rename the temporary file to the original booked trips file name.");
        }
    }



    public String getUsername() {
        return this.username;
    }

public static void displayPassenger() {
    try (BufferedReader br = new BufferedReader(new FileReader("passenger.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }}
    public void reviewBookedTrips (String username){

        String bookedTripsFileName = "bookedtrips.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(bookedTripsFileName))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains(username)) {
                    System.out.println("Booked Trip: " + line);
                    found = true;
                }
            }


            if (!found) {
                System.out.println("No booked trips found for passenger: " + username);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}