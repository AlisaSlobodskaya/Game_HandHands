import java.util.Random;

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

            if (creature.isDead())
                System.out.println(name + " нанес критический урон " + creature.getName() + "..."
                                    + "\n" + creature.getName() +" мертв");
        } else {
            System.out.println(creature.getName() + " увернулся от атаки!");
        }
    }

    public boolean isAttackSuccessful(int attackModifier) {
        if (attackModifier < 1)
            attackModifier = 1;

        for (int i = 1; i <= attackModifier; i++) {
            Random random = new Random();
            int diceRoll = random.nextInt(1,7);
            System.out.println("Бросок кубика №" + i + " равен: " + diceRoll);
            if (diceRoll == 5 || diceRoll == 6)
                return true;
        }

        return false;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            isDead = true;
        }
        System.out.println(name + " получил " + damage + " урона!" +
                "\nТекущий уровень здоровья " + name + ": " + health);
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
