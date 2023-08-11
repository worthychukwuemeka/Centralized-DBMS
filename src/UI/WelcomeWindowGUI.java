package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeWindowGUI extends JFrame {
    private JComboBox<String> orgComboBox;

    public WelcomeWindowGUI() {
        setTitle("Welcome to the Centralized Database Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 182, 193));

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        Font comboFont = new Font("Arial", Font.PLAIN, 14);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel headerLabel = new JLabel("Welcome to the Centralized Database Management System");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(labelFont);
        add(headerLabel);

        JLabel paragraphLabel = new JLabel("Select an organization to view its records");
        paragraphLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        paragraphLabel.setFont(labelFont);
        add(paragraphLabel);

        orgComboBox = new JComboBox<>(new String[]{"NIMC", "NIS", "INC", "FRSC"});
        orgComboBox.setMaximumSize(new Dimension(200, 30));
        orgComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        orgComboBox.setFont(comboFont);
        add(orgComboBox);

        add(Box.createVerticalGlue());

        JButton nextButton = new JButton("Next");
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextButton.setFont(buttonFont);
        nextButton.setBackground(Color.decode("#EEEEEE"));
        nextButton.setForeground(Color.decode("#222222"));
        add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLoginWindow();
            }
        });

        setVisible(true);
    }

    private void openLoginWindow() {
        String selectedOrg = (String) orgComboBox.getSelectedItem();

        JFrame loginFrame = new JFrame("Login to access user data");
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setSize(400, 300);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.getContentPane().setBackground(new Color(255, 182, 193)); // Baby Pink Background

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 12);
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);

        loginFrame.setLayout(new BoxLayout(loginFrame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel headerLabel = new JLabel(selectedOrg + " Login to access user data");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(labelFont);
        loginFrame.add(headerLabel);

        JLabel usernameLabel = new JLabel("Admin Username:");
        usernameLabel.setFont(labelFont);

        JTextField usernameField = new JTextField();
        usernameField.setFont(fieldFont);
        usernameField.setMaximumSize(new Dimension(200, 30));

        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.X_AXIS));
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        loginFrame.add(usernamePanel);

        JLabel passwordLabel = new JLabel("Admin Password:");
        passwordLabel.setFont(labelFont);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(fieldFont);
        passwordField.setMaximumSize(new Dimension(200, 30));

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        loginFrame.add(passwordPanel);

        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setFont(buttonFont);
        loginButton.setBackground(Color.decode("#EFEFEF"));
        loginButton.setForeground(Color.decode("#222222"));

        loginFrame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (isValidLogin(username, password)) {
                    loginFrame.dispose();
                    openAdminOptions(selectedOrg);
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid credentials. Please try again.");
                }
            }
        });

        loginFrame.setVisible(true);
    }

    private boolean isValidLogin(String username, String password) {
        if (username.equals("johnpatrick") && password.equals("password1")) {
            return true;
        } else if (username.equals("sarahgbenga") && password.equals("password2")) {
            return true;
        } else if (username.equals("fatimamusa") && password.equals("password3")) {
            return true;
        } else if (username.equals("philipokocha") && password.equals("password4")) {
            return true;
        } else {
            return false;
        }
    }

    private void openAdminOptions(String organization) {
        new AdminOptionsGUI(organization);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WelcomeWindowGUI();
            }
        });
    }
}

// Chukwuemeka Worthy Oluebube
