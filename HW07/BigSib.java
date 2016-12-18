// Alison Lee
// APCS pd5
// HW07 -- On BigSib Individuality and the Elimination of Radio Fuzz
// 2016-09-22

public class BigSib {
    public String helloMsg ;
    public void setHelloMsg( String Greeting ) {
	// doesn't exactly return anything, but instead sets helloMsg to
	    // so void can be used (I think)
	// Greeting: something like "Word up" etc.
	// in Greet.java, used in lines like: richard.setHelloMsg( "Word up" ) ;
		helloMsg = Greeting + " " ;
    }
    public String greet( String name ) {
		helloMsg += name ;
	// used in lines like: greeting = richard.greet( "freshman" ) ;
	// helloMsg is now the Greeting + name
		return helloMsg ;
    }
}
