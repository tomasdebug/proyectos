using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace MvcMovie.Models;

public class Movie
{
    public int Id { get; set; }
    public string? Title { get; set; }

    [Display(Name = "Release Date")]//l atributo Display especifica qué se muestra como nombre de un campo (en este caso, "Release Date" en lugar de "ReleaseDate").
    [DataType(DataType.Date)]//El atributo DataType en ReleaseDate especifica el tipo de los datos (Date). 
    public DateTime ReleaseDate { get; set; }
    public string? Genre { get; set; }//El signo de interrogación después de string indica que la propiedad admite un valor NULL.
    [Column(TypeName = "decimal(18, 2)")]//La anotación de datos [Column(TypeName = "decimal(18, 2)")] es necesaria para que Entity Framework Core asigne correctamente Price a la moneda en la base de datos. 
    // decimal o numeric (t,d): Pueden tener hasta 38 digitos, guarda un valor exacto. El primer argumento indica el total de dígitos y el segundo, la cantidad de decimales.
    public decimal Price { get; set; }
}

