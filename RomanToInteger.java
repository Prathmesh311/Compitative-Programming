import java.util.*;

class Solution {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String romanNum = sc.nextLine();
        int number = romanToInt(romanNum);
        System.out.println(number);
    }
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        System.out.println(map);
        
        ArrayList<Character> priority = new ArrayList<Character>();
        priority.add('I');
        priority.add('V');
        priority.add('X');
        priority.add('L');
        priority.add('C');
        priority.add('D');
        priority.add('M');
        System.out.println(priority);
        
        int num = 0;
        int check = 0;
       
        for(int i=0; i <= s.length()-2; i++)
        {

            if(priority.indexOf(s.charAt(i)) < priority.indexOf(s.charAt(i+1)))
            {
                num += (map.get(s.charAt(i+1)) - map.get(s.charAt(i)));
                System.out.println(num);
                if((i) == s.length()-2)
                {
                    check = 1;
                }
                i=i+1;

            }
            else{
                num = num + (map.get(s.charAt(i)));
                System.out.println(num);
            }
        }
        if(check == 0)
        {
            num = num + (map.get(s.charAt(s.length()-1)));
        }
        
        
        return num;
    }
}
