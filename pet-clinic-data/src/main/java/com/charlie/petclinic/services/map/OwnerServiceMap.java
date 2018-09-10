package com.charlie.petclinic.services.map;

import com.charlie.petclinic.model.Owner;
import com.charlie.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Integer> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Integer integer) {
        return super.findyById(integer);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
