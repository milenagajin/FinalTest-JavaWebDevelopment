package jwd.takmicenje.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.takmicenje.model.Ucesnik;
import jwd.takmicenje.service.TakmicenjeService;
import jwd.takmicenje.service.UcesnikService;
import jwd.takmicenje.support.TakmicenjeToTakmicenjeDTO;
import jwd.takmicenje.support.UcesnikToUcesnikDTO;
import jwd.takmicenje.web.dto.TakmicenjeDTO;
import jwd.takmicenje.web.dto.UcesnikDTO;

@RestController
@RequestMapping("/api/takmicenja")
public class ApiTakmicenjeController {
	@Autowired
	private TakmicenjeService takmicenjeService;
	@Autowired
	private UcesnikService ucesnikService;
	@Autowired
	private TakmicenjeToTakmicenjeDTO toDTO;
	@Autowired
	private UcesnikToUcesnikDTO toDTOUcesnik;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TakmicenjeDTO>> get(){
		return new ResponseEntity<>(
				toDTO.convert(takmicenjeService.findAll()),
				HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/{takmicenjeId}/ucesnici")
	public ResponseEntity<List<UcesnikDTO>> festivaliMesta(
			@PathVariable Long takmicenjeId,
			@RequestParam(defaultValue="0") int pageNum){
		
		Page<Ucesnik> ucesnici = ucesnikService.findByTakmicenjeId(pageNum, takmicenjeId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(ucesnici.getTotalPages()) );
		return  new ResponseEntity<>(
				toDTOUcesnik.convert(ucesnici.getContent()),
				headers,
				HttpStatus.OK);
		
	}
	
	
	
	
	
	
}
