using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Sandbox_MVC.Controllers
{
    public class LoginController : Controller
    {
   
        // GET: LoginController
        public ActionResult Index()//llamaría a la vista del controlador de index
        {
            @ViewBag.algo1 = "Hola muy buenas ";
            @ViewData["algo2"]="adios mu buenas";
;            return View();
        }
       public String Adios(int id,String nombre)//si pones en la url login/index te sale el hola mundo el primero es el controlador y el ultimo es la accion 
        {
            if(id == 2) { return "adios mundo"; }//el 2 es lo que esta a la derecha es decir= https://localhost:7011/login/Adios/2 == adios mundo
            //https://localhost:7011/login/Adios/1== hola mundo
            return "Hola  " + nombre;//View();//https://localhost:7011/Login/Adios?id=0&nombre=Tomás =me dice hola tomás 
            //En conclusion se pueden llamar y meter parametros desde la barra de busqueda
        }//Explicacion funcionamiento en el cuaderno (Dominio(URL)/controlador/acción/ID)
        /*
        public String Index()//si pones en la url login/index te sale el hola mundo el primero es el controlador y el ultimo es la accion 
        {
            return "Hola mundo";//View();
        }
        /*
    * Lo dejo vacio ya que realmente sobra un poco
   // GET: LoginController/Details/5
   public ActionResult Details(int id)
   {
       return View();
   }

   // GET: LoginController/Create
   public ActionResult Create()
   {
       return View();
   }

   // POST: LoginController/Create
   [HttpPost]
   [ValidateAntiForgeryToken]
   public ActionResult Create(IFormCollection collection)
   {
       try
       {
           return RedirectToAction(nameof(Index));
       }
       catch
       {
           return View();
       }
   }

   // GET: LoginController/Edit/5
   public ActionResult Edit(int id)
   {
       return View();
   }

   // POST: LoginController/Edit/5
   [HttpPost]
   [ValidateAntiForgeryToken]
   public ActionResult Edit(int id, IFormCollection collection)
   {
       try
       {
           return RedirectToAction(nameof(Index));
       }
       catch
       {
           return View();
       }
   }

   // GET: LoginController/Delete/5
   public ActionResult Delete(int id)
   {
       return View();
   }

   // POST: LoginController/Delete/5
   [HttpPost]
   [ValidateAntiForgeryToken]
   public ActionResult Delete(int id, IFormCollection collection)
   {
       try
       {
           return RedirectToAction(nameof(Index));
       }
       catch
       {
           return View();
       }
   }*/
    }
}
