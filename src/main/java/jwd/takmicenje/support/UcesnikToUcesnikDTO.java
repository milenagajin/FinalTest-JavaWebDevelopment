package jwd.takmicenje.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.takmicenje.model.Ucesnik;
import jwd.takmicenje.web.dto.UcesnikDTO;

@Component
public class UcesnikToUcesnikDTO 
	implements Converter<Ucesnik, UcesnikDTO> {

	@Override
	public UcesnikDTO convert(Ucesnik source) {
		UcesnikDTO dto = new UcesnikDTO();
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setBrojBodova(source.getBrojBodova());
		dto.setBrojSusreta(source.getBrojSusreta());
		dto.setKontakt(source.getKontakt());
		dto.setMesto(source.getMesto());
		dto.setTakmicenjeId(source.getTakmicenje().getId());
		dto.setTakmicenjeNaziv(source.getTakmicenje().getNaziv());
		
		
		return dto;
	}
	
	public List<UcesnikDTO> convert(List<Ucesnik> ucesnici){
		List<UcesnikDTO> ret = new ArrayList<>();
		
		for(Ucesnik u : ucesnici){
			ret.add(convert(u));
		}
		
		return ret;
	}

}
