public class Rogue extends Character {

     //default constructor
    public Rogue(String setName) {
	name = setName;
	HP = 100;
	strength = (int)((Math.random() * 45) + 10);
	defense = 10;
	attack = 2;
    }//end Rogue()
    
    public void specialize() {
	attack = 3;
	defense = 5;
    }

    public void normalize() {
	attack = 2;
	defense = 10;
    }

    public String about() {
	String retStr = "";
	retStr += "HP: " + HP + "\n";
	retStr += "Strength: " + strength + "\n";
	retStr += "Defense: " + defense + "\n";
	retStr += "Attack: " + attack;
	return retStr;
    }
	
}//end class Rogue
