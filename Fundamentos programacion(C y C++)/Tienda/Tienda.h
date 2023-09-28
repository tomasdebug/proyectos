#pragma once
typedef enum Tipo_Producto{aliment,vestido,menaje,electron};
typedef struct Tipo_Articulo{
  int codigo;
  float precio,peso;
  Tipo_Producto producto;
};
const int MaxArt=10;
typedef Tipo_Articulo Articulo[MaxArt];
typedef struct ListaCompra{
  void CargarCesta(Tipo_Articulo Art[],int &max);
  float TotalPrecio(Tipo_Articulo Art[],int &max);
  bool Peso(Tipo_Articulo Art[],int &max);
  bool TipoArticulos(Tipo_Articulo Art[],int &max);
  };
