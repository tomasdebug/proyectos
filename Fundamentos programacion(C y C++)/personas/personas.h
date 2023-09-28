/* INTERFAZ DEL TAD */
#pragma once
/* www.aprenderaprogramar.com/foros/index.php?topic=401.0*/
const int upperBoundArray = 49;
typedef enum TipoEstadoCivil {soltero, casado, divorciado, indefinido};
typedef char TipoCadena[100]; /*Cadena de texto*/
typedef TipoCadena ArrayCadenas[upperBoundArray] ;
typedef TipoEstadoCivil ArrayEstadosCiv[upperBoundArray] ;
typedef int ArrayEdades[upperBoundArray] ;
typedef struct TipoArrayPersonas {
/*Datos en el TAD*/
ArrayCadenas nombre;
ArrayCadenas primerApellido;
ArrayCadenas segundoApellido;
ArrayEstadosCiv estadoCivil;
ArrayEdades edad;
/*Operaciones en el TAD: MayoresDe, ContEstadoCivil y GuardarNuevo*/
void MayoresDe (int edadParaListado);
int ContEstadoCivil (TipoEstadoCivil estadoRecibido);
void GuardarNuevo (TipoCadena nombreRecibido, TipoCadena primerApRecibido, TipoCadena
segApellidoRecibido, TipoEstadoCivil estadoRecibido, int edadRecibida);
/* Operaciones auxiliares: no definimos ninguna*/
}; /*Cierre del struct con ; */
