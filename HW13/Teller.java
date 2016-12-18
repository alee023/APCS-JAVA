//Team Take 2 (Thomas Lin, Alison Lee, Kristin Lin)
//APCS1 pd 05
//HW#13 -- Outsourcing
//2016-10-05

public class Teller {

    public static void main(String[] args) {

	//Test 1 with all vars returning true and valid. 
	BankAccount person = new BankAccount("Joe", "idkman", 1234, 123456789, 1000f);
	person.print();
	System.out.println(person.authenticate (123456789, "idkman"));
	//Skips a line to separate the output of authenticate and person.print();
	System.out.println(" ");
	person.withdraw(800f);
	person.print();
	person.deposit(500f);
	person.print();
	
	//Test 2 with invalid pinToSet and accountNumToSet
	BankAccount person1 = new BankAccount ("Bob", "idkman", 12345, 1234567890, 1000f);
	person1.print();
	System.out.println(person1.authenticate(123456789, "idkman"));
	//Skips a line to separate the output of authenticate and person.print();
	System.out.println(" ");
	person1.withdraw(800f);
	person1.print();
	person1.deposit(500f);
	person1.print();

	//Test 3 with amountToWithdraw being greater than balance.
	BankAccount person2 = new BankAccount("Paul Johnson III", "idkman", 1234, 123456789, 1000f);
	person2.print();
	System.out.println(person2.authenticate(123456789,"idkman"));
	//Skips a line to separate the output of authenticate and person.print();
	System.out.println(" ");
	person2.withdraw(8000f);
	person2.print();
	person2.deposit(500f);
	person2.print();
    }
}
