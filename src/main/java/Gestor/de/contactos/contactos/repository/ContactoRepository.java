package Gestor.de.contactos.contactos.repository;

import Gestor.de.contactos.contactos.entidades.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
}
