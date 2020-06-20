package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight{
    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public CompareResult compareWeight(CompareWeight smthHasWeigt){
        int rW = Integer.compare(weight, ((Food) smthHasWeigt).weight);
        CompareResult result = null;

        if (0 > rW) {
            result = CompareResult.LESS;
        }
        else if (0 == rW) {
            result = CompareResult.EQUAL;
        }
        else if (0 < rW) {
            result = CompareResult.GREATER;
        }

        return result;
    }
}
