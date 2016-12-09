//test

public class SuperMonster extends Character {

    //default constructor
    public SuperMonster() {
	HP = 250;
	strength = (int) ((Math.random() * 50 + 50));
	defense = 100;
	attack = 3;
    }//end SuperMonster()

    public void specialize() {}

    public void normalize() {}

    public String about() {
	String retStr = "";
	retStr += "HP: " + HP + "\n";
	retStr += "Strength: " + strength + "\n";
	retStr += "Defense: " + defense + "\n";
	retStr += "Attack: " + attack;
	return retStr;
    }
}//end class SuperMonster
