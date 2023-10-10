import java.util.Scanner;

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
        System.out.println("\n" + name + " получил " + damage + " урона!");

        if (health <= 0) {
            health = 0;
            System.out.println("♥ Текущий уровень здоровья " + name + ": " + health);
            if (healingAttempt == 0)
                isDead = true;
            if (healingAttempt != 0)
                healing();
        } else {
            if (health < 5) {
                offerHealing();
            } else
                System.out.println("♥ Текущий уровень здоровья " + name + ": " + health);
        }

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private void offerHealing() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Воспользоваться исцелением? (да/нет)");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("да") || answer.equals("нет")) {
            healing();
        } else {
            System.out.println("Введите допустимый ответ.");
            offerHealing();
        }
    }

    private void healing() {
        float healthPoint = (maxHealth / 100) * 30;
        healthPoint = Math.round(healthPoint);
        health += healthPoint;
        healingAttempt --;
        System.out.println("\n" + name + " исцелился на " + (int)healthPoint + " единиц!" +
                        "\n♥ Текущий уровень здоровья " + name + ": " + health +
                        "\nКоличество попыток исцеления: " + healingAttempt);
    }

    @Override
    public int rollDice() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        return super.rollDice();
    }
}
