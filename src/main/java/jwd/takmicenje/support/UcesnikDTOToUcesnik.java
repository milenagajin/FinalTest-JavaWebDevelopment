package jwd.takmicenje.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.takmicenje.model.Ucesnik;
import jwd.takmicenje.service.TakmicenjeService;
import jwd.takmicenje.service.UcesnikService;
import jwd.takmicenje.web.dto.UcesnikDTO;

@Component
public class UcesnikDTOToUcesnik 
	implements Converter<UcesnikDTO, Ucesnik>{
	
	@Autowired
	private UcesnikService ucesnikService;
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	
	@Override
	public Ucesnik convert(UcesnikDTO dto) {
		Ucesnik u;
		if(dto.getId()==null){
			u = new Ucesnik();
			u.setTakmicenje(takmicenjeService.findOne(dto.getTakmicenjeId()));
			u.setBrojSusreta(0);
			u.setBrojBodova(0);
		}else{
			u = ucesnikService.findOne(dto.getId());
			u.setBrojBodova(dto.getBrojBodova());
			u.setBrojSusreta(dto.getBrojSusreta());
		}
		u.setNaziv(dto.getNaziv());
		u.setKontakt(dto.getKontakt());
		u.setMesto(dto.getMesto());
		
		
		return u;
	}

}
