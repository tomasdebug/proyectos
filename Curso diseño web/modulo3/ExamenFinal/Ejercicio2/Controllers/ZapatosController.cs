using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Ejercicio2.Data;
using Ejercicio2.Models;

namespace Ejercicio2.Controllers
{
    public class ZapatosController : Controller
    {
        private readonly Ejercicio2Context _context;

        public ZapatosController(Ejercicio2Context context)
        {
            _context = context;
        }

        // GET: Zapatos
        public async Task<IActionResult> Index()
        {
              return _context.Zapatos != null ? 
                          View(await _context.Zapatos.ToListAsync()) :
                          Problem("Entity set 'Ejercicio2Context.Zapatos'  is null.");
        }

        // GET: Zapatos/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null || _context.Zapatos == null)
            {
                return NotFound();
            }

            var zapatos = await _context.Zapatos
                .FirstOrDefaultAsync(m => m.Id == id);
            if (zapatos == null)
            {
                return NotFound();
            }

            return View(zapatos);
        }

        // GET: Zapatos/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Zapatos/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,Talla,Color,Tipo,Cantidad,ReleaseDate")] Zapatos zapatos)
        {
            if (ModelState.IsValid)
            {
                _context.Add(zapatos);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(zapatos);
        }

        // GET: Zapatos/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null || _context.Zapatos == null)
            {
                return NotFound();
            }

            var zapatos = await _context.Zapatos.FindAsync(id);
            if (zapatos == null)
            {
                return NotFound();
            }
            return View(zapatos);
        }

        // POST: Zapatos/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Talla,Color,Tipo,Cantidad,ReleaseDate")] Zapatos zapatos)
        {
            if (id != zapatos.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(zapatos);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!ZapatosExists(zapatos.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(zapatos);
        }

        // GET: Zapatos/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null || _context.Zapatos == null)
            {
                return NotFound();
            }

            var zapatos = await _context.Zapatos
                .FirstOrDefaultAsync(m => m.Id == id);
            if (zapatos == null)
            {
                return NotFound();
            }

            return View(zapatos);
        }

        // POST: Zapatos/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            if (_context.Zapatos == null)
            {
                return Problem("Entity set 'Ejercicio2Context.Zapatos'  is null.");
            }
            var zapatos = await _context.Zapatos.FindAsync(id);
            if (zapatos != null)
            {
                _context.Zapatos.Remove(zapatos);
            }
            
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool ZapatosExists(int id)
        {
          return (_context.Zapatos?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }
}
