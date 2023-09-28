
/**
 * Write a description of class MultiplosDe5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiplosDe5
{
    // instance variables - replace the example below with your own
    private int j;

    public void MultiplosDe5()
    {
        int x=10;
        while(x<95 && x>=10){
            x=x+5;
            System.out.println(x);
        }
      
    }
    public void SumarNum1_10()
    {  int sum = 0;
        int num = 1;
    while(num <= 10) {
     sum += num;
     num++; 
    }
        System.out.println("The sum of the values 1 to 10 is " + sum);
    }
    public int sumar2num(int num1, int num2)
    {
        int num3;
        
        num3=num1+num2;
        return num3;
    }
}
