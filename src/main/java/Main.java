public class Main {

    public static void main(String[] args) {
        System.out.println("Let the Battle Begin");

        GameCharacter player = new GameCharacter("Human", 100);
        GameCharacter bot = new GameCharacter("Ghoul", 200);

        while(true){

            if(bot.health <= 0 ){
                System.out.println("Ghoul is dead.");
                System.out.println("Player wins!");
                break;
            }

            if(player.health <= 0 ){
                System.out.println("Player is dead is dead.");
                System.out.println("Ghoul wins!");
                break;
            }

            System.out.println("A scary monster is atacking you");
            bot.takeDamage(20);
            System.out.println("Player hits Ghoul for 20 HP. Ghoul has 60 Hp left.");
            player.takeDamage(20);
            System.out.println("Ghoul hits player for 20 HP. Player has 100 HP left.");
            bot.takeDamage(20);
            System.out.println("Player hits Ghoul for 20 HP. Ghoul has 40 Hp left.");
            player.takeDamage(20);
            System.out.println("Ghoul hits player for 20 HP. Player has 80 HP left.");
            bot.takeDamage(20);
            System.out.println("Player hits Ghoul for 20 HP. Ghoul has 20 Hp left.");
            player.takeDamage(20);
            System.out.println("Ghoul hits player for 20 HP. Player has 60 HP left.");


        }

    }

}
