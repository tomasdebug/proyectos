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
    public class PantalonesController : Controller
    {
        private readonly Ejercicio2Context _context;

        public PantalonesController(Ejercicio2Context context)
        {
            _context = context;
        }

        // GET: Pantalones
        public async Task<IActionResult> Index()
        {
              return _context.Pantalones != null ? 
                          View(await _context.Pantalones.ToListAsync()) :
                          Problem("Entity set 'Ejercicio2Context.Pantalones'  is null.");
        }

        // GET: Pantalones/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null || _context.Pantalones == null)
            {
                return NotFound();
            }

            var pantalones = await _context.Pantalones
                .FirstOrDefaultAsync(m => m.Id == id);
            if (pantalones == null)
            {
                return NotFound();
            }

            return View(pantalones);
        }

        // GET: Pantalones/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Pantalones/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,Talla,Color,Cantidad,ReleaseDate")] Pantalones pantalones)
        {
            if (ModelState.IsValid)
            {
                _context.Add(pantalones);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(pantalones);
        }

        // GET: Pantalones/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null || _context.Pantalones == null)
            {
                return NotFound();
            }

            var pantalones = await _context.Pantalones.FindAsync(id);
            if (pantalones == null)
            {
                return NotFound();
            }
            return View(pantalones);
        }

        // POST: Pantalones/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Talla,Color,Cantidad,ReleaseDate")] Pantalones pantalones)
        {
            if (id != pantalones.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(pantalones);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!PantalonesExists(pantalones.Id))
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
            return View(pantalones);
        }

        // GET: Pantalones/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null || _context.Pantalones == null)
            {
                return NotFound();
            }

            var pantalones = await _context.Pantalones
                .FirstOrDefaultAsync(m => m.Id == id);
            if (pantalones == null)
            {
                return NotFound();
            }

            return View(pantalones);
        }

        // POST: Pantalones/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            if (_context.Pantalones == null)
            {
                return Problem("Entity set 'Ejercicio2Context.Pantalones'  is null.");
            }
            var pantalones = await _context.Pantalones.FindAsync(id);
            if (pantalones != null)
            {
                _context.Pantalones.Remove(pantalones);
            }
            
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool PantalonesExists(int id)
        {
          return (_context.Pantalones?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }
}
