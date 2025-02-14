



### **Transportation System** 🚍  

#### **Overview**  
This project is a **Java-based Transportation System** that allows users to register, log in, and manage trips. The system supports three types of users: **Passengers, Employees (Managers & Drivers)**. It utilizes **file-based storage** to manage user data, trip details, and vehicle information.

#### **Team Leadership**  
This project was developed by a team, with **[Your Name]** as the team leader. The primary goal was to build a simple yet efficient transportation management system using **Object-Oriented Programming (OOP) principles**.

---

## **Features**  

### 🔹 **User Authentication**  
- Users can **register and log in** using a username and password.  
- Passwords and user data are stored in files.  

### 🔹 **Passenger Functionalities**  
- **Book a Trip**: Passengers can view available trips and book tickets.  
- **Cancel a Trip**: Allows users to cancel their booked tickets.  
- **Review Trips**: Passengers can check their past bookings.  

### 🔹 **Employee Functionalities**  
#### **Manager**  
- **Add & Remove Trips**  
- **Assign Drivers to Trips**  
- **Add Vehicles & Review Fleet**  
- **Generate Reports** (Trips, Vehicles, Employees)  

#### **Driver**  
- **View Assigned Trips**  
- **Update Personal Information (Phone, Car Type)**  

---

## **Project Structure**  
```
/TransportationSystem
│── Main.java           # Entry point of the application
│── User.java           # Handles user authentication and registration
│── Passenger.java      # Passenger functionalities
│── Employee.java       # Base class for employees
│── Manager.java        # Manager functionalities
│── Driver.java         # Driver functionalities
│── Trip.java           # Trip management (add, remove, assign)
│── vehicle.java        # Vehicle management
│── data/               # Folder where user/trip/vehicle data is stored
│── README.md           # Project documentation
```

---

## **Technology Stack**  
- **Java** (OOP concepts, Exception Handling)  
- **File Handling** (Used for persistent data storage)  
- **Scanner Class** (For user input)  

---

## **How to Run the Project**  
1. Clone the repository:  
   ```sh
   git clone https://github.com/yourusername/TransportationSystem.git
   ```
2. Open the project in **VS Code** or any Java IDE.  
3. Compile and run the program:  
   ```sh
   javac Main.java  
   java Main  
   ```
4. Follow the on-screen instructions to interact with the system.  

---

## **Future Improvements**  
- 🔹 Replace file storage with a **Database (MySQL/PostgreSQL)**  
- 🔹 Implement a **Graphical User Interface (GUI)**  
- 🔹 Add **Payment Processing** for booking trips  

---
 


🚀 *Thank you for checking out our project!* 🚀
