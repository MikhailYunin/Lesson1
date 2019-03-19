package lesson4;

public class BattleUnit extends Unit{
    protected int attackScore;

    public  BattleUnit (int health, int attackScore){
        super(health); // насдедование
        this.attackScore = attackScore;
    }

    public void attack (BattleUnit enemy){
        if (!this.isAlive()){
            System.out.println("персонаж мертв");
            return;
        }
        enemy.health -= this.attackScore;
    };

}
