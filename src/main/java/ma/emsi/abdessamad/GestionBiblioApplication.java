package ma.emsi.abdessamad;

import java.util.Date;
import java.util.List;

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
				new Livre(null, "Les misérables", "Gallimard",new Date(), "Victor Hugo", 1500,"1-234-5528-91234",null,true));
		
		livreRepo.save(
				new Livre(null, "Le bourgeois gentilhomme", "Minuit",new Date(), "Molière", 1670,"1-2345-5289-1639",null,false));
		
		livreRepo.save(
				new Livre(null, "Rich dad poor dad", "Flammarion",new Date(), "Robert Kiyosaki", 1300,"1-2335-5289-2625",null,true));
		
		
		
		
		
		System.out.println("***********Inserted Rows************");
		System.out.println("Count : " + livreRepo.count());
		
		System.out.println("**********Display Rows************");
		
		List<Livre> livres = livreRepo.findAll();
		livres.forEach(etudiant -> 
			{ 
				System.out.println(livres.toString());
			});
		
		System.out.println("**********Get Element By Id**********");
		Livre livre = livreRepo.findById(1).orElse(null);
		System.out.println(livre.toString());
		
		
		
		
		
	}
}
