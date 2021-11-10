import by.gsu.epamlab.Segments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.epamlab.Constants.*;

public class Runner {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FREQUENCIES);) {

            statement.executeUpdate(DELETE_FREQUENCIES);

            List<Segments> segmentsList = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery(SELECT_COORDINATES)) {
                while (resultSet.next()) {
                    segmentsList.add(new Segments(resultSet.getInt(LEN), resultSet.getInt(NUM)));
                }
            }
            for (Segments segment : segmentsList) {
                preparedStatement.setInt(LEN_IND, segment.getLen());
                preparedStatement.setInt(NUM_IND, segment.getNum());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

            try(ResultSet resultSet = statement.executeQuery(SELECT_FROM_FREQUENCIES_WHERE_LEN_MORE_NUM)){
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(LEN) + DELIMITER + resultSet.getInt(NUM));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

