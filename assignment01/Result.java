public class Result implements Measurable {

    private String name;
    private double[] scores;

    // constructor for setting name and initial capacity of scores
    public Result(String name, int numOfScores) {
        this.name = name;
        scores = new double[numOfScores];
    }

    // sets the i-th score with the given amount
    // if index i does not exist, the used data structure (e.g. array, ...)
    // must be adjusted
    public void setScore(int i, double amount) {
        try {
            scores[i] = amount;
        } catch (ArrayIndexOutOfBoundsException e) {
            // double [] extend_score = new double[scores.length + 1];
            double[] extend_score = new double[i + 1]; // adjust the existing array by coppying and increase the
                                                       // array-length

            for (int y = 0; y < scores.length; y++) {
                extend_score[y] = scores[y];
            }
            scores = extend_score;
            scores[i] = amount;
        }

    }

    // returns the i-th score
    // if index i does not exist, returns 0
    public double getScore(int i) {
        try {
            return scores[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    public double getMeasure() {
        double sum = 0.0;

        for (double score : scores) { // enhanced for-loop
            sum += score;
        }
        return sum;
    }

    // returns the total score (= sum of all scores)
    public double getTotalScore() {
        return getMeasure();
    }

    // returns a string representation of the name combined with all scores and the
    // total score
    public String toString() {
        String str = this.name + ": ";

        for (int i = 0; i < scores.length; i++) {
            str += scores[i];
            if (i < scores.length - 1)
                str += " / ";
        }

        str += " = " + getTotalScore();
        return str;
    }
}
