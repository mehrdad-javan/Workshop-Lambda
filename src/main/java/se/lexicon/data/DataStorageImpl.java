package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.util.PersonGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Create implementations for all methods. I have already provided an implementation for the first method *
 */
public class DataStorageImpl implements DataStorage {

    private static final DataStorage INSTANCE;

    static {
        INSTANCE = new DataStorageImpl();
    }

    private final List<Person> personList;

    private DataStorageImpl() {
        personList = PersonGenerator.getInstance().generate(1000);
    }


    static DataStorage getInstance() {
        return INSTANCE; // Returning the singleton instance
    }

    @Override
    public List<Person> findMany(Predicate<Person> filter) {
        List<Person> result = new ArrayList<>(); // Creating a list to store filtered Person objects
        for (Person person : personList) { // Iterating over each Person object in personList
            if (filter.test(person)) { // Testing if the Person object satisfies the filter predicate
                result.add(person); // Adding the Person object to the result list if it satisfies the predicate
            }
        }
        return result; // Returning the list of filtered Person objects
    }

    @Override
    public Person findOne(Predicate<Person> filter) {
        for (Person p : personList) { // Iterating over each Person object in personList
            if (filter.test(p)) { // Testing if the Person object satisfies the filter predicate
                return p; // Returning the first Person object that satisfies the predicate
            }
        }
        return null; // Returning null if no Person object satisfies the predicate
    }

    @Override
    public String findOneAndMapToString(Predicate<Person> filter, Function<Person, String> personToString) {
        Person person = findOne(filter); // Finding a Person object that satisfies the filter predicate
        return person != null ? personToString.apply(person) : null; // Applying the personToString function to the Person object if it is not null, otherwise returning null
    }

    @Override
    public List<String> findManyAndMapEachToString(Predicate<Person> filter, Function<Person, String> personToString) {
        List<Person> persons = findMany(filter); // Finding a list of Person objects that satisfy the filter predicate
        List<String> stringListOutPut = new ArrayList<>(); // Creating a list to store the resulting strings
        for (Person p : persons) { // Iterating over each filtered Person object
            stringListOutPut.add(personToString.apply(p)); // Applying the personToString function to each Person object and adding the result to the list
        }
        return stringListOutPut; // Returning the list of resulting strings
    }

    @Override
    public void findAndDo(Predicate<Person> filter, Consumer<Person> consumer) {
        List<Person> persons = findMany(filter); // Finding a list of Person objects that satisfy the filter predicate
        for (Person person : persons) { // Iterating over each filtered Person object
            consumer.accept(person); // Applying the consumer action to each Person object
        }
    }

    @Override
    public List<Person> findAndSort(Comparator<Person> comparator) {
        List<Person> sortedList = new ArrayList<>(personList); // Creating a new list containing all Person objects from personList
        sortedList.sort(comparator); // Sorting the list using the provided comparator
        return sortedList; // Returning the sorted list
    }

    @Override
    public List<Person> findAndSort(Predicate<Person> filter, Comparator<Person> comparator) {
        List<Person> persons = findMany(filter); // Finding a list of Person objects that satisfy the filter predicate
        persons.sort(comparator); // Sorting the filtered list using the provided comparator
        return persons; // Returning the sorted list of filtered Person objects
    }
}
