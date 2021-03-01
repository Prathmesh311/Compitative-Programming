import java.util.*;
import java.lang.*;
import java.io.*;

class Main     // The name of class will depend on compiler. 
{
    
    public static void main (String[] args) throws java.lang.Exception
    {
        
        Scanner sc = new Scanner(System.in);
        
        Voter[] v = new Voter[4];
        
        for(int i=0;i<4;i++)
        {
            Voter x = new Voter();
            
            x.voterid = sc.nextInt();
            sc.nextLine();
            x.votername = sc.nextLine();
            x.voterage = sc.nextInt();
            x.isvotecasted = sc.nextBoolean();
            sc.nextLine();
            x.constituency = sc.nextLine();
          
            v[i] = x;
        }
        
        String cons = sc.nextLine();
        
        int ans = findtotalvotescastedbyconst(v , cons);
        
        if(ans==0)
        {
            System.out.println("No Votes Casted");
        }
        
        else
        {
            System.out.println(ans);
        }
        
        Voter[] ans2 = searchvoterbyage(v);
        
        if(ans2==null)
        {
            System.out.println("No such Voters");
        }
        
        else
        {
            int i=0;
            
            while(ans2[i]!=null)
            {
                System.out.println(ans2[i].voterid);
                i++;
            }
        }
           
    }
    
    
    public static int findtotalvotescastedbyconst(Voter[] v , String cons)
    {
        int sum = 0;
        
        for(int i=0;i<v.length;i++)
        {
            if((v[i].constituency).equals(cons))
            {
                if(v[i].isvotecasted) sum++;
            }
        }
        
        return sum;
    }
    
    public static Voter[] searchvoterbyage(Voter[] v)
    {
        int count=0;
        
        Voter[] help = new Voter[4];
        
        int j=0;
        
        for(int i=0;i<v.length;i++)
        {
            if(v[i].voterage<30)
            {
                help[j]=v[i];
                j++;
            }
        }
        
        
        for(int i=0;i<j;i++)
        {
            for(int k=i+1;k<j;k++)
            {
                if(help[k].voterid<help[i].voterid)
                {
                    Voter temp = help[k];
                    help[k] = help[i];
                    help[i] = temp;
                }
            }
        }
        
        if(j==0) return null;
        
        return help;
        
    }
}

class Voter    
{
    public int voterid , voterage;
    public String votername , constituency;
    public boolean isvotecasted;
    
    Voter()
    {
        voterid = 0;
        voterage = 0;
        votername = "";
        constituency = "";
        isvotecasted = false;
    }
       
}
