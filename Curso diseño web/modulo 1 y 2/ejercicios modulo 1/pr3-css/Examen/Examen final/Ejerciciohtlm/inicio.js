//AL HACER DOBLE CLICK HACER DESAPARECER LA IMAGEN


img1.addEventListener("dblclick",remover);
img2.addEventListener("dblclick",remover);
img3.addEventListener("dblclick",remover);
img4.addEventListener("dblclick",remover);
img5.addEventListener("dblclick",remover);
img6.addEventListener("dblclick",remover);
    
function remover() {
      this.src="";
      console.log(this +"eliminada");
      
    }