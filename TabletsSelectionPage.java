import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabletsSelectionPage extends JFrame {
    private JPanel contentPane;

    public TabletsSelectionPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 800);

        // Load the background image
        Image backgroundImage = new ImageIcon("C:\\Users\\javer\\Downloads\\background.jpg.jpg").getImage();

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
        JLabel titleLabel = new JLabel("iPad Management");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 34));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 100, 900, 80);
        contentPane.add(titleLabel);


        JButton displayButton = new JButton("Display iPads");
        displayButton.setFont(new Font("Helvetica", Font.PLAIN, 20));
        displayButton.setBounds(300, 300, 300, 50);
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PhoneDisplay phoneDisplay1=new PhoneDisplay();
                phoneDisplay1.setVisible(true);
                CategoryPage category=new CategoryPage();
                category.setVisible(false);
            }
        });
        contentPane.add(displayButton);

        // Button for Insert Phones
        JButton insertButton = new JButton("Insert iPads");
        insertButton.setFont(new Font("Helvetica", Font.PLAIN, 20));
        insertButton.setBounds(300, 400, 300, 50);
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneEntryPage phoneEntry1=new  phoneEntryPage();
                phoneEntry1.setVisible(true);
                CategoryPage category=new CategoryPage();
                category.setVisible(false);
            }
        });
        contentPane.add(insertButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PhoneSelectionPage frame = new PhoneSelectionPage();
            frame.setVisible(true);
        });
    }
}

