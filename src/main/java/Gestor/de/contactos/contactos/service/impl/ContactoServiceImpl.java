package Gestor.de.contactos.contactos.service.impl;

import Gestor.de.contactos.contactos.entidades.Contacto;
import Gestor.de.contactos.contactos.repository.ContactoRepository;
import Gestor.de.contactos.contactos.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ContactoServiceImpl implements ContactoService {
    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public List<Contacto> listarContactos() {

        return contactoRepository.findAll();
    }

    @Override
    public Contacto obtenerContactoPorId(int id) {
        return contactoRepository.findById(id).orElse(null);
    }

    @Override
    public Contacto agregarContacto(Contacto contacto) {

        return contactoRepository.save(contacto);
    }

    @Override
    public Contacto actualizarContacto(int  id, Contacto contacto) {
        if (contactoRepository.existsById(id)) {
            Contacto contactoExistente = contactoRepository.findById(id).orElse(null);
            if (contactoExistente != null) {
                contactoExistente.setNombre(contacto.getNombre());
                contactoExistente.setCorreo(contacto.getCorreo());
                contactoExistente.setTelefono(contacto.getTelefono());
                return contactoRepository.save(contactoExistente);
            }
        }
        return null;
    }

    @Override
    public void eliminarContacto(int id) {
        contactoRepository.deleteById(id);
    }
}
