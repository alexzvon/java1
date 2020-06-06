package ru.progwards.java1.lessons.classes;

public class Animal {
    double weight;
    enum AnimalKind { ANIMAL, COW, HAMSTER, DUCK };
    enum FoodKind { UNKNOWN, HAY, CORN };

    public Animal() {
        //
    }

    public Animal(double weight) {
        this.weight = weight;
    }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    public String toString() {
        return "I am " + getKind().toString() + ", eat " + getFoodKind().toString();
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return 0.02;
    }

    public double calculateFoodWeight() {
        return getWeight() * getFoodCoeff();
    }

    public String toStringFull() {
        Double cfw = calculateFoodWeight();
        return "I am " + getKind().toString() + ", eat " + getFoodKind().toString() + " " + cfw.toString();
    }
}
