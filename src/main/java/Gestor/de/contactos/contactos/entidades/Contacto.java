package Gestor.de.contactos.contactos.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity // se usa para definir una clase como una entidad de base de datos
@Table(name = "tbl_contacto")
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactoId;
    private String nombre;
    @Column(name = "email", unique = true)
    private String correo;
    private String telefono;

    /*@Setter
    @Getter
    public int getContactoId() {
        return contactoId;

    }
    @Setter
    public void setContactoId(int contactoId) {
        this.contactoId = contactoId;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContactoId() {
        return contactoId;
    }

    public void setContactoId(int contactoId) {
        this.contactoId = contactoId;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ID: " + contactoId +
                " | Nombre: " + nombre +
                " | Correo: " + correo +
                " | Teléfono: " + telefono;
    }
}



