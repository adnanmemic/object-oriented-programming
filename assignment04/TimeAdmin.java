import java.util.*;

public class TimeAdmin {

    private HashMap<String, ArrayList<Double>> timeMap;

    // constructor: creates a map container
    public TimeAdmin() {
        this.timeMap = new HashMap<>();
    }

    // adds only a name without any working time;
    // does nothing if name has aready been added;
    // does nothing if name is the empty string;
    public void addName(String name) {
        if (!timeMap.containsKey(name) && name != "") {
            ArrayList<Double> worktime = new ArrayList<>();
            timeMap.put(name, worktime);
        }
    }

    // adds a working time for the given name,
    // negative values for time are not allowed;
    // adds also the name if it hasn't been added before and if time is valid;
    public void addTime(String name, double time) {
        if (time > 0.0) {
            if (timeMap.containsKey(name)) {
                timeMap.get(name).add(time);
            } else {
                ArrayList<Double> worktime = new ArrayList<>();
                worktime.add(time);
                timeMap.put(name, worktime);
            }
        }
    }

    // returns an iterator over the list of all working times of the given name;
    // returns null if name is not valid (not added via addName);
    public Iterator<Double> getIterator(String name) {

        if (timeMap.containsKey(name))
            return timeMap.get(name).iterator();
        else
            return null;
    }

    // returns a list of all working times of the given name
    // returns null if name is not valid (not added via addName);
    public List<Double> getTimeList(String name) {

        if (timeMap.containsKey(name))
            return timeMap.get(name);
        else
            return null;
    }

    // returns the average of all working times for the given name;
    // returns 0 if no working time is available for the given name;
    // returns null if name does not exist
    public Double getAverage(String name) {

        double sum = 0;
        int num = 0;

        if (!timeMap.containsKey(name)) {
            return null;
        } else if (timeMap.get(name).size() == 0) {
            return 0.0;
        } else {
            for (double time : timeMap.get(name)) {
                sum += time;
                num++;
            }
            return sum / num;
        }
    }

    // returns the sum of all working times for the given name;
    // returns 0 if no working time is available for the given name;
    // returns null if name does not exist
    public Double getTimeSum(String name) {

        double sum = 0;

        if (!timeMap.containsKey(name)) {
            return null;
        } else if (timeMap.get(name).size() == 0) {
            return 0.0;
        } else {
            for (double time : timeMap.get(name)) {
                sum += time;
            }
            return sum;
        }
    }

    // returns the overall sum of all working times of all names
    public Double getTotalTime() {
        double total_sum = 0.0;

        for (String name : timeMap.keySet()) {
            total_sum += getTimeSum(name);
        }
        return total_sum;
    }

    // returns the number of all registered names;
    public int size() {
        int num = 0;

        for (String _ : timeMap.keySet()) {
            num++;
        }
        return num;
    }

    // returns a compact String-representation of all names with their working
    // times;
    // Hint: use a suitable toString implementation in the java Collection
    // framework;
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ArrayList<Double>> entry : timeMap.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    // returns the maximum working time over all names and all their working times;
    // returns -1.0 if no result is available
    public Integer getOverallMax() {
        int max = 0;

        for (String name : timeMap.keySet()) {
            for (double time : timeMap.get(name)) {
                if (time > max)
                    max = (int) time;
            }
        }
        if (max == 0)
            return -1;
        else
            return max;
    }

    // returns the ranking of the given name by comparing the sum of all its
    // working times with the sums of the working times of all other names
    // - ranking 1 is for the maximum sum of results,
    // - equal sums have the same rank;
    // returns -1 if name is not valid (not added),
    // returns -2 if no time for the given name is available;
    public Integer getTimeRanking(String name) {
        int rank = 1;

        if (!timeMap.containsKey(name))
            return -1;
        else if (timeMap.get(name).size() == 0)
            return -2;
        else {
            for (String name_comparison : timeMap.keySet()) {
                if (getTimeSum(name) < getTimeSum(name_comparison))
                    rank++;
            }
            return rank;
        }
    }
}
