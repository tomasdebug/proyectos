using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
// Añadimos los métodos para búsquedas
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Sandbox7.Data;
using Sandbox7.Modelos;

namespace Sandbox7.Pages.Peliculas
{
    // Creación de el modelo para Index en base al modelo de páginas Razor
    public class IndexModel : PageModel
    {
        // Adición del contexto
        private readonly Sandbox7.Data.Sandbox7Context _context;

        public IndexModel(Sandbox7.Data.Sandbox7Context context)
        {
            _context = context;
        }

        // Acceso al listado de películas (creación de instancia)
        public IList<Pelicula> Pelicula { get;set; } = default!;

        // Funcionalidad de búsqueda
        [BindProperty(SupportsGet = true)]
        public string ? CadenaBusqueda { get; set; }
        public SelectList ? ListaGeneros { get; set; }
        [BindProperty(SupportsGet = true)]
        public string ? GeneroPeli { get; set; }

        // "Extracción" de las películas del contexto existentes
        public async Task OnGetAsync()
        {
            // Búsqueda de Géneros
            IQueryable<string> Generos = from p in _context.Pelicula orderby p.Genero select p.Genero;

            // Búsqueda de películas
            var Peliculas = from p in _context.Pelicula select p;

            // Filtrado de Títulos
            if (!string.IsNullOrEmpty(CadenaBusqueda))
            {
                Peliculas = Peliculas.Where(s => s.Titulo.Contains(CadenaBusqueda));
            }
            
            // Listar Géneros
            if (!string.IsNullOrEmpty(GeneroPeli))
            {
                Peliculas = Peliculas.Where(g => g.Genero == GeneroPeli);
            }

            ListaGeneros = new SelectList(await Generos.Distinct().ToListAsync());
            Pelicula = await Peliculas.ToListAsync();
        }
    }
}
