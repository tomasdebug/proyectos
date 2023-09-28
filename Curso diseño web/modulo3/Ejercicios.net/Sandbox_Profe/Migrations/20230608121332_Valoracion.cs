using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Sandbox7.Migrations
{
    /// <inheritdoc />
    public partial class Valoracion : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "Valoracion",
                table: "Pelicula",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Valoracion",
                table: "Pelicula");
        }
    }
}
