import edu.princeton.cs.algs4.StdIn;

public class Subset {
    public static void main(String[] args) {
        if (args.length > 0 && canParseInt(args[0])) {
            System.out.printf("Please write in at least %d input elements (separated by a space)%n", Integer.parseInt(args[0]));
            RandomizedQueue<String> rq = new RandomizedQueue<>();
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                if(StdIn.isEmpty()) break;
                String s = StdIn.readString();
                rq.enqueue(s);
            }
            for (String i: rq) {
                System.out.printf("%s ", i);
            }
        } else {
            System.out.println("Please enter an integer command line argument to the program. Running program exit protocol..");
            //return;
        }
    }
    private static boolean canParseInt(String s) {
       int n = -1;
       try {
        n = Integer.parseInt(s);   
      }
       catch (NumberFormatException e) {
       System.out.println("Could not parse integer");
       return false;
      }
       return n != -1;
 }
}