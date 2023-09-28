    #pragma once
    #include "gestordefechas.h"
    /* http://www.aprenderaprogramar.com/foros/index.php?topic=401.0*/
    const int MaxRegOperaciones = 5;
    typedef enum TipoError {errorindefinido, saldoinsuficiente};
    typedef enum TipoClaseOperacion {Indefinida, Cargar, Sacar, Consultar};
    typedef struct TipoDatosOperacion {
    TipoFecha fechaOperacion;
    float cantidadOperacion;
    TipoClaseOperacion claseOperacion;
    float saldoTrasOperacion;
    };
    typedef TipoDatosOperacion TipoVectorDatosOperacion [MaxRegOperaciones];
    typedef struct TipoDatosTarjetaMonedero {
    float saldo;
    TipoVectorDatosOperacion Operacion;
    void CargarCantidad(TipoFecha fecha, float cantidad);
    void SacarCantidad(TipoFecha fecha, float cantidad);
    void Consultar();
    void ReordenarRegistros();
    };


