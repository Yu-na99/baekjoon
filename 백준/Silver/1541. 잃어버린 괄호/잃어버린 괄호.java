import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split("-");

            int total = 0;
            int[] input = Arrays.stream(str[0].split("\\+")).mapToInt(Integer::parseInt).toArray();
            for(int num: input){
                total += num;
            }

            for(int i=1; i<str.length; i++){
                int[] data = Arrays.stream(str[i].split("\\+")).mapToInt(Integer::parseInt).toArray();
                int sum = 0;
                for(int num: data){
                    sum += num;
                }
                total -= sum;
            }

            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}