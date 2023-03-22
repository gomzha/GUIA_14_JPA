package com.gomzha.servicio;

import com.gomzha.entidad.Autor;
import com.gomzha.entidad.Editorial;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ServicioEditorial {
    Scanner leer;
    EntityManager em;
    public ServicioEditorial() {
         em = Persistence.createEntityManagerFactory("pruebaPU").createEntityManager();
        leer = new Scanner(System.in).useDelimiter("\n");
    }
    public void crearEditorial() {
        Editorial editorial = new Editorial();
        System.out.println("Ingrese el nombre de la editorial");
        editorial.setNombre(leer.next());
        editorial.setAlta(true);
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();

    }


    public Editorial elegirEditorial() {
        int indice, num = 1;
        ArrayList<Editorial> editorialArrayList = new ArrayList<>(mostrarEdotoriales());

        System.out.println("Editorial:");
        for (Editorial editorial : editorialArrayList) {
            System.out.println(num + "- Editorial: " + editorial.toString());
            num++;
        }
        System.out.println("Seleccione el ID que desea seleccionar:");
        indice = leer.nextInt()-1;
        return editorialArrayList.get(indice);
    }
    public Collection<Editorial> mostrarEdotoriales() {
        return (Collection<Editorial>) em.createQuery("select t from Editorial t").getResultList();

    }
}
