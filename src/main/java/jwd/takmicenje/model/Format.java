package jwd.takmicenje.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="format")
public class Format {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private Integer brojUcesnika;
	@Column
	private String naziv;
	@Column
	private Integer brojPobeda;
	@Column
	private Integer brojNereseno;
	@Column
	private Integer brojGubitak;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="format")
	private List<Takmicenje> takmicenja = new ArrayList<>();
	public Format(Long id, Integer brojUcesnika, Integer brojPobeda, Integer brojNereseno, Integer brojGubitak) {
		super();
		this.id = id;
		this.brojUcesnika = brojUcesnika;
		this.brojPobeda = brojPobeda;
		this.brojNereseno = brojNereseno;
		this.brojGubitak = brojGubitak;
	}
	
	public Format() {
		super();
	}

	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getBrojUcesnika() {
		return brojUcesnika;
	}
	public void setBrojUcesnika(Integer brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}
	public Integer getBrojPobeda() {
		return brojPobeda;
	}
	public void setBrojPobeda(Integer brojPobeda) {
		this.brojPobeda = brojPobeda;
	}
	public Integer getBrojNereseno() {
		return brojNereseno;
	}
	public void setBrojNereseno(Integer brojNereseno) {
		this.brojNereseno = brojNereseno;
	}
	public Integer getBrojGubitak() {
		return brojGubitak;
	}
	public void setBrojGubitak(Integer brojGubitak) {
		this.brojGubitak = brojGubitak;
	}
	public List<Takmicenje> getTakmicenja() {
		return takmicenja;
	}
	public void setTakmicenja(List<Takmicenje> takmicenja) {
		this.takmicenja = takmicenja;
	}
	
	
	
	
	
}
