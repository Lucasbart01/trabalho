package br.com.trabalho.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalho.beans.Loja;
import br.com.trabalho.dao.LojaDAO;


@RestController
@CrossOrigin("*")
@RequestMapping(path="/loja")
public class LojaController {
	
	@Autowired
	private LojaDAO dao;
	
	@GetMapping
	public ResponseEntity<List<Loja>> getAll(){
		List<Loja> lista = (List<Loja>) dao.findAll();
		if(lista.size() ==0) {
			return ResponseEntity.status(404).build();
			
		}
		return ResponseEntity.ok(lista);
		
	}
	
	 @GetMapping(path="/{id}")
	 public ResponseEntity<Optional<Loja>> getById(@PathVariable Integer id){
		 Optional<Loja> loja;
		 try {
			 loja = dao.findById(id);
			 return new ResponseEntity<Optional<Loja>>(loja, HttpStatus.OK);
		 }catch (NoSuchElementException nsee) {
			 return new ResponseEntity<Optional<Loja>>(HttpStatus.NOT_FOUND);
		 }
	 }

}
