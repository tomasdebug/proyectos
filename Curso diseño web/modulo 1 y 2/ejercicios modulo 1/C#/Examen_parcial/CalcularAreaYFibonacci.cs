using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Examen_parcial
{
    internal class CalcularAreaYFibonacci
    {



        public static void calcularAreaYFibonacci()
        {
            Boolean ejecucion = true;
            double areaCirculo;

            while (ejecucion == true)
            {
                Console.WriteLine("");
                Console.WriteLine("Menú:");
                Console.WriteLine("1.Calcular el area de una circunferencia de radio x.");
                Console.WriteLine("2.Calcular la sucesion de fibonacci hasta x numero(solo valores menores de 100).");
                Console.WriteLine("3.Salir");
                Console.WriteLine("");
                string str = Console.ReadLine();
                Console.WriteLine("");


                switch (str)
                {


                    case "1":
                        {
                            try
                            {
                                Console.WriteLine("¿Que radio? ");
                                float x = float.Parse(Console.ReadLine());
                                areaCirculo = Math.PI * Math.Pow(x, 2);
                                Console.WriteLine("El resultado es :" + areaCirculo);

                              
                            }
                            catch(Exception) {
                                Console.WriteLine("Pon un número");
                            }
                            break;
                        }
                    case "2":
                        {
                            try {
                                long x = 0, y = 1, cont = 0, suma = 0;//i es el numero actual y j el numero siguiente y la suma es el que lo continua
                                Console.WriteLine("Hasta que numero lo quieres ");
                                long limite = Convert.ToInt32(Console.ReadLine());
                                Console.WriteLine("");

                                if (limite < 100)
                                {
                                    while (cont != limite)
                                    {

                                        Console.Write(x + " ");
                                        suma = x + y;// este es el tercer numero
                                        x = y;//damos al numero actual el numero siguiente 
                                              //primero asignamos el numero siguiente al actual y luego la suma pasa a ser el numero siguiente(de esa forma lovoy haciendo)
                                        y = suma;
                                        cont++;//contador que cuenta cuantos números llevamos 


                                    }
                                }
                            
                            
                            else {
                                Console.WriteLine("Te has pasado");
                            }
                            }
                            catch (Exception) {
                                Console.WriteLine("Pon un número");

                            }
                            break;
                            
                          


                        }

                    case "3":
                        {
                            ejecucion = false;
                            break;

                        }

                    default:
                        {
                            Console.WriteLine("Pon un numero");
                            Console.WriteLine("");
                            break;
                        }


                }
            }
        }











    }
}
