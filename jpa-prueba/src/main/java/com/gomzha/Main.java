package com.gomzha;

import com.gomzha.entidad.Autor;
import com.gomzha.servicio.ServicioAutor;
import com.gomzha.servicio.ServicioEditorial;
import com.gomzha.servicio.ServicioLibro;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String opcion;
        Boolean bucle = false;
        ServicioAutor servicioAutor = new ServicioAutor();
        ServicioLibro servicioLibro = new ServicioLibro();
        ServicioEditorial servicioEditorial = new ServicioEditorial();

        do {
            System.out.println("_____________________________________________________");
            System.out.println("Ingresar una opción: ");
            System.out.println("a) Crear una Editorial."); // listo
            System.out.println("b) Crear un Libro."); // listo
            System.out.println("c) Crear un Autor."); // listo
            System.out.println("d) Buscar un Autor por nombre.");
            System.out.println("e) Buscar un libro por ISBN");
            System.out.println("f) Editar un libro.");
            System.out.println("g) Eliminar un libro.");
            System.out.println("h) Eliminar un autor.");
            System.out.println("i) Salir del programa.");

            opcion = leer.next();
            switch (opcion) {
                case "a": {
                    System.out.println("Usted eligió la opcion 1.");
                    servicioEditorial.crearEditorial();
                    break;
                }
                case "b": {
                    System.out.println("Usted eligió la opcion 2.");
                    servicioLibro.crearLibro();

                    break;
                }
                case "c": {
                    System.out.println("Usted eligió la opcion 3.");
                    servicioAutor.crearAutor();

                    break;
                }
                case "d": {
                    servicioAutor.busquedaPorNombre();
                    break;
                }
                case "e": {
                    servicioLibro.busquedaPorIDBN();
                    break;
                }
                case "f": {
                    servicioLibro.editarLibro();
                    break;
                }
                case "g": {
                    System.out.println("Usted eligió la opcion ingresar un fabricante.");
                    servicioLibro.borrarLibro();

                    break;
                }
                case "h": {
                    System.out.println("Usted eligió la opcion editar producto.");
                    servicioAutor.borrarAutor();

                    break;
                }
                case "i": {
                    System.out.println("Se sale del programa!");
                    bucle = true;
                    break;
                }

                default: {
                    System.out.println("Opcion incorrecta");
                }

            }//cierra SWITCH

        } while (!bucle);

    }
}
