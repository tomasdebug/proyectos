using Empleados.Models;
using Microsoft.EntityFrameworkCore;

namespace Empleados.App_Data
{
    public class EmpleadosContext : DbContext
    {
        //creo el generador de contexto
        public EmpleadosContext(DbContextOptions<EmpleadosContext> options) : base(options) { }//crea el contexto y le pasa a la base todas las opciones que tiene
        //el entity framework coge los modelos ,los pasa al contexto y de ahí a la base de datos
        public DbSet<Cargo> Cargos { get; set; } = default!;//crea la tabla con los distintos datos
        public DbSet<Departamento> Departamentos { get; set; } = default!;
        public DbSet<Persona> personas { get; set; } = default!;

    }
}