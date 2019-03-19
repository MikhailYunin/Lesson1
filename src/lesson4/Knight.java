package lesson4;

public class Knight extends BattleUnit{

    public Knight (int health,int attackScore){

            //вызов конструкторского класса
            super(health, attackScore);

    }

    //переопределение метода

    @Override // анотации для защиты метода (ошибки )
    public  void attack (BattleUnit enemy){
        //вызов родительского метода
        super.attack((enemy));
        //расширение функционала

        enemy.health -=10;

    }



}
