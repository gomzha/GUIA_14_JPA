package com.gomzha.servicio;

import com.gomzha.entidad.Autor;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.Scanner;

public class ServicioJPAAutor {
    Scanner leer;
    EntityManager em;

    public ServicioJPAAutor() {
        em = Persistence.createEntityManagerFactory("pruebaPU").createEntityManager();
        leer = new Scanner(System.in).useDelimiter("\n");
    }


    public void persist(Autor autor) {
        em.getTransaction().begin();
        System.out.println("llego");
        em.persist(autor);
        em.getTransaction().commit();
    }

    public void remove(Autor autor) {
        try{
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ERROR DE BORRADO DE REGISTRO: " + e.getMessage());
            em.getTransaction().rollback();

        }
    }

    public Collection<Autor> selectAll() {
        return (Collection<Autor>) em.createQuery("select t from Autor t").getResultList();
    }
}
