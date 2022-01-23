import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let the Battle Begin");

        System.out.println("What is your name");
        String playerName = scanner.nextLine();

        GameCharacter player = new Player(playerName, 100);
        GameCharacter npc = new Npc("Ghoul", 80);

    while(true) {
        System.out.println("A scary white walker is attacking you");
        while (true) {
            System.out.println("%n Do you want to attack (enter) or skidaddle (q)");
            String userInput = scanner.nextLine();
            if (userInput.equals("q")) {
                System.out.println("You descided to run away, do");
                break;
            }
            // Spelaren attackerar npcn och kollar om npcn dör
            System.out.printf("%s hits white walker for %d HP. White walker has %d Hp left. %n",player.getName(), player.attack(npc), npc.getHealth());
            if (npc.getHealth() <= 0) {
                System.out.println("White walker is dead.");
                System.out.printf("Player wins with %d HP left ", player.getHealth());
                break;
            }
            // npcn attackerar spelaren och kollar om spelaren dör
            System.out.printf("White walker hits %s for %d HP. %s has %d HP left %n", player.getName(),npc.attack(player),player.getName(), player.getHealth());
            if (player.getHealth() <= 0) {
                System.out.printf("Player is dead, White walker wins with %d HP left", npc.getHealth());
                System.out.println("Game over, thanks for playing");
                break;
            }
        }
        // kollar om playern är död och avslutar spelet isåfall
        if(player.getHealth() <= 0){
            break;
        }
        System.out.println("Play again (Enter) or exit (q)");
        String userInput = scanner.nextLine();
        if(userInput.equals("q")){
            break;
        }
        // om man väljer att spela igen, sätter vi npcns health tillbaka till 80;
        npc.setHealth(80);
    }
    }

}
