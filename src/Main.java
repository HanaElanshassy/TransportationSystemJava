import java.util.*;

public class Main {
    public static void main(String[] args) {

        Trip trip1 = new Trip();
        trip1.setTripname("cairo");
        trip1.setType("internal");
        trip1.setSource("cairo");
        trip1.setDestination("alex");
        trip1.setOneWay(true);
        trip1.setNumStops(1);
        trip1.setAvailableSeats(10);
        trip1.saveToFile();

        User user = new User();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Welcome to the Transportation System!");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();

                if (option == 1) {
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();

                    boolean success = user.register(username, password);
                    if (success) {
                        User user1 = new User(username, password);
                        user1.saveToFile();
                        System.out.println("Registration successful!");


                    } else {
                        System.out.println("Username already taken.");
                        continue;
                    }

                } else if (option == 2) {
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    if (User.login(username, password)) {
                        System.out.println("Login Successful.");
                    } else {
                        System.out.println("Invalid username or password.");
                        continue;
                    }
                }

                System.out.println("1. Passenger");
                System.out.println("2. Employee");
                System.out.print("Choose an option: ");
                int userType = scanner.nextInt();

                if (userType == 1) {

                    System.out.println("You have to log in for authentication purposes");
                    System.out.print("Enter username: ");
                    String username1 = scanner.next();
                    System.out.print("Enter password: ");
                    String password1 = scanner.next();
                    boolean success = User.login(username1, password1);
                    Passenger passenger = new Passenger(username1, password1);

                    if (success) {
                        System.out.println("Login successful!");
                        System.out.println("Welcome! ");
                    } else {
                        System.out.println("Login failed. Please try again.");
                        continue;
                    }
                    while (true) {
                        System.out.println("1. Book a trip");
                        System.out.println("2. Cancel a trip");
                        System.out.println("3. Review trips");
                        System.out.println("4.exit");
                        System.out.print("Choose an option: ");
                        int passengerOption = scanner.nextInt();
                        scanner.nextLine();

                        if (passengerOption == 1) {
                            System.out.println("Available trips:");
                            Trip.displayTrips();
                            System.out.print("Enter trip name: ");
                            String tripname = scanner.nextLine();
                            passenger.bookTicket(tripname);

                        } else if (passengerOption == 2) {
                            System.out.println("enter your username");
                            String usercancel = scanner.next();
                            passenger.cancelBookedTicket(usercancel);
                            System.out.println("Ticket cancelled successfully!");
                        } else if (passengerOption == 3) {
                            System.out.println("enter your username");
                            String pass = scanner.next();
                            passenger.reviewBookedTrips(pass);
                        } else if (passengerOption == 4) {
                            break;
                        } else {
                            System.out.println("the info you provided is in incorrect");
                            break;
                        }
                    }
                } else if (userType == 2) {
                    System.out.println("You have to log in for authentication purposes");
                    System.out.print("Enter username: ");
                    String username1 = scanner.next();
                    System.out.print("Enter password: ");
                    String password1 = scanner.next();
                    User loginUser = new User(username1, password1);
                    boolean success = User.login(username1, password1);

                    if (success) {
                        System.out.println("Login successful!");
                        Employee employee = new Employee(loginUser.getUsername(), loginUser.getPassword(), "");
                        System.out.println("Welcome, " + loginUser.getUsername() + "!");

                        System.out.println("1. Manager");
                        System.out.println("2. Driver");
                        System.out.print("Choose an option: ");
                        int employeeType = scanner.nextInt();

                        if (employeeType == 1) {
                            Manager manager = new Manager(username1, password1, Integer.parseInt(User.createID()));
                            manager.saveToFile();
                            System.out.println("Welcome, Manager!" + manager.getUsername());

                            System.out.println("Welcome, Manager!");
                            while (true) {

                                System.out.println("1. Add a trip");
                                System.out.println("2. Remove a trip");
                                System.out.println("3. Assign a driver to a trip");
                                System.out.println("4. Review all trips");
                                System.out.println("5. Add vehicle");
                                System.out.println("6. Review vehicles");
                                System.out.println("7. add driver");
                                System.out.println("8. generate report");
                                System.out.println("9.Exit");
                                int managerOption = scanner.nextInt();

                                if (managerOption == 1) {
                                    Trip newTrip = new Trip();
                                    System.out.println("enter trip name");
                                    newTrip.setTripname(scanner.next());
                                    System.out.print("Enter source: ");
                                    newTrip.setSource(scanner.next());
                                    System.out.print("Enter destination: ");
                                    newTrip.setDestination(scanner.next());
                                    System.out.print("Enter price: ");
                                    newTrip.setPrice(scanner.nextDouble());
                                    System.out.print("Enter type (1: one-way, 2: round-trip): ");
                                    newTrip.setType(scanner.next());
                                    System.out.print("Enter number of stops: ");
                                    newTrip.setNumStops(scanner.nextInt());
                                    System.out.print("Enter available seats: ");
                                    newTrip.setAvailableSeats(scanner.nextInt());
                                    newTrip.saveToFile();
                                    System.out.println("Trip added successfully!");
                                } else if (managerOption == 2) {
                                    Trip.displayTrips();
                                    System.out.println("please enter the name of the trip that you want to remove");
                                    String removeTrip = scanner.next();
                                    manager.cancelTrip(removeTrip);
                                } else if (managerOption == 3) {
                                    System.out.println("Available drivers:");
                                    Driver.displayDriver();
                                    Trip.displayTrips();
                                    System.out.println("Enter the driver name:");
                                    String name = scanner.next();
                                    System.out.println("Enter the trip name:");
                                    String tripname = scanner.next(); // Use scanner.next() to read the trip name
                                    Manager.AssignDriver(name, tripname);
                                }

                             else if (managerOption == 4) {
                                    Trip.displayTrips();
                                } else if (managerOption == 5) {

                                    System.out.print("Enter Type: ");
                                    String type = scanner.next();
                                    System.out.print("Enter capacity: ");
                                    int capacity = scanner.nextInt();
                                    System.out.print("Enter license plate: ");
                                    String LicencePlate = scanner.next();

                                    vehicle newvehicle = new vehicle(type, capacity, LicencePlate);
                                    newvehicle.saveToFile();

                                    System.out.println("vehicle added successfully!");


                                } else if (managerOption == 6) {

                                    System.out.println("Available vehicles:");
                                    vehicle.displayVehicle();

                            } else if (managerOption == 7) {
                                    System.out.println("enter info of the driver");
                                    Driver newdriver =new Driver();
                                    System.out.println("enter the name of the driver");
                                    newdriver.setUsername(scanner.next());
                                    System.out.println("enter the carType");
                                    newdriver.setCarType(scanner.next());
                                    System.out.println("enter the password of the driver");
newdriver.setPassword(scanner.next());
                                manager.addEmployee(newdriver.getUsername(),newdriver.getPassword(),newdriver.getPhoneNumber(),newdriver.getCarType());
                            }
                                else if(managerOption==8){
                                    System.out.println("the System's report");
                                    System.out.println(" trips available");
                                    Trip.displayTrips();
                                    System.out.println("vehicles available");
                                    vehicle.displayVehicle();
                                    System.out.println("employees available");
                                    Manager.displayManger();
                                    Driver.displayDriver();

                                }else if(managerOption==9){
                                    break;
                                }
                        }
                    } else if (employeeType == 2) {
                        Driver driver = new Driver(username1, password1, Integer.parseInt(User.createID()));
                        driver.saveToFile();
                        System.out.println("Welcome, Driver!");
                        while (true) {
                            System.out.println("1. View assigned trips");
                            driver.getAssignedTrips();
                            System.out.println("2. Update driver information");
                            System.out.print("Choose an option: ");
                            int driverOption = scanner.nextInt();

                            if (driverOption == 1) {
                                String name=driver.getName();
                                System.out.println("Assigned trips:" );
                                driver.displayAssignedTrips(name);
                            } else if (driverOption == 2) {
                                System.out.print("Enter new phone number: ");
                                String newPhoneNumber = scanner.next();
                                driver.setPhoneNumber(newPhoneNumber);
                                System.out.println("enter your car type");
                                String newcartype = scanner.next();
                                driver.setCarType(newcartype);
                                System.out.println("your updated info are: Phone Number" + driver.getPhoneNumber() + "car type:" + driver.getCarType());
                                driver = new Driver(username1, password1, driver.driverID, newPhoneNumber, newcartype);
                                driver.saveToFile();
                            } else if (driverOption == 3) {
                                break;
                            }
                        }
                    }

                }
            }
        } catch(InputMismatchException e){
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        } catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
}