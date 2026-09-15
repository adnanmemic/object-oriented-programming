import java.util.Random;

public class MyQueueDemo {
    public static void main(String[] args) throws Exception {
        DynQueue<Integer> q = new DynQueue<>();
        DynQueue<String> q2 = new DynQueue<>();

        Random random = new Random();

        // filling the queue with 1000 random int values
        for (int i = 0; i < 1000; i++) {
            q.enqueue(random.nextInt(1000));
        }

        int dequeue_cnt = 0; // count variables for maintaining the rate (2:2:1)
        int enqueue_cnt = 0;
        int peek_cnt = 0;

        for (int i = 0; i < 1000; i++) {
            // randomly selecting a queue operation
            int operation = random.nextInt(5); // 0-1: Dequeue, 2-3: Enqueue, 4: Peek

            if ((operation == 0 || operation == 1) && dequeue_cnt < 400) { // rate between dequeue:enqueue:peek is 2:2:1
                if (!q.isEmpty()) {
                    q.dequeue(); // dequeue
                    dequeue_cnt++;
                }
            } else if ((operation == 2 || operation == 3) && enqueue_cnt < 400) {
                q.enqueue(random.nextInt(1000)); // enqueue random int values between 0 and 999
                enqueue_cnt++;
            } else if (operation == 4 && peek_cnt < 200) {
                if (q.isEmpty()) {
                    peek_cnt++;
                }
            }
        }

        // fillig the queue with strings
        q2.enqueue("amsal");
        q2.enqueue("enes");
        q2.enqueue("adnan");
        q2.enqueue("ismeta");
        q2.enqueue("ivan");
        q2.enqueue("max");

        /*
         * q.enqueue(18);
         * q.enqueue(2);
         * q.enqueue(22);
         * q.enqueue(1);
         * q.enqueue(30);
         * q.enqueue(99);
         * q.enqueue(15);
         * q.enqueue(7);
         */

        System.out.println("---------- INTEGER QUEUE ----------------");
        System.out.println(q.toString());

        System.out.println("-------------------");
        System.out.println("Size = " + q.size());

        System.out.println("Top element: " + q.peek());

        System.out.println("Bottom element: " + q.get(q.size() - 1) + "\n");

        System.out.println("---------- STRING QUEUE ----------------");
        System.out.println(q2.toString());

        System.out.println("-------------------");

        System.out.println("Deleted element: " + q2.dequeue());
        System.out.println(q2.toString());

        System.out.println("-------------------");

        System.out.println("Top element: " + q2.peek());
        System.out.println(q2.toString());

        System.out.println("-------------------");
        System.out.println("Size = " + q2.size());

        System.out.println("-------------------");
        System.out.println("Element at specified position: " + q2.get(4));

        System.out.println("-------------------");
        System.out.println(q2.contains("ismeta"));
    }
}
