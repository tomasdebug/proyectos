
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;
using Pajaros.Data;
using Pajaros.Models;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddRazorPages();

builder.Services.AddDbContext<PajaroContext>(options =>

    options.UseSqlServer(builder.Configuration.GetConnectionString("PajaroContext") ?? throw new InvalidOperationException("Connection string 'PajaroContext' not found.")));




var app = builder.Build();

if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Error");
    app.UseHsts();
}
else
{
    app.UseDeveloperExceptionPage();
}

    using (var scope = app.Services.CreateScope())
    {
        var services = scope.ServiceProvider;

        var context = services.GetRequiredService<PajaroContext>();
        context.Database.EnsureCreated();

        // DbInitializer.Initialize(context);
    }




app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapRazorPages();

app.Run();