using Microsoft.AspNetCore.Mvc;
using System.Text.Encodings.Web;

namespace MvcMovie.Controllers;

public class HelloWorldController : Controller
{
    /*
     * Cada método public en un controlador puede ser invocado como un punto de conexión HTTP. En el ejemplo anterior, ambos métodos devuelven una cadena. Observe los comentarios delante de cada método.

Un punto de conexión HTTP:

Es una dirección URL que se puede establecer como destino en la aplicación web, por ejemplo, https://localhost:5001/HelloWorld.
Combina:
El protocolo usado: HTTPS.
La ubicación de red del servidor web, incluido el puerto TCP: localhost:5001.
El URI de destino: HelloWorld.
El primer comentario indica que se trata de un método HTTP GET que se invoca anexando /HelloWorld/ a la dirección URL base.

El segundo comentario especifica un método HTTP GET que se invoca anexando /HelloWorld/Welcome/ a la dirección URL. Más adelante en el tutorial se usa el motor de scaffolding para generar métodos HTTP POST que actualizan los datos.
    La lógica de enrutamiento de URL predeterminada que usa MVC emplea un formato similar al siguiente para determinar qué código se debe invocar:

/[Controller]/[ActionName]/[Parameters]
    El formato de enrutamiento se establece en el archivo Program.cs.

     */
    // GET: /HelloWorld/
    public IActionResult Index()
    {
        return View();
    }
    // Llama al método View del controlador.
    //Usa una plantilla de vista para generar una respuesta HTML.

    // GET: /HelloWorld/Welcome/ 
    // Requires using System.Text.Encodings.Web;
    public IActionResult Welcome(string name, int numTimes = 1)
    {
        ViewData["Message"] = "Hello " + name;
        ViewData["NumTimes"] = numTimes;
        return View();
    }
    /*
La plantilla de vista genera una respuesta dinámica, 
lo que significa que se deben pasar los datos adecuados del controlador a la vista para que se genere la respuesta.
Para hacerlo, indique al controlador que coloque los datos dinámicos (parámetros) que necesita la plantilla de vista en un diccionario ViewData. 
    
El diccionario ViewData es un objeto dinámico, lo que significa que se puede usar cualquier tipo.
El objeto ViewData no tiene ninguna propiedad definida hasta que se agrega algo.   
ViewData contiene datos que se pasarán a la vista.
     */
    /*
     * public string Welcome(string name, int numTimes = 1)
     {
         return HtmlEncoder.Default.Encode($"Hello {name}, NumTimes is: {numTimes}");
     }
    */
    /*
     *Usa la característica de parámetro opcional de C# para indicar que el parámetro numTimes tiene el valor predeterminado 1 si no se pasa ningún valor para ese parámetro.  
     * Usa HtmlEncoder.Default.Encode para proteger la aplicación de entradas malintencionadas, por ejemplo, mediante JavaScript. Usa cadenas interpoladas en $"Hello {name}, NumTimes is: {numTimes}".
     *Se pasan los parámetros name y numTimes en la cadena de consulta.
       El ? (signo de interrogación) en la dirección URL anterior es un separador y le sigue la cadena de consulta.(Una cadena de consulta es parte de un localizador uniforme de recursos (URL) que asigna valores a parámetros específicos. )
       El carácter & separa los pares campo-valor.
     */
}