using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Sandbox7.Modelos;

namespace Sandbox7.Data
{
    public class Sandbox7Context : DbContext
    {
        public Sandbox7Context (DbContextOptions<Sandbox7Context> options)
            : base(options)
        {
        }

        public DbSet<Sandbox7.Modelos.Pelicula> Pelicula { get; set; } = default!;
    }
}
