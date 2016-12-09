public class Demon extends Character {

    public Demon() {
	HP = 200;
	strength = (int) (Math.random() * 50 + 25);
	defense = 25;
	attack = 2;
    }

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

}
