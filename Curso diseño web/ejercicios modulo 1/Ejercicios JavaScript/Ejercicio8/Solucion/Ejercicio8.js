/*
5.Escribe una funcion que nos muestre una cantidad de dinero separada en billetes y monedas(sin decimales).
Entrada:179
Salida:1billete de 100€,1 billete de 50€,1billete de 20€,1billete de 5€,2monedas de 2€
*/
/*
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
            console.log("JODETE ME COMÍ EL DINERO");
            cambio=0;
        }
    
    
    }
    console.log("Se usaran: "+ billetes100+ " billetes de 100 "+ billetes50+" billetes de 50 "+billetes20+" billetes de 20 "+ billetes5+" billetes de 5 "+ monedas2+" monedas de 2.");

}
*/
let dinero=prompt("introduce la cantidad de dinero: ");

let salida=[];

function ContarDinero(entrada) {
    
    const billetes=[500,200,100,50,20,10,5,2,1];
    let conteo=[];
    dinero=parseInt(entrada);//convierte el string en numero
    for (let i = 0; i<billetes.length;i++){
  
    if(dinero>=billetes[i]){
      conteo[i]=parseInt(dinero/billetes[i]);//el parseInt quita los decimales
      dinero-=conteo[i]*billetes[i];//resta el numero de billetes que te han quedado
      
    }
        /*
        if(conteo[i]>=1){

           console.log(conteo[i] +" billetes de "+ billetes[i]);
         } 
        esto funciona pero no tiene en cuenta los plurales y los singulares
         */
    }

    for(i=0;i<billetes.length;i++){
       
            if(conteo[i]!=undefined){//saca cuando es un billete
                if(i<7){//si es un billete

                    if(conteo[i]==1){//si unicamente tengo un billete
                        salida.push(conteo[i]+ " billete de " +billetes[i]);

                    }else{//si tengo varios

                        salida.push(conteo[i]+ " billetes de " +billetes[i]);
                        
                    }
                }//si es una moneda
                    else{
                        if(conteo[i]==1){//si tengo una moneda
                            salida.push(conteo[i] + " moneda de "+ billetes[i]);

                        }
                        else{//si tengo varias

                            salida.push(conteo[i] + " monedas de "+ billetes[i]);
                        }


                    }

               
                        
    return entrada +" € se compone de "+ salida.join(", ");//une toda lo que le meto a la salida .Mete todo el array en una sola cadena ,es una conquetenacion
            }
        
    }

                  
}
console.log(ContarDinero(dinero));
         

        
 

 
   





    
