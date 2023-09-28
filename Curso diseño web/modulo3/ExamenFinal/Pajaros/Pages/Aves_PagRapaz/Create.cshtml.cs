using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using Pajaros.Data;
using Pajaros.Models;

namespace Pajaros.Pages.Aves_PagRapaz
{
    public class CreateModel : PageModel
    {
        private readonly Pajaros.Data.PajaroContext _context;

        public CreateModel(Pajaros.Data.PajaroContext context)
        {
            _context = context;
        }

        public IActionResult OnGet()
        {
            return Page();
        }

        [BindProperty]
        public Rapaz Rapaz { get; set; } = default!;
        

        // To protect from overposting attacks, see https://aka.ms/RazorPagesCRUD
        public async Task<IActionResult> OnPostAsync()
        {
          if (!ModelState.IsValid || _context.Rapaz == null || Rapaz == null)
            {
                return Page();
            }

            _context.Rapaz.Add(Rapaz);
            await _context.SaveChangesAsync();

            return RedirectToPage("./Index");
        }
    }
}
