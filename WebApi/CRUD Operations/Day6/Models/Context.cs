using Microsoft.EntityFrameworkCore;

namespace Day6.Models
{
    public class Context : DbContext
    {
        public Context(DbContextOptions<Context>options)
           : base(options)
        { }
        public DbSet<Class> TodoItems { get; set; } = null!;
    }
}
