/*INTERFAZ DEL TIPO ABSTRACTO TIEMPO CIUDAD*/
#pragma once
/* http://www.aprenderaprogramar.com/foros/index.php?topic=401.0*/
typedef char TipoCadena [100]; /*Cadena de texto*/
typedef enum TipoError {ErrorGenerado}; /*Para uso con throw*/
typedef enum TipoMomento {mannana, tarde, noche, madrugada};
typedef enum TipoEstado {sol, nubes, lluvia, nieve};
typedef TipoEstado TipoVectorEstados [4];
typedef float TipoVectorTemperaturas [4];
typedef struct TipoTiempoCiudad {
TipoVectorTemperaturas temperatura;
TipoVectorEstados estado;
TipoCadena NombreCiudad;
void NuevoTiempo (TipoCadena nombredeciudad, TipoMomento momento, float temperaturamomento, TipoEstado estadomomento);
void NuevaCiudad (TipoCadena nombredeciudad);
void ListaTiempo (TipoCadena nombredeciudad);
};
