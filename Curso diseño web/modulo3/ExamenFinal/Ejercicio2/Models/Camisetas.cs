using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using System.Xml.Linq;

namespace Ejercicio2.Models
{
    public class Camisetas
    {
        public int Id { get; set; }
        [Required]
        [StringLength(3)]
        public string? Talla { get; set; }
        public string Color { get; set; }
        [Required]
        public int Cantidad { get; set; }
        [Required]
        [Display(Name = "Fecha de modificación")]//l atributo Display especifica qué se muestra como nombre de un campo (en este caso, "Release Date" en lugar de "ReleaseDate").
        [DataType(DataType.Date)]//El atributo DataType en ReleaseDate especifica el tipo de los datos (Date). 
        public DateTime ReleaseDate { get; set; }
       
    }
}
