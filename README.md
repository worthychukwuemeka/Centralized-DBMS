# Centralized Database Management System

This project implements a Centralized Database Management System using Java Swing for the graphical user interface (GUI) and CSV files for data storage. The system allows administrators to register new users, view past records, and manage user profiles. Citizens can view their own profiles.

## Features

- Admin users can:
  - Register new users, and
  - View past records.

## Getting Started

1. Clone the repository:
   ```
   git clone https://github.com/worthychukwuemeka/centralized-dbms.git
   ```
2. Open the project in your preferred Java IDE.

## Usage

1. Run the `WelcomeWindow` class to start the application.
2. In the Welcome window, select an organization and click "Proceed."
3. In the Registration window, enter your login ID and password.
4. If you're an admin, you will see additional options for managing users.
   - Select "Register New User" to open the Registration form.
   - Select "View Past Records" to view a CSV file with dummy data.
5. If you're a citizen, you will see your own profile.

## Project Structure

- `WelcomeWindow.java`: Displays the welcome window with organization options.
- `RegistrationWindow.java`: Displays the registration window for users to log in.
- `DashboardWindow.java`: Displays the dashboard for admin and citizen users.
- `CsvWriter.java`: Handles writing data to a CSV file.
- `ExistingUserData.csv`: CSV file containing dummy user data.

## Data Storage

- User data is stored in the `UserData.csv` file using CSV format.

## Dependencies

- Java Swing: For creating the GUI.
- OpenCSV: For reading and writing CSV files.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- This project is a sample implementation and may require additional features and improvements for production use.
- Thanks to [OpenCSV](http://opencsv.sourceforge.net/) for providing the CSV library.
