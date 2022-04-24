package ma.emsi.abdessamad.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Table (name = "LIVRE")
@Entity 
@Data @AllArgsConstructor @NoArgsConstructor

public class Livre {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "TITRE",length = 50,nullable = false)
	private String titreLivre;
	
	@Column(name = "MAISON_EDITION",length = 50,nullable = false,updatable = false)
	private String maisonEditionLivre;
	
	@Temporal(TemporalType.DATE)
	private Date dateSortieLivre;
	
	@Column(name = "AUTEUR",length = 50,nullable = false)
	private String auteurLivre;
	
	@Column(name = "NOMBRE_PAGE",nullable = false)
	private int nombrePageLivre;
	
	@Column(name="ISBN",length = 13,nullable = false,updatable = false)
	private String isbnLivre;
	
	@Temporal(TemporalType.TIMESTAMP) @CreationTimestamp
	private Date derniereConsultation;
	
	private boolean disponibilteLivre;
	
	
	
	
	
}
