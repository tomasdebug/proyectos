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
    public class IndexModel : PageModel
    {
        private readonly Pajaros.Data.PajaroContext _context;

        public IndexModel(Pajaros.Data.PajaroContext context)
        {
            _context = context;
        }

        public IList<Pajaro> Pajaro { get;set; } = default!;

        public async Task OnGetAsync()
        {
            if (_context.Pajaro != null)
            {
                Pajaro = await _context.Pajaro.ToListAsync();
            }
        }
    }
}
