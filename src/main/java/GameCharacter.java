import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

abstract class GameCharacter implements Serializable {

    private final String name; // Instansvariabel för namn
    public int health; // Instansvariabel för hälsa
    public Weapon weapon;
    public double finesse;
    private final ArrayList<Weapon> inventory = new ArrayList<>();
    public ArrayList<Weapon> getInventory() {return inventory;}

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

        inventory.add(new Weapon("Axe",25));
        inventory.add(new Weapon("Shwovel",15));
        inventory.add(new Weapon("Magic Sword",100));
    }

    public int getHealth() {
        return health;
    }

    public String getName(){
        return name;
    }

    public void addWeapon(Weapon weapon){inventory.add(weapon);}


}
