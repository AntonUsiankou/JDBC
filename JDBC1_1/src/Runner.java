import by.gsu.epamlab.Segments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.epamlab.Constants.*;

public class Runner {

    public static void main(String[] args) {

        try {
            Class.forName(CLASS_NAME);
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            List<Segments> segmentsList = new ArrayList<>();
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                statement = connection.createStatement();
                resultSet = statement.executeQuery(SQL_QUERY_FOR_COORDINATES);

                while (resultSet.next()) {
                    segmentsList.add(new Segments(resultSet.getInt(LEN), resultSet.getInt(NUM)));
                }
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_FREQUENCIES);
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(INSERT_INTO_FREQUENCIES);
                for (Segments segment : segmentsList) {
                    preparedStatement.setInt(PARAMETER_INDEX_ONE, segment.getLen());
                    preparedStatement.setInt(PARAMETER_INDEX_TWO, segment.getNum());
                    preparedStatement.executeUpdate();
                }

                resultSet = statement.executeQuery(SELECT_FROM_FREQUENCIES);
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(LEN) + DELIMITER + resultSet.getInt(NUM));
                }

                System.out.println();

                resultSet = statement.executeQuery(COMPARE_SELECT_FROM_FREQUENCIES);
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(LEN) + DELIMITER + resultSet.getInt(NUM));
                }
            } finally {
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
    }
}

