package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElectionResults {
    public static void showResults() {
        String sql = "SELECT name, party, votes FROM candidates ORDER BY votes DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Election Results:");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " (" + rs.getString("party") + ") - Votes: " + rs.getInt("votes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
