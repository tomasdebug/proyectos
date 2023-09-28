using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Pajaros.Data;
using Pajaros.Models;
using Pajaros.Services;


namespace Pajaros.Pages
{
    public class PizzaListModel : PageModel
    {
        private readonly PizzaService _service;
        public IList<Models.Pajaros> PajarosList { get; set; } = default!;

        public PizzaListModel(PizzaService service)
        {
            _service = service;
        }

        public void OnGet()
        {
            PajarosList = _service.GetPizzas();
        }
        [BindProperty]//BindProperty se usa para enlazar la propiedad NewPizza a la página de Razor.
        public Models.Pajaros NewPajaro { get; set; } = default!;//La palabra clave default! se usa para inicializar la propiedad NewPizza en null.
        public IActionResult OnPost()
        {
            if (!ModelState.IsValid || NewPajaro == null)//ModelState.IsValid se usa para determinar si la entrada del usuario es válida.
            {
                return Page();
            }

            _service.AddPizza(NewPajaro);

            return RedirectToAction("Get");
        }
        public IActionResult OnPostDelete(int id)
        {
            _service.DeletePizza(id);

            return RedirectToAction("Get");
        }
    }
}
