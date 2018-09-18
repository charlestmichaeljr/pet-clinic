package com.charlie.petclinic.services.map;

import com.charlie.petclinic.model.Visit;
import com.charlie.petclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit,Integer> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {

        if(visit.getPet() == null || visit.getPet().getOwner() == null ||
                visit.getPet().getId() == null ||
                visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit object. Missing owner or pet information.");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Integer id) {
        return super.findyById(id);
    }
}
