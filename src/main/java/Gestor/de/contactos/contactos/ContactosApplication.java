package Gestor.de.contactos.contactos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static java.awt.SystemColor.menu;

@SpringBootApplication
public class ContactosApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ContactosApplication.class, args);

		Principal principal = context.getBean(Principal.class); // Inyección de dependencia
		principal.menu(); // Llamamos al menú después de que Spring haya cargado los Beans
	}
}