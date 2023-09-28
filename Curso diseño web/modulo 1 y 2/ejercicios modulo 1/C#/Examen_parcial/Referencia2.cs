using System;
using System.Linq;
using System.Security.Cryptography;

namespace EjerciciosCS
{
    class EjercicioObjetos2
    {
        /*
        2. En un taller mecánico tienen una serie de vehículos de diferentes clases y características:
        Tipo        Marca       Matrícula   Cilindrada(CC)  Potencia(CV)    Plazas
        Moto        Honda	    2852-IAS	650		                        2
        Moto        Yamaha	    9285-VMQ	250		                        2
        Turismo     Citroën     MU-6248-FC		            70	            5
        Turismo     Peugeot	    2395-QWT		            90	            5
        Turismo     Hyundai     M-2623-YD		            120	            2
        Autobús     Mercedes	9292-THJ		            300	            24

        Además, tienen una lista de clientes de esos vehículos, datos de pago y entrega:
        Matrícula   Nombre              Problema            Coste   Pagado  Entregado
        2852-IAS    Jorge Sánchez       Ruedas	            150	    Sí      Sí
        9285-VMQ    Antonio García      Transmisión	        400	    Sí      Sí
        MU-6248-FC  Pedro Martínez      Caja de cambios	    550	    No      No
        2395-QWT    María Nieves        Filtros	            100	    Sí      No
        M-2623-YD   Juana Fernández     Bomba refrigerante	350	    No      No
        9292-THJ    Ana Jiménez         Filtros	            150	    Sí      No

        Se pide crear en C#:
        -	Crear los objetos necesarios con la información de las tablas.
        -	Crear los métodos para realizar las consultas de los datos.
        -	Crear los controles de excepciones que puedan ocurrir (sobre todo en la introducción de datos).

        El programa debe realizar las siguientes operaciones:
        -	Mostrar un listado de todas las matrículas.
        -	Mostrar un listado de todos los vehículos(matrícula) de 2 plazas y sus CC o CV.
        -	Mostrar un listado de los vehículos (matrícula y marca) pendientes de entrega y si están o no pagados.
        -	Pedir input de matrícula y mostrar el dueño y el problema.
        o Entrada: 2395-QWT
        o Salida: María Nieves, Filtros
        -	Pedir input de coste y mostrar las matrículas que estén por encima de ese valor.
        o Entrada: 200
        o Salida: 9285-VMQ, MU-6248-FC, M-2623-YD

        */

    }
    abstract class Vehiculo
    {
        internal string Marca { get; set; }
        internal string Matricula { get; set; }
        internal int Plazas { get; set; }
        internal abstract string Potencia { get; set; }
        public Vehiculo(string marca, string matricula, int plazas)
        {
            this.Marca = marca;
            this.Matricula = matricula;
            this.Plazas = plazas;
        }
    }
    class Moto : Vehiculo
    {
        public int Cilindrada { get; set; }
        public Moto(string marca, string matricula, int cilindrada, int plazas) : base(marca, matricula, plazas)
        {
            this.Cilindrada = cilindrada;
        }
        internal override string Potencia
        {
            get { return this.Cilindrada + " CC"; }
            set {; }
        }
    }
    class Coche : Vehiculo
    {
        public int CV { get; set; }
        public Coche(string marca, string matricula, int cv, int plazas) : base(marca, matricula, plazas)
        {
            this.CV = cv;
        }
        internal override string Potencia
        {
            get { return this.CV + " CV"; }
            set {; }
        }
    }
    class Cliente
    {
        internal Vehiculo Vehiculo { get; set; }
        internal string Nombre { get; set; }
        internal string Problema { get; set; }
        internal int Coste { get; set; }
        internal bool Pagado { get; set; }
        internal bool Entregado { get; set; }
        internal Cliente(Vehiculo vehiculo, string nombre, string problema, int coste, bool pagado, bool entregado)
        {
            Vehiculo = vehiculo;
            Nombre = nombre;
            Problema = problema;
            Coste = coste;
            Pagado = pagado;
            Entregado = entregado;
        }
    }
    class Ejercicio2
    {
        internal static Cliente[] Datos()
        {
            Moto honda = new Moto("Honda", "2852-IAS", 650, 2);
            Moto yamaha = new Moto("Yamaha", "9285-VMQ", 250, 2);
            Coche citroen = new Coche("Citroën", "MU-6248-FC", 70, 5);
            Coche peugeot = new Coche("Peugeot", "2395-QWT", 90, 5);
            Coche hyundai = new Coche("Hyundai", "M-2623-YD", 120, 2);
            Coche mercedes = new Coche("Mercedes", "9292-THJ", 300, 24);

            Cliente[] clientes =
            {
                new Cliente(honda, "Jorge Sánchez", "Ruedas", 150, true, true),
                new Cliente(yamaha, "Antonio García", "Transmisión", 400, true, true),
                new Cliente(citroen, "Pedro Martínez", "Caja de cambios", 550, false, false),
                new Cliente(peugeot, "María Nieves", "Filtros", 100, true, false),
                new Cliente(hyundai, "Juana Fernández", "Bomba refrigerante", 350, false, false),
                new Cliente(mercedes, "Ana Jiménez", "Filtros", 150, true, false),
            };

            return clientes;
        }
        static void MostrarDatos(Cliente[] datos)
        {
            // Mostrar todas las matrículas
            // Método 1 - Iteracion directa de los objetos
            /*
            for (int i = 0; i < datos.Length; i++)
            {
                Console.WriteLine(datos[i].Vehiculo.Matricula);
            }
            
            foreach (Cliente cliente in datos)
            {
                Console.WriteLine(cliente.Vehiculo.Matricula);
            }
            */
            // Método 2 - Consulta LINQ
            var listamatriculas = from cliente in datos
                                  select cliente.Vehiculo.Matricula;
            Console.WriteLine("Listado de matrículas:");
            foreach (string matricula in listamatriculas)
            {
                Console.WriteLine(matricula);
            }

            // Mostrar vehículos de 2 plazas y CC/CV
            var listaV2plazas = from cliente in datos
                                where cliente.Vehiculo.Plazas == 2
                                select cliente.Vehiculo.Matricula + " -> " + cliente.Vehiculo.Potencia;
            Console.WriteLine();
            Console.WriteLine("Listado de Vehículos de 2 plazas con su potencia:");
            foreach (string vehiculo in listaV2plazas)
            {
                Console.WriteLine(vehiculo);
            }
            Console.WriteLine();

            // Vehículos pendientes de entrega y pago
            var pendientesentrega = from cliente in datos
                                    where cliente.Entregado == false
                                    //select cliente.Vehiculo.Matricula + " " + cliente.Vehiculo.Marca + " -> " + cliente.Pagado
                                    select cliente;
            Console.WriteLine("Vehículos pagados y no pagados pendientes de entrega:");
            foreach (Cliente cliente in pendientesentrega)
            {
                if (cliente.Pagado == false)
                {
                    Console.WriteLine(cliente.Vehiculo.Matricula + " " + cliente.Vehiculo.Marca + " -> Sin pagar");
                }
                else
                {
                    Console.WriteLine(cliente.Vehiculo.Matricula + " " + cliente.Vehiculo.Marca + " -> Pagado");
                }
            }
            Console.WriteLine();
        }
        // Input Matrícula y búsqueda
        internal static string RecogerMatricula(string entrada)
        {
        PedirAgain:
            try
            {
                Console.Write($"Introduce {entrada}: ");
                string salida = Console.ReadLine();
                if (salida.Length == 0) { throw new Exception(); }
                return salida;
            }
            catch (Exception)
            {
                Console.WriteLine("Valor no válido");
                goto PedirAgain;
            }

        }
        static void BuscarMatricula(string matricula, Cliente[] cliente)
        {
            var buscarmatricula = from clientes in cliente
                                  where clientes.Vehiculo.Matricula == matricula
                                  select $"{clientes.Nombre}, {clientes.Problema}".ToString();

            if (buscarmatricula.Any())
            {
                Console.WriteLine($"Dueño y problema correspondiente a {matricula}:");
                foreach (string salida in buscarmatricula)
                {
                    Console.WriteLine(salida);
                }
            }
            else
            {
                Console.WriteLine("No se ha encontrado la matrícula.");
            }
        }
        // Input coste y búsqueda
        internal static int RecogerNum(string entrada)
        {
        PedirAgain:
            try
            {
                Console.Write($"Introduce {entrada}: ");
                string linea = Console.ReadLine();
                if (linea.Length == 0) { throw new Exception(); }
                int salida = Convert.ToInt32(linea);
                return salida;
            }
            catch (Exception)
            {
                Console.WriteLine("Valor no válido");
                goto PedirAgain;
            }
        }
        internal static void CosteMinimo(int costemin, Cliente[] cliente)
        {
            var buscarcoste = from clientes in cliente
                              where clientes.Coste >= costemin
                              select clientes.Vehiculo.Matricula;
            if (buscarcoste.Any())
            {
                Console.WriteLine($"Vehículos con coste de reparación superior a {costemin}:");
                foreach (string salida in buscarcoste)
                {
                    Console.WriteLine(salida);
                }
            }
            else
            {
                Console.WriteLine("No se ha encontrado ningún coste superior al indicado.");
            }
        }

        public static void E2()
        {
            Cliente[] clientes = Datos();
            //MostrarDatos(clientes);
            string matricula = RecogerMatricula("una matrícula");
            BuscarMatricula(matricula, clientes);
            int costemin = RecogerNum("un coste mínimo");
            CosteMinimo(costemin, clientes);

        }
    }

}