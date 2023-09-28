/*
let x=document.getElementsByClassName("texto");//pillo el elemento p
console.log(x);//si tengo una clase tengo que acceder a sus propiedades como si fuera un array x[0]
//pero si es en el caso del id entonces lo que tengo que hacer es ponerlo directamente ,id es mas concreto .
boton.onclick = function(){
    
    texto.style.fontFamily="Arial";
    texto.style="color:blue";
    console.log("colocambiado");

};
*/
//solucion 



let x;
x=document.querySelector("p#texto");//selecciona el p con la clase texto
console.log(x);
//boton.setAttribute("onclick","CambiarEstilo()");
boton.addEventListener("click",CambiarEstilo);
boton.addEventListener("mouseleave",document.removeEventListener);
function CambiarEstilo(){
//x.style.fontFamily="Arial";//que es equivalente a x.style="font-family:'Arial'";
//
//x.style.color="blue";//que es equivalente a x.style=fontFamily:Arial;
//al hacer style cojo todo lo que haga dentro de style y sobreescribe sobre ello.
x.style="font-family:Arial;color:blue";
}
/*
si tengo varios p sería 
let x=document.querySelectorAll(p.texto)//selecciona el p con la clase texto
console.log(x);
function CambiarEstilo(){
 
    for (let i in x) {
        x[i].style.fontFamily=Arial;//que es equivalente a x.style=fontFamily:Arial;
         x[i].style.color=blue;//que es equivalente a x.style=fontFamily:Arial;
    }
    o tambien con un for each
    x.forEach(i => {
        i.style.fontFamily="Arial";
        i.style.color="blue";
        
    });
}
*/
