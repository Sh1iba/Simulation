package main.java.io.github.sh1iba.simulation.entities;

/*
TODO Predator
   Хищник, наследуется от Creature. В дополнение к полям класса Creature, имеет силу атаки. На что может потратить ход хищник:
   Переместиться (чтобы приблизиться к жертве - травоядному)
   Атаковать травоядное. При этом количество HP травоядного уменьшается на силу атаки хищника. Если значение HP жертвы опускается до 0, травоядное исчезает
 */

public class Predator extends Creature {
    public static final String SYMBOL = "\uD83D\uDC3A";
    public int attackPower;

    @Override
    public void makeMove() {
        super.makeMove();
    }

    public void attack() {

    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
