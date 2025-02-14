import java.io.*;
import java.util.ArrayList;

public class Trip  {
    public String type;
    private String tripname;
    private double price;
    private String source;
    private String destination;
    private boolean oneWay;
    private int numStops;
    private  int availableSeats;
    private Driver driver;
    static ArrayList<Trip>trips=new ArrayList<>();

    public Trip(String tripname, String type, double price, String source, String destination, boolean oneWay, int numStops, int availableSeats) {
        this.tripname=tripname;
        this.type = type;
        this.price = price;
        this.source = source;
        this.destination = destination;
        this.oneWay = oneWay;
        this.numStops = numStops;
        this.availableSeats = availableSeats;
    }
    public Trip(){

    }
    protected  String filename= "trips.txt";
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
            writer.write( tripname+ "," + type + "," +price+","+source+","+destination+","+oneWay+","+numStops+","+availableSeats );
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void setType(String type) {
        this.type = type;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOneWay(boolean oneWay) {
        this.oneWay = oneWay;
    }


    public void setNumStops(int numStops) {
        this.numStops = numStops;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println("Seat booked successfully!");
        } else {
            System.out.println("No available seats for this trip!");
        }

    }


    public void setTripname(String tripname) {
        this.tripname = tripname;
    }

    public static void displayTrips() {
        try (BufferedReader br = new BufferedReader(new FileReader("trips.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
