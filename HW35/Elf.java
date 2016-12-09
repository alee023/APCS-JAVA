public class Elf extends Character {

     //default constructor
    public Elf(String setName) {
	name = setName;
	HP = 120;
	strength = (int)((Math.random() * 45) + 10);
	defense = 20;
	attack = 3;
    }//end Elf()

    public void specialize() {
	attack = 4;
	defense = 15;
    }

    public void normalize() {
	attack = 3;
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
  
}//end class Elf
