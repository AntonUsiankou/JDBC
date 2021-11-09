import by.gsu.epamlab.Segments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.epamlab.Constants.*;

public class Runner {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_COORDINATES)) {
                List<Segments> segmentsList = new ArrayList<>();
                while (resultSet.next()) {
                    segmentsList.add(new Segments(resultSet.getInt(LEN), resultSet.getInt(NUM)));
                }
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FREQUENCIES);
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(INSERT_FREQUENCIES);
                for (Segments segment : segmentsList) {
                    preparedStatement.setInt(PARAMETER_INDEX_ONE, segment.getLen());
                    preparedStatement.setInt(PARAMETER_INDEX_TWO, segment.getNum());
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            }
            try( ResultSet resultSet = statement.executeQuery(SELECT_FREQUENCIES)) {

                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(LEN) + DELIMITER + resultSet.getInt(NUM));
                }
            }
                System.out.println();
            try(ResultSet resultSet = statement.executeQuery(COMPARE_SELECT_FROM_FREQUENCIES)){
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(LEN) + DELIMITER + resultSet.getInt(NUM));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

