public class Player extends GameCharacter{

    public Player(String name, int health) {
        super(name, health);
        weapon = new Weapon("Sword", 20);
        finesse = 0.8;
    }
    public static int heal(int health){
        int minHeal = health;
        health = (int)((Math.random() * (100 - minHeal)) + minHeal);
        return health;
    }
}
