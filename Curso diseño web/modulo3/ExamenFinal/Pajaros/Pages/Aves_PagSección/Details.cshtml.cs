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
    public class DetailsModel : PageModel
    {
        private readonly Pajaros.Data.PajaroContext _context;

        public DetailsModel(Pajaros.Data.PajaroContext context)
        {
            _context = context;
        }

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
    }
}
