using Microsoft.AspNetCore.Mvc;

namespace ContosoPizza_Api_.Controllers;

[ApiController]
[Route("[controller]")]
public class WeatherForecastController : ControllerBase
{
    private static readonly string[] Summaries = new[]
    {
        "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };

    private readonly ILogger<WeatherForecastController> _logger;

    public WeatherForecastController(ILogger<WeatherForecastController> logger)
    {
        _logger = logger;
    }

    [HttpGet(Name = "GetWeatherForecast")]//Este atributo enruta las solicitudes GET HTTP al método public IEnumerable<WeatherForecast> Get(). 
    //Por eso, en el ejercicio anterior, las solicitudes a https://localhost:{PORT}/weatherforecast dieron lugar a la devolución de los resultados meteorológicos.
    public IEnumerable<WeatherForecast> Get()
    {
        return Enumerable.Range(1, 5).Select(index => new WeatherForecast
        {
            Date = DateOnly.FromDateTime(DateTime.Now.AddDays(index)),//coge la fecha actual y le añade el indice en dias
            TemperatureC = Random.Shared.Next(-20, 55),//cojo un valor aleatorio entre -20 y 55
            Summary = Summaries[Random.Shared.Next(Summaries.Length)]//cojo un valor aleatorio de entre el array de arriba
        })
        .ToArray();
    }
}
