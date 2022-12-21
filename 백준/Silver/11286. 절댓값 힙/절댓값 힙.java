import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(Math.abs(o1) < Math.abs(o2)){
                        return -1;
                    } else if (Math.abs(o1) > Math.abs(o2)){
                        return 1;
                    } else {
                        if(o1 < o2) {
                            return -1;
                        } else if(o1 > o2){
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
            });

            for(int i=0; i<N; i++){
                int num = Integer.parseInt(br.readLine());
                if(num == 0){
                    System.out.println(pq.isEmpty()? 0 : pq.poll());
                }else{
                    pq.add(num);
                }
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}