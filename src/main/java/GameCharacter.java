import java.util.concurrent.ThreadLocalRandom;

abstract class GameCharacter {
    ThreadLocalRandom tlr = ThreadLocalRandom.current();

    private String name; // Instansvariabel för namn
    public int health; // Instansvariabel för hälsa
    public Weapon weapon;
    public double finesse;

    void takeDamage(int damage){
         health = health - damage;
         if(health <= 0){
             health = 0;
         }
    }

    public int attack(GameCharacter defender){
        int min_damage = (int) (weapon.damage * finesse);
        int max_damage = weapon.damage;
        int randDamage = ThreadLocalRandom.current().nextInt(min_damage,max_damage+1);
        defender.takeDamage(randDamage);
        return randDamage;
    }

    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public String getName(){
        return name;
    }
}
