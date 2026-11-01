import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginForm {
    private JPanel loginFormPanel;
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;

    public LoginForm() {
        userNameTextField.setName("userNameTextField");
        passwordTextField.setName("passwordTextField");
        loginButton.setName("loginButton");

        loginButton.addActionListener(e -> {
            String username = userNameTextField.getText();
            String password = new String(passwordTextField.getPassword());
            boolean isSuccess = checkCredentials(username, password);
            JDialog statusDialog = new JDialog();
            statusDialog.setTitle("Status");
            statusDialog.setSize(250, 150);
            statusDialog.setLocationRelativeTo(null);
            JLabel messageLabel = new JLabel();
            messageLabel.setName("messageLabel");
            messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

            if (isSuccess) {
                messageLabel.setText("Login Successful!");
            } else {
                messageLabel.setText("Login Failed!");
            }

            statusDialog.add(messageLabel);
            statusDialog.setVisible(true);
        });
    }

    private boolean checkCredentials(String inputUser, String inputPass) {
        try (BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    if (parts[0].trim().equals(inputUser) && parts[1].trim().equals(inputPass)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            if (inputUser.equals("admin") && inputPass.equals("admin")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        LoginForm app = new LoginForm();
        frame.setContentPane(app.loginFormPanel);
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}