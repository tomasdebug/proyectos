using Microsoft.EntityFrameworkCore;
using Sandbox7.Data;

namespace Sandbox7.Modelos
{
    public static class DatosPeliculas
    {
        public static void InicializarBBDD(IServiceProvider serviceProvider)
        {
            // Inicializador de la conexión a la base de datos mediante el servicio
            using (var context = new Sandbox7Context(
                serviceProvider.GetRequiredService<
                DbContextOptions<Sandbox7Context>>()))
            {
                if (context == null || context.Pelicula == null)
                {
                    throw new ArgumentNullException("Base de datos nula.");
                }
                // Comprobación de que la base de datos está vacía
                if (context.Pelicula.Any())
                {
                    return;
                }
                // Añadimos las 4 películas de ejemplo
                context.Pelicula.AddRange(
                    new Pelicula
                    {
                        Titulo = "PeliEjemplo1",
                        FechaSalida = DateTime.Parse("1/2/2020"),
                        Genero = "Acción",
                        Precio = 9.99M,
                        Valoracion = "Buena"
                    },
                    new Pelicula
                    {
                        Titulo = "PeliEjemplo2",
                        FechaSalida = DateTime.Parse("1/3/2020"),
                        Genero = "Terror",
                        Precio = 9.99M,
                        Valoracion = "Excelente"
                    },
                    new Pelicula
                    {
                        Titulo = "PeliEjemplo3",
                        FechaSalida = DateTime.Parse("1/4/2020"),
                        Genero = "Suspense",
                        Precio = 9.99M,
                        Valoracion = "Malísima"
                    },
                    new Pelicula
                    {
                        Titulo = "PeliEjemplo4",
                        FechaSalida = DateTime.Parse("1/5/2020"),
                        Genero = "Comedia",
                        Precio = 9.99M,
                        Valoracion = "Regular"
                    }
                    );
                // Hacemos update de la BB.DD.
                context.SaveChanges();
            }
        }
    }
}