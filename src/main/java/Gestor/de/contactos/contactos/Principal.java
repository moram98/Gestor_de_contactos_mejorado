package Gestor.de.contactos.contactos;

import Gestor.de.contactos.contactos.entidades.Contacto;
import Gestor.de.contactos.contactos.service.ContactoService;

import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  // Para que Spring lo gestione
public class Principal{

    @Autowired
    private ContactoService contactoService; // Inyección del servicio

    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;
        do {
            System.out.println("\n********************** MENÚ GESTOR DE CONTACTOS ******************");
            System.out.println("1- Agregar contacto");
            System.out.println("2- Listar contactos");
            System.out.println("3- Editar contacto");
            System.out.println("4- Eliminar contacto");
            System.out.println("0- Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    listarContactos();
                    break;
                case 3:
                    editarContacto();
                    break;
                case 4:
                    eliminarContacto();
                    break;
                case 0:
                    System.out.println("👋 Saliendo...");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private void agregarContacto() {
        System.out.println("🔹 Agregar nuevo contacto:");
        System.out.println("Ingrese nombre del contacto:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese correo del contacto:");
        String correo = sc.nextLine();

        System.out.println("Ingrese teléfono del contacto:");
        String telefono = sc.nextLine();

        Contacto nuevoContacto = new Contacto();
        nuevoContacto.setNombre(nombre);
        nuevoContacto.setCorreo(correo);
        nuevoContacto.setTelefono(telefono);

        Contacto contactoGuardado = contactoService.agregarContacto(nuevoContacto);
        System.out.println("Contacto agregado: " + contactoGuardado);
    }

    private void listarContactos() {
        List<Contacto> contactos = contactoService.listarContactos();

        if (contactos.isEmpty()) {
            System.out.println("No hay contactos guardados.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contacto c : contactos) {
                System.out.println(c); // Se usará el `toString()` que creamos antes
            }
        }
    }

    private void editarContacto() {
        System.out.print("Ingrese el ID del contacto que desea editar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        Contacto contactoExistente = contactoService.obtenerContactoPorId(id);
        if (contactoExistente == null) {
            System.out.println("Contacto no encontrado.");
            return;
        }

        System.out.println("📌 Contacto encontrado: " + contactoExistente);
        System.out.println("**********Ingrese los nuevos datos (deje vacío si no quiere modificar):**********");

        System.out.print("Nuevo nombre: ");
        String nuevoNombre = sc.nextLine();
        if (!nuevoNombre.isEmpty()) {
            contactoExistente.setNombre(nuevoNombre);
        }

        System.out.print("Nuevo correo: ");
        String nuevoCorreo = sc.nextLine();
        if (!nuevoCorreo.isEmpty()) {
            contactoExistente.setCorreo(nuevoCorreo);
        }

        System.out.print("Nuevo teléfono: ");
        String nuevoTelefono = sc.nextLine();
        if (!nuevoTelefono.isEmpty()) {
            contactoExistente.setTelefono(nuevoTelefono);
        }

        contactoService.actualizarContacto(id, contactoExistente);
        System.out.println("Contacto actualizado con éxito.");
    }

    private void eliminarContacto() {
        System.out.print("Ingrese el ID del contacto que desea eliminar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        Contacto contacto = contactoService.obtenerContactoPorId(id);
        if (contacto == null) {
            System.out.println("❌ Contacto no encontrado.");
            return;
        }

        System.out.println("📌 Contacto encontrado: " + contacto);
        System.out.print("¿Está seguro de que desea eliminar este contacto? (S/N): ");
        String confirmacion = sc.nextLine().trim().toLowerCase();

        if (confirmacion.equals("s")) {
            contactoService.eliminarContacto(id);
            System.out.println("✅ Contacto eliminado con éxito.");
        } else {
            System.out.println("❌ Eliminación cancelada.");
        }
    }
}