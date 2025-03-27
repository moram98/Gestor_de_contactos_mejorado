package Gestor.de.contactos.contactos.service;

import Gestor.de.contactos.contactos.entidades.Contacto;

import java.util.List;

public interface ContactoService {
    List<Contacto> listarContactos();
    Contacto obtenerContactoPorId(int id);
    Contacto agregarContacto(Contacto contacto);
    Contacto actualizarContacto(int id, Contacto contacto);
    void eliminarContacto(int id);
}
