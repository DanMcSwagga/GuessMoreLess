package ua.kpi.tef;

public class IntMap {
    int min;
    int max;

    IntMap(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void outputSingleNode(String message) {
        System.out.format(message, this.min, this.max);
    }
}
