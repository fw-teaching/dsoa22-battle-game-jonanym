public class Npc extends GameCharacter{
    int randomDamage = (int)((Math.random() * (20 - 10)) + 10);
    public Npc(String name, int health) {
        super(name, health);
        weapon = new Weapon("Sword", randomDamage);
        finesse = 0.5;
    }
}
