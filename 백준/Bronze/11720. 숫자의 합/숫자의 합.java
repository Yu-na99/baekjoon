import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
            int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

            int answer=0;
            for(int a: arr){
                answer += a;
            }

            System.out.println(answer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}