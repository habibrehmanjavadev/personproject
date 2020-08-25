package com.personapplication.person.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personapplication.person.entity.Person;
import com.personapplication.person.entity.repository.Personrepo;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	private Personrepo prepo;

	@GetMapping("/all")
	public ResponseEntity<List<Person>> list() {
		System.out.println("Request Recieved");
		return new ResponseEntity<>(prepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/allwithpagination")
	public Page<Person> listwithpagination(Pageable page) {
		return prepo.findAll(page);

	}

	@PostMapping("/addpersons")
	public void add(@RequestBody Person person) {
		prepo.save(person);
	}

	@PutMapping("/persons/{id}")
	public ResponseEntity<?> update(@RequestBody Person person, @PathVariable Integer id) {
		try {
			Optional<Person> existProduct = prepo.findById(id);
			prepo.save(person);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/persons/{id}")
	public void delete(@PathVariable Integer id) {
		prepo.deleteById(id);
	}
}
