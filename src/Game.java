import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        Player player = new Player("Alisa", 6, 2, 15, 3, 5);
        ArrayList<Monster> monsters = new ArrayList<>(3);
        monsters.add(new Monster("Scary Beast", 15, 4, 120, 50, 90));
        monsters.add(new Monster("Ghost", 2, 2, 6, 1, 3));

        System.out.println("Приключения " + player.getName() + " в ужасном подземелье только начинаются =>");

        for (Monster monster : monsters) {
            System.out.println(player.getName() + " встретила противника " + monster.getName().toUpperCase());
            while (!player.isDead() && !monster.isDead()) {
                System.out.println(player.getName() + " атакует!");
                player.attackCreature(monster);
                System.out.println(monster.getName() + " атакует!");
                monster.attackCreature(player);
            }
            if (player.isDead()) {
                System.out.println("Вы сгинули в темноте подземелья...");
                break;
            }
            if (monster.isDead())
                System.out.println(player.getName() + " уничтожила " + monster.getName() + "!");
        }

        if (!player.isDead())
            System.out.println("Вы зачистили подземелье от монстров!");
    }
}