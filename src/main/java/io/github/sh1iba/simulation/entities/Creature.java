package main.java.io.github.sh1iba.simulation.entities;

/*
TODO Creature
   Абстрактный класс, наследуется от Entity.
   Существо, имеет скорость (сколько клеток может пройти за 1 ход),
   количество HP. Имеет метод makeMove() - сделать ход.
 */

public abstract class Creature extends Entity {
    public int speed = 0;
    public int healthPoint = 0;

    public void makeMove(){

    }
}
