using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace EjerciciosCS
{
    internal class EjercicioObjetos1
    {
        /*
        1. Crea 3 clases de objetos: Persona, Soldado, Capitan.
        Soldado y Capitan deben heredar las propiedades de Persona.
        Persona {int edad, string nombre}
        Soldado {string especialidad}
        Capitan {int subordinados, string division}
        Crear un capitán y 3 soldados.
        Crear una serie de métodos que realicen lo siguiente:
        - Recoger datos de todo el personal.
        - Recoger una entrada en la que se indique una persona y se muestre su edad y, si es un capitán su división y las personas a su cargo, si es un soldado su especialidad.
        */

    }

    class Persona
    {
        public int edad { get; set; }
        public string nombre { get; set; }
    }

    class Soldado : Persona
    {
        public string especialidad { get; set; }
    }

    class Capitan : Persona
    {
        public string division { get; set; }
        public int subordinados { get; set; }

        /*public string Division(string id) => division = id;
        public int Subordinados(int id) => subordinados = id;*/
    }

    public class EJ1
    {
        public static string PedirNombre(Type entrada)
        {
        PedirAgain:
            Console.Write($"Introduce el nombre del {entrada.Name}: ");
            string salida = Console.ReadLine();
            if (salida == null || salida.Length == 0)
            {
                Console.WriteLine("Entrada inválida. Volver a introducir.");
                goto PedirAgain;
            }
            return salida;
        }
        public static int PedirEdad(string nombre)
        {
        PedirAgain:
            Console.Write($"Introduce la edad de {nombre}: ");
            string entrada = Console.ReadLine();
            try
            {
                if (entrada == null || entrada.Length == 0) { throw new Exception(); }
                int salida = Convert.ToInt32(entrada);
                return salida;
            }
            catch (Exception)
            {
                Console.WriteLine("Introduce un valor válido.");
                goto PedirAgain;
            }
        }
        public static string PedirEspecialidad(string nombre)
        {
        PedirAgain:
            Console.Write($"Introduce la división o especialidad de {nombre}: ");
            string salida = Console.ReadLine();
            if (salida == null || salida.Length == 0)
            {
                Console.WriteLine("Entrada inválida. Volver a introducir.");
                goto PedirAgain;
            }
            return salida;
        }
        public static void CrearInstancias()
        {
            Capitan[] capitanes =
            {
                new Capitan(),
            };
            Soldado[] soldados =
            {
                new Soldado(),
                new Soldado(),
                new Soldado(),
            };

            foreach (Capitan capi in capitanes)
            {
                capi.nombre = PedirNombre(capi.GetType());// Método para pedir nombre
                capi.edad = PedirEdad(capi.nombre);// Método para pedir edad
                capi.division = PedirEspecialidad(capi.nombre); // Método para pedir división/especialidad
                int subs = 0;
                foreach (Soldado soldado in soldados)
                {
                    soldado.nombre = PedirNombre(soldado.GetType());// Método para pedir nombre
                    soldado.edad = PedirEdad(soldado.nombre);// Método para pedir edad
                    soldado.especialidad = PedirEspecialidad(soldado.nombre); ; // Método para pedir división/especialidad
                    subs++;
                }
                capi.subordinados = subs;
            }

        PedirPersona:
            Console.Write("Escribe el nombre de una persona: ");
            string entrada = Console.ReadLine();
            if (entrada == null || entrada.Length == 0)
            {
                Console.WriteLine("Entrada inválida. Volver a introducir.");
                goto PedirPersona;
            }
            var consultacapi = from Capitan persona in capitanes
                               where persona.nombre == entrada
                               select persona;
            var consultasoldados = from Soldado persona in soldados
                                   where persona.nombre == entrada
                                   select persona;
            if (consultacapi.Count() > 0)
            {
                foreach (var persona in consultacapi)
                {
                    Console.WriteLine($"Edad de {persona.nombre}: {persona.edad}");
                    Console.WriteLine($"División de {persona.nombre}: {persona.division}");
                    Console.WriteLine($"Subordinados de {persona.nombre}: {persona.subordinados}");
                }
            }
            else if (consultasoldados.Count() > 0)
            {
                foreach (var persona in consultasoldados)
                {
                    Console.WriteLine($"Edad de {persona.nombre}: {persona.edad}");
                    Console.WriteLine($"Especialidad de {persona.nombre}: {persona.especialidad}");
                }
            }
            else
            {
                Console.WriteLine("No se ha encontrado ninguna persona con ese nombre.");
                goto PedirPersona;
            }
        }
    }



    /*
    class ObjLista
    {
        public string algo { get; set; }
        public ObjLista(string algo)
        {
            this.algo = algo;
        }
    }
    class Ejemplolista
    {
        public static void generarLista()
        {
            List<ObjLista> list = new List<ObjLista>();
            for (int i = 0; i < 10; i++)
            {
                list.Add(new ObjLista($"algo{i + 1}"));
            }
            foreach (ObjLista objeto in list)
            {
                Console.WriteLine(objeto.algo);
            }
        }

        public static void generarLista2()
        {
            ObjLista[] list = new ObjLista[10];
            for (int i = 0; i < 10; i++)
            {
                list[i] = new ObjLista($"algo{i + 1}");
            }
            foreach (ObjLista objeto in list)
            {
                Console.WriteLine(objeto.algo);
            }
        }
    }
    */

}