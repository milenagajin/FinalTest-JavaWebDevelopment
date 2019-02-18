package jwd.takmicenje.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Models a physical activity.
 * 
 *
 */
@Entity
@Table(name="Takmicenje")
public class Takmicenje {
	

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String Naziv;
	@ManyToOne(fetch=FetchType.EAGER)
	private Format format;
	
	public Takmicenje() {
		super();
	}
	public Takmicenje(Long id, String naziv, Format format) {
		super();
		this.id = id;
		Naziv = naziv;
		this.format = format;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public Format getFormat() {
		return format;
	}
	public void setFormat(Format format) {
		this.format = format;
	}
	
	
	
	


	
	
	
}
