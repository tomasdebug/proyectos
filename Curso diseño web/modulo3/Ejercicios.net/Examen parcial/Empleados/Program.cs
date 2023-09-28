using Empleados.App_Data;
using Empleados.Models;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);


// Add services to the container.
builder.Services.AddControllersWithViews();
builder.Services.AddDbContext<EmpleadosContext>(options => options.UseSqlServer(builder.Configuration.GetConnectionString("EmpleadosContext")));//el add context es el tipo de elemento a añadir y se le pasa se le asigna las opciones que cogen del contexto para obtener los metodos que procesan el conection string y así hacer una conexión


var app = builder.Build();
using (var scope = app.Services.CreateScope())
{
    var services = scope.ServiceProvider;//es el acceso a los servicios que hemos añadido automaticamente a la app que corresponden a los que va a usar la inicializacion de la base de datos 
    EmpleadosDBInit.Inicializar(services);//se crea la base de datos

}

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}
//Persona persona = new Persona { Edad = 199 };
//Console.WriteLine(persona.Edad);
app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
