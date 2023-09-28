#include "Tienda.h"
#include <stdio.h>
void ListaCompra::CargarCesta(Tipo_Articulo Art[],int &max){
  scanf("%d",&Art[max].codigo);
  scanf("%f",&Art[max].precio);
  scanf("%f",&Art[max].peso);
  scanf("%d",&Art[max].producto);
  max++;
  }
  float ListaCompra::TotalPrecio(Tipo_Articulo Art[],int &max){
    float Total=0.0;
    for (int j=0;j<max;j++){
      Total=Total+Art[j].precio;
      }
      return Total;
    }
  bool ListaCompra::Peso(Tipo_Articulo Art[],int &max){
    float pesoT=0.0;
    float comprobar;
    scanf("%f",&comprobar);
    for(int j=0;j<max;j++){
      pesoT=pesoT+Art[j].peso;
      }
      printf("---->Tl PESO: %.2f\n",pesoT);
      if(pesoT>comprobar){
        return false;
        }else{
      return true;
        }
    }
  bool ListaCompra::TipoArticulos(Tipo_Articulo Art[],int &max){
    Tipo_Producto comparar;
    bool SiSon=true;
    scanf("%d",&comparar);
    for(int j=0;j<max;j++){
      if(Art[j].producto==comparar){
        return SiSon;
        }else{
          return false;
          }
      }
    }
