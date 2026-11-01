import javax.swing.*;

public class NumberCounter {
    private JPanel numcount;
    private JLabel countLabel;
    private JButton decreaseButton;
    private JButton increaseButton;

    public NumberCounter() {
        countLabel.setName("countLabel");
        decreaseButton.setName("decreaseButton");
        increaseButton.setName("increaseButton");

        decreaseButton.addActionListener(e -> {
            int value = Integer.parseInt(countLabel.getText());
            countLabel.setText(String.valueOf(value - 1));
        });

        increaseButton.addActionListener(e -> {
            int value = Integer.parseInt(countLabel.getText());
            countLabel.setText(String.valueOf(value + 1));
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Counter");
        frame.setContentPane(new NumberCounter().numcount);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
