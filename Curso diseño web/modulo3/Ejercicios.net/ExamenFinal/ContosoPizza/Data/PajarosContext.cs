using Microsoft.EntityFrameworkCore;

namespace Pajaros.Data
{
    public class PajarosContext : DbContext
    {
        public PajarosContext(DbContextOptions<PajarosContext> options)
            : base(options)
        {
        }
        public DbSet<Pajaros.Models.Pajaros>? Pajaros { get; set; }
    }
}
