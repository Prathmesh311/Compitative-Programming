import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            int index = -1;
            ArrayList<Character> arr = new ArrayList<Character>();
            for (int i = 0; i < input.length(); i++)
            {
                if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[')
                {
                    arr.add(input.charAt(i));
                    continue;
                }

                if (arr.size() == 0)
                {
                    //System.out.println("false");
                    index = i;
                    break;
                }else
                {
                    char cheack = arr.get(arr.size()-1);
                
                    if (input.charAt(i) == ')' && cheack == '(' || 
                            input.charAt(i) == '}' && cheack == '{' ||
                            input.charAt(i) == ']' && cheack == '[')
                    {
                        arr.remove((arr.size()-1));

                    }
                
                
                }
                
            //System.out.println(arr);
            }
            if (index != -1)
            {
                System.out.println("false");
            }
            else{

            
                if(arr.size() == 0)
                {
                    System.out.println("true");
                }
                else
                {
                    System.out.println("false");
                }
            }
		}
		
	}
}



