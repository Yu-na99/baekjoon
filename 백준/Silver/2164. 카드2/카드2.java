import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> q = new ArrayDeque<>();

            for(int i=2; i<=N; i+=2){
                q.offer(i);
            }

            if(!q.isEmpty() && q.size() > 1 && N % 2 == 0) q.pollFirst();
            while (!q.isEmpty() && q.size() != 1){
                int temp = q.pollFirst();
                q.offer(temp);
                q.removeFirst();
            }

            System.out.println(q.isEmpty()? 1 : q.peek());
        } catch(Exception e){
            System.out.println(e);
        }
    }
}