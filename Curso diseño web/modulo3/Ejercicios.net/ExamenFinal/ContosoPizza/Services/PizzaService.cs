using Pajaros.Data;
using Pajaros.Models;

namespace Pajaros.Services
{
    public class PizzaService
    {
        private readonly PajarosContext _context = default!;

        public PizzaService(PajarosContext context) 
        {
            _context = context;
        }
        
        public IList<Models.Pajaros> GetPizzas()
        {
            if(_context.Pajaros != null)
            {
                return _context.Pajaros.ToList();
            }
            return new List<Models.Pajaros>();
        }

        public void AddPizza(Models.Pajaros pizza)
        {
            if (_context.Pajaros != null)
            {
                _context.Pajaros.Add(pizza);
                _context.SaveChanges();
            }
        }

        public void DeletePizza(int id)
        {
            if (_context.Pajaros != null)
            {
                var pizza = _context.Pajaros.Find(id);
                if (pizza != null)
                {
                    _context.Pajaros.Remove(pizza);
                    _context.SaveChanges();
                }
            }            
        } 
    }
}
