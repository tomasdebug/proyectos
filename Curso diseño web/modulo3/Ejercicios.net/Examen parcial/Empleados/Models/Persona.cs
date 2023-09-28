
using Empleados.Models;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Empleados.Models
{
    public class Persona
    {
        [Required]
        [Range(1, 1000, ErrorMessage = "Value for {0} must be between {1} and {2}.")]
        public int ID { get; set; }   
        [Required]
        [StringLength(30)]
        public String Nombre { get; set; }
        [Required]
        [StringLength(30)]
        [DisplayName("Primer Apellido:")]
        public String Apellido1 { get; set; }
        [StringLength(30)]
        [DisplayName("Segundo Apellido:")]
        public String Apellido2 { get; set; }
        [Required]
        [Range(18, 67, ErrorMessage = "Value for {0} must be between {1} and {2}.")]
        public int Edad { get; set; }
        public int Antiguedad { get; set; }
        public Cargo Cargo { get; set; }
        public Departamento Departamento { get; set; }
        
        
    
    }

}