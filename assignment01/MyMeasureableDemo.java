import java.util.Arrays;

public class MyMeasureableDemo {
    public static void main(String[] args) throws Exception {

        Measurable[] measurement = new Measurable[3]; // array containing of objects from classes that implemented
                                                      // the interface Measurable

        measurement[0] = new Result("Amsal", 5); // generating measurement elements
        measurement[1] = new Result("Adnan", 5);
        measurement[2] = new Result("Enes", 5);

        Result r1 = (Result) measurement[0]; // narrowing casting (=converting the measurement element into a Result
                                             // object)
        Result r2 = (Result) measurement[1];
        Result r3 = (Result) measurement[2];

        // set scores
        r1.setScore(0, 5.5);
        r1.setScore(1, 3.5);
        r1.setScore(2, 10.0);
        r1.setScore(3, 0.0);
        r1.setScore(4, 2.5);

        r2.setScore(0, 8.0);
        r2.setScore(1, 3.5);
        r2.setScore(2, 9.0);
        r2.setScore(3, 4.0);
        r2.setScore(4, 1.5);

        r3.setScore(0, 0.0);
        r3.setScore(1, 6.5);
        r3.setScore(2, 7.0);
        r3.setScore(3, 1.75);
        r3.setScore(4, 8.0);

        for (Measurable m : measurement) {
            System.out.println(m.toString());
        }

        System.out.println("---------------------------------------------------------");

        System.out.println(Arrays.toString(Utilities.getKlargest(measurement, 2)));
        System.out.println(Arrays.toString(Utilities.getKlargest(measurement, 4)));

        System.out.println("---------------------------------------------------------");

        System.out.println(Utilities.listMeasure(r1));

        System.out.println(r2.getScore(3));

        System.out.println(Utilities.listMeasure(r2));
        System.out.println(Utilities.listMeasure(r3));
    }
}
