package cucumberCMDLine;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsLog {
	
	
	@Given("l'utilisateur ouvre la page de connexion")
	public void l_utilisateur_ouvre_la_page_de_connexion() {
	    System.out.println("============je suis sur la page de connexion==============");
	}

	@When("l'utilisateur saisit un identifiant valide")
	public void l_utilisateur_saisit_un_identifiant_valide() {
		 System.out.println("============j'ecrit mon identifiant ==============");
	}

	@Then("il est redirigé vers la page d'accueil")
	public void il_est_redirigé_vers_la_page_d_accueil() {
		 System.out.println("============je suis sur la page de d'accueil==============");
	}
}
