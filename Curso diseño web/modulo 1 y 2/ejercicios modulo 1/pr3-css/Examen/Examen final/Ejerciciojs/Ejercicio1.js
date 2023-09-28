let x,y,numero1,numero2,resultado;
x=prompt("¿Numero 1?");
y=prompt("¿Numero2?");
numero1=parseInt(x);
numero2=parseInt(y);
Sumar(numero1,numero2);
function Sumar(numero1,numero2) {
  console.log(numero1);
  console.log(numero2);
  if(isNaN(numero1)|| isNaN(numero2)){
    alert("error");
  }
    if(numero1%2==0){
        numero1++;
        console.log(numero1);
    }
    if(numero2%2==0){
        numero2++;
        console.log(numero2);
    }
    resultado=(numero1+numero2)/2;
    console.log(resultado);
}
