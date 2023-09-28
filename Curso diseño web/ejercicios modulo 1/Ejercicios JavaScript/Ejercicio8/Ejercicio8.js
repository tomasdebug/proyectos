/*
5.Escribe una funcion que nos muestre una cantidad de dinero separada en billetes y monedas(sin decimales).
Entrada:179
Salida:1billete de 100€,1 billete de 50€,1billete de 20€,1billete de 5€,2monedas de 2€
*/
let cambio;

cambio=prompt("¿Que valor quieres que cambiar?");
if(isNaN(cambio)){
console.log("por favor escribe un numero");

}else{

    GenerarCambio(cambio);
}
function GenerarCambio(cambio) {
    let billetes100=0;//va a ser mi contador para los billetes de 100
    let billetes50=0;//va a ser mi contador para los billetes de 100
    let billetes20=0;//va a ser mi contador para los billetes de 100
    let billetes5=0;//va a ser mi contador para los billetes de 100
    let monedas2=0;//va a ser mi contador para los billetes de 100
   while(cambio!=0){
        if(cambio>=100){
        cambio-=100;
        billetes100++;
        }
        else if(cambio>=50){
            cambio-=50;
            billetes50++;
        }
        else if(cambio>=20){

            cambio-=20;
            billetes20++;
        }
        else if(cambio>=5){
            cambio-=5;
            billetes5++;

        }
        else if(cambio>=2){
            cambio-=2;
            monedas2++;
        }else{
            console.log("JODETE ME COMÍ EL DINERO")
        }
    
    
    }
    console.log("Se usaran: "+ billetes100+ " billetes de 100 "+ billetes50+" billetes de 50 "+billetes20+" billetes de 20 "+ billetes5+" billetes de 5 "+ monedas2+" monedas de 2.");

}