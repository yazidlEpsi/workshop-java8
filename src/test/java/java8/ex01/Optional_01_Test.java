package java8.ex01;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.nio.file.DirectoryStream.Filter;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 01 - Optional
 */
public class Optional_01_Test {

    class NotFountException extends RuntimeException {}


    // tag::findMethod[]
    <T> T find(List<T> list, Predicate<T> predicate, T defaultValue) {
        T result = defaultValue;
        
        for (T p : list) {
            if (predicate.test(p)) {
                result = p;
                break;
            }
        }

        return result;
    }
    // end::findMethod[]


    @Test
    public void test_optional_found() throws Exception {

        List<Person> personList = Data.buildPersonList(100);
        Predicate<Person> predicate = (p)-> p.getAge() == 10;
        // TODO invoquer la méthode find(List<T> list, Predicate<T> predicate)
        // TODO age == 10
        Optional<Person> result = Optional.of(find(personList, predicate,null));

        assertThat(result, instanceOf(Optional.class));
        assertThat(result.isPresent(), is(true));
        assertThat(result.get(), instanceOf(Person.class));
        assertThat(result.get(), hasProperty("firstname", is("first_10")));
        assertThat(result.get(), hasProperty("age", is(10)));
    }

    @Test
    public void test_optional_notfound() throws Exception {


        List<Person> personList = Data.buildPersonList(100);
        Predicate<Person> predicate = (p)-> p.getAge() == 400;

        // TODO invoquer la méthode find(List<T> list, Predicate<T> predicate)
        // TODO age == 400
        Optional<Person> result = Optional.ofNullable(find(personList, predicate,null));

        assertThat(result, instanceOf(Optional.class));
        assertThat(result.isPresent(), is(false));
    }

    @Test(expected = NotFountException.class)
    public void test_optional_notfound_throw_exception() throws Exception {


        List<Person> personList = Data.buildPersonList(100);
        Predicate<Person> predicate = (p)-> p.getAge() == 10 && p.getFirstname().equals("last_10");

        // TODO invoquer la méthode find(List<T> list, Predicate<T> predicate)
        // TODO age == 10 et firstname == "last_10"
        Optional<Person> result = Optional.ofNullable(find(personList, predicate,null));
        		result.orElseThrow(() -> new NotFountException());

        // TODO Utiliser la méthode orElseThrow pour déclencher l'exception NotFountException si non trouvé
    }

    @Test
    public void test_optional_notfound_with_default_value() throws Exception {


        List<Person> personList = Data.buildPersonList(100);

        Person defaultValue = new Person();
        defaultValue.setFirstname("DEFAULT");
        defaultValue.setLastname("DEFAULT");
        
        Predicate<Person> predicate = (p)-> p.getAge() == 400 ;

        // TODO invoquer la méthode find(List<T> list, Predicate<T> predicate, T defaultValue)
        // TODO predicate => age == 400
        Person result = find(personList, predicate,defaultValue);

        assertThat(result, notNullValue());
        assertThat(result, hasProperty("firstname", is("DEFAULT")));
        assertThat(result, hasProperty("lastname", is("DEFAULT")));
    }


}
