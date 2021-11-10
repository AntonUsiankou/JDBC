package by.gsu.epamlab;

public class Constants {
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/start";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String LEN = "len";
    public static final String NUM = "num";
    public static final String SELECT_COORDINATES= "SELECT FLOOR(ABS(x2-x1)+0.5) AS len,Count(*) AS num FROM Coordinates GROUP BY len ORDER BY len";
    public static final String DELETE_FREQUENCIES = "DELETE FROM Frequencies";
    public static final String INSERT_FREQUENCIES = "INSERT INTO Frequencies(len, num) VALUES(?, ?)";
    public static final String SELECT_FROM_FREQUENCIES_WHERE_LEN_MORE_NUM = "SELECT * FROM Frequencies WHERE len > num";
    public static final String DELIMITER = ";";
    public static final int LEN_IND = 1;
    public static final int NUM_IND  = 2;
}
