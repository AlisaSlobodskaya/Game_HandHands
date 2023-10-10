import java.util.Random;
import java.util.Scanner;

import static constant.ImageAscii.DICE;

public abstract class Creature {
    String name;
    int attack;
    int protection;
    int health;
    int minDamage;
    int maxDamage;
    boolean isDead;

    public Creature(String name, int attack, int protection, int health, int minDamage, int maxDamage) {
        this.name = name;
        this.attack = attack;
        this.protection = protection;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.isDead = false;
    }

    public void attackCreature(Creature creature) {
        int attackModifier = this.attack - creature.protection + 1;
        if (isAttackSuccessful(attackModifier)) {
            Random random = new Random();
            int damage = random.nextInt(minDamage, maxDamage + 1);
            creature.takeDamage(damage);
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            if (creature.isDead())
                System.out.println("\n" + name + " нанес критический урон " + creature.getName() + "..."
                                    + "\n☠ " + creature.getName() +" мертв.");
        } else {
            System.out.println(creature.getName() + " увернулся от атаки!");
        }
    }

    public boolean isAttackSuccessful(int attackModifier) {
        if (attackModifier < 1)
            attackModifier = 1;
        System.out.println("Бросков кости: " + attackModifier);

        for (int i = 0; i < attackModifier; i++) {
            int roll = rollDice();
            if (roll == 4 || roll == 5)
                return true;
        }

        return false;
    }

    public int rollDice() {
        Random random = new Random();
        int roll = random.nextInt(0,6);
        System.out.println(DICE[roll]);
        return roll;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            isDead = true;
        }
        System.out.println("\n" + name + " получил " + damage + " урона!" +
                "\n♥ Текущий уровень здоровья " + name + ": " + health);

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public boolean isDead() {
        return isDead;
    }
}
