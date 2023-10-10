public class Monster extends Creature {
    private String imageAscii;

    public Monster(String name,
                   int attack,
                   int protection,
                   int health,
                   int minDamage,
                   int maxDamage,
                   String imageAscii) {
        super(name, attack, protection, health, minDamage, maxDamage);
        this.imageAscii = imageAscii;
    }

    public Monster(String name,
                   int attack,
                   int protection,
                   int health,
                   int minDamage,
                   int maxDamage) {
        super(name, attack, protection, health, minDamage, maxDamage);
    }

    public String getImageAscii() {
        return imageAscii;
    }

    public void setImageAscii(String imageAscii) {
        this.imageAscii = imageAscii;
    }
}
