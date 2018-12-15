
import java.util.Scanner;

/**
 *
 * @author williamscott
 */
public class CheckPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n, k;

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        String temp[] = input.split(" ");

        n = Integer.parseInt(temp[0]);
        k = Integer.parseInt(temp[1]);

        input = in.nextLine();
        temp = input.split(" ");

        int a[] = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            a[i] = Integer.parseInt(temp[i]);
        }

        boolean flag = true;

        int totalRemSum = 0;

        for (int i = 0; i < a.length; i++) {
            totalRemSum = totalRemSum + a[i] % k; // sum of mod of all the elements witk k
        }

        flag = totalRemSum % k == 0;

        if (a.length % 2 != 0) {
            flag = false; //if the input numbers are odd, its false by default
        }
        
        System.out.println(flag);
    }

}
