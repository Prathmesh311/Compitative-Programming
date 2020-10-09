import java.util.*;

public class main {
    public static List<String> mixColors(List<List<Integer>> colors, List<List<Integer>> queries) {
        // Write your code here

        List<String> ans = new ArrayList<String>();

        for(int i=0; i < queries.size(); i++)
        {
            int a = queries.get(i).get(0);
            int b = queries.get(i).get(1);
            int c = queries.get(i).get(2);
            int cA = 0, cB = 0, cC = 0;

            for(int j=0; j < colors.size(); j++)
            {
                if(colors.get(j).get(0) == a)
                {
                    cA = 1;
                }
                if(colors.get(j).get(1) == b)
                {
                    cB = 1;
                }
                if(colors.get(j).get(2) == c)
                {
                    cC = 1;
                }
            }
            if(cA == 1 && cB == 1 && cC == 1)
            {
                ans.add("YES");
            }
            else
            {
                ans.add("NO");
            }
        }

        return ans;
    }
}
