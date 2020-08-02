package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.pojo.Contact;
import com.nt.service.ContactServiceImpl;

@Controller
public class ContactViewController {
	@Autowired
	private ContactServiceImpl service;

	@GetMapping("/viewallcontacts")
	public String getAllContacts(Model model) {
		List<Contact> contacts = null;
		contacts = service.getAllContacts();
		model.addAttribute("listcontacts", contacts);
		return "viewcontacts";
	}

	@GetMapping("/editcontact")
	public String updateContact(@RequestParam("cid") Integer cid, Model model) {
		Contact contact = null;
		contact = service.findById(cid);
		model.addAttribute("contact", contact);
		return "contact";
	}

	@GetMapping("/deletecontact")
	public String updateContact(@RequestParam("did") Integer did) {
		service.deleteContact(did);
		return "redirect:/viewallcontacts";
	}
}
