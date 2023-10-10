import java.util.ArrayList;
import java.util.Scanner;

import static constant.ImageAscii.*;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player;
        if (enterClass(scanner).equals("маг")) {
            player = new Player(enterName(scanner), 8, 2, 12, 7, 9);
        } else {
            player = new Player(enterName(scanner), 6, 5, 17, 3, 5);
        }

        ArrayList<Monster> monsters = new ArrayList<>(3);
        monsters.add(new Monster("Dragon", 7, 6, 12, 5, 11, DRAGON));
        monsters.add(new Monster("Spider", 2, 1, 6, 3, 6, SPIDER));
        monsters.add(new Monster("Demon", 5, 4, 9, 4, 8, DEMON));

        System.out.println("\nПриключения " + player.getName() + " в ужасном подземелье только начинаются =>");

        for (Monster monster : monsters) {
            System.out.println("\n" + player.getName() + " встретил противника " +
                    monster.getName().toUpperCase() + monster.getImageAscii());
            while (!player.isDead() && !monster.isDead()) {
                System.out.println("\n➹ " + player.getName() + " атакует!");
                player.attackCreature(monster);
                if (!monster.isDead()) {
                    scanner.nextLine();
                    System.out.println("\n➹ " + monster.getName() + " атакует!");
                    monster.attackCreature(player);
                }
            }
            if (player.isDead()) {
                System.out.println("""
                        Вы сгинули в темноте подземелья...
                               ▄▄▄▄▄▄▄
                             ▄█████████▄
                             ██─▀███▀─██
                             ▀████▀████▀
                               ██▀█▀██
                        """);
                break;
            }
            if (monster.isDead())
                System.out.println("\n" + player.getName() + " спускается глубже в подземелье...");
        }

        if (!player.isDead())
            System.out.println("Вы зачистили подземелье от монстров!");
    }

    public static String enterName(Scanner scanner) {
        System.out.println("\nПриветствую вас, путник! Укажите имя, о котором в скором времени будут слагать легенды:");
        String name = scanner.nextLine();
        if (name.length() > 30) {
            System.out.println("Такое имя не поместится ни на одном манускрипте. Длина имени не должна превышать 30 символов.");
            enterName(scanner);
        }
        return name;
    }

    public static String enterClass(Scanner scanner) {
        System.out.println("К какому классу вы относитесь?" +
                "\n* Маг" + STICK +
                "\n* Рыцарь" + SWORD + "\n");
        String job = scanner.nextLine().toLowerCase();
        if (job.equals("маг") || job.equals("рыцарь")) {
            return job;
        } else {
            System.out.println("Разве есть кто-то помимо магов и рыцарей? Не путайте меня, дорогой путник." +
                    "\nВыберите что-то из предложенных вариантов.");
            enterClass(scanner);
        }
        return "";
    }
}