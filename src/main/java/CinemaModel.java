import java.time.LocalDate;
import java.util.List;

/**
 * Created by IIS on 10.03.2016.
 */
public interface CinemaModel {
    List <Seance> find (String str, LocalDate d);
    Hall getHall (int seanceID);
    boolean reserve (int seanceID, int row, int seat, String username, LocalDate date);
}
