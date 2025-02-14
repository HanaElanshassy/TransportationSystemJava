import java.io.*;
import java.util.ArrayList;

class User {

    protected static int userlastID = readIDFromFile();
    protected String username;
    protected String password;
    protected static long idCounter = 0;
    protected static ArrayList<User> users = new ArrayList<>();

    public User(){

    }

    public User(String username, String password, long idCounter) {
        this.username = username;
        this.password = password;
    }




    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static synchronized String createID()
    {
        return String.valueOf(idCounter++);
    }

    public User(String username, String idCounter) {
        this.username = username;
        String id = idCounter;
    }

    protected String filename= "users.txt";
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
            writer.write(  username + "," + password);
            writer.newLine();
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        public boolean register(String username, String password) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length > 0 && parts[0].equals(username)) {
                        return false;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                writer.write(username + "," + password);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
        }
    public static boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1 && parts[0].equals(username) && parts[1].equals(password)) {
                    // Username and password match
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    private static int readIDFromFile() {
        File file = new File("id.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 1;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 1;
    }
    public static void updateID(int id) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("id.txt"))) {
            writer.write(Integer.toString(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }






