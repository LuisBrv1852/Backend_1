package com.ejemplo1.Ejemplo1.controllers;
import com.ejemplo1.Ejemplo1.models.UsusarioModel;
import com.ejemplo1.Ejemplo1.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController //indicar a aspring que va a controlar
@RequestMapping("/usuario")  //en que direccion del servidor se activira la clase, en este caso
// el nombre de la tabla que renombraamos en UsusuarioModel como usuario
public class UsusarioController {
    @Autowired//con esto ya no tenemos que instanciar spring lo hace de manera automatica
    // marca error hasta que definamos la variable
    UsuarioService usuarioService; //definimos variable tipo UsuarioService

    @GetMapping() //cuando llegue una peticion ejecute este metodo
    //ahora declaramos nuestro metodo tipó ArrayList de la clase UsusuarioModel nombre del metodo
    public ArrayList<UsusarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
 //return variableUsuarioService .metodoObtenerDeLaClaseService
        }

        @PostMapping() //para mostrar los valores que ya estan guarados en la base de datos
 // public de la clase UsusuarioModel nombre del metodo
    public  UsusarioModel guardarUsuario(@RequestBody UsusarioModel usuario){
 //RequestBody para indicar que todos los clientes pueden mandar dentro del cuerpo solicitud http
         return this.usuarioService.guardarUsuario(usuario);
 //return this.varibleUsuarioService.metodoGuardarDeLaClaseService
        }

@GetMapping (path ="/{id}") // para que busque pero tomara el camino por la id
// public Optional<clase UsusuarioModel> nombrMetodo (@PathVariable ("nombreColumna") tipoDato nombreColumna){
public Optional<UsusarioModel> obtenerUsusrioPorId (@PathVariable ("id") Long id){
        return this.usuarioService.obtenerPorId(id);
        //return this.ClaseServicio.nombremetodo(nombrecolumna)
}

@GetMapping (path="/query") // para que busque pero tomara el camino otro servicio
//public ArrayList <clase UsusuarioModel> nombrMetodo (@RequestParam ("nombreColumna") tipoDato nombreColumna){
public ArrayList<UsusarioModel> obtenerUsusrioPorPrioridad (@RequestParam ("prioridad") Integer prioridad){
       return this.usuarioService.obtenerPorPrioridad(prioridad);
    //return this.ClaseServicio.nombremetodo(nombrecolumna)
 }
 //en este caso @RequestParam indica que el camino que buscara sera por prioridad en este caso

@DeleteMapping (path="/{id}") //para borrar por id
//public String nombreMetodo (@PathVariable ("nombreColumna") tipoDato nombreColumna){
public String eliminarPorId (@PathVariable("id") Long id){
// declaramos boolean nombreVariable = this.ClaseServicio.nombremetodo(nombrecolumna)
 boolean ok = this.usuarioService.eliminarUsuario(id);
 //condiciones si es
 if(ok){ //true
   return "Se elimino el usuario con id "+ id;
   }else{ //false
     return "No pudo eliminar el usuario con id"+ id;
   }

 }

}
