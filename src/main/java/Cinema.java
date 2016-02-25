import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by IIS on 25.02.2016.
 */

public class Cinema {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = DriverManager.getConnection("jdbc:derby:CinemaDB; create = true")) {

            try (PreparedStatement create1 = connection.prepareStatement("CREATE TABLE HALLS (NUM INT NOT NULL GENERATED BY DEFAULT " +
                    "AS IDENTITY (START WITH 100) PRIMARY KEY, NROWS INT NOT NULL)")) {
                create1.execute();
            }
            try (PreparedStatement create2 = connection.prepareStatement("CREATE TABLE SEANCES (ID INT NOT NULL GENERATED BY DEFAULT " +
                    "AS IDENTITY (START WITH 100) PRIMARY KEY, STIME VARCHAR(5) NOT NULL, HALL INT NOT NULL," +
                    "PRICE INT NOT NULL, FILM VARCHAR(100) NOT NULL, AGE INT NOT NULL, FOREIGN KEY (HALL) " +
                    "REFERENCES HALLS (NUM))")) {
                create2.execute();
            }
            try (PreparedStatement create3 = connection.prepareStatement("CREATE TABLE HROWS (HALL INT NOT NULL GENERATED BY DEFAULT "
                    + "AS IDENTITY (START WITH 100) PRIMARY KEY, ROW INT NOT NULL, " +
                    "SEATS INT NOT NULL, FOREIGN KEY(HALL) REFERENCES HALLS(NUM))")) {
                create3.execute();
            }

            try (PreparedStatement create4 = connection.prepareStatement("CREATE TABLE RESERVATIONS (USERID VARCHAR(100) NOT NULL, " +
                    "ROW INT NOT NULL, SEAT INT NOT NULL, SEANCE INT NOT NULL, FOREIGN KEY (SEANCE) REFERENCES SEANCES (ID))")) {
                create4.execute();
            }
        }
    }
}