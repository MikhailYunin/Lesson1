package fitness;

import java.util.Date;

@AccessMode(group = 0)
public class Client extends Human {

    private boolean isVisited = false;
    private Access gym = new Access(8, 22, FitnessServiceEnumiration.GYM);
    private Access pool = new Access(8, 22, FitnessServiceEnumiration.POOL);


    public Client(String name, String surname, int bYear, String regDate) {
        super(name, surname, bYear, regDate);
    }

    public Client(String name, String surname, int bYear) {
        super(name, surname, bYear);
    }
}
