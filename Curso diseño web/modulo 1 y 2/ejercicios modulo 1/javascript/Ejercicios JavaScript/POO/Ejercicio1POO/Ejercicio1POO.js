
/*
//PERTENECE A LA LIBRERIA OBJETO
Let vehiculo=Object.keys(coche);//devuelve el nombre de la propiedad
vehiculo=Object.values(coche);//devuelve los valores
let Objetocopia=Object.create(objeto)
Objetct.assign(objetoCopia,objeto)//meto en el primero las propiedades del segundo ,si alguno coincide en key lo sobreescribe,el primer objeto conserva sus propiedades 

*/
 //EJERCICIO1
let objeto={
    x:"hola",
    y:"caracola",
    z:"adios",
}
let objetoCopia=copiarObjeto(objeto);
console.log(objetoCopia);
let objetoCopia2=copiarObjeto(objeto,["x","y"]);//copiame este objeto solamente con estos dos.No puedo inicializarlo allí
console.log(objetoCopia2);

function copiarObjeto(objeto,claves){
let objetoCopia={};//lo inicializo vacio
//si tenemos un segundo parametro, es decir claves
if(claves){//claves son las propiedades que tiene cada objeto ,arriba se ve que se pueden poner las claves
    console.log("con propiedades");
    for(let clave in claves){//me va a recorrer el array que le he puesto en claves ,sacando cada clave
          
            //console.log("CLAVES: "+ claves[clave]);
            //console.log("CLAVE: "+ clave);//me esta sacando posiciones,eso valdría si fuera un array ,pero como es un objeto y en vez de ver 0,1,2... ve x,y,z...
           // console.log("OBJETO: "+ objeto[claves[clave]]);//para sacar la posicion del objeto saco del array su posicion 
            //clave=0 de ahí la posicion 0 en el array es x y el objeto[x] u objeto.x da su valor me da 1
           // objetoCopia.push(objeto[claves[clave]]); el push es solamente para arrays es igual a una pila necesita tener un indice
            objetoCopia[claves[clave]]=objeto[claves[clave]];
        }
        return objetoCopia;
   
    }else{
        console.log("sin propiedades");

        return Object.assign(objetoCopia,objeto);
    }

}

/*
//const array = [x="hola ",y="caracola",z="adios"];se puede hacer con un array
const array = {x:"hola ",y:"caracola",z:"adios"};//o con un objeto ,las propiedades de un objeto son equivalentes a las que habría en un array
for(let i in array){

    console.log(i);
    console.log(array[i]);
}
*/