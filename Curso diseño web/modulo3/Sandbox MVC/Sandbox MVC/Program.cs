var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();
/*
app.MapControllerRoute(
    name: "adios",//el controlador por defecto
    pattern: "{controller=Login}/{action=Adios}/{nombre?}/{identificacion}");//llama al controlador home y dice muestrame index, si cambias el index puede mostrar por defecto otra pagina
*/
app.MapControllerRoute(
    name: "default",//el controlador por defecto
    pattern: "{controller=Home}/{action=Index}/{id?}");//llama al controlador home y dice muestrame index, si cambias el index puede mostrar por defecto otra pagina

app.Run();
