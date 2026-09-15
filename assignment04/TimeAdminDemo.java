import java.util.*;

public class TimeAdminDemo {

    public static void main(String[] args) {

        TimeAdmin mechanic = new TimeAdmin();
        TimeAdmin seller = new TimeAdmin();
        String cut = "-------------------------------------------------------------------------";

        // addName
        mechanic.addName("enes");
        mechanic.addName("adnan");
        mechanic.addName("amsal");
        mechanic.addName("ivan");
        seller.addName("tom");
        seller.addName("ismeta");
        // Test - if name is empty string or a name that already exists
        mechanic.addName("enes");
        mechanic.addName("");

        // addTime
        mechanic.addTime("enes", 2.5);
        mechanic.addTime("enes", 17.3);
        mechanic.addTime("enes", 10.2);
        mechanic.addTime("adnan", 4.0);
        mechanic.addTime("adnan", 20.6);
        mechanic.addTime("amsal", 14.5);
        // Test - if time is negative
        mechanic.addTime("amsal", -2.0);

        // getIterator
        Iterator<Double> iterator = mechanic.getIterator("enes");
        System.out.println("Iterator-enes: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Iterator<Double> iterator2 = mechanic.getIterator("adnan");
        System.out.println("Iterator-adnan: ");
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        Iterator<Double> iterator3 = mechanic.getIterator("amsal");
        System.out.println("Iterator-amsal: ");
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }
        // Test - if name does not exist
        Iterator<Double> iterator4 = mechanic.getIterator("sergei");
        System.out.println("Iterator-sergei: \n" + iterator4);
        System.out.println(cut);

        // getTimeList
        List<Double> times = mechanic.getTimeList("enes");
        System.out.println("Worktime from Enes: expected [2.5, 17.3, 10.2] | got " + times);
        List<Double> times2 = mechanic.getTimeList("adnan");
        System.out.println("Worktime from Adnan: expected [4.0, 20.6] | got " + times2);
        List<Double> times3 = mechanic.getTimeList("amsal");
        System.out.println("Worktime from Amsal: expected [14.5] | got " + times3);
        // Test - if name does not exist
        List<Double> times4 = mechanic.getTimeList("sergei");
        System.out.println("Worktime from Sergei: expected null | got " + times4);
        System.out.println(cut);

        // getAverage
        System.out.println("Average worktime from Enes: expected 10.0 | got " + mechanic.getAverage("enes"));
        System.out.println("Average worktime from Adnan: expected 12.3 | got " + mechanic.getAverage("adnan"));
        System.out.println("Average worktime from Amsal: expected 14.5 | got " + mechanic.getAverage("amsal"));
        // Test - if name has no workingtime or if name does not exist
        System.out.println("Average worktime from Ivan: expected 0.0 | got " + mechanic.getAverage("ivan"));
        System.out.println("Average worktime from Sergei: expected null | got " + mechanic.getAverage("sergei"));
        System.out.println(cut);

        // getTimeSum
        System.out.println("Sum of worktime from Enes: expected 30.0 | got " + mechanic.getTimeSum("enes"));
        System.out.println("Sum of worktime from Adnan: expected 24.6 | got " + mechanic.getTimeSum("adnan"));
        System.out.println("Sum of worktime from Amsal: expected 14.5 | got " + mechanic.getTimeSum("amsal"));
        // Test - if name has no workingtime or if name does not exist
        System.out.println("Sum of worktime from Ivan: expected 0.0 | got " + mechanic.getTimeSum("ivan"));
        System.out.println("Sum of worktime from Sergei: expected null | got " + mechanic.getTimeSum("sergei"));
        System.out.println(cut);

        // getTotalTime
        System.out.println("Total time of all names: expected 69.1 | got " + mechanic.getTotalTime());
        System.out.println(cut);

        // size
        System.out.println("Number of all registered names: expected 4 | got " + mechanic.size());
        System.out.println(cut);

        // toString
        System.out.print(mechanic.toString());
        System.out.println(cut);

        // getOverallMax
        System.out.println("Highest worktime: expected 20 | got " + mechanic.getOverallMax());
        // Test if no results are available
        System.out.println("Highest worktime: expected -1 | got " + seller.getOverallMax());
        System.out.println(cut);

        // getTimeRankingds
        System.out.println("Rank of Enes : expected 1 | got " + mechanic.getTimeRanking("enes") + " (Sum: "
                + mechanic.getTimeSum("enes") + ")");
        System.out.println("Rank of Adnan: expected 2 | got " + mechanic.getTimeRanking("adnan") + " (Sum: "
                + mechanic.getTimeSum("adnan") + ")");
        System.out.println("Rank of Amsal: expected 3 | got " + mechanic.getTimeRanking("amsal") + " (Sum: "
                + mechanic.getTimeSum("amsal") + ")");
        // Test - if name does not exist or there is no time for the name given
        System.out.println("Rank of Ivan: expected -2 | got " + mechanic.getTimeRanking("ivan"));
        System.out.println("Rank of Sergei: expected -1 | got " + mechanic.getTimeRanking("sergei"));
    }
}
