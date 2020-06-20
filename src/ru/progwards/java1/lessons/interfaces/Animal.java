package ru.progwards.java1.lessons.interfaces;

public class Animal implements FoodCompare, CompareWeight {
    double weight;
    enum AnimalKind { ANIMAL, COW, HAMSTER, DUCK };
    enum FoodKind { UNKNOWN, HAY, CORN };

    public static void main(String[] args) {
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

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Animal animal = (Animal) anObject;
        return calculateFoodWeight() == animal.calculateFoodWeight();
    }

    public double getFood1kgPrice() {
        double result = 0.0;

        switch(getFoodKind()) {
            case HAY:
                result = 20.0;
                break;
            case CORN:
                result = 50.0;
                break;
            case UNKNOWN:
                result = 0.0;
                break;
            default:
                result = 0.0;
                break;
        }

        return result;
    }

    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    @Override
    public int compareFoodPrice(Animal aminal) {
        return Double.compare(getFoodPrice(), aminal.getFoodPrice());
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        int rCFW = Double.compare(getWeight(), ((Animal) smthHasWeigt).getWeight());

        CompareResult result = null;

        if (0 > rCFW) {
            result = CompareResult.LESS;
        }
        else if (0 == rCFW) {
            result = CompareResult.EQUAL;
        }
        else if (0 < rCFW) {
            result = CompareResult.GREATER;
        }

        return result;
    }
}
