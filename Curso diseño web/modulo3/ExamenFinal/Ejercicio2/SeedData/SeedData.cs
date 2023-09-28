using System;
using System.Diagnostics;
using Ejercicio2.Data;
using Ejercicio2.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;

namespace Ejercicio2.SeedData
{
    public class SeedData
    {
        public static void Initialize(IServiceProvider serviceProvider)
        {
            using (var context = new Ejercicio2Context(
         serviceProvider.GetRequiredService<
             DbContextOptions<Ejercicio2Context>>()))
            {
                // Look for any students.
                if (context.Camisetas.Any())
                {
                    return;   // DB has been seeded
                }
                if (context.Pantalones.Any())
                {
                    return;   // DB has been seeded
                }
                if (context.Zapatos.Any())
                {
                    return;   // DB has been seeded
                }

                var camisetas = new Camisetas[]
                {
                new Camisetas{Talla="S",Color="Blanca",Cantidad=3, ReleaseDate=DateTime.Parse("2019-09-01")},
                new Camisetas{Talla="M",Color="Negra",Cantidad=4, ReleaseDate=DateTime.Parse("2020-12-01")}

                };

                context.Camisetas.AddRange(camisetas);
                context.SaveChanges();

                var pantalones = new Pantalones[]
                {

                new Pantalones{Talla=21,Color="Blanca",Cantidad=3, ReleaseDate=DateTime.Parse("2019-09-01")},
                new Pantalones{Talla=65,Color="Negra",Cantidad=4, ReleaseDate=DateTime.Parse("2020-12-01")}

                };

                context.Pantalones.AddRange(pantalones);
                context.SaveChanges();

                var zapatos = new Zapatos[]
                {

                new Zapatos{Talla=41,Color="Morados",Tipo="deportiva",Cantidad=23, ReleaseDate=DateTime.Parse("2019-09-01")},
                new Zapatos{Talla=33,Color="Rojas",Tipo="Casual",Cantidad=75, ReleaseDate=DateTime.Parse("2020-12-01")}
                };

                context.Zapatos.AddRange(zapatos);
                context.SaveChanges();

            }
        }
    }
}

