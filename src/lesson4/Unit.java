package lesson4;

public class Unit {
    protected int health;

    protected Unit(int health) {
        this.health = health;
    }


    public boolean isAlive(){
        return health > 0;
    }
}
