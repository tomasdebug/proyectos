using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Empleados.Models
{
    public class Cargo
    {

        public int ID { get; set; }

        public String nomCargo { get; set; }
        
   
    }
}