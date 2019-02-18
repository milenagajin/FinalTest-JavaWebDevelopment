package jwd.takmicenje.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.takmicenje.model.Ucesnik;
import jwd.takmicenje.service.UcesnikService;
import jwd.takmicenje.support.UcesnikDTOToUcesnik;
import jwd.takmicenje.support.UcesnikToUcesnikDTO;
import jwd.takmicenje.web.dto.UcesnikDTO;

@RestController
@RequestMapping(value="/api/ucesnici")
public class ApiUcesnikController {
	@Autowired
	private UcesnikService ucesnikService;
	@Autowired
	private UcesnikToUcesnikDTO toDTOUcesnik;
	@Autowired
	private UcesnikDTOToUcesnik toUcesnik;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UcesnikDTO>> get(
			@RequestParam(required=false) String naziv,
			@RequestParam(required=false) Long takmicenjeId,
			@RequestParam(defaultValue="0") int pageNum){
		
		Page<Ucesnik> ucesnici;
		
		if(naziv != null || takmicenjeId != null ) {
			ucesnici = ucesnikService.pretraga(naziv, takmicenjeId, pageNum);
		}else{
			ucesnici = ucesnikService.findAll(pageNum);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(ucesnici.getTotalPages()) );
		return  new ResponseEntity<>(
				toDTOUcesnik.convert(ucesnici.getContent()),
				headers,
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,
					value="/{id}")
	public ResponseEntity<UcesnikDTO> get(
			@PathVariable Long id){
		Ucesnik ucenik = ucesnikService.findOne(id);
		
		if(ucenik==null){
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTOUcesnik.convert(ucenik),
				HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<UcesnikDTO> add(
			@Validated @RequestBody UcesnikDTO nov){
		
		Ucesnik ucesnik = toUcesnik.convert(nov); 
		if(ucesnikService.save(ucesnik) != null) {
			return new ResponseEntity<>(toDTOUcesnik.convert(ucesnik),
					HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/edit/{id}")
	public ResponseEntity<UcesnikDTO> edit(
			@PathVariable Long id,
			@Validated @RequestBody UcesnikDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Ucesnik festival = toUcesnik.convert(izmenjen); 
		ucesnikService.save(festival);
		
		return new ResponseEntity<>(toDTOUcesnik.convert(festival),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public ResponseEntity<UcesnikDTO> delete(@PathVariable Long id){
		
		Ucesnik ucesnik = ucesnikService.findOne(id);
		if(ucesnik == null) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		ucesnikService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler
	public ResponseEntity<Void> validationHandler(
					DataIntegrityViolationException e){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
}
