import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(input);

            int result = 0;
            int acc = 0;
            for(int num : input){
                acc += num;
                result += acc;
            }
            System.out.println(result);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}