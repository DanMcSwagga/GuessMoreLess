package ua.kpi.tef;

public class IntMap {
    int min;
    int max;

    IntMap(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Outputs a <strong>single node</strong> of the List of Integer Pairs, which set the game range
     * @param message to be outputted
     * @param attempt number of the user
     */
    public void outputSingleNode(String message, int attempt) {
        System.out.format(message, attempt + 1, this.min, this.max);
    }
}
