package com.charlie.petclinic.services;

import com.charlie.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Integer> {
    Owner findByLastName(String lastName);
}
