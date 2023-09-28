using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Empleados.Models
{
    public class Departamento
    {
        public int ID { get; set; }
        public String nomDep { get; set; }
     
    }
}