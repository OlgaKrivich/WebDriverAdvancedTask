package gdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Assert;

public class Main {

    private static final String QUERY_SELECT = "SELECT lastName FROM people WHERE firstName='albert'";
    private static final String QUERY_JOIN = "SELECT people_book.book,people.lastName FROM people_book JOIN people ON people.id=people_book.id";

    public static void verifyLastNameFromQuery() {
        String expectedLastName = "einstein";
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_SELECT);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("lastName"));
                String lastNameFromQuery = resultSet.getString("lastName");
                Assert.assertEquals(lastNameFromQuery, expectedLastName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionManager.getInstance().close();
    }

    public static void verifyBookNameFromQuery() {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_JOIN);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("book"));
                System.out.println(resultSet.getString("lastName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionManager.getInstance().close();
    }

    public static void main(String[] args) {
        verifyLastNameFromQuery();
        System.out.println();
        verifyBookNameFromQuery();
    }

}
