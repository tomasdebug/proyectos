using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO.Ports;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Examen_final
{
    internal class Ejercicio2
    {
     
         
          class baraja
        {

           

         

            List<carta> listaCartas;
             static int numcartas = 48;
            //siempre hay el mismo numero de cartas (para no perder el timepo haciendo un metodo
                                //que distinga que tipo de palo es haré lo siguiente :
                                //12 primeras:oros ,12siguientes:espadas...Teniendo
                                //1-12:oros
                                //13-24:espadas
                                //25-36:copas
                                //37:48:bastos)
            public baraja()//me crea la baraja con 48 cartas
            {
                numcartas = 48;
                listaCartas = new List<carta>();
                for (int i = 0; i < numcartas; i++)
                {
                    carta carta = new carta(i);
                    listaCartas.Add(carta);

                }


            }



            //metodos para la baraja 

            public static void RobarCartas(List<carta> baraja) {
                Console.WriteLine("¿cuantas cartas quieres robar?");
                int cartRobo = Convert.ToInt32(Console.ReadLine());
                int CartasRestantes = numcartas - cartRobo;
                for (int i = numcartas; i < CartasRestantes; i--) {

                    baraja.RemoveAt(i);
                    numcartas--;
                
                }
                //te da el numero de la carta que te queda y el palo suyo
                Console.WriteLine("La carta numero: "+ baraja[CartasRestantes].numcarta%12 +" de"+ baraja[CartasRestantes].t);
                

            }
            public static void RobarUnaCarta(List<carta> baraja)
            {
                Console.WriteLine("¿Que carta quieres robar?");
                int cartRobo = Convert.ToInt32(Console.ReadLine());
            
              
                Console.WriteLine("Has robado la carta numero: " + baraja[cartRobo].numcarta % 12 + " de" + baraja[cartRobo].t);


            }
            public static void listarBaraja(List<carta> baraja)
            {
                for (int i = 0; i < baraja.Count; i++)
                {
                    Console.WriteLine("Carta: " + baraja[i].numcarta+"es de: " + baraja[i].t);
                }


            }
            public static void ReiniciarBaraja(List<carta> baraja)
            {
                numcartas = 48;
                baraja = new List<carta>();
                for (int i = 0; i < numcartas; i++)
                {
                    carta carta = new carta(i);
                    baraja.Add(carta);

                }


            }

        }
        class carta : baraja
        {
           public enum Tipo
            {
                Oros,
                Espadas,
                Copas,
                Bastos
            }
            public Tipo t;
                public int numcarta { get; set; }
            public carta(int numcarta) {
                if (numcarta > 0 && numcarta <= 12) {

                    Tipo t = Tipo.Oros;
             
                   
                }
                if (numcarta > 12 && numcarta <= 24)
                {

                    Tipo t = Tipo.Espadas;

                }
                if (numcarta > 24 && numcarta <= 36)
                {

                    Tipo t = Tipo.Copas;


                }
                if (numcarta > 36 && numcarta <= 48)
                {

                    Tipo t = Tipo.Bastos;

                }

            }
            //añadir metodos


        }
        public static void ejercicio2() {
               
            baraja baraja = new baraja();//creo mi baraja de cartas 


             

            }

        
    }


            

        


    }

