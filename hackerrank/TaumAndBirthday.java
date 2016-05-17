import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T-->0)
        {
            long B = sc.nextLong();  //no of white gifts to buy
            long W = sc.nextLong();  //no black gifts to buy
            long X = sc.nextLong();  // price black
            long Y = sc.nextLong();  // price white
            long Z = sc.nextLong();  // price conversion

            System.out.println(Math.min( Math.min((B*X)+(W*Y),(B*(Y+Z))+(W*Y)) , Math.min((B*X)+(W*(X+Z)),(B*(Y+Z))+(W*(X+Z)))));
        }
    }
}
