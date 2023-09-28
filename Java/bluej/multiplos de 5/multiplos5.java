
/**
 * Write a description of class multiplos5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class multiplos5
{
    // instance variables - replace the example below with your own
    private int x=0;
    
    private boolean seguir = true;
    private int num=0;
    private int suma=0;
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void multiplosde5(int y)
    {
        while(y>5 && seguir){
         y=y-5;
         System.out.println(y);
        
        } 
        
    }
     public void sumanumeros1a10()
    {
        while(suma<=10 )
        {
            suma=x+num;
            System.out.println("la suma es"+ x + "+" + num + "=" + suma);
            num++;
             
            if(suma == 10 && x!=10)
            {
                suma=0;
                num=1;
                x++;
            
            }
          
        }
         
    }
    /**
    * Sum the numbers from a to b, inclusive.
    */
    public int sum(int a, int b)
    {
         int sum = 0;
         int number = a;
         while(number <= b) 
        {
         sum = sum + number;
         number = number + 1;
        }
     return sum;
    }
}
