import javax.swing.*;

public class CharacterRemover {
    private JPanel characterRemoverPanel;
    private JButton removeButton;
    private JButton restoreButton;
    private JLabel textLabel;
    private JCheckBox vowelCheckBox;
    private JCheckBox consonantCheckBox;
    private JCheckBox numberCheckBox;

    private final String ORIGINAL_TEXT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public CharacterRemover() {
        vowelCheckBox.setName("vowelCheckbox");
        consonantCheckBox.setName("consonantCheckbox");
        numberCheckBox.setName("numberCheckbox");
        removeButton.setName("removeButton");
        restoreButton.setName("restoreButton");
        textLabel.setName("textLabel");

        removeButton.addActionListener(e -> {
            String result = ORIGINAL_TEXT;
            if (vowelCheckBox.isSelected()) {
                result = result.replaceAll("[AEIOU]", "");
            }
            if (consonantCheckBox.isSelected()) {
                result = result.replaceAll("[BCDFGHJKLMNPQRSTVWXYZ]", "");
            }
            if (numberCheckBox.isSelected()) {
                result = result.replaceAll("[0-9]", "");
            }
            textLabel.setText(result);
        });

        restoreButton.addActionListener(e -> {
            vowelCheckBox.setSelected(false);
            consonantCheckBox.setSelected(false);
            numberCheckBox.setSelected(false);
            textLabel.setText(ORIGINAL_TEXT);
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Character Remover");
        CharacterRemover app = new CharacterRemover();
        frame.setContentPane(app.characterRemoverPanel);
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
