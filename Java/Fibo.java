import java.util.*;
class Fibo
{
	  public static void main(String[] args)
	  { 
	  Scanner s=new Scanner(System.in);
	  System.out.print("Enter a number:");
	  int n=s.nextInt();
	  int sum=0,a=0,b=1,i;
	  for(i=0;i<n;i++)
	  {
	    System.out.println(sum+" ");
	    sum=a+b;
	    a=b;
	    b=sum;
	  }
	  }
}
	  
