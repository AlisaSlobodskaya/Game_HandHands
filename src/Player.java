public class Player extends Creature {
    private int healingAttempt = 4;
    private final float maxHealth;

    public Player(String name,
                  int attack,
                  int protection,
                  int health,
                  int minDamage,
                  int maxDamage) {
        super(name, attack, protection, health, minDamage, maxDamage);
        maxHealth = health;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " получил " + damage + " урона!");
        if (health <= 0) {
            health = 0;
            System.out.println("Текущий уровень здоровья " + name + ": " + health);
            if (healingAttempt == 0)
                isDead = true;
            if (healingAttempt != 0)
                healing();
        } else {
            System.out.println("Текущий уровень здоровья " + name + ": " + health);
        }
    }

    private void healing() {
        float healthPoint = (maxHealth / 100) * 30;
        healthPoint = Math.round(healthPoint);
        health += healthPoint;
        healingAttempt --;
        System.out.println(name + " исцелился на " + (int)healthPoint + " единиц!" +
                        "\nТекущий уровень здоровья " + name + ": " + health +
                        "\nКоличество попыток исцеления: " + healingAttempt);
    }
}
