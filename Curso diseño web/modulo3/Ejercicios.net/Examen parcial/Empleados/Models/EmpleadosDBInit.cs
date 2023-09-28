using Empleados.Models;
using Microsoft.EntityFrameworkCore;
using Empleados.App_Data;

namespace Empleados.Models
{
    public class EmpleadosDBInit
    {
        public static void Inicializar(IServiceProvider serviceProvider) //el serviceProvider gestiona los servicios del ASP.Net(sus metodos propios)
        {
            var cargos = new List<Cargo> {
            new Cargo {nomCargo="Gerente"},
            new Cargo { nomCargo="Jefe de departamento"},
            new Cargo{ nomCargo="Empleado"} };

            var departamentos = new List<Departamento> {
            new Departamento {nomDep="I+D"},
            new Departamento { nomDep="Software"},
            new Departamento{ nomDep="Limpiadores"} };

            var persona = new List<Persona> {
            new Persona {Nombre="Paco",Apellido1="Garcia",Apellido2="Campos",Edad=22,Antiguedad=1,Cargo=cargos[0],Departamento=departamentos[0]},
            new Persona {Nombre="José",Apellido1="Juan",Apellido2="Campos",Edad=43,Antiguedad=14,Cargo=cargos[2],Departamento=departamentos[2]},
            new Persona {Nombre="Juan",Apellido1="Campos",Apellido2="Garcia",Edad=62,Antiguedad=20,Cargo=cargos[1],Departamento=departamentos[1]},
            new Persona {Nombre="Marcos",Apellido1="Garcia",Apellido2="Campos",Edad=52,Antiguedad=12,Cargo=cargos[2],Departamento=departamentos[2]},
            new Persona {Nombre="Dolores",Apellido1="Garcia",Apellido2="Ano",Edad=33,Antiguedad=1,Cargo=cargos[0],Departamento=departamentos[0]},
            new Persona {Nombre="Clara",Apellido1="Amor",Apellido2="Campos",Edad=30,Antiguedad=5,Cargo=cargos[0],Departamento=departamentos[0]},
            new Persona {Nombre="Sasha",Apellido1="Espinosa",Apellido2="Campos",Edad=31,Antiguedad=2,Cargo=cargos[2],Departamento=departamentos[1]},
            new Persona {Nombre="Erberegildo",Apellido1="Garcia",Apellido2="Garcia",Edad=57,Antiguedad=2,Cargo=cargos[1],Departamento=departamentos[0]},
            new Persona {Nombre="Eustaquio",Apellido1="Almohada",Apellido2="Espiga",Edad=42,Antiguedad=2,Cargo=cargos[1],Departamento=departamentos[2]},
            new Persona {Nombre="Paco",Apellido1="Rosales",Apellido2="sandia",Edad=32,Antiguedad=2,Cargo=cargos[0],Departamento=departamentos[0]}};
            //
            using (var context = new EmpleadosContext(serviceProvider.GetRequiredService<DbContextOptions<EmpleadosContext>>())) 
            {
                if (context == null || context.personas == null|| context.Cargos == null|| context.Departamentos == null)
                {
                    throw new ArgumentNullException("Base de datos nula.");
                }
                // Comprobación de que la base de datos está vacía
                if (context.personas.Any() || context.Cargos.Any()||context.Departamentos.Any())//any te dice si tiene objetos
                {
                    return;
                }

                cargos.ForEach(c => context.Add(c));
                departamentos.ForEach(c => context.Add(c));
                persona.ForEach(c => context.Add(c));
                context.SaveChanges();

            }


            
          
        
        }
    }
}

      
   
    
