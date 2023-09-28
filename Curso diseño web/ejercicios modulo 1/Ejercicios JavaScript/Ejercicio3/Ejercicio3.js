let a =0;
let b =0;
let suma =0;
for(let i = 0;i<=400;i++){
//suma los multiplos de 3
    if(i%3==0|| i%7==0){

   
        suma+=i;
        console.log(suma);
   
    }
    //si quiero sumar tambien las que sean multiplos de 3 y de 7
    if(i%3==0&& i%7==0){

   
        suma+=i;
        console.log(suma);
   
    }




}