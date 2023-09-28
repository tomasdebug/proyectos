// Referencias para añadir las anotaciones (atributos) para el formato de las propiedades (llamadas entre corchetes p.e. [Display])
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Sandbox7.Modelos
{
    public class Pelicula
    {
        public int ID { get; set; }


        [Display(Name = "Título")]
        [Required]
        [StringLength(60, MinimumLength = 5, ErrorMessage = "Longitud mínima 5, máxima 60 caracteres")]
        public string Titulo { get; set; }


        [Display(Name = "Fecha Salida")]
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:dd-MM-yyyy}", ApplyFormatInEditMode = true)]
        [Range(typeof(DateTime), "1/1/1900", "1/1/2024")]
        public DateTime FechaSalida { get; set; }

        [Required]
        [StringLength(30)]
        [RegularExpression(@"^[A-Z]+[a-zA-Záéíóú\s]*$")]
        [Display(Name = "Género")]
        public string Genero { get; set; }


        [Column(TypeName = "decimal(18, 2)")]
        [Range(1,100, ErrorMessage = "El precio debe estar entre 1€ y 100€")]
        [DataType(DataType.Currency)]
        public decimal Precio { get; set; }


        [RegularExpression(@"^[A-Z]+[a-zA-Záéíóú\s]*$")]
        [Required]
        [StringLength(15)]
        public string Valoracion { get; set; } = string.Empty;
    }
}
