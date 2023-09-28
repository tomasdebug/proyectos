using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MiProyecto
{
    internal class Ejercicios
    {
        public static void Ejercicio1()
        {
            /*1.Crea un programa que enseñe hola mundo de forma vertical(1 caracter por linea)*/
            String str = "hola Mundo"; // cadena (2B/c)


            for (int i = 0; i < str.Length; i++)
            {

                Console.WriteLine(str[i]);

            }



        }
        /*otra forma
        StringBuilder texto=new StringBuilder("Hola Mundo");// se usa para gestionar memoria de forma mas eficiente
        ya que el texto se puede sobreescribir en un stringbuilder
        */
        public static void Ejercicio2()
        {
            for (int i = 2; i <= 5; i++)
            {

                for (int j = 1; j <= 5; j++)
                {

                    Console.WriteLine(" " + i + "x" + j + "=" + i * j + "\t\t" + i + "x" + (j + 5) + "=" + (i) * (j + 5));
                    //Console.WriteLine($"{i} x {j} = {(i * j)}\t{i} x {(j + 5)} = {(i * (j + 5))}");
                }

                Console.WriteLine("*----------------------*");
                //Console.Write(\n)== Console.WriteLine("");
            }
            Console.ReadLine();
        }
        public static void Ejercicio3()
        {
            /*
            3.Crea un programa en C# que recoja un número, le haga el cuadrado (exponencial 2) y se lo reste a 612,47
            string entrada = Console.ReadLine();
             */
            Console.Write("Escribe un número: ");
            StringBuilder entrada = new StringBuilder(Console.ReadLine());
            double num = Convert.ToDouble(entrada.ToString());
            num = Math.Pow(num, 2);
            // num *= num;
            const double x = 612.47;
            Console.WriteLine(x - num);
        }
        public static void Ejercicio4()
        {

            /*
          4.Crea un programa en C# que recoja 3 números y que haga las siguientes operaciones:
          - Sumar el primero con el segundo y multiplicar el resultado por el tercero.
          - Comprobar si el resultado es múltiplo de 5.
          - Comprobar si el segundo número es impar.
            Usar Console.ReadLine()
          */
            Console.WriteLine("Dame 3 numeros");

            int num1 = Convert.ToInt32(Console.ReadLine());
            int num2 = Convert.ToInt32(Console.ReadLine());
            int num3 = Convert.ToInt32(Console.ReadLine());
       //manera1 menu:
            Console.WriteLine("Los numeros elegidos son: " + num1 + "     " + num2  +"     "+num3);


            
            int resultado = (num1 + num2) * num3;
            Boolean ejecucion = true;

            while (ejecucion == true)
            {
                Console.WriteLine("");
                Console.WriteLine("Menú:");
                Console.WriteLine("Sumar el primero con el segundo y multiplicar el resultado por el tercero(1).");
                Console.WriteLine("Comprobar si el resultado es múltiplo de 5(2).");
                Console.WriteLine("Comprobar si el segundo número es impar(3).5");
                Console.WriteLine("Salir(4)");

                string str = Console.ReadLine();

              


                switch (str)
                {


                    case "1":
                        {

                            Console.WriteLine(resultado);
                            Console.WriteLine("");
                            //goto menu;
                            break;
                           
                            

                        }
                    case "2":
                        {
                            if (resultado % 5 == 0)
                            {
                                Console.WriteLine("el resultado es multiplo de 5");
                                Console.WriteLine("");
                                break;
                                //goto menu;
                            }
                            else
                            {
                                Console.WriteLine("el resultado no es multiplo de 5");
                                Console.WriteLine("");
                                //goto menu;
                                break;
                            }
                            

                        }
                    case "3":
                        if (num2 % 2 == 0)
                        {
                            Console.WriteLine("el numero 2 es impar");
                            Console.WriteLine("");
                            //  goto menu;
                            break;
                        }
                        else {
                            Console.WriteLine("el numero 2 no es impar");
                            Console.WriteLine("");
                            // goto menu;
                            break;
                        }
                     
                    case "4":
                        {
                            ejecucion = false;
                            break;

                        }
                    default: {
                            Console.WriteLine("Pon un numero");
                            Console.WriteLine("");
                            break;
                        }
                        

                }
            }
        }
    }
}
