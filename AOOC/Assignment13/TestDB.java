import java.sql.*;

class TestDB {
    public static void main(String args[]) {
        int rn = 0;
        String name;
        float mks;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cse?useSSL=false", "root", "root");

            // Create a statement object to execute queries
            Statement stmt = con.createStatement();

            // Execute the query and retrieve the result set
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            // Iterate through the result set and print the data
            while (rs.next()) {
                rn = rs.getInt(1);
                name = rs.getString(2);
                mks = rs.getFloat(3);
                System.out.println("Rollno: " + rn + "\t" + "Name: " + name + "\t" + "Marks: " + mks);
            }

            // Close the connection
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}