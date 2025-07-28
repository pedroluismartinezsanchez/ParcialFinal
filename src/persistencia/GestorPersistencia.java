/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia {

    private static GestorPersistencia instancia;

    private GestorPersistencia() {
        // Constructor privado para patrón Singleton
    }

    public static GestorPersistencia getInstance() {
        if (instancia == null) {
            instancia = new GestorPersistencia();
        }
        return instancia;
    }

    // Método genérico para guardar una lista de objetos en un archivo
    public <T> void guardar(String rutaArchivo, List<T> lista) {
        File archivo = new File(rutaArchivo);
        archivo.getParentFile().mkdirs();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar en archivo: " + rutaArchivo);
            e.printStackTrace();
        }
    }

    // Método genérico para cargar una lista de objetos desde un archivo
    @SuppressWarnings("unchecked")
    public <T> List<T> cargar(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Error al cargar desde archivo: " + rutaArchivo);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public <T> List<T> leer(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return new ArrayList<>(); // si el archivo no existe, retorna lista vacía
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public <T> void escribir(String rutaArchivo, List<T> datos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(datos);
        } catch (IOException e) {
            System.err.println("Error al escribir archivo: " + e.getMessage());
        }
    }

    public static GestorPersistencia getInstancia() {
        if (instancia == null) {
            instancia = new GestorPersistencia();
        }
        return instancia;
    }

    public static void setInstancia(GestorPersistencia instancia) {
        GestorPersistencia.instancia = instancia;
    }
    
    
}
