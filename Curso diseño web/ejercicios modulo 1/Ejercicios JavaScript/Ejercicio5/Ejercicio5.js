
/*
    Escribe un bucle que muestre del 1 al 20 e indique seguidamente si es impar o par

*/ 
for(let i=1;i<50;i++){

//indicar si es par o impar
    if(i%3==0){

    console.log(i+" es multiplo de 3"); 

    if(i%2==0){

        console.log(i+" es par");
    }
    
    else{
        console.log(i+" es impar");
      
    }
}   

}
let multi=3;
/*otra forma 
for(let i=multi;i<50;i+=multi){
console.log(i+ `es multiplo de ${multi}`)//el dolar es para escapar de las comillas  llamar a multi equivalente a i+"es multiplo de "+ muti.

    if(i%2==0){

        console.log(i+" es par");
    }
    
    else{
        console.log(i+" es impar");
      
    }
*/