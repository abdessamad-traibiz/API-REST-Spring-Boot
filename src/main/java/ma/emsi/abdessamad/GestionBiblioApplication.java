package ma.emsi.abdessamad;

import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.emsi.abdessamad.entities.Livre;
import ma.emsi.abdessamad.repos.LivreRepo;


/**
 * Author: Abdessamad Traibiz
 */


@SpringBootApplication
public class GestionBiblioApplication implements CommandLineRunner{
	
	@Autowired 
	private LivreRepo livreRepo;
	
	@Test
	public static void main(String[] args) {
		SpringApplication.run(GestionBiblioApplication.class, args);
	}
	
	
	@Override
	public void run(String... args ) throws Exception{
		
		System.out.println("***********Insertion************");
		livreRepo.save(
				new Livre(null, "Les misérables", "Gallimard",new Date(), "Victor Hugo", 1500,"1234552891234",null,true));
		
		livreRepo.save(
				new Livre(null, "Le bourgeois gentilhomme", "Gallimard",new Date(), "Molière", 1670,"1234552891234",null,false));
		
		System.out.println("***********Inserted Rows************");
		System.out.println("Count : " + livreRepo.count());
		
		System.out.println("**********Display Rows************");
		
		Collection<Livre> livres = livreRepo.findAll();
		livres.forEach(etudiant -> 
			{ 
				System.out.println(livres.toString());
			});
		
		System.out.println("**********Get Element By Id**********");
		Livre livre = livreRepo.findById(1).orElse(null);
		System.out.println(livre.toString());
		
		
		
		
		
	}
}
