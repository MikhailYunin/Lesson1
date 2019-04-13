package fitness;

public class Access {
    private int from;
    private int to;
    private FitnessServiceEnumiration type;

    public Access(int from, int to, FitnessServiceEnumiration type) {
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public FitnessServiceEnumiration getType() {
        return type;
    }

    public void setType(FitnessServiceEnumiration type) {
        this.type = type;
    }


}
