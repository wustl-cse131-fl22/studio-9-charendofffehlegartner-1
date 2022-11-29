package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
// always use = new HashMap 
		Map<String, Integer> NametoHeight = new HashMap<>();
		NametoHeight.put("Izzy", 69);
		NametoHeight.put("Chandler", 68);
		NametoHeight.put("Rachel", 61);
		NametoHeight.put("Mia", 68);
		System.out.println("Enter a name");
		String name = in.next();
		while(!name.equals("quit"))
		{
		
			if(NametoHeight.get(name)==null)
			{
				System.out.println("Name not found");
				System.out.println("Enter a name");
				String newname = in.next();
				name = newname;			
				}
			else {
			System.out.println(NametoHeight.get(name));
			System.out.println("Enter a name");
			String newname = in.next();
			name = newname;
			}
		
		}
		
	}

	
}
