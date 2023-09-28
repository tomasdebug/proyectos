using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Pajaros.Data;
using Pajaros.Models;

namespace Pajaros.Pages.Aves_Pajaros
{
    public class EditModel : PageModel
    {
        private readonly Pajaros.Data.PajaroContext _context;

        public EditModel(Pajaros.Data.PajaroContext context)
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

            var pajaro =  await _context.Pajaro.FirstOrDefaultAsync(m => m.id == id);
            if (pajaro == null)
            {
                return NotFound();
            }
            Pajaro = pajaro;
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

            _context.Attach(Pajaro).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PajaroExists(Pajaro.id))
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

        private bool PajaroExists(int id)
        {
          return (_context.Pajaro?.Any(e => e.id == id)).GetValueOrDefault();
        }
    }
}
