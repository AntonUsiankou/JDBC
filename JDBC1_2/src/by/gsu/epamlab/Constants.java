package by.gsu.epamlab;

public class Constants {
    public static final String CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/start";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String LEN = "len";
    public static final String NUM = "num";
    public static final String SELECT_COORDINATES= "SELECT FLOOR(ABS(x2-x1)+0.5) AS len,Count(*) AS num FROM Coordinates GROUP BY len ORDER BY len";
    public static final String DELETE_FREQUENCIES = "DELETE FROM Frequencies";
    public static final String INSERT_FREQUENCIES = "INSERT INTO Frequencies(len, num) VALUES(?, ?)";
    public static final String SELECT_FREQUENCIES = "SELECT * FROM Frequencies";
    public static final String COMPARE_SELECT_FROM_FREQUENCIES = "SELECT * FROM Frequencies WHERE len > num";
    public static final String DELIMITER = ";";
    public static final int PARAMETER_INDEX_ONE = 1;
    public static final int PARAMETER_INDEX_TWO = 2;
    public static final String ERROR_MESSAGE = "Error: ";
}
