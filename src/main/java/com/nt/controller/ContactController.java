package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.pojo.Contact;
import com.nt.service.ContactServiceImpl;

@Controller
public class ContactController {
	@Autowired
	private ContactServiceImpl service;

	@GetMapping(value = { "/", "/addcontact" })
	public String loadFormPage(Model model) {
		Contact contact = null;
		contact = new Contact();
		model.addAttribute("contact", contact);
		return "contact";
	}

	@PostMapping("/savecontact")
	public String handleSbmtbttn(@ModelAttribute("contact") Contact contact, RedirectAttributes model) {
		boolean issaved;
		issaved = service.contactSave(contact);
		if (contact.getContactId() == null) {
			if (issaved) {
				model.addFlashAttribute("succmssg", "contact saved successfully");
			} else {
				model.addFlashAttribute("failedmssg", "contact saving failed");
			}
		} else {
			if (issaved) {
				model.addFlashAttribute("updatesuccmssg", "update succesfull");
			} else {
				model.addFlashAttribute("updatefailedmssg", "update failed");
			}
		}

		return "redirect:/";
	}

}
