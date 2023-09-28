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
            StringBuilder str = new StringBuilder(); // cadena (2B/c)
            str.Append("hola Mundo");//me devuelve un array con la cadena
            str.ToString();
            for (int i=0;i<str.Length;i++) {
                Console.WriteLine(str[i]);

            }
            Console.ReadLine();
           

        }
        public static void Ejercicio2() {
            /*2.Crea un programa que muestre las tablas de multiplicar del 2 al 5 mostradas de la siguiente forma
               2x1=2 
               2x2=4
               2x3=6...
               */

        }
    }
}
