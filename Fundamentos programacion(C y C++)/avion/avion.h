#pragma once
typedef enum Tipo_rumbo = {Norte, Sur, Este, Oeste};
typedef Struct Tipo_avion{
Tipo_rumbo LeerRumbo();
float LeerAltura();
float LeerVelocidad();
private:

Tipo_rumbo rumbo;
float velocidad, altura;
};
