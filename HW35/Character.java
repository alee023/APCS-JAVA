public abstract class Character {
    //declare instance variables
    protected int HP ;
    protected int strength ;
    protected int defense ;
    protected double attack ;
    protected String name ;

    //returns boolean indicating living or dead
    public boolean isAlive() {
	return( HP > 0 ) ;
    }//end isAlive()

    //returns value of defense attribute
    public int getDefense() {
	return defense ;
    }//end getDefense()

    //returns value of name attribute
    public String getName() {
	return name ;
    }//end getName()

    //takes an int parameter, decreases life attribute by that amount
    public void lowerHP( int damage ) {
	HP -= damage ;
    }//end lowerHP()

    /*takes a Monster as a parameter
      calculates damage using this formula: damage = (strength * attack rating) - monster defense
      damage should be an integer value*/
    public int attack(Character attacked ) {
	int Defense = attacked.getDefense() ;	
		
	int damage = (int)( strength * attack - Defense );

	//if damage is negative, make it equal to zero
	if (damage < 0) {
	    damage = 0;}
	attacked.lowerHP(damage);
        return damage;
    }//end attack()

    //prepares Character to perform a special attack
    public abstract void specialize();
    
    /*prepares the Character to perform a normal attack
      resets defense attribute
      resets attack attribute*/
    public abstract void normalize();

    public abstract String about();
    
} //end class Character
