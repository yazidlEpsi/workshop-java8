package java8.ex03;

import org.junit.Test;

/**
 * Exercice 03 - Méthode statique
 */
public class ClasseAnonymeTest {

	interface Operation {
		int calculerOpeartion(int nb1, int nb2);
	}

	interface Calculatrice {
		int xxx(int nb1, int nb2);

		default int a() {
			return 0;
		};
	}

	interface Calculatrice2 {
		int xxx(int nb1, int nb2);
	}
	


	@Test
	public void test_classe_anonyme() {

		Calculatrice addition = new Calculatrice() {

			@Override
			public int xxx(int nb1, int nb2) {
				return nb1 + nb2;
			}
		};

		Calculatrice soustraction = new Calculatrice() {

			@Override
			public int xxx(int nb1, int nb2) {
				return nb1 - nb2;
			}
		};

		afficherResultat(10, 15, addition);
		afficherResultat(20, 30, soustraction);

		// java 7
		afficherResultat(20, 30, new Calculatrice() {

			@Override
			public int xxx(int nb1, int nb2) {
				return nb1 * nb2;
			}
		});

		// java 8 - etape 1
		afficherResultat(20, 30, (int nb1, int nb2) -> {
			return nb1 * nb2;
		});

		// java 8 - etape 2
		afficherResultat(20, 30, (nb1, nb2) -> {
			return nb1 * nb2;
		});

		// java 8 - etape 3
		afficherResultat(20, 30, (nb1, nb2) -> nb1 * nb2);
		
		afficherResultat(20, 30, this::additionner);

	}
	
	public int additionner(int n1, int n2) {
		return n1 + n2;
	}

	void afficherResultat(int nb1, int nb2, Calculatrice calculatrice) {
		System.out.println("Resultat = " + calculatrice.xxx(nb1, nb2));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
