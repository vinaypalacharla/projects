package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.ContactEntity;
import com.nt.pojo.Contact;
import com.nt.repo.ContactsRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactsRepository repo;

	@Override
	public boolean contactSave(Contact contact) {
		ContactEntity entity = null;
		ContactEntity save = null;
		if (contact != null) {
			entity = new ContactEntity();
			BeanUtils.copyProperties(contact, entity);
			save = repo.save(entity);
		}
		return save.getContactId() != null;

	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> findAll = null;
		List<Contact> listcontacts = null;
		findAll = repo.findAll();
		listcontacts = findAll.stream().map(contact -> {
			Contact c = new Contact();
			BeanUtils.copyProperties(contact, c);
			return c;
		}).collect(Collectors.toList());
		return listcontacts;
	}

	@Override
	public Contact findById(Integer id) {
		ContactEntity entity = null;
		Contact contact = null;
		Optional<ContactEntity> findById = null;
		findById = repo.findById(id);
		if (findById != null) {
			entity = findById.get();
			contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
		}
		return contact;
	}

	@Override
	public void deleteContact(Integer id) {
		repo.deleteById(id);
	}

}
