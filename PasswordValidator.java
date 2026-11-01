import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PasswordValidator {
    private JPanel passwordValidationPanel;
    private JPasswordField passwordTextField;
    private JLabel statusLabel;

    public PasswordValidator() {
        passwordTextField.setName("passwordTextField");
        statusLabel.setName("statusLabel");

        passwordTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { validatePassword(); }
            public void removeUpdate(DocumentEvent e) { validatePassword(); }
            public void changedUpdate(DocumentEvent e) { validatePassword(); }
        });
    }

    private void validatePassword() {
        String password = new String(passwordTextField.getPassword());

        if (password.length() < 8) {
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("Password must be 8 characters long");
        } else {
            boolean hasDigit = false;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    hasDigit = true;
                    break;
                }
            }

            if (!hasDigit) {
                statusLabel.setForeground(Color.RED);
                statusLabel.setText("Password must contain at least one digit");
            } else {
                boolean hasSpecial = false;
                for (int i = 0; i < password.length(); i++) {
                    char c = password.charAt(i);
                    if (!Character.isLetterOrDigit(c)) {
                        hasSpecial = true;
                        break;
                    }
                }

                if (!hasSpecial) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Password must contain at least one special character");
                } else {
                    statusLabel.setForeground(Color.GREEN);
                    statusLabel.setText("Password is valid");
                    writePasswordToFile(password);
                }
            }
        }
    }

    private void writePasswordToFile(String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("passwords.txt", true))) {
            writer.write(password);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing password to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Validator");
        PasswordValidator app = new PasswordValidator();
        frame.setContentPane(app.passwordValidationPanel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
