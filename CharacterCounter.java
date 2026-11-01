import javax.swing.*;

public class CharacterCounter {
    private JPanel characterCounterPanel;
    private JTextArea messageTextArea;
    private JTextField characterTextField;
    private JButton countButton;
    private JLabel countLabel;

    public CharacterCounter() {
        messageTextArea.setName("messageTextArea");
        characterTextField.setName("characterTextField");
        countButton.setName("countButton");
        countLabel.setName("countLabel");

        countButton.addActionListener(e -> {
            String text = messageTextArea.getText();
            String charInput = characterTextField.getText();
            if (!charInput.isEmpty()) {
                char target = charInput.charAt(0);
                int count = 0;
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) == target) {
                        count++;
                    }
                }
                countLabel.setText(String.valueOf(count));
            } else {
                countLabel.setText("0");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Character Counter");
        CharacterCounter app = new CharacterCounter();
        frame.setContentPane(app.characterCounterPanel);
        frame.setSize(400, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
