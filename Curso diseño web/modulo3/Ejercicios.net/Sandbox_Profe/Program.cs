// Adición automática de "Datos" (BB.DD. / Contexto generado con el scaffolding)
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;
using Sandbox7.Data;
// Referencia a Modelos (objetos en base a la lógica de negocio) creados en sus carpetas correspondientes
using Sandbox7.Modelos;

// Inicialización de de objeto con la configuración predefinida
var builder = WebApplication.CreateBuilder(args);

// Add services to the container. (Compatibilidad con páginas de Razor)
builder.Services.AddRazorPages();
// Se añade la cadena de conexión del contexto que proviene de "appsettings.json"
builder.Services.AddDbContext<Sandbox7Context>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("Sandbox7Context") ?? throw new InvalidOperationException("Connection string 'Sandbox7Context' not found.")));

// Inicialización de la app (Compilar/Renderizar)
var app = builder.Build();

// Llamada a la inicialización de la BBDD
using (IServiceScope scope = app.Services.CreateScope())
{
    IServiceProvider servicios = scope.ServiceProvider;
    DatosPeliculas.InicializarBBDD(servicios);
}

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

// Middleware
app.UseHttpsRedirection(); // Redirige solicitudes HTTP a HTTPS
app.UseStaticFiles(); // Usa archivos de wwwroot (HTML, CSS, Javascript)
app.UseRouting(); // Agregar coincidencias de rutas de middleware
app.UseAuthorization(); // Autorización de usuarios a recursos
app.UseStatusCodePages(); // Control de errores (404, etc.)

app.MapRazorPages(); // "Indexación" y enrutamiento de las páginas de la app

app.Run(); // Ejecución de la app

/*
Pasos seguidos para la modificación de la plantilla:
1. Crear carpeta Modelos y añadir Pelicula.cs
2. Crear carpeta Pages/Peliculas y añadir elemento con scaffold (Entity Framework con CRUD)
3. Migración de la base de datos: Herramientas>Administrador de paquetes NuGet>Consola de administrador de paquetes
3.1 Add-Migration InitialCreate
3.2 Update-Database
4. Crear la inicialización de la base de datos en Modelos/DatosPeliculas.cs
5. Correción del formato de las propiedades en la BB.DD. (Peliculas.cs) [Display]
6. Añadimos búsqueda de películas
6.1 Modificamos Peliculas/Index.cshtml.cs para programar la búsqueda de películas
6.2 Modificamos Formulario en Peliculas/Index.cshtml (Campos de búsqueda)
7. Añadimos un campo nuevo a una instancia (Modelos/Pelicula.cs) ya existente
7.1 Modificamos todos los documentos necesarios sin regenerar con scaffold (Peliculas/Index|Create|Delete|Edit y Modelos/DatosPeliculas.cs)
7.2 Actualizamos la base de datos migrando el campo nuevo (Add-Migration CampoNuevo) y Paso 3.2
8 Añadimos una validación adicional a los campos de Película (con atributos)
8.1 [Required], [StringLength], [RegularExpression] y [Range]
8.2 [DataType], [DisplayFormat]
8.3 Regenerar migración para mantener la coherencia entre modelo y base de datos (Paso 7.2)
*/