import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for(int i=0; i<N; i++){
                queue.add(Integer.parseInt(br.readLine()));
            }

            int sum = 0;
            while(queue.size() > 1){
                int num1 = queue.poll();
                int num2 = queue.poll();
                int sumNum = num1 + num2;
                sum += sumNum;
                queue.add(sumNum);
            }

            System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}