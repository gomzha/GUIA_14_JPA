package com.gomzha.entidad;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "editorial")
public class Editorial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Editorial_SEQ")
    @SequenceGenerator(name = "Editorial_SEQ")
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nombre;
    private boolean alta;

    public Editorial() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Editorial(Integer id, String nombre, boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alta=" + alta +
                '}';
    }

}