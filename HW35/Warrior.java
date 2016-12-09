public class Warrior extends Character {

     //default constructor
    public Warrior(String setName) {
	name = setName;
	HP = 150;
	strength = (int)((Math.random() * 45) + 20);
	defense = 20;
	attack = 1;
    }//end Warrior()

    public void specialize() {
	attack = 2;
	defense = 15;
    }

    public void normalize() {
	attack = 1;
	defense = 20;
    }

    public String about() {
	String retStr = "";
	retStr += "HP: " + HP + "\n";
	retStr += "Strength: " + strength + "\n";
	retStr += "Defense: " + defense + "\n";
	retStr += "Attack: " + attack;
	return retStr;
    }
  
}//end class Warrior
