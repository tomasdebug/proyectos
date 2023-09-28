using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using Pajaros.Data;
using Pajaros.Models;

namespace Pajaros.Pages.Aves_PagRapaz
{
    public class DetailsModel : PageModel
    {
        private readonly Pajaros.Data.PajaroContext _context;

        public DetailsModel(Pajaros.Data.PajaroContext context)
        {
            _context = context;
        }

      public Rapaz Rapaz { get; set; } = default!; 

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null || _context.Rapaz == null)
            {
                return NotFound();
            }

            var rapaz = await _context.Rapaz.FirstOrDefaultAsync(m => m.id == id);
            if (rapaz == null)
            {
                return NotFound();
            }
            else 
            {
                Rapaz = rapaz;
            }
            return Page();
        }
    }
}
