#include <stdio.h>
#include "Tipo_avion.h"
const int MaxVuelos = 20;
typedef Tipo_avion Tipo_lista_vuelos[ MaxVuelos ];
static Tipo_lista_vuelos lista_vuelos;
void ImprimirVuelos(){
printf( "LISTA DE VUELOS: \n" );
for( int i = 0; i < MaxVuelos; i++ ){
printf( "Avion %d: \n", i );
printf( "Rumbo: " );
switch( lista_vuelos[i].LeerRumbo() ) {
case Norte: printf( "Norte \n" ); break;
case Sur: printf( "Sur \n" ); break;
case Este: printf( "Este \n" ); break;
case Oeste: printf( "Oeste \n" ); break;
}
printf( "Altitud: %.4f \n", lista_vuelos[i].LeerAltura() );
printf( "Velocidad: %.1f \n", lista_vuelos[i].LeerVelocidad() );

}
printf( "FIN DE LISTA." );
}
