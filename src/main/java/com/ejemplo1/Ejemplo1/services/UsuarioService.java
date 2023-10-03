package com.ejemplo1.Ejemplo1.services;
import com.ejemplo1.Ejemplo1.models.UsusarioModel;
import com.ejemplo1.Ejemplo1.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service // colocamos service para indicar que la clase es servicio
public class UsuarioService {
    @Autowired //con esto ya no tenemos que instanciar spring lo hace de manera automatica
    // marca error hasta que definamos la variable
    UsuarioRepository usuarioRepository; //definimos una variable tipo UsuarioRepositorio
//para este caso la variable se llama usuarioRepository

 //definimos un metodo tipo ArrayList por lo que tendra que regresar un valor igual
    public ArrayList <UsusarioModel> obtenerUsuarios(){ // el metodo se llama obtenerUsusario
        return (ArrayList<UsusarioModel>) usuarioRepository.findAll();
     //return tipoDeDato VariableTipoRepositorio .accionAEjecutar();
     //find all es para encontrar todos los registros podemos elegir la opcion que necesitemos
    }

 //metodo para guardar usuarios en este caso sera tipo UsusarioModel
 //nombre del metodo guardar usuauri en parentesis definimos una variable tipo UsusuarioModel
    public UsusarioModel guardarUsuario(UsusarioModel usuario){
        return usuarioRepository.save(usuario);
 //return variableTipoRepositorio .save(varibleDefinidaParaElMetodo);
    }

    // este metdo es el mas comun , por lo que lo dejamos opcional
    // al tratarse de un metodo comun no tuvimos que definirlos en la interfaz de repositorio por que ya
    // lo trabaja spring
    //public Optional<claseUsuarioModel> nombre metodo (tipoDato nombreColumna)
    public Optional<UsusarioModel> obtenerPorId(Long id){
         return usuarioRepository.findById(id);
        //return variableTipoRepositorio . findById(nombreColumna)
    }

    //ahora el metodo que definimos en la interfaz
    //public tipoDeDato<claseUsuarioModel> nombre metodo (tipoDato nombreColumna)
    public ArrayList<UsusarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
        //return variableTipoRepositorio . findByPrioridad(nombreColumna)
    }

    //declaramos metodo para borrar tipó boolean
    // deletedById al tratarse de un metodo comun no tuvimos que definirlos en la interfaz
    // de repositorio por que ya lo trabaja spring
    // public boolean nombremetodo (tipoDato nombreColumna)
    public boolean eliminarUsuario(Long id){
     //colocamos un try y catch ya que puede causar un error si falla
        try{
            // si sucede borra el usuario por la id
            usuarioRepository.deleteById(id);
         //variableTipoRepositorio .deletById
            return true;
        }catch(Exception err){
            return false;
        }
        //si se borra manda verdadero, si no existe o no ya se borro manda false
    }
}
