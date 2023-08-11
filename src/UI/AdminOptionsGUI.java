package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdminOptionsGUI extends JFrame {
    private String adminName;

    public AdminOptionsGUI(String adminName) {
        this.adminName = adminName;

        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 182, 193));

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel headerLabel = new JLabel("What would you like to do today?");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(labelFont);
        add(headerLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        buttonPanel.setBackground(new Color(255, 182, 193));

        JButton viewExistingDataButton = new JButton("View Existing User Data");
        JButton registerNewUserButton = new JButton("Register New User");
        viewExistingDataButton.setFont(buttonFont);
        registerNewUserButton.setFont(buttonFont);
        viewExistingDataButton.setBackground(Color.decode("#EEEEEE"));
        registerNewUserButton.setBackground(Color.decode("#EEEEEE"));
        viewExistingDataButton.setForeground(Color.decode("#222222"));
        registerNewUserButton.setForeground(Color.decode("#222222"));

        buttonPanel.add(viewExistingDataButton);
        buttonPanel.add(registerNewUserButton);

        add(buttonPanel);

        viewExistingDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewExistingUserData();
            }
        });

        registerNewUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegistrationForm();
            }
        });

        setVisible(true);
    }


    private void viewExistingUserData() {
        try {
            File csvFile = new File("C:\\Users\\worth\\IdeaProjects\\project-work\\existing_user_data.csv");
            Desktop.getDesktop().open(csvFile);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Failed to open CSV file: " + ex.getMessage());
        }
    }


    private List<String[]> readUserDataFromCSV() {
        List<String[]> userData = new ArrayList<>();

        String filePath = "C:\\Users\\worth\\IdeaProjects\\project-work\\existing_user_data.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");
                userData.add(rowData);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Failed to read user data: " + ex.getMessage());
        }

        return userData;
    }


    private void openRegistrationForm() {
        JFrame registrationFormFrame = new JFrame("Register New User");
        registrationFormFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registrationFormFrame.setSize(400, 500);
        registrationFormFrame.setLocationRelativeTo(null);
        registrationFormFrame.setLayout(new GridLayout(13, 2));
        registrationFormFrame.getContentPane().setBackground(new Color(255, 182, 193));

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setFont(labelFont);

        JTextField fullNameField = new JTextField();
        fullNameField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(labelFont);

        JTextField ageField = new JTextField();
        ageField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel stateLabel = new JLabel("State of Origin:");
        stateLabel.setFont(labelFont);

        JTextField stateField = new JTextField();
        stateField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel lgaLabel = new JLabel("LGA:");
        lgaLabel.setFont(labelFont);

        JTextField lgaField = new JTextField();
        lgaField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(labelFont);

        JTextField phoneField = new JTextField();
        phoneField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);

        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel ninLabel = new JLabel("NIN:");
        ninLabel.setFont(labelFont);

        JTextField ninField = new JTextField();
        ninField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel nextOfKinLabel = new JLabel("Next of Kin:");
        nextOfKinLabel.setFont(labelFont);

        JTextField nextOfKinField = new JTextField();
        nextOfKinField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel maritalStatusLabel = new JLabel("Marital Status:");
        maritalStatusLabel.setFont(labelFont);

        JTextField maritalStatusField = new JTextField();
        maritalStatusField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel genotypeLabel = new JLabel("Genotype:");
        genotypeLabel.setFont(labelFont);

        JTextField genotypeField = new JTextField();
        genotypeField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel bloodGroupLabel = new JLabel("Blood Group:");
        bloodGroupLabel.setFont(labelFont);

        JTextField bloodGroupField = new JTextField();
        bloodGroupField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(labelFont);

        JTextField genderField = new JTextField();
        genderField.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(Color.decode("#EEEEEE"));
        submitButton.setForeground(Color.decode("#222222"));

        registrationFormFrame.add(fullNameLabel);
        registrationFormFrame.add(fullNameField);
        registrationFormFrame.add(ageLabel);
        registrationFormFrame.add(ageField);
        registrationFormFrame.add(stateLabel);
        registrationFormFrame.add(stateField);
        registrationFormFrame.add(lgaLabel);
        registrationFormFrame.add(lgaField);
        registrationFormFrame.add(phoneLabel);
        registrationFormFrame.add(phoneField);
        registrationFormFrame.add(emailLabel);
        registrationFormFrame.add(emailField);
        registrationFormFrame.add(ninLabel);
        registrationFormFrame.add(ninField);
        registrationFormFrame.add(nextOfKinLabel);
        registrationFormFrame.add(nextOfKinField);
        registrationFormFrame.add(maritalStatusLabel);
        registrationFormFrame.add(maritalStatusField);
        registrationFormFrame.add(genotypeLabel);
        registrationFormFrame.add(genotypeField);
        registrationFormFrame.add(bloodGroupLabel);
        registrationFormFrame.add(bloodGroupField);
        registrationFormFrame.add(genderLabel);
        registrationFormFrame.add(genderField);
        registrationFormFrame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = fullNameField.getText();
                String age = ageField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String nin = ninField.getText();
                String state = stateField.getText();
                String lga = lgaField.getText();
                String nextOfKin = nextOfKinField.getText();
                String maritalStatus = maritalStatusField.getText();
                String genotype = genotypeField.getText();
                String bloodGroup = bloodGroupField.getText();
                String gender = genderField.getText();

                String[] rowData = {fullName, age, phone, email, nin, state, lga, nextOfKin, maritalStatus, genotype, bloodGroup, gender};

                String filePath = "C:\\Users\\worth\\IdeaProjects\\project-work\\existing_user_data.csv";

                try {
                    FileWriter fileWriter = new FileWriter(filePath, true);
                    PrintWriter printWriter = new PrintWriter(fileWriter);

                    printWriter.println(String.join(",", rowData));
                    printWriter.close();

                    JOptionPane.showMessageDialog(null, "User registered successfully!");

                    fullNameField.setText("");
                    ageField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                    ninField.setText("");
                    stateField.setText("");
                    lgaField.setText("");
                    nextOfKinField.setText("");
                    maritalStatusField.setText("");
                    genotypeField.setText("");
                    bloodGroupField.setText("");
                    genderField.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to register user: " + ex.getMessage());
                }
            }
        });

        registrationFormFrame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String fullName = "";
                AdminOptionsGUI optionsGUI = new AdminOptionsGUI(fullName);
                optionsGUI.setVisible(true);
            }
            }
        });
    }
}
