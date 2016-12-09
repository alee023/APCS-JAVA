public class Dwarf extends Character {

     //default constructor
    public Dwarf(String setName) {
	name = setName;
	HP = 110;
	strength = (int)((Math.random() * 45) + 15);
	defense = 15;
	attack = 2;
    }//end Dwarf()

    public void specialize() {
	attack = 3;
	defense = 10;
    }

    public void normalize() {
	attack = 2;
	defense = 15;
    }

    public String about() {
	String retStr = "";
	retStr += "HP: " + HP + "\n";
	retStr += "Strength: " + strength + "\n";
	retStr += "Defense: " + defense + "\n";
	retStr += "Attack: " + attack;
	return retStr;
    }

  
}//end class Dwarf
