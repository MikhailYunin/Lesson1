package fitness;

public class FullDayClient extends Human{
    private Access group = new Access(8, 22, FitnessServiceEnumiration.GROUP);
    private Access gym = new Access(8, 22, FitnessServiceEnumiration.GYM);
    private Access pool = new Access(8, 22, FitnessServiceEnumiration.POOL);

    public FullDayClient(String name, String surname, int bYear) {
        super(name, surname, bYear);
    }

    public FullDayClient(String name, String surname, int bYear, String regDate, Access group, Access gym, Access pool) {
        super(name, surname, bYear, regDate);
        this.group = group;
        this.gym = gym;
        this.pool = pool;
    }
}
