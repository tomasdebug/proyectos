using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using ContosoPizza.Models;
using ContosoPizza.Services;


namespace ContosoPizza.Pages
{
    public class PizzaListModel : PageModel
    {
        private readonly PizzaService _service;
        public IList<Pizza> PizzaList { get; set; } = default!;

        public PizzaListModel(PizzaService service)
        {
            _service = service;
        }

        public void OnGet()
        {
            PizzaList = _service.GetPizzas();
        }
        [BindProperty]//BindProperty se usa para enlazar la propiedad NewPizza a la página de Razor.
        public Pizza NewPizza { get; set; } = default!;//La palabra clave default! se usa para inicializar la propiedad NewPizza en null.
        public IActionResult OnPost()
        {
            if (!ModelState.IsValid || NewPizza == null)//ModelState.IsValid se usa para determinar si la entrada del usuario es válida.
            {
                return Page();
            }

            _service.AddPizza(NewPizza);

            return RedirectToAction("Get");
        }
        public IActionResult OnPostDelete(int id)
        {
            _service.DeletePizza(id);

            return RedirectToAction("Get");
        }
    }
}
