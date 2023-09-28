using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace Sandbox7.Pages
{
    public class IndexModel : PageModel
    {
        // Código preparado para alojar un sistema de inicio de sesión
        private readonly ILogger<IndexModel> _logger;

        public IndexModel(ILogger<IndexModel> logger)
        {
            _logger = logger;
        }

        // Código que se ejecuta tras la solicitud de la página
        public void OnGet()
        {

        }
    }
}