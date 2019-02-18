package jwd.takmicenje.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.takmicenje.model.Takmicenje;
import jwd.takmicenje.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeToTakmicenjeDTO implements Converter<Takmicenje, TakmicenjeDTO> {

	@Override
	public TakmicenjeDTO convert(Takmicenje t) {
		TakmicenjeDTO dto = new TakmicenjeDTO();
		dto.setId(t.getId());
		dto.setNaziv(t.getNaziv());
		dto.setFormatNaziv(t.getFormat().getNaziv());
		dto.setFormatId(t.getFormat().getId());
		return dto;

	}

	public List<TakmicenjeDTO> convert(List<Takmicenje> takmicenja) {
		List<TakmicenjeDTO> ret = new ArrayList<>();

		for (Takmicenje t : takmicenja) {
			ret.add(convert(t));
		}

		return ret;
	}
}
