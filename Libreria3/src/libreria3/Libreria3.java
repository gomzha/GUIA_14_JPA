/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreria3;

import Entidad.Autor;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author A308443
 */
public class Libreria3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         EntityManager em = Persistence.createEntityManagerFactory("pruebaPU").createEntityManager();
        Autor autor = new Autor();
        autor.setAlta(true);
        autor.setNombre("pepe2");
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        System.out.println("autor: " + autor.toString() );
         autor = new Autor();
        autor.setAlta(true);
        autor.setNombre("pepe2");
            em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
                 autor = new Autor();
        autor.setAlta(true);
        autor.setNombre("pepe2");
                    em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
                 autor = new Autor();
        autor.setAlta(true);
        autor.setNombre("pepe2");
                    em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
                    em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
                    em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
                    em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        
    
    
    }
    
}
