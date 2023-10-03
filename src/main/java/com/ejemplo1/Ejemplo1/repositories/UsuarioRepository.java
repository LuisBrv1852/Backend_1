package com.ejemplo1.Ejemplo1.repositories;
import com.ejemplo1.Ejemplo1.models.UsusarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository //colocamos repository para indicar la funcion de la interfaz
public interface UsuarioRepository extends CrudRepository<UsusarioModel, Long> {
// extends CrudRepository de dodne heredaremos las funciones
// entre <> <nombreClaseModelo, tipoDato>
    //aclaro otra vez escribi mal usuario en su lugar puse Ususario

    //declaramos un public abstract ArratList<nombreClaseModelo> nombreMetodo (TipoDeDato nombreColumna)
    public abstract ArrayList<UsusarioModel> findByPrioridad(Integer prioridad);
    //mientras declaremos que es un metodo abstracto spring boot se encarga del resto
    //tambien podriamos hacer de findByNombre o findByEmail, etc
}
