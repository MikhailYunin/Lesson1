package fitness;


@AccessMode(gym = "16", group = "16", pool = "16")
public class DayClient extends Client{

    private String endOfReg;
    private Access group = new Access(8, 16, FitnessServiceEnumiration.GROUP);
    private Access gym = new Access(8, 16, FitnessServiceEnumiration.GYM);



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
        this.endOfReg = "12.04.2020"; //TODO: сделать автоматически
    }

    public DayClient(String name, String surname, int bYear, String regDate, String endOfReg) {
        super(name, surname, bYear, regDate);
        this.endOfReg = "12.08.2019"; // TODO

    }
}
