# AreebaPOS - Point of Sale System

AreebaPOS is a robust and efficient Point of Sale (POS) system developed using Java and the Spring Boot framework. This system is designed to simplify and automate the sales, inventory management, and reporting processes for small and medium-sized businesses. With a focus on user-friendly design, security, and scalability, AreebaPOS offers a comprehensive solution for business owners to track sales, manage stock, and generate reports.

## Features
- **Sales Transactions**: Facilitates smooth and efficient sales transactions with product lookup, adding to cart, and finalizing payments.
- **Inventory Management**: Allows users to track product quantities, update stock, and receive notifications when stock is low.
- **User Authentication**: Secure login system with role-based access control (Admin, Cashier, etc.).
- **Sales Reporting**: Generates daily, weekly, and monthly sales reports, including total revenue and item-wise sales data.
- **Payment Integration**: Integration with payment gateways for processing transactions.
- **Product Search**: Quick and easy product search by name, category, or SKU.
- **Receipt Generation**: Generates printable receipts after completing a sale.

## Technologies Used
- **Java**: The core programming language used to develop the system.
- **Spring Boot**: A framework used for building and deploying Java-based applications, simplifying configuration and setup.
- **PostgreSQL**: A relational database used for storing product, user, and sales data.
- **Thymeleaf**: A Java-based templating engine for rendering web pages.
- **Maven**: A build automation tool for managing dependencies and building the project.
- **Spring Security**: Used for implementing authentication and authorization.

## Prerequisites
Before you can run the application, ensure you have the following installed:
- **Java 8 or later**
- **Maven**
- **PostgreSQL**
- **IDE (Optional, e.g., IntelliJ IDEA or Eclipse)**

## Setup Instructions

Follow the steps below to set up and run the project locally:

1. **Clone the Repository**:
   Open your terminal and clone the repository using the following command:
   ```bash
   git clone https://github.com/abbas1512/AreebaPOS.git
   ```

2. **Navigate to Project Directory**:
   ```bash
   cd AreebaPOS
   ```

3. **Configure Database**:
   - Create a new PostgreSQL database called `areebapos` (or update the database name in `application.properties`).
   - Update the `application.properties` file with your PostgreSQL username, password, and other configurations:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/areebapos
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. **Build the Project**:
   - Run the following Maven command to install the project dependencies:
   ```bash
   mvn clean install
   ```

5. **Run the Application**:
   Start the application using the following Maven command:
   ```bash
   mvn spring-boot:run
   ```

6. **Access the Application**:
   Open a browser and go to `http://localhost:8080` to use the POS system.

7. **Login Credentials**:
   - Admin username: `admin`
   - Admin password: `admin`
   - Cashier username: `cashier`
   - Cashier password: `cashier`

## Directory Structure

- `src/main/java/com/areebapos`: Contains all the Java classes, including controllers, services, and repositories.
- `src/main/resources`: Contains configuration files, including `application.properties` for database setup.
- `src/main/resources/templates`: Contains Thymeleaf templates for the front-end UI.

## Usage

Once the application is running:
- **For Admin**: Manage products, users, and view reports.
- **For Cashiers**: Process sales, search for products, and finalize payments.
- **Reports**: View daily, weekly, and monthly sales data to monitor business performance.

## Contributing

Feel free to fork this repository and submit pull requests for any improvements, features, or bug fixes. Please make sure to follow best practices for coding and testing.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
