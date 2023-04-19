package CHP3;

import java.util.LinkedList;

// Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
// out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
// or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
// that type). They cannot select which specific animal they would like. Create the data structures to
// maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
// and dequeueCat. You may use the built-in Linked list data structure.

public class AnimalShelter6 {

    private int timestamp;
    private LinkedList<Animal> dogs;
    private LinkedList<Animal> cats;

    public AnimalShelter6() {
        timestamp = 0;
        dogs = new LinkedList<>();
        cats = new LinkedList<>();

    }

    public void enqueue(Animal animal) {
        animal.setTimestamp(timestamp++);
        if (animal instanceof Dog) {
            dogs.add(animal);
        } else if (animal instanceof Cat) {
            cats.add(animal);
        }
    }

    public Animal dequeuAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        } else {
            Dog oldestDog = (Dog) dogs.peek();
            Cat oldestCat = (Cat) cats.peek();
            if (oldestDog.getTimestamp() < oldestCat.getTimestamp()) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }
    }

    public Dog dequeueDog() {
        System.out.println("Removed Dog");
        return (Dog) dogs.poll();
    }

    public Cat dequeueCat() {
        System.out.println("Removed Cat");
        return (Cat) cats.poll();
    }

    public static void main(String[] args) {
        Animal a1 = new Dog("Dog1");

        Animal a2 = new Cat("Cat1");

        Animal a3 = new Cat("Cat 2");

        Animal a4 = new Dog("Dog 2");

        AnimalShelter6 animalShelter6 = new AnimalShelter6();

        animalShelter6.enqueue(a4);
        animalShelter6.dequeuAny();
        animalShelter6.enqueue(a1);
        animalShelter6.enqueue(a2);
        animalShelter6.enqueue(a3);
        animalShelter6.dequeueCat();
        animalShelter6.dequeuAny();
        animalShelter6.dequeueDog();

    }
}
