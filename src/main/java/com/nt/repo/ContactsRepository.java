package com.nt.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.ContactEntity;

public interface ContactsRepository extends JpaRepository<ContactEntity, Serializable> {

}
