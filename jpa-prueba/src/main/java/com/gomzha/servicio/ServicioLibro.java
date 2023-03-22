package com.gomzha.servicio;

import com.gomzha.entidad.Editorial;
import com.gomzha.entidad.Libro;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ServicioLibro {

    Scanner leer;
    EntityManager em;

    public ServicioLibro() {
        em = Persistence.createEntityManagerFactory("pruebaPU").createEntityManager();
        leer = new Scanner(System.in).useDelimiter("\n");
    }

    public void crearLibro() {
        Libro libro = new Libro();
        System.out.println("Ingrese el título del libro");
        libro.setTitulo(leer.next());
        System.out.println("Ingrese el año");
        libro.setAnio(leer.nextInt());
        System.out.println("Ingrese cantidad total de ejemplares");
        libro.setEjemplares(leer.nextInt());
        System.out.println("Ingrese cantidad total de ejemplares prestados");
        libro.setEjemplaresPrestados(leer.nextInt());
        System.out.println("Ingrese cantidad total de ejemplares restantes");
        libro.setEjemplaresRestantes(leer.nextInt());
        libro.setAlta(true);
        ServicioAutor autor = new ServicioAutor();
        libro.setAutor(autor.elegirAutor());
        ServicioEditorial editorial = new ServicioEditorial();
        libro.setEditorial(editorial.elegirEditorial());

        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();

    }

    public void busquedaPorIDBN() {
        long isbn;
        System.out.println("Ingresar isbn:");
        isbn = leer.nextLong();
        Libro libro = em.find(Libro.class, isbn);
        try {
            System.out.println("Libro: " + libro.toString());

        } catch (NullPointerException e) {
            System.out.println("No se encontró el libro");
        }

    }

    public void editarLibro() {
        mostrarLibros();
        System.out.println("Ingrese el ISBN a modificar: ");
        Long isbn = leer.nextLong();
        Libro libro = em.find(Libro.class,isbn);
        try {
            System.out.println("Libro: " + libro.toString());
            System.out.println("Ingrese la cantidad de ejemplares nuevamente: ");
            Integer ejemplares = leer.nextInt();
            libro.setEjemplares(ejemplares);
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();

        } catch (NullPointerException e) {
            System.out.println("No se encontró el libro");
        }



    }

    public void mostrarLibros() {
        ArrayList<Libro> libroArrayList = new ArrayList<Libro>(em.createQuery("select t from Libro t").getResultList());

        if (!libroArrayList.isEmpty()) {
            for (Libro libro : libroArrayList) {
                System.out.println("Libro: " + libro.toString());
            }
        }else System.out.println("No existe libros");
    }

    public void borrarLibro() {

        mostrarLibros();
        System.out.println("Ingrese el ISBN a borrar: ");
        Long isbn = leer.nextLong();

        try {
            Libro libro = em.find(Libro.class,isbn);
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("No se encontró el libro");
        }


    }
}
