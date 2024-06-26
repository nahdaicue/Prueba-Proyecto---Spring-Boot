
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    public PersonaRepository persoRepo;

    @Override
    public List<Persona> verPersona() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long Id) {
        persoRepo.deleteById(Id);
    }

    @Override
    public Persona buscarPersona(Long Id) {
        return persoRepo.findById(Id).orElse(null);
    }
    
    @Override //resive un void en vez de un Persona, por si se da el caso que no exista la persona 
    public void modificarPersona(Long Id, Persona pers) {
        Persona modifPer = persoRepo.findById(Id).get();
        modifPer.setNombre(pers.getNombre());
        modifPer.setApellido(pers.getApellido());
        persoRepo.save(modifPer);
    }
}
