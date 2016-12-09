public class Mage extends Character {

    public Mage(String setName){
	name = setName;
	HP = 100;
	strength = (int)((Math.random() * 45) + 5);
	defense = 10;
	attack = 4;
    }//end Mage()

    public void specialize() {
	attack = 5;
	defense = 5;
    }

    public void normalize() {
	attack = 4;
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
	
}//end class Mage
