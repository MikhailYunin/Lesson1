package fitness;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@AccessMode(gym = "16", group = "16", pool = "0")
public class DayClient extends Client{

    private String endOfReg;
    private Access group = new Access(8, 16, FitnessServiceEnumiration.GROUP);
    private Access gym = new Access(8, 16, FitnessServiceEnumiration.GYM);

    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");



    public Access getGroup() {
        return group;
    }

    public void setGroup(Access group) {
        this.group = group;
    }

    @Override
    public Access getGym() {
        return gym;
    }

    @Override
    public void setGym(Access gym) {
        this.gym = gym;
    }

    public DayClient(String name, String surname, int bYear) {
        super(name, surname, bYear);
        this.endOfReg = date.plusYears(1).format(formatter) ; //TODO: сделать автоматически
        setTypeClient("DayClient");
    }

    public DayClient(String name, String surname, int bYear, String regDate, int endOfReg) {
        super(name, surname, bYear, regDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime date2 = (LocalDateTime) formatter.parse(regDate);
        this.endOfReg = date2.plusMonths(endOfReg).format(formatter); // TODO
        setTypeClient("DayClient");


    }
}

