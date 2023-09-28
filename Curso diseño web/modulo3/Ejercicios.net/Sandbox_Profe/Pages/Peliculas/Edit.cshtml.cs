using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Sandbox7.Data;
using Sandbox7.Modelos;

namespace Sandbox7.Pages.Peliculas
{
    public class EditModel : PageModel
    {
        private readonly Sandbox7.Data.Sandbox7Context _context;

        public EditModel(Sandbox7.Data.Sandbox7Context context)
        {
            _context = context;
        }

        // Vincula los valores del formulario a las propiedades del objeto "película" actual y se los pasa a la base de datos
        [BindProperty]
        public Pelicula Pelicula { get; set; } = default!;

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null || _context.Pelicula == null)
            {
                return NotFound();
            }

            var pelicula =  await _context.Pelicula.FirstOrDefaultAsync(m => m.ID == id);
            if (pelicula == null)
            {
                return NotFound();
            }
            Pelicula = pelicula;
            return Page();
        }

        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see https://aka.ms/RazorPagesCRUD.
        public async Task<IActionResult> OnPostAsync()
        {
            if (!ModelState.IsValid)
            {
                return Page();
            }

            _context.Attach(Pelicula).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PeliculaExists(Pelicula.ID))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return RedirectToPage("./Index");
        }

        private bool PeliculaExists(int id)
        {
          return (_context.Pelicula?.Any(e => e.ID == id)).GetValueOrDefault();
        }
    }
}
