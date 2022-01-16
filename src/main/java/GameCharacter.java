public class GameCharacter {

    private static String name; // Instansvariabel för namn
    public static int health; // Instansvariabel för hälsa

    void takeDamage(int damage){
         health = this.health - damage;
    }
    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;

    }

}
