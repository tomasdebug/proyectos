using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sandbox_clase
{
    internal class referencia
    {
        /*
        static void Main(string[] args)
        {

            const char c = 'a';

            // tipos numéricos integrales
            byte b; // 0 - 255 (2^8)
            short s; // -32768 - 32767 (2^16)
            int i; // -2 000 000 000 - 2 000 000 000 (2^32)
            long l; // -9 000 000 000 000 000 000 - 9 000 000 000 000 000 000 (2^64)

            sbyte byet; // -128 - 127
            ushort us; // 0 - 65535
            uint ui; //  Igual que int pero sólo positivos
            ulong ul; // Igual que long pero sólo positivos (18 000 000 000 000 000 000) 

            // tipos numéricos de punto flotante
            float f; // 6-9 cifras (4 bytes)
            double d; // 15-17 cifras (8 bytes)
            decimal dec; // 28-29 cifras (16 bytes)

            StringBuilder str = new StringBuilder(); // cadena (2B/c)
            str.Append("hola");
            str.ToString();

            /* Array */
            //Formas para declararlo:
            /*
            int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

            int[] nums2 = new int[] { 1, 2, 3 };

            int[] nums3 = new int[5] { 1, 2, 3, 4, 5 };
            /*go to*/
            /*
            if (nums.Length == 11)
            {

                goto irAqui;//si llego aquí y salta el goto se saltará el codigo donde se declara la y

            }


            int y = 15;
            y++;
            Console.WriteLine(y);


        irAqui:
            {

                int x = 12;
                Console.WriteLine(x);

                Console.ReadLine();

            }


        }
            */
    }
}
