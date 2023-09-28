   #pragma once
typedef enum TipoError {errorGenerado};
typedef enum TipoSabor {desconocido, chocolate, vainilla, fresa, limon, pistacho, menta};
typedef float TipoCantidadDisponible[7];
typedef char TipoCadena[15];
typedef TipoCadena TipoNombresHelados[7];
typedef struct TipoHelado {
TipoCantidadDisponible cantidadDisponible;
void IncrementarHelado (TipoSabor sabor, float cantidad);
bool EsPosibleCucurucho (TipoSabor sabor1, TipoSabor sabor2, TipoSabor sabor3);
void CucuruchosDisponibles ();
};
