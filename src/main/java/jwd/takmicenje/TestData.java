package jwd.takmicenje;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.takmicenje.model.Format;
import jwd.takmicenje.model.Takmicenje;
import jwd.takmicenje.model.Ucesnik;
import jwd.takmicenje.service.FormatService;
import jwd.takmicenje.service.TakmicenjeService;
import jwd.takmicenje.service.UcesnikService;

@Component
public class TestData {
	@Autowired
	private TakmicenjeService tService;
	@Autowired
	private FormatService fService;
	@Autowired
	private UcesnikService uService;

	@PostConstruct
	public void init() {
		
		
		Format f = new Format();
		f.setBrojGubitak(0);
		f.setBrojNereseno(1);
		f.setBrojPobeda(2);
		f.setBrojUcesnika(1);
		f.setId(1L);
		f.setNaziv("format prvog takmicenja");
		fService.save(f);
		
		
		Takmicenje t= new Takmicenje();
		t.setId(1L);
		t.setNaziv("Super liga");
		t.setFormat(f);
		tService.save(t);
		
		Ucesnik u = new Ucesnik();
		u.setBrojBodova(1);
		u.setBrojSusreta(1);
		u.setId(1L);
		u.setKontakt("primer@gmail.com");
		u.setMesto("Subotica");
		u.setNaziv("Spartak");
		u.setTakmicenje(t);
		uService.save(u);
		
	}
}