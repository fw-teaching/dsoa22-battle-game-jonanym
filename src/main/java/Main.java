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
            System.out.println("Do you want to attack (enter) or skidaddle (q)");
            String userInput = scanner.nextLine();
            if (userInput.equals("q")) {
                System.out.println("You descided to run away, do");
                break;
            }
            // Spelaren attackerar npcn och kollar om npcn dör
            System.out.println(player.getName() + " hits white walker for " + player.attack(npc) + " HP. White walker has " + npc.getHealth() + " Hp left.");
            if (npc.getHealth() <= 0) {
                System.out.println("White walker is dead.");
                System.out.println("Player wins with " + player.getHealth() + "HP left");
                break;
            }
            // npcn attackerar spelaren och kollar om spelaren dör
            System.out.println("White walker hits " +player.getName() + " for " + npc.attack(player) + " HP. Player has " + player.getHealth() + " HP left.");
            if (player.getHealth() <= 0) {
                System.out.println("Player is dead, White walker wins with " + npc.getHealth() + " HP left");
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
