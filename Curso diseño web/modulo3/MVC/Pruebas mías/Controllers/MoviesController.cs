using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using MvcMovie.Data;
using MvcMovie.Models;

namespace Pruebas_mías.Controllers
{
    public class MoviesController : Controller
    {
        private readonly MvcMovieContext _context;

        public MoviesController(MvcMovieContext context)
        {
            _context = context;
        }

        // GET: Movies
        //Todos los métodos HttpGet del controlador de películas siguen un patrón similar.
        //Obtienen un objeto de película (o una lista de objetos, en el caso de Index) y pasan el objeto (modelo) a la vista.
        public async Task<IActionResult> Index(string searchString)
        {
            if (_context.Movie == null)
            {
                return Problem("Entity set 'MvcMovieContext.Movie'  is null.");
            }

            var movies = from m in _context.Movie//La siguiente línea del método de acción de Index crea una consulta LINQ para seleccionar las películas:
                         select m;

            if (!String.IsNullOrEmpty(searchString))
                //En este momento, solo se define la consulta y no se ejecuta en la base de datos.
                //Si el parámetro searchString contiene una cadena, la consulta de películas se modifica para filtrar según el valor de la cadena de búsqueda:
            {
                movies = movies.Where(s => s.Title!.Contains(searchString));
            }

            return View(await movies.ToListAsync());
        }
        // GET: Movies/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null || _context.Movie == null)
            {
                return NotFound();
            }

            var movie = await _context.Movie
                .FirstOrDefaultAsync(m => m.Id == id);//Asynchronously returns the first element of a sequence, or a default value if the sequence contains no elements.
//selecciona entidades de película que coincidan con los datos de enrutamiento o el valor de consulta de cadena.
            if (movie == null)
            {
                return NotFound();
            }

            return View(movie);
        }

        // GET: Movies/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Movies/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        //Todos los métodos HttpGet del controlador de películas siguen un patrón similar.
        //Obtienen un objeto de película (o una lista de objetos, en el caso de Index) y pasan el objeto (modelo) a la vista.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,Title,ReleaseDate,Genre,Price")] Movie movie)
        {
            if (ModelState.IsValid)
            {
                _context.Add(movie);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(movie);
        }

        // GET: Movies/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null || _context.Movie == null)
            {
                return NotFound();
            }

            var movie = await _context.Movie.FindAsync(id);
            if (movie == null)
            {
                return NotFound();
            }
            return View(movie);
        }

        // POST: Movies/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]//El atributo HttpPost especifica que este método Edit se puede invocar solamente para solicitudes POST
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Title,ReleaseDate,Genre,Price")] Movie movie)
        //El Bind atributo es una manera de protegerse frente a la publicación excesiva en escenarios de creación.
        //Por ejemplo, supongamos que la Student entidad incluye una Secret propiedad que no desea establecer esta página web.
        //Incluso si no tiene un Secret campo en la página web, un hacker podría usar una herramienta como fiddler,
        //o escribir algún JavaScript, para publicar un Secret valor de formulario.
        //esto se evita con el bind 
        //El atributo ValidateAntiForgeryToken se usa para impedir la falsificación de una solicitud y se empareja con un token antifalsificación generado en el archivo de vista de edición (Views/Movies/Edit.cshtml). 
        {
            if (id != movie.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)// La propiedad ModelState.IsValid comprueba que los datos enviados en el formulario pueden usarse para modificar (editar o actualizar) un objeto Movie. Si los datos son válidos, se guardan. 
            {
                try
                {
                    _context.Update(movie);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!MovieExists(movie.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(movie);
        }

        // GET: Movies/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null || _context.Movie == null)
            {
                return NotFound();
            }

            var movie = await _context.Movie
                .FirstOrDefaultAsync(m => m.Id == id);
            if (movie == null)
            {
                return NotFound();
            }

            return View(movie);
        }

        // POST: Movies/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            if (_context.Movie == null)
            {
                return Problem("Entity set 'MvcMovieContext.Movie'  is null.");
            }
            var movie = await _context.Movie.FindAsync(id);
            if (movie != null)
            {
                _context.Movie.Remove(movie);
            }
            
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool MovieExists(int id)
        {
          return (_context.Movie?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }
}
