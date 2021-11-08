package by.gsu.epamlab;

public class Constants {
    public static final String CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/start";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static final String SQL_QUERY_FOR_COORDINATES = "SELECT ROUND(Cast(ABS(x1-x2) AS DECIMAL)) AS len, Count(*) AS num FROM Coordinates GROUP BY 1 ORDER BY 1";
    public static final String LEN = "len";
    public static final String NUM = "num";
    public static final String DELETE_FROM_FREQUENCIES = "DELETE FROM Frequencies";
    public static final String INSERT_INTO_FREQUENCIES = "INSERT INTO Frequencies(len, num) VALUES(?, ?)";
    public static final String SELECT_FROM_FREQUENCIES = "SELECT * FROM Frequencies";
    public static final String DELIMITER = ";";
    public static final String COMPARE_SELECT_FROM_FREQUENCIES = "SELECT * FROM Frequencies WHERE len > num";
    public static final int PARAMETER_INDEX_ONE = 1;
    public static final int PARAMETER_INDEX_TWO = 2;
    public static final String ERROR_MESSAGE = "Error: ";
}
