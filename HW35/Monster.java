public class Monster extends Character{

    //default constructor
    public Monster() {
	HP = 150;
	strength = (int)((Math.random() * 45) + 20);
	defense = 20;
	attack = 1;
    }//end Monster()

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
    
}//end class Monster
