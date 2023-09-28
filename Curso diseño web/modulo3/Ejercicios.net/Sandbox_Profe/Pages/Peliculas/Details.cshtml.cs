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
    public class DetailsModel : PageModel
    {
        private readonly Sandbox7.Data.Sandbox7Context _context;

        public DetailsModel(Sandbox7.Data.Sandbox7Context context)
        {
            _context = context;
        }

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
    }
}
