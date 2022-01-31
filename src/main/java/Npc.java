import java.util.Random;

public class Npc extends GameCharacter{
    int randomDamage = (int)((Math.random() * (20 - 10)) + 10);
    Random random = new Random();
    String[] weaponNames = {"Sword", "Axe","Knife","Showel","HulkFists"};
    int randomIndex = random.nextInt(weaponNames.length);
    String randomWeapon = weaponNames[randomIndex];

    public Npc(String name, int health) {
        super(name, health);
        weapon = new Weapon(randomWeapon, randomDamage);
        finesse = 0.5;
    }

    public static GameCharacter spawnNpc(){
        Random random = new Random();
        String[] names = {"White walker", "Skeleton", "Zombie", "Goblin"};
        int randomIndex = random.nextInt(names.length);
        String name = names[randomIndex];
        return new Npc(name,80);
    }
}
