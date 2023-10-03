package com.ejemplo1.Ejemplo1.models;
import jakarta.persistence.*;
// podemos colocar  import jakarta.persistence.*; en lugar de importar cada libreria que necesitmos

@Entity //para decir que es un modelo real o una entidad
@Table(name="usuario") //redefinimos el nombre de la tabla
public class UsusarioModel { //si no colocamos @Table el nombre seria UsuarioModel
    //definimos las columnas de nuestra tabla
    @Id  // decimos que la variable que sigue es una ID
    // que genero los valores la estrategia sera generar automaticamente tipo identidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // el valor generado en esta columna sera unico (verdero) y  nulo (falso) es decir
    // no puede estar vacio
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String email;
    private Integer prioridad;
    //realizamos los getter y setter de cada uno
    //get de id
    public Long getId() {
        return id;
    }
    //set de id
    public void setId(Long id) {
        this.id = id;
    }
    //get de nombre
    public String getNombre() {
        return nombre;
    }
    //set de nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //get de email
    public String getEmail() {
        return email;
    }
    //set de email
    public void setEmail(String email) {
        this.email = email;
    }
    //get de prioridad
    public Integer getPrioridad() {
        return prioridad;
    }
    //set de prioridad
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

}
