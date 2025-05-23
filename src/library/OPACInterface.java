package library;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OPACInterface extends JFrame {
    private JTextField titleField;
    private JTextField authorField;
    private JButton searchButton;
    private JLabel resultLabel;

    public OPACInterface() {
        initUI();
    }

    private void initUI() {
        setTitle("Library OPAC Search");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Book Title Label and Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Book Title:"), gbc);

        gbc.gridx = 1;
        titleField = new JTextField(20);
        panel.add(titleField, gbc);

        // Author Label and Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Author:"), gbc);

        gbc.gridx = 1;
        authorField = new JTextField(20);
        panel.add(authorField, gbc);

        // Search Button
        gbc.gridx = 1;
        gbc.gridy = 2;
        searchButton = new JButton("Search Book");
        panel.add(searchButton, gbc);

        // Result Label
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        resultLabel = new JLabel(" ");
        panel.add(resultLabel, gbc);

        add(panel);

        searchButton.addActionListener(e -> searchBook());
    }

    private void searchBook() {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();

        if (title.isEmpty() || author.isEmpty()) {
            resultLabel.setText("Please enter both title and author.");
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT id FROM books WHERE title = ? AND author = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, author);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                resultLabel.setText("The book \"" + title + "\" is available (ID: " + id + ").");
            } else {
                resultLabel.setText("The book \"" + title + "\" by " + author + " is not available.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resultLabel.setText("Error occurred while searching for the book.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OPACInterface opac = new OPACInterface();
            opac.setVisible(true);
        });
    }
}
