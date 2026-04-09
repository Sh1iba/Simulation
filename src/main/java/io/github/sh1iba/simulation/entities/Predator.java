package main.java.io.github.sh1iba.simulation.entities;

/*
TODO Predator
   Хищник, наследуется от Creature. В дополнение к полям класса Creature, имеет силу атаки. На что может потратить ход хищник:
   Переместиться (чтобы приблизиться к жертве - травоядному)
   Атаковать травоядное. При этом количество HP травоядного уменьшается на силу атаки хищника. Если значение HP жертвы опускается до 0, травоядное исчезает
 */

import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.GameMap;

public class Predator extends Creature {

    private static final String SYMBOL = "\uD83D\uDC79";

    private final int attackPower;

    public Predator() {
        this.healthPoint = 100;
        this.speed = 6;
        this.attackPower = 25;
    }

    @Override
    public Class<? extends Entity> getTargetClass() {
        return Herbivore.class;
    }

    @Override
    public void interact(Coordinates coordinates, GameMap map) {

    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public void attack() {

    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
