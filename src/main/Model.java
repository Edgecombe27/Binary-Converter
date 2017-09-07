package main;

/*
 * Model
 * 
 * Created October 10 2015
 * 
 *  by Spencer Edgecombe
 */

public class Model {
	
	public Model() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Converts any 32 bit integer value of base ten to a base of 1-62 (Recursively).
	 * 
	 * @param num in base ten
	 * @param base to convert num to
	 * @return the number in the desired base
	 */
	
	public String calculate(int num, int base){
		
		if(num < 1)
			return "";
		else if(num%base < 10){
			return calculate(num/base,base) + (num%base);
		}
		else if(num % base <= 46){
			char c = (char)(num%base+55); 
			return "" + calculate(num/base, base) + c;
		}else{
			char c = (char)(num%base+87); 
			return "" + calculate(num/base, base) + c;
		}
		
	}

}
