import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            
            for(int i=0; i<N; i++){
                pq.add(Integer.parseInt(br.readLine()));
            }

            for(int i=0; i<N; i++){
                System.out.println(pq.poll());
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}