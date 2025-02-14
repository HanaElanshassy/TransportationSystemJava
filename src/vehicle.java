import java.io.*;
import java.util.ArrayList;

public class vehicle  {
    private String type;
    private int capacity;
    private String licensePlate;
    static ArrayList<vehicle> vehicles=new ArrayList<>();
    public vehicle(String type,int capacity,String licensePlate){
        this.type=type;
        this.capacity=capacity;
        this.licensePlate=licensePlate;
    }

    protected  String filename= "vehicle.txt";
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
            writer.write(type+ "," + capacity + "," + licensePlate);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void displayVehicle() {
        try (BufferedReader br = new BufferedReader(new FileReader("vehicle.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    }

