import javax.swing.*;
import java.awt.*;

class laptopCoversButton extends JFrame {

    private JPanel contentPane;

    public laptopCoversButton() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 800);

        // Load the background image
        Image backgroundImage = new ImageIcon("C:\\Users\\javer\\Downloads\\assignments\\gui\\background.jpg.jpg").getImage();

        // Set up the content pane
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

                // Draw a gradient overlay
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 0, 0, 150), 0, getHeight(), new Color(0, 0, 0, 50));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };


        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("Enter MAC Details");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 34));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 50, 900, 50);
        contentPane.add(titleLabel);

        // Name label and text field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Helvetica", Font.PLAIN, 18));
        nameLabel.setBounds(150, 150, 100, 30);
        contentPane.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(300, 150, 400, 30);
        contentPane.add(nameField);

        // Description label and text field
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Helvetica", Font.PLAIN, 18));
        descriptionLabel.setBounds(150, 200, 120, 30);
        contentPane.add(descriptionLabel);

        JTextField descriptionField = new JTextField();
        descriptionField.setBounds(300, 200, 400, 30);
        contentPane.add(descriptionField);

        // Price label and text field
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setFont(new Font("Helvetica", Font.PLAIN, 18));
        priceLabel.setBounds(150, 250, 100, 30);
        contentPane.add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(300, 250, 400, 30);
        contentPane.add(priceField);

        // Color label and text field
        JLabel colorLabel = new JLabel("Color:");
        colorLabel.setForeground(Color.WHITE);
        colorLabel.setFont(new Font("Helvetica", Font.PLAIN, 18));
        colorLabel.setBounds(150, 300, 100, 30);
        contentPane.add(colorLabel);

        JTextField colorField = new JTextField();
        colorField.setBounds(300, 300, 400, 30);
        contentPane.add(colorField);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(350, 370, 200, 50);
        submitButton.setFont(new Font("Helvetica", Font.BOLD, 20));
        contentPane.add(submitButton);
    }

}