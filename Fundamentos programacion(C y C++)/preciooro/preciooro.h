
#pragma once
/* http://www.aprenderaprogramar.com/foros/index.php?topic=401.0*/
const int numeroMonedas = 5;
extern float cambioMoneda1;
extern float cambioMoneda2;
typedef enum TipoError {errorGenerado};
typedef enum TipoNombreMoneda {desconocida, dolares, euros, yenes, libras, yuanes};
typedef struct TipoPrecioOro {
TipoNombreMoneda nombreMoneda;
float precioOroMoneda;
};
typedef TipoPrecioOro TipoVectorMoneda [numeroMonedas+1];
typedef struct TipoVectorOro {
TipoVectorMoneda moneda;
void NuevoPrecio (TipoNombreMoneda nombre_moneda, float precionuevo);
void CambioOro (TipoNombreMoneda nombre_moneda1, TipoNombreMoneda nombre_moneda2);
void ListarPrecios();
};
