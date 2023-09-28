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
    public class IndexModel : PageModel
    {
        private readonly Pajaros.Data.PajaroContext _context;

        public IndexModel(Pajaros.Data.PajaroContext context)
        {
            _context = context;
        }

        public IList<Rapaz> Rapaz { get;set; } = default!;

        public async Task OnGetAsync()
        {
            if (_context.Rapaz != null)
            {
                Rapaz = await _context.Rapaz.ToListAsync();
            }
        }
    }
}
