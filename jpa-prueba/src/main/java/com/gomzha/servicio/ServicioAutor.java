package com.gomzha.servicio;

import com.gomzha.entidad.Autor;
import com.gomzha.entidad.Libro;
import org.eclipse.persistence.exceptions.DatabaseException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.lang.reflect.Array;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ServicioAutor {

    Scanner leer;
    EntityManager em;
    ServicioJPAAutor servicioJPAAutor;

    public ServicioAutor() {
        em = Persistence.createEntityManagerFactory("pruebaPU").createEntityManager();
        leer = new Scanner(System.in).useDelimiter("\n");
        servicioJPAAutor = new ServicioJPAAutor();
    }

    public void crearAutor() {
        Autor autor = new Autor();
        System.out.println("Ingrese el nombre del Autor");
        autor.setNombre(leer.next());
        autor.setAlta(true);
        servicioJPAAutor.persist(autor);
//        em.getTransaction().begin();
//        em.persist(autor);
//        em.getTransaction().commit();
    }

    public Autor elegirAutor() {
        int indice, num = 1;

        ArrayList<Autor> autorCollection = new ArrayList<>(mostrarAutores());

        System.out.println("Autores:");
        for (Autor autor : autorCollection) {
            System.out.println("Opc " + num + "- Autor: " + autor.getNombre());
            num++;
        }
        System.out.println("Seleccione el ID que desea seleccionar:");
        indice = leer.nextInt() - 1;
        try {
            return autorCollection.get(indice);
        }catch (IndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("No existe esa opción");
            return null;
        }
    }

    public Collection<Autor> mostrarAutores() {
//        Collection<Autor> autorCollection = servicioJPAAutor.selectAll();
//        return (Collection<Autor>) em.createQuery("select t from Autor t").getResultList();
        return servicioJPAAutor.selectAll();
    }

    public void busquedaPorNombre() {

        System.out.println("Ingrese el nombre y el sistema le informará los registros que contiene el nombre ingresado.");
        String nombreAutor = leer.next();
        //String nombreAutor = "nza";
        System.out.println("nombre " + nombreAutor);
        List<Libro> autorCollection = em.createQuery("select t from Libro t WHERE t.autor.nombre LIKE :nombre").setParameter("nombre", "%" + nombreAutor + "%").getResultList();
        if (!autorCollection.isEmpty()) {
            System.out.println("Autores:");
            for (Libro libro : autorCollection) {
                System.out.println("Libro: " + libro.toString());
            }
        } else System.out.println("No hay registros");

    }

    public void borrarAutor() {
        servicioJPAAutor.remove(elegirAutor());
    }
}
