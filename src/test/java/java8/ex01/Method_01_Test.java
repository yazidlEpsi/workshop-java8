package java8.ex01;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();
        	
        // TODO créer une méthode int sumAge()
        // TODO Cette méthode retourne le résultat de l'addition des ages des personnes
        
        public default int sumAge(){

        	int value =0;
        	for (Person temp : findAll()) {
    				value += temp.getAge() ;
    		}
        	
        	return value ;
        }
    }
    // end::IDao[]
  
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    class DaoB implements IDao {

        List<Person> people = Data.buildPersonList(100);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    @Test
    public void test_daoA_sumAge() throws Exception {

        DaoA daoA = new DaoA();
        
        // TODO invoquer la méthode sumAge pour que le test soit passant
       
        int value = daoA.sumAge();
        assertThat(value, is(210));
    }

    @Test
    public void test_daoB_sumAge() throws Exception {

        DaoB daoB = new DaoB();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int value = daoB.sumAge();
        
        assertThat(value, is(5050));

    }
}
