package ma.emsi.abdessamad.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.abdessamad.entities.Livre;

@Transactional
public interface LivreRepo extends JpaRepository<Livre, Integer>{
	
	
	List<Livre> findAllById(Integer id);
	List<Livre> findAll();
	
	/*
	 * Collection<Livre> findBytitreLivre(String titreLivre); Collection<Livre>
	 * findBymaisonEditionLivre(String maisonEditionLivre); Collection<Livre>
	 * findBydateSortieLivre(Date dateSortieLivre); Collection<Livre>
	 * findByauteurLivre(String auteurLivre); Collection<Livre>
	 * findByisbnLivre(String isbnLivre); Collection<Livre>
	 * findByderniereConsultation(Date derniereConsultation);
	 */


	

	
	



}
