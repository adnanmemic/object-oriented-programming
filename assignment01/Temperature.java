import java.util.*;

public class Temperature implements Measurable {

    private String name; // name of the city or region that you measure the temperature from
    private ArrayList<Double> temp_values;

    // constructor for setting name and initial capacity of days you want to measure
    // the temperature
    public Temperature(String name, int numOfdays) {
        this.name = name;
        this.temp_values = new ArrayList<Double>(numOfdays);
    }

    // setting the i-th temeperature value
    // i repressents the corresponding day
    public void setTempValue(int i, double value) {
        temp_values.add(value);
    }

    // returns the i-th temperature value
    // if index i does not exist, returns 0
    public double getTempValue(int i) {
        try {
            return temp_values.get(i);
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    // returns the average temperature
    public double getMeasure() {
        double sum = 0.0;
        int numOfdays = temp_values.size();
        double avg = 0.0;

        for (double value : temp_values) { // enhanced for-loop
            sum += value;
        }
        avg = sum / numOfdays;

        return avg;
    }

    // returns a string representation of the name combined with all scores and the
    // total score
    public String toString() {
        String str = this.name + ": \n" + "Average Temperature: " + getMeasure() + "\n";
        return str;
    }

}
