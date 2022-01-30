import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameCharacter player = (GameCharacter) FileUtils.loadGame("game.save");

        System.out.println("Continue saved Game (enter) or start new game (n)");

        String userInput = scanner.nextLine();
        if(userInput.equals("n")){
            System.out.println("What is your name");
            String playerName = scanner.nextLine();
            player = new Player(playerName, 100);
        }

        System.out.printf("Player %s has %d HP \n\n", player.getName(), player.getHealth());
        GameCharacter npc = Npc.spawnNpc();

    while(true) {
        System.out.println("A scary " + npc.getName() + " is attacking you");
        while (true) {
            System.out.println("\n------ Inventory ------");
            for(int i = 0; i < player.getInventory().size(); i++){
                System.out.printf("%d - %s \n",i, player.getInventory().get(i).getName());
            }
            System.out.println("\nChose weapon for attack (enter) or skidaddle (q)");

            while(true) {
                userInput = scanner.nextLine();
                try {
                    if (userInput.equals("q")) {
                        System.out.println("You decided to run away!");
                        break;
                    }
                    player.weapon = player.getInventory().get(Integer.parseInt(userInput));
                    break;
                } catch (Exception e) {
                    System.out.printf("Choose weapon (0-%d) or skidaddle (q)\n", player.getInventory().size());
                }
            }
            if (userInput.equals("q")) {
                break;
            }

            // Spelaren attackerar npcn och kollar om npcn dör
            System.out.printf("⚔ %s hits %s with a %s for %d HP. \n --> %s has %d Hp left. \n",player.getName(), npc.getName(),player.weapon.getName(), player.attack(npc),npc.getName(), npc.getHealth());
            if (npc.getHealth() <= 0) {
                System.out.printf("%s is dead.",npc.getName());
                System.out.printf("\n%s wins with %d HP left\n ", player.getName(),player.getHealth());
                System.out.printf("\nYour defeated %s dropped their %s (%s)\n",npc.getName(), npc.weapon.getName(), npc.weapon.damage);
                System.out.println("\n ---- Add to (a) inventory or continue (enter) ----");
                userInput = scanner.nextLine();
                if(userInput.equals("a")){
                    player.addWeapon(npc.weapon);
                    System.out.printf("%s added to inventory", npc.weapon.getName());
                }

                break;
            }
            // npcn attackerar spelaren och kollar om spelaren dör
            System.out.printf("\n⚔ %s hits %s with a %s for %d HP. \n --> %s has %d HP left \n", npc.getName(), player.getName(), npc.weapon.getName(),npc.attack(player),player.getName(), player.getHealth());
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
        System.out.println("\nPlay again (Enter) or exit (q)");
        userInput = scanner.nextLine();
            if (userInput.equals("q")) {
                break;
            }

        // om man väljer att spela igen, spawna en ny npc
        npc = Npc.spawnNpc();
    }
        scanner.close();
        FileUtils.saveObject("game.save", player);
    }

}
