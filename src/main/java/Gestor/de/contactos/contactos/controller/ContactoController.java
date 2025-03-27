package Gestor.de.contactos.contactos.controller;


import Gestor.de.contactos.contactos.entidades.Contacto;
import Gestor.de.contactos.contactos.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Contacto")


public class ContactoController {
    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public List<Contacto> listarContactos() {
        return contactoService.listarContactos();
    }

    @GetMapping("/{id}")
    public Contacto obtenerContacto(@PathVariable int id) {
        return contactoService.obtenerContactoPorId(id);
    }

    @PostMapping
    public Contacto agregarContacto(@RequestBody Contacto contacto) {
        return contactoService.agregarContacto(contacto);
    }

    @PutMapping("/{id}")
    public Contacto actualizarContacto(@PathVariable int id, @RequestBody Contacto contacto) {
        return contactoService.actualizarContacto(id, contacto);
    }

    @DeleteMapping("/{id}")
    public void eliminarContacto(@PathVariable int id) {
        contactoService.eliminarContacto(id);
    }
}
