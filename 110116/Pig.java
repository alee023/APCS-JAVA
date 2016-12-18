//Take2 (
//APCS1 pd05
//HW#25 -- Otnay Ybay Ethay Airhay Onway Ymay Inneechay Inchay Inchay
//2016-10-31

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           9
     ,--.-'-,--.
     \  /-~-\  /
    / )' a a `( \
   ( (  ,---.  ) )
    \ `(_o_o_)' /
     \   `-'   /
      | |---| |     
      [_]   [_]
      PROTIP: Make this class compilable first, 
      then develop and test one method at a time.
      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
import java.util.Scanner;

public class Pig 
{
    //Q: How does this initialization make your life easier?
    /* Because a linear search for vowels will occur often and there will be no
       change in the vowels, it is easier to create a final String containing
       all the vowels instead of typing them out each time */

    private static final String VOWELS = "aeiou";
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") → true  
      hasA("cat", "p") → false

      description: 
      if the letter exists in the string, indexOf will produce a number greater
      than 0. if not, then it'll produce -1.
      =====================================*/
    public static boolean hasA( String w, String letter ) {
	return w.indexOf(letter) >= 0;
    }//end hasA()


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1

      description: 
      If the letter is in the set of VOWELS, indexOf will return a number 0 or
      or greater. Otherwise, not. 
      =====================================*/
    public static boolean isAVowel( String letter ) {
	return VOWELS.indexOf(letter) >= 0;
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") → 3

      description: 
      uses modular design by returning the length of a string of 
      all the vowels in w
      =====================================*/
    public static int countVowels( String w ) {
	return allVowels(w).length();
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") → true
      hasAVowel("zzz") → false

      description: 
      if the countVowels method counted more than 0 vowels, the string must have
      a vowel. Otherwise, if it is 0, then there is no vowel.
      =====================================*/
    public static boolean hasAVowel( String w ) {
	return countVowels(w) > 0;
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") → "eaa"

      description: 
      Creates a variable output, then runs through the entire string with 
      a for LOOP and adds on the letter to the output var if it is a vowel
      using modular design with beginsWithVowel. 
      =====================================*/
    public static String allVowels( String w ) {
	String output = "";
	for (int x = 0; x < w.length(); x += 1) {
	    /* accounts for y, because when y is not the first letter, typically
	       it is a vowel. */
	    if (w.substring(x,x+1).equals("y") && x != 0) {
		output += w.substring (x, x+1);
	    }
	    if (isAVowel(w.substring(x,x+1))) {
		output += w.substring (x, x+1);
	    }
	}
	return output;	    	       
    }


    /*=====================================
      String firstVowel(String) -- returns first vowel in a String
      pre:  w != null
      post: firstVowel("") --> ""
      firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"

      description: 
      Runs trhough the entire String input with a for LOOP, asking 
      each time if the letter is a vowel. if it is, then it returns
      that letter. if it hasn't returned anything by the end of the 
      loop, the string must not contain any vowels. the return is "".
      =====================================*/
    public static String firstVowel( String w ) {
	String ans = "";
	if ( hasAVowel(w)) //if no vowels,less work bc skips this step
	    ans = allVowels(w).substring(0,1);

	return ans;
    }


    /*=====================================
      boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
      pre:  w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false

      description: 
      runs trhough the entire VOWEL string with a for LOOP, and if it
      matches the first letter of the input, then it returns true. 
      if it hasn't returned anything by the end of the loop, the first letter
      must not be a vowel, so it returns false.
      =====================================*/
    public static boolean beginsWithVowel( String w ) {
	//y is typically not a vowel at the beginning of a word
	return isAVowel(w.substring(0,1));
    }


    /*=====================================
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"

      description:
      creates a variable output which is initialized as the input String
      
      three different cases: 
      if the first character in w is not a lowercase letter, then it turns the 
      boolean value of isCaps to true, making us aware that the original was 
      capitalized. 
      if the last character in w is not a letter, then it turns the boolean value 
      ifPunc to true, making us aware that the original had punctuation. output is
      then set as string w without the last character, the punctation mark.
      if there was no punctuation mark, then it just sets the output as w.

      it then goes through the normal procedure, adding way if beginning letter is a
      vowel, and if otherwise, adding the string of consonants in front of the word
      behind it and then an "ay"at the very end. Here, the consonants are lowercased, 
      in case there was an uppercase at the beginning of the word.

      Then at the very end, it asks if isCaps and isPunc is true, and if they are, then 
      uppercases the first character of output and adds the last character of string w 
      on to it.
      =====================================*/
    public static String engToPig( String w ) {
		String output = "";
		boolean isCaps = false;
		boolean isPunc = false;

		String first = w.substring(0,1);
		if (!(first.equals(first.toLowerCase()))) {
			isCaps = true;
		}

		String last = w.substring(w.length()-1);
		if (ALPHABET.indexOf(last) == -1) {
			isPunc = true;
			output = w.substring (0, w.length()-1);
		} else {
			output = w;
		}

		if (beginsWithVowel(w)){
			output += "way";
		} else {
			int x = w.indexOf(firstVowel(w));
			output = output.substring(x) + output.substring(0,x).toLowerCase() + "ay";
		}

		if (isCaps ) {
			output = output.substring(0,1).toUpperCase() + output.substring(1);
		}
		if (isPunc) {
			output += last;
		}
		return output;
	}
	
	public static String pigToEng( String w ) {
		String retStr = "" ;
		
		if ( ( w.substring( w.length() - 3 )).equals( "way" ) ) {
			if ( Math.random() < 0.5 ) {
				retStr = w.substring( 0 , w.length() - 3 ) ; 
			}
			else {
				retStr = "w" + w.substring( 0 , w.length() - 3 ) ;
			}
		}
		
		else {
			retStr = w.substring( w.length() - 3 , w.length() - 2 ) + w.substring( 0 , w.length() - 3 ) ;
		}
		
		return retStr ;
	}

	public static void main( String[] args ) {
	//TEST CALLS HERE
	/*==============================================================
	to verify my methods work: 

	System.out.println(beginsWithVowel ("dog"));
	System.out.println(beginsWithVowel ("angel"));
	System.out.println(beginsWithVowel ("uber"));
	System.out.println(firstVowel ("uber"));
	System.out.println(firstVowel ("dog"));
	System.out.println(firstVowel ("chocolate"));
	System.out.println(firstVowel ("sdfisdfw"));
	System.out.println(allVowels ("sagebrush"));
	System.out.println(allVowels ("aeiou"));
	System.out.println(allVowels ("zddww"));
	System.out.println(hasAVowel ("super"));
	System.out.println(hasAVowel ("Sttn"));
	System.out.println(countVowels ("ittybitty"));
	System.out.println(countVowels ("funyunsuuo"));
	System.out.println(countVowels ("sfdssrrt"));
	System.out.println(isAVowel ("a"));
	System.out.println(isAVowel ("b"));
	System.out.println(hasA ("chocolate", "o"));
	System.out.println(hasA ("chocolate", "u"));
	System.out.println(hasAVowel ("sky"));
	System.out.println(allVowels ("baby"));
	System.out.println(allVowels ("yellow"));

	System.out.println(engToPig ("chocolate"));
	System.out.println(engToPig ("trrranslate"));
	System.out.println(engToPig ("apples"));
	System.out.println(engToPig ("yellow"));
	System.out.println(engToPig ("tryst"));
	System.out.println(engToPig ("Doggone."));
	============================================*/

	System.out.println( pigToEng( "appleway" )) ;
	System.out.println( pigToEng( "abybay" )) ;
	System.out.println( pigToEng( "ysttray" )) ;
	
	/*
	Scanner sc = new Scanner(System.in);
	while( sc.hasNext() ) {	
	    System.out.println( engToPig(sc.next()) );
	}
	*/	
    }//end main()

}//end class Pig


