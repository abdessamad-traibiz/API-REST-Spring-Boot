package ma.emsi.abdessamad.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.abdessamad.entities.Livre;
import ma.emsi.abdessamad.service.LivreService;



@RestController
public class LivreController {
	
	private LivreService livreService;
	
	public LivreController(LivreService livreService) {
		this.livreService=livreService;
	}
	
	  //L’utilisateur peut avoir la liste des livres en utilisant l’url : emsi_api/livres
	  @GetMapping("/emsi_api/livres")
	  public List<Livre> getAllBooks() {
		   return this.livreService.getAllBooks();
	  }
	
	  //L’utilisateur peut avoir la liste un livre en utilisant l’url : emsi_api/livres/{id}
		  @GetMapping("/emsi_api/livres/{id}") 
		  public List<Livre> getBookById(@PathVariable Integer id) { 
			  return this.livreService.getBookById(id);
		  }
		 
	  
	  
		
		  //Update Book By Id
		  
		  @PutMapping("/emsi_api/livres/{id}") 
		  public void updateBookById(@RequestBody Livre livre, @PathVariable Integer id) {
			  livreService.updateBookById(livre, id);
			}
		  
		  
		  //Delete Book By Id
		  
		  @DeleteMapping("/emsi_api/livres/{id}") 
		  public void deleteBookById(@PathVariable Integer id) {
			  livreService.deleteBookById(id);
		  }
		 
	  
	  
	  

	
}
