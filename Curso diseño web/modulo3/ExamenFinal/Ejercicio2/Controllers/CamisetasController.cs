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
    public class CamisetasController : Controller
    {
        private readonly Ejercicio2Context _context;

        public CamisetasController(Ejercicio2Context context)
        {
            _context = context;
        }

        // GET: Camisetas
        public async Task<IActionResult> Index()
        {
              return _context.Camisetas != null ? 
                          View(await _context.Camisetas.ToListAsync()) :
                          Problem("Entity set 'Ejercicio2Context.Camisetas'  is null.");
        }

        // GET: Camisetas/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null || _context.Camisetas == null)
            {
                return NotFound();
            }

            var camisetas = await _context.Camisetas
                .FirstOrDefaultAsync(m => m.Id == id);
            if (camisetas == null)
            {
                return NotFound();
            }

            return View(camisetas);
        }

        // GET: Camisetas/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Camisetas/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,Talla,Color,Cantidad,ReleaseDate")] Camisetas camisetas)
        {
            if (ModelState.IsValid)
            {
                _context.Add(camisetas);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(camisetas);
        }

        // GET: Camisetas/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null || _context.Camisetas == null)
            {
                return NotFound();
            }

            var camisetas = await _context.Camisetas.FindAsync(id);
            if (camisetas == null)
            {
                return NotFound();
            }
            return View(camisetas);
        }

        // POST: Camisetas/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Talla,Color,Cantidad,ReleaseDate")] Camisetas camisetas)
        {
            if (id != camisetas.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(camisetas);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!CamisetasExists(camisetas.Id))
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
            return View(camisetas);
        }

        // GET: Camisetas/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null || _context.Camisetas == null)
            {
                return NotFound();
            }

            var camisetas = await _context.Camisetas
                .FirstOrDefaultAsync(m => m.Id == id);
            if (camisetas == null)
            {
                return NotFound();
            }

            return View(camisetas);
        }

        // POST: Camisetas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            if (_context.Camisetas == null)
            {
                return Problem("Entity set 'Ejercicio2Context.Camisetas'  is null.");
            }
            var camisetas = await _context.Camisetas.FindAsync(id);
            if (camisetas != null)
            {
                _context.Camisetas.Remove(camisetas);
            }
            
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool CamisetasExists(int id)
        {
          return (_context.Camisetas?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }
}
