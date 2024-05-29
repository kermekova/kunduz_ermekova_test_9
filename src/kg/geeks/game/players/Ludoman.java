package kg.geeks.game.players;

import java.util.Random;

public class Ludoman extends Hero {
    private Random random = new Random();

    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.LUDOMAN_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        if (die1 == die2) {
            int damage = die1 * die2;
            boss.setHealth(boss.getHealth() - damage);
            System.out.println(this.getName() + " бросил" + die1 + " и" + die2 +
                    ". Одинаковые кости! Босс получает " + damage + " урона");
        } else {
            Hero teammate = heroes[random.nextInt(heroes.length)];
            while (teammate == this) {
                teammate = heroes[random.nextInt(heroes.length)];
            }
            int damage = die1 + die2;
            teammate.setHealth(teammate.getHealth() - damage);
            System.out.println(this.getName() + " бросил " + die1 + " и " + die2 +
                    ". Разные кости! " + teammate.getName()+ " получает " + damage + " урона.");
        }
    }

}
