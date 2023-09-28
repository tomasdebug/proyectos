using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using Sandbox7.Data;
using Sandbox7.Modelos;

namespace Sandbox7.Pages.Peliculas
{
    public class DeleteModel : PageModel
    {
        private readonly Sandbox7.Data.Sandbox7Context _context;

        public DeleteModel(Sandbox7.Data.Sandbox7Context context)
        {
            _context = context;
        }

        [BindProperty]
      public Pelicula Pelicula { get; set; } = default!;

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null || _context.Pelicula == null)
            {
                return NotFound();
            }

            var pelicula = await _context.Pelicula.FirstOrDefaultAsync(m => m.ID == id);

            if (pelicula == null)
            {
                return NotFound();
            }
            else 
            {
                Pelicula = pelicula;
            }
            return Page();
        }

        public async Task<IActionResult> OnPostAsync(int? id)
        {
            if (id == null || _context.Pelicula == null)
            {
                return NotFound();
            }
            var pelicula = await _context.Pelicula.FindAsync(id);

            if (pelicula != null)
            {
                Pelicula = pelicula;
                _context.Pelicula.Remove(Pelicula);
                await _context.SaveChangesAsync();
            }

            return RedirectToPage("./Index");
        }
    }
}
