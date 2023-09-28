using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Examen_parcial
{
    internal class Calculadora
    {

        //sumas
        public static float suma(float num1, float num2)
        {

            float resultado = num1 + num2;
            return resultado;


        }
    
        //restas
        public static float resta(float num1, float num2)
        {

            float resultado = num1 - num2;
            return resultado;


        }
      
        //multiplicaciones
        public static float multiplicacion(float num1, float num2)
        {

            float resultado = num1 * num2;
            return resultado;


        }
        //divisiones
        public static float division(float num1, float num2)
        {

            float resultado = num1 / num2;
            return resultado;


        }
     
       


        public static void calculadora()
        {

       
            float resultado = 0;
            int i = 0;//contador para ver el numero de ejecuciones del programa





            Boolean ejecucion = true;

            while (ejecucion == true)
            {
                if (i == 0)
                {
                    Console.WriteLine("");
                    Console.WriteLine("Menú:");
                    Console.WriteLine("1.Suma.");
                    Console.WriteLine("2.Resta.");
                    Console.WriteLine("3.Multiplicacion");
                    Console.WriteLine("4.Division");
                    Console.WriteLine("5.Potencia de 2");//falta seleccionar que numero de los dos quiero 
                    Console.WriteLine("6.Raíz cuadrada");//falta seleccionar que numero de los dos quiero 
                    Console.WriteLine("7.Borrar Resultado");
                    Console.WriteLine("8.Salir");
                }
              
              
                else {
                    Console.WriteLine("¿Que mas quieres hacer?");
                    Console.WriteLine("");
                    Console.WriteLine("Menú:");
                    Console.WriteLine("1.Suma.");
                    Console.WriteLine("2.Resta.");
                    Console.WriteLine("3.Multiplicacion");
                    Console.WriteLine("4.Division");
                    Console.WriteLine("5.Potencia de 2");
                    Console.WriteLine("6.Raíz cuadrada");
                    Console.WriteLine("7.Borrar Resultado");
                    Console.WriteLine("8.Salir");

                }
                string str = Console.ReadLine();
                Console.WriteLine("");



                switch (str)
                {


                    case "1":
                        {
                            

                            if (resultado == 0)
                            {

                                Console.WriteLine("Dame 2 numeros");
                                try
                                {
                                    float num1 = float.Parse(Console.ReadLine());
                                    float num2 = float.Parse(Console.ReadLine());
                                    Console.WriteLine("");
                                    //manera1 menu:
                                    Console.WriteLine("Los numeros elegidos son: " + num1 + "     " + num2 + ".");
                                    //tengo que hacer una asignacion ya que el parametro se me queda en local 
                                    resultado = suma(num1, num2);

                                    Console.WriteLine("resultado:" + resultado);
                                    Console.WriteLine("");
                                }
                                catch (Exception) {
                                    Console.WriteLine("Pon un numero");
                                    Console.WriteLine("");

                                }
                                
                               

                            }
                            else {
                                try { 
                                Console.WriteLine("Dame otro número(se lo sumaré a tu resultado anterior)");
                                float num = float.Parse(Console.ReadLine());
                                Console.WriteLine("");
                                Console.WriteLine("Los numeros elegidos son: " + resultado + "     " + num + ".");
                                resultado += num;
                                Console.WriteLine("resultado: " + resultado);
                                    Console.WriteLine("");
                                }
                                catch (Exception)
                                {
                                    Console.WriteLine("Pon un numero");
                                    Console.WriteLine("");

                                }
                            }
      
                          
                            i++;
                            break;
                        }
                 
                case "2":
                    {


                        if (resultado == 0)
                        {
                                try
                                {
                                    Console.WriteLine("Dame 2 numeros");

                                    float num1 = float.Parse(Console.ReadLine());
                                    float num2 = float.Parse(Console.ReadLine());
                                    Console.WriteLine("");
                                    //manera1 menu:
                                    Console.WriteLine("Los numeros elegidos son: " + num1 + "     " + num2 + ".");
                                    Console.WriteLine("");
                                    //tengo que hacer una asignacion ya que el parametro se me queda en local 
                                    resultado = resta(num1, num2);

                                    Console.WriteLine("resultado:" + resultado);
                                    Console.WriteLine("");
                                }
                                catch (Exception) {
                                    Console.WriteLine("Pon un numero");
                                    Console.WriteLine("");
                                }


                        }
                        else {
                                try
                                {
                                    Console.WriteLine("Dame otro número(se lo restaré a tu resultado anterior)");
                                    float num = float.Parse(Console.ReadLine());
                                    Console.WriteLine("Los numeros elegidos son: " + resultado + "     " + num + ".");
                                    Console.WriteLine("");
                                    resultado -= num;
                                    Console.WriteLine("resultado: " + resultado);
                                    Console.WriteLine("");
                                }
                                catch(Exception) {

                                    Console.WriteLine("Pon un numero");
                                    Console.WriteLine("");
                                }
                        }

                      
                        i++;
                        break;
                    }
                        
                    case "3":
                        {


                            if (resultado == 0)
                            {
                                try
                                {
                                    Console.WriteLine("Dame 2 numeros");

                                    float num1 = float.Parse(Console.ReadLine());
                                    float num2 = float.Parse(Console.ReadLine());
                                    Console.WriteLine("");

                                    //manera1 menu:
                                    Console.WriteLine("Los numeros elegidos son: " + num1 + "     " + num2 + ".");
                                    //tengo que hacer una asignacion ya que el parametro se me queda en local 
                                    resultado = multiplicacion(num1, num2);
                                    Console.WriteLine("");

                                    Console.WriteLine("resultado:" + resultado);
                                    Console.WriteLine("");
                                }
                                catch(Exception)
                                {
                                    Console.WriteLine("Pon un numero");
                                    Console.WriteLine("");
                                }

                            }
                            else
                            {
                                try
                                {
                                    Console.WriteLine("Dame otro número(se lo multiplicaré a tu resultado anterior)");
                                    float num = float.Parse(Console.ReadLine());
                                    Console.WriteLine("");
                                    Console.WriteLine("Los numeros elegidos son: " + resultado + "     " + num + ".");
                                    resultado *= num;
                                    Console.WriteLine("");
                                    Console.WriteLine("resultado: " + resultado);
                                    Console.WriteLine("");
                                }
                                catch(Exception) {
                                    Console.WriteLine("Pon un numero");
                                    Console.WriteLine("");

                                }
                            }

                            
                            i++;
                            break;
                        }
                    case "4":
                        {


                            if (resultado == 0)
                            {
                                try
                                {
                                    Console.WriteLine("Dame 2 numeros");

                                    float num1 = float.Parse(Console.ReadLine());
                                    float num2 = float.Parse(Console.ReadLine());
                                    Console.WriteLine("");
                                    //manera1 menu:
                                    Console.WriteLine("Los numeros elegidos son: " + num1 + "     " + num2 + ".");
                                    Console.WriteLine("");
                                    //tengo que hacer una asignacion ya que el parametro se me queda en local 
                                    resultado = division(num1, num2);

                                    Console.WriteLine("resultado:" + resultado);
                                    Console.WriteLine("");
                                }
                                catch(Exception)
                                {
                                    Console.WriteLine("Pon un numero");
                                    Console.WriteLine("");
                                }
                            
                            }
                            else
                            {
                                try
                                {
                                    Console.WriteLine("Dame otro número(se lo dividiré a tu resultado anterior)");
                                    float num = float.Parse(Console.ReadLine());
                                    Console.WriteLine("Los numeros elegidos son: " + resultado + "     " + num + ".");
                                    resultado /= num;
                                    Console.WriteLine("");
                                    Console.WriteLine("resultado: " + resultado);
                                    Console.WriteLine("");
                                }
                                catch(Exception) {
                                    Console.WriteLine("Pon un numero");
                                    Console.WriteLine("");
                                }
                            }

                            //goto menu;
                            i++;
                            break;
                        }
                        
                    case "5":
                        if (resultado == 0) {
                            try
                            {
                                Console.WriteLine("Dame 1 numero");

                                float num1 = float.Parse(Console.ReadLine());
                                Console.WriteLine("");
                                //manera1 menu:
                                Console.WriteLine("El numero elegido es: " + num1 );
                                Console.WriteLine("");

                                resultado = num1;
                                resultado = (float)Math.Pow(resultado, 2);
                                Console.WriteLine("resultado: " + resultado);
                                Console.WriteLine("");
                            }
                            catch (Exception){
                                Console.WriteLine("");
                                Console.WriteLine("Pon un numero");
                                Console.WriteLine("");

                            }

                        }
                        else
                        {
                            try
                            {
                                resultado = (float)Math.Pow(resultado,2);
                                Console.WriteLine("resultado: " + resultado);
                                Console.WriteLine("");
                            }
                            catch (Exception)
                            {
                                Console.WriteLine("");
                                Console.WriteLine("Pon un numero");
                                Console.WriteLine("");
                            }
                        }

                        break;
                    case "6":
                        if (resultado == 0)
                        {
                            try
                            {
                                Console.WriteLine("Dame 1 numero");

                                float num1 = float.Parse(Console.ReadLine());
                                Console.WriteLine("");

                                //manera1 menu:
                                Console.WriteLine("El numero elegido es: " + num1);

                                resultado = num1;
                                resultado = (float)Math.Sqrt(resultado);
                                Console.WriteLine("resultado: " + resultado);
                                Console.WriteLine("");



                            }
                            catch(Exception) {
                                Console.WriteLine("");
                                Console.WriteLine("Pon un numero");
                                Console.WriteLine("");
                            }
                          

                        }
                        else
                        {
                            try { 
                            resultado = (float)Math.Sqrt(resultado);
                            Console.WriteLine("resultado: " + resultado);
                            Console.WriteLine("");
                            }
                            catch (Exception) {
                                Console.WriteLine("");
                                Console.WriteLine("Pon un numero");
                                Console.WriteLine("");
                            }
                        }

                        break;
                    case "7":

                        Console.Clear();
                        resultado = 0;
                        break;





                    case "8":
                        {
                            ejecucion = false;
                            break;

                        }
                    default:
                        {
                            Console.WriteLine("");  
                            Console.WriteLine("Pon un numero");
                            Console.WriteLine("");
                            break;
                        }


                }
            }
        }
    }
}
