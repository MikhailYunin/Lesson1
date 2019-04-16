package fitness;

import java.util.Date;

@AccessMode(gym = "22", group = "-1", pool = "22")
public class Client extends Human {

    private boolean isVisited = false;
    private Access gym = new Access(8, 22, FitnessServiceEnumiration.GYM);
    private Access pool = new Access(8, 22, FitnessServiceEnumiration.POOL);


    public Client(String name, String surname, int bYear, String regDate) {
        super(name, surname, bYear, regDate);
        setTypeClient("Client");
    }

    public Client(String name, String surname, int bYear) {
        super(name, surname, bYear);
        setTypeClient("Client");
    }
    public Access getGym() {
        return gym;
    }

    public void setGym(Access gym) {
        this.gym = gym;
    }

    public Access getPool() {
        return pool;
    }

    public void setPool(Access pool) {
        this.pool = pool;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

//    public FitnessServiceEnumiration enumiration (){
//
//        return
//    }

    public static void main(String[] args) {

    }

}
