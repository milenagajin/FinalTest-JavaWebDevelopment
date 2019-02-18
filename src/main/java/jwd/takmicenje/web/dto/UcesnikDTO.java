package jwd.takmicenje.web.dto;

import org.hibernate.validator.constraints.NotBlank;

public class UcesnikDTO {
	private Long id;
//	@Length(min=2, max=40)
	@NotBlank
	private String naziv;
	private String mesto;
//	@Email
	private String kontakt;
	private Integer brojSusreta;
	private Integer brojBodova;
	private Long takmicenjeId;
	private String takmicenjeNaziv;

	public UcesnikDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public String getKontakt() {
		return kontakt;
	}
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	public Integer getBrojSusreta() {
		return brojSusreta;
	}
	public void setBrojSusreta(Integer brojSusreta) {
		this.brojSusreta = brojSusreta;
	}
	public Integer getBrojBodova() {
		return brojBodova;
	}
	public void setBrojBodova(Integer brojBodova) {
		this.brojBodova = brojBodova;
	}
	public Long getTakmicenjeId() {
		return takmicenjeId;
	}
	public void setTakmicenjeId(Long takmicenjeId) {
		this.takmicenjeId = takmicenjeId;
	}
	public String getTakmicenjeNaziv() {
		return takmicenjeNaziv;
	}
	public void setTakmicenjeNaziv(String takmicenjeNaziv) {
		this.takmicenjeNaziv = takmicenjeNaziv;
	}
	
	
	
	
}
