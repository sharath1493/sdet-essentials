package java8;

public class StringProblem {

	public static void main(String[] args) {


		/*
		 * Given a string, print below combinations of characters in the string.
		Input: abcd
		Output: a, ab, abc, abcd, b, bc, bcd, c, cd, d
		 */
		
		String s="abcd";
		
		for(int i=0; i <s.length(); i++)
		{
			for(int j=i+1; j <=s.length(); j++)
			{
				System.out.println(s.substring(i,j));
			}
		}



	}

}
