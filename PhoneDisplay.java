import javax.swing.*;
import java.awt.*;
import java.sql.*;

class PhoneDisplay extends JFrame {
    private JPanel contentPane;
    private JPanel cardsPanel;
    private JScrollPane scrollPane;

    public PhoneDisplay() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 0, 900, 800);

        // Load the background image
        Image backgroundImage = new ImageIcon("C:\\Users\\javer\\Downloads\\background.jpg.jpg").getImage();

        // Set up the content pane with custom painting for background and gradient
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
        JLabel titleLabel = new JLabel("Explore the lineup");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 34));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 20, 900, 50);
        contentPane.add(titleLabel);

        // Panel to hold cards in a grid
        cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(0, 3, 0, 0)); // 2 columns with space between cards
        cardsPanel.setOpaque(false);

        // ScrollPane to make the cards panel scrollable
        scrollPane = new JScrollPane(cardsPanel);
        scrollPane.setBounds(50, 80, 800, 650);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        contentPane.add(scrollPane);

        // Fetch data and create cards
        fetchData();
    }

    private void fetchData() {
        // Database connection parameters
        String url = "jdbc:sqlserver://Javeria\\SQLEXPRESS;databaseName=SCD;encrypt=false;trustServerCertificate=true;user=Javeria;password=JAVERIANOOR123";
        String query = "SELECT name, description, price, colour FROM phones";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // For each entry, create a card
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String price = resultSet.getString("price");
                String color = resultSet.getString("colour");
               // int quantity =resultSet.getInt("Quantity");

                // Create card
                JPanel card = createCard(name, description, price, color);
                cardsPanel.add(card);
            }
            cardsPanel.revalidate();
            cardsPanel.repaint();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JPanel createCard(String name, String description, String price, String color) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setPreferredSize(new Dimension(250,300));
        card.setBackground(new Color(255, 255, 255, 220));
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        card.setOpaque(false);

        // Image placeholder at the top
        // Image placeholder at the top
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\javer\\OneDrive\\Pictures\\picture 1.png");


// Resize the image to a width of 300 and a height of 200 (adjust as needed)
        Image resizedImage = originalIcon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        card.add(imageLabel, BorderLayout.NORTH);

        // Content Panel for text, arranged vertically
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // padding inside the card

        // Name label
        JLabel nameLabel = new JLabel(name);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(nameLabel);

        // Description label
        JLabel descriptionLabel = new JLabel( description );
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(descriptionLabel);

        // Color label
        JLabel colorLabel = new JLabel("Color: " + color);
        colorLabel.setForeground(Color.WHITE);
        colorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(colorLabel);

        // Price label
        JLabel priceLabel = new JLabel("Price: " + price);
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setFont(new Font("Helvetica", Font.PLAIN, 14));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(priceLabel);

        card.add(contentPanel, BorderLayout.CENTER);

        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PhoneDisplay frame = new PhoneDisplay();
            frame.setVisible(true);
        });
    }
}
