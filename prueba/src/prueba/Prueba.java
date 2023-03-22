/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author A308443
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManager em = Persistence.createEntityManagerFactory("pruebaPU").createEntityManager();
        
        em.getTransaction().begin();
     
     
    }
    
}
