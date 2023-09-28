using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO.Ports;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Examen_final
{
    internal class Ejercicio1
    {
        public static void ejercicio1()
        {
            Boolean ejecucion = true;
            Boolean datoincorrecto = true;
            int parametros;
          
                while (ejecucion == true)
            {
                try
                {


                    Console.WriteLine("");
                    Console.WriteLine("Seleccioné el numero de parametros(1,2,3)o salir 4");
                    parametros = Convert.ToInt32(Console.ReadLine());

                    if (parametros == 1)
                    {
                        while (datoincorrecto == true)
                        {
                            try
                            {
                                Console.WriteLine("Seleccioné string");
                                String par = Console.ReadLine();
                                Programa(par);
                                datoincorrecto = false;
                            }
                            catch
                            {
                                Console.WriteLine("Seleccioné string");

                            }
                        }

                    }

                    if (parametros == 2)
                    {
                        while (datoincorrecto == true)
                        {
                            try
                            {
                                Console.WriteLine("Seleccioné string");
                                String strpar = Console.ReadLine();
                                Console.WriteLine("Seleccioné un numero");
                                int intpar = Convert.ToInt32(Console.ReadLine());

                                Console.WriteLine("");
                                Programa(strpar, intpar);
                                datoincorrecto = false;

                            }
                            catch
                            {
                                Console.WriteLine("Error intente de nuevo");
                            }
                        }
                    }
                    // Console.WriteLine(parametros); Parametros es una variable local
                    if (parametros == 3)
                    {
                        while (datoincorrecto == true)
                        {

                            try
                            {
                                Console.WriteLine("Seleccioné string");
                                String strpar = Console.ReadLine();
                                Console.WriteLine("Seleccioné un numero");
                                int intpar = Convert.ToInt32(Console.ReadLine());
                                Console.WriteLine("Seleccioné un numero o caracter");
                                string straux = Console.ReadLine();
                                int i;
                                // bool isNumber = int.TryParse(stringNumber, out int numericValue);
                                bool esNum = int.TryParse(straux, out i);
                                if (i != 0)
                                { //significa que el parseamiento a funcionado por ello es un numero.Y se trabaja con este mismo 
                                  //esto va a ir dentro de datos (parstring ,parint ,i)
                                    Programa(strpar, intpar, i);
                                    datoincorrecto = false;

                                }
                                else
                                {
                                    //si no es un numero entonces es un char ,por ello me aseguro de que se quede como char con una conversion
                                    char charpar = Convert.ToChar(straux);
                                    Programa(strpar, intpar, charpar);
                                    datoincorrecto = false;

                                }

                            }
                            catch
                            {

                                Console.WriteLine("Error,por favor escriba los datos pedidos");

                            }
                            Console.WriteLine("");
                        }
                    }
                    if (parametros == 4)
                        {
                            Console.WriteLine("saliendo");
                            ejecucion = false;
                        }
                    
                }
                catch
                {
                    Console.WriteLine("Se tiene que poner un numero del 1 al 4");
                }
            }
            

        }
        private static void Programa(String parString)
        {
            //almacena cada caracter en un array
            char[] charArr = parString.ToCharArray();
            //StringBuilder que usare para formar mi cadena con los valores unicode del array 
            StringBuilder cadena = new StringBuilder();
            //for para que me imprima cada unicode 
            for (int i = 0; i < charArr.Length; i++)
            {
                char c = charArr[i];
                cadena.Append((int)c + " ");
                
            }
            Console.WriteLine(parString + "-->" + cadena);

            //si metes un numero tmb cuenta como cadena de texto en unicode te va a dar igual
        }
        private static void Programa(String parString,int repeticiones)
        {
        
            for (int i = 0; i < repeticiones; i++)
            {
                Console.Write(parString);
            }
       
        }
        
        private static void Programa(String parString, int caracterinicio, int caracterfinal)
        {
            try
            {
                //almacena cada caracter en un array
                char[] charArr = parString.ToCharArray();
                //StringBuilder que usare para formar mi cadena con los valores unicode del array 
                StringBuilder cadena = new StringBuilder();
                //for para que me imprima cada unicode 
                for (int z = caracterinicio; z < caracterfinal; z++)
                {

                    char c = charArr[z];
                    cadena.Append(c);


                }
                Console.WriteLine(cadena);
            }
            catch {

                Console.WriteLine("Porfavor no sobrepase con su rango el numero de letras de la palabra");
            
            }
        }
        private static void Programa(String parString, int repeticiones, char chpar)
        {

            try
            {
                //almacena cada caracter en un array
                char[] charArr = parString.ToCharArray();
             
                //uso un for para recorrer el array de chars y si alguno contiene el char del parametro lo elimimino
                for (int z = 0; z < charArr.Length; z++)
                {
                    //sino he encontrado el caracter no elimino ninguno.
                    bool encontrado = false;
                    if (charArr[z].Equals(chpar)) {
                        encontrado = true;
                    
                    }
                    if (encontrado)
                    {
                        //usaré el metodo except que he encontrado en la guia de microsoft
                        char c = charArr[z];
                        charArr = charArr.Except(new char[] { c }).ToArray();
                       
                    }
                                 
                }
                //por ultimo escribimos la palabra las veces que me digan

                for (int j = 0; j < repeticiones; j++) {

                    Console.WriteLine("");
               
                    for (int z = 0; z < charArr.Length; z++)
                    {
                   
                   
                      
                            char a = charArr[z];
                            Console.Write(a);

                    

                    }
                }


            }
            catch
            {

                Console.WriteLine("Porfavor no sobrepase con su rango el numero de letras de la palabra");

            }

        }


    }
}
