using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using Pajaros.Data;
using Pajaros.Models;

namespace Pajaros.Pages.Aves_Pajaros
{
    public class DeleteModel : PageModel
    {
        private readonly Pajaros.Data.PajaroContext _context;

        public DeleteModel(Pajaros.Data.PajaroContext context)
        {
            _context = context;
        }

        [BindProperty]
      public Pajaro Pajaro { get; set; } = default!;

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null || _context.Pajaro == null)
            {
                return NotFound();
            }

            var pajaro = await _context.Pajaro.FirstOrDefaultAsync(m => m.id == id);

            if (pajaro == null)
            {
                return NotFound();
            }
            else 
            {
                Pajaro = pajaro;
            }
            return Page();
        }

        public async Task<IActionResult> OnPostAsync(int? id)
        {
            if (id == null || _context.Pajaro == null)
            {
                return NotFound();
            }
            var pajaro = await _context.Pajaro.FindAsync(id);

            if (pajaro != null)
            {
                Pajaro = pajaro;
                _context.Pajaro.Remove(Pajaro);
                await _context.SaveChangesAsync();
            }

            return RedirectToPage("./Index");
        }
    }
}
