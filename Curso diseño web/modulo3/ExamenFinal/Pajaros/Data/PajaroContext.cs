using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Pajaros.Models;

namespace Pajaros.Data
{
    public class PajaroContext : DbContext
    {
        public PajaroContext (DbContextOptions<PajaroContext> options)
            : base(options)
        {
        }

        public DbSet<Pajaros.Models.Pajaro> Pajaro { get; set; } = default!;
        public DbSet<Pajaros.Models.Rapaz> Rapaz { get; set; } = default!;
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
        
            modelBuilder.Entity<Pajaro>().ToTable("Pajaros");

            modelBuilder.Entity<Rapaz>().ToTable("Rapaces");
        }
    }
    
}
