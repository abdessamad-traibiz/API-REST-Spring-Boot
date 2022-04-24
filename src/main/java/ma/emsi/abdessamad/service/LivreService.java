package ma.emsi.abdessamad.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.OrderBy;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import ma.emsi.abdessamad.entities.Livre;
import ma.emsi.abdessamad.repos.LivreRepo;

@Component
public class LivreService {
	
	
	
	private LivreRepo livreRepo;
	
	//Constructor
	public LivreService(LivreRepo livreRepo) {
		 this.livreRepo=livreRepo; 
	}
	
	
	//Method To Find All Books Ascending
	@OrderBy
	public List<Livre> getAllBooks() {
		return livreRepo.findAll();
	}
	
	//Method To Find Book By Id
	public List<Livre> getBookById (Integer id) {
		Optional<Livre> livre = livreRepo.findById(id);
		if(livre.isPresent()) {
			return livreRepo.findAllById(id);
		}else {
			throw new RuntimeException("Book not found for the id "+id);
		}
		
	}
	
	//Delete book By Id
	public String deleteBookById(Integer id) {
		Optional<Livre> livre = livreRepo.findById(id);
		if(livre.isPresent()) {
			livreRepo.deleteById(id);
			return ("Book deleted with id "+id);
		}else {
			throw new RuntimeException("Book not found for the id "+id);
		}
	}
	
	
	//Update book By Id

	public ResponseEntity<Livre> updateBookById(Livre livre, Integer id) {
		Livre getBook = livreRepo.getById(id);
		getBook.setTitreLivre(livre.getTitreLivre());
		getBook.setDateSortieLivre(livre.getDateSortieLivre());
		getBook.setAuteurLivre(livre.getAuteurLivre());
		getBook.setNombrePageLivre(livre.getNombrePageLivre());
		getBook.setDerniereConsultation(livre.getDerniereConsultation());
		
		Livre updateLivre = livreRepo.save(getBook);
		return ResponseEntity.ok().body(updateLivre);




	}
	

	
	

	


}
