using Microsoft.AspNetCore.Mvc;
using Sandbox_MVC.Models;
using System.Diagnostics;

namespace Sandbox_MVC.Controllers
{
    public class HomeController : Controller//todos los controladores heredam de controles
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()//devuelve la vista de Index
        {
            return View();//no hay interaccion si te fijas
        }

        public IActionResult Privacy()//devuelve la vista de Index
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()//cuando me salga un error me genera una nueva vista con el id del error
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}