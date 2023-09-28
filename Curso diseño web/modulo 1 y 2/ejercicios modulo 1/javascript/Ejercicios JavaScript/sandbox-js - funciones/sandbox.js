/*funciones*/

/*function nombreFun(x,y) {//funciones
    return x+y;
}

console.log(nombreFun(2,3));
*/

/*let lkup = prompt("Ecribe una fruta");//El prompt es una ventanita(Es como el JoptionPane de Java)
let lista = ["Pera", "Manzana", "Platano", "Fresa", "Kiwi"];

buscarFruta(lkup,lista);

function buscarFruta(x,y) {
    let i;
    for(i=0;i<y.length;i++){
        y[i]=x;
        console.log("Estado lista"+y);

    }
    return y;

}

*/
/*let params = prompt("Ecribe una fruta");

function name(param) {
    return param+"1";
}
console.log(name);
alert(name);
*/
/*let lista = ["Pera", "Manzana", "Platano", "Fresa", "Kiwi"];
console.log(longArray(lista));
function longArray(x){
    let cuenta=0;
    for(let i=0; i<999;i++){
        console.log(i);
        if (x[i]==undefined) {
            break;    
        }else{
            cuenta+=1;
        }
    }
    return cuenta;
}*/
/*let lkup = prompt("Ecribe un valor");
let resultado=[];
*/
/*function reverse(params) {
    for (let index = lkup.length; index >= 0; index--) {
    
        const element = lkup[index];
        resultado.push(element);  
        
    }
    return resultado.join("");
    
}
console.log(reverse(param));
*/
/*for (let index = 0; index < lkup.length; index++) {
    
    const element = lkup[index];
    resultado.push(element);      
}
console.log(resultado);
resultado.reverse();
resultado=resultado.join("");
console.log(resultado);*/
/*let lkup = prompt("Ecribe un valor");
console.log(lkup.split("").reverse().join(""));*/

/*function numVocales() {
    let texto = "Esto es un texto en una cadena de caractares" ;
    let cont=0;
    let vocales;
    //voacles=["a","e","i","o","u"];
    //vocales="aeiou";//como String
    //vocales= /[aeiou]/;//como patron
    
    for (let index = 0; index < texto.length; index++) {
            if(vocales.includes(texto[index].toLowerCase())){//nofuncioan con patron
            //if(texto[i].macth(vocales)!=null)){
            //if(texto[i].search(vocales)!==-1){
            //if(vocales.test(texto[i])){
            //if(vocales.exec(texto[i])!==null){
                cont++;    
            }  
    }
    console.log(cont);
}
console.log(numVocales());
*/


//console.log(cuadrado(param1, param2));
/*
//Dibuja un cuadrado
function cuadrado(x, y) {
let tamaño=10;
    for (let h = 0; h < tamaño; h++) {
        let filas=prompt("Escribe el numero de filas");
        let columnas=prompt("Escribe el numero de columnas");
        if (!isNaN(filas) || !isNaN(columnas)) {
            alert("uno o ambos valores no son numero. Volver a introducir valores. Intento " + (h+1)+"/5");
        }else{
            cuadrado(filas,columnas);
        }
    return filas;
    }
}


function cuadrado(x,y) {
    let simbolo="*";
}*/
