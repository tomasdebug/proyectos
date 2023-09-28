using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using Sandbox7.Data;
using Sandbox7.Modelos;

namespace Sandbox7.Pages.Peliculas
{
    public class CreateModel : PageModel
    {
        private readonly Sandbox7.Data.Sandbox7Context _context;

        public CreateModel(Sandbox7.Data.Sandbox7Context context)
        {
            _context = context;
        }

        public IActionResult OnGet()
        {
            return Page();
        }
        // Vincula los valores del formulario a las propiedades del objeto "película" actual y se los pasa a la base de datos
        [BindProperty]
        public Pelicula Pelicula { get; set; } = default!;
        

        // To protect from overposting attacks, see https://aka.ms/RazorPagesCRUD
        public async Task<IActionResult> OnPostAsync()
        {
          if (!ModelState.IsValid || _context.Pelicula == null || Pelicula == null)
            {
                return Page();
            }

            _context.Pelicula.Add(Pelicula);
            await _context.SaveChangesAsync();

            return RedirectToPage("./Index");
        }
    }
}
