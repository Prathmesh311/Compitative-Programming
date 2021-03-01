import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TravelAgencies[] A = new TravelAgencies[4];
		
		for(int i=0; i < 4; i++)
		{
		    int regNo = sc.nextInt();
		    String agencyName = sc.nextLine();
		    String packageType = sc.nextLine();
		    int price = sc.nextInt();
		    boolean flightFacility = nextBoolean();
		    A[i] = new TravelAgencies(regNo, agencyName, packageType, price, flightFacility);
		}
		
		int num = sc.nextInt();
		String package = sc.nextLine();
		
		int maxPrice = findAgencyWithHighestpackagePrice(A);
		System.out.println(maxPrice);
		
		TravelAgencies matchedAgency = agencyDetailForGivenIdAndType(A, num, package);
		if(matchedAgency == null)
		{
		    System.out.println("No such agencies");
		}
		else
		{
		    System.out.println(matchedAgency.getagencyName);
		    System.out.println(matchedAgency.getprice);
		}
	}
	
	public static int findAgencyWithHighestpackagePrice(TravelAgencies[] A)
	{
	    int max = 0;
	    for(int i=0; i < A.length; i++)
	    {
	        if(A[i].getprice() > max)
	        {
	            max = A[i].getprice();
	        }
	    }
	    
	    return max;
	}
	
	public static TravelAgencies agencyDetailForGivenIdAndType(TravelAgencies[] A, int num, String package)
	{
	    for(int i=0; i < A.length; i++)
	    {
	        if(A[i].getregNo() == num && A[i].getpackageType() == package && A[i].getflightFacilities() == true)
	        {
	            return A[i];
	        }
	    }
	}
}

class TravelAgencies
{
    int regNo;
    String agencyName;
    String packageType;
    int price;
    boolean flightFacility;
    
    TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility){
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }
    
    void setregNo(int regNo)
    {
        this.regNo = regNo;
    }
    void setagencyName(String agencyName)
    {
        this.agencyName = agencyName;
    }
    void setpackageType(String packageType)
    {
        this.packageType = packageType;
    }
    void setprice(int price)
    {
        this.price = price;
    }
    void setflightFacility(boolean flightFacility)
    {
        this.flightFacility = flightFacility;
    }
    
    int getregNo()
    {
        return this.regNo;
    }
    String getagencyName()
    {
        return this.agencyName;
    }
    String getpackageType()
    {
        return this.packageType;
    }
    int getprice()
    {
        return this.price;
    }
    boolean getflightFacilities()
    {
        return this.flightFacility;
    }
    
}
