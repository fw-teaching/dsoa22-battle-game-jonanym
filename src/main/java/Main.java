import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let the Battle Begin");

        System.out.println("What is your name");
        String playerName = scanner.nextLine();

        GameCharacter player = new Player(playerName, 100);
        GameCharacter npc = Npc.spawnNpc();


    while(true) {

        System.out.println("A scary " + npc.getName() + " is attacking you");
        while (true) {
            System.out.println("------ Inventory ------");
            for(int i = 0; i < player.getInventory().size(); i++){
                System.out.printf("%d - %s \n",i, player.getInventory().get(i).getName());
            }
            System.out.println("Chose weapon for attack (enter) or skidaddle (q)");
            String userInput = scanner.nextLine();

            if (userInput.equals("q")) {
                System.out.println("You descided to run away, do");
                break;
            }
            player.weapon = player.getInventory().get(Integer.parseInt(userInput));
            // Spelaren attackerar npcn och kollar om npcn dör
            System.out.printf(" -> %s hits %s with a %s for %d HP. %s has %d Hp left. %n",player.getName(), npc.getName(),player.weapon.getName(), player.attack(npc),npc.getName(), npc.getHealth());
            if (npc.getHealth() <= 0) {
                System.out.printf("%s is dead.",npc.getName());
                System.out.printf("\n%s wins with %d HP left ", player.getName(),player.getHealth());
                break;
            }
            // npcn attackerar spelaren och kollar om spelaren dör
            System.out.printf("%s hits %s with a %s for %d HP. %s has %d HP left \n", npc.getName(), player.getName(), npc.weapon.getName(),npc.attack(player),player.getName(), player.getHealth());
            if (player.getHealth() <= 0) {
                System.out.printf("%s is dead, %s wins with %d HP left", player.getName(),npc.getName(),npc.getHealth());
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
        // om man väljer att spela igen, spawna en ny npc
        npc = Npc.spawnNpc();
    }
    }

}
