import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            ArrayList<Meeting> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                int[] times = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                list.add(new Meeting(times[0], times[1]));
            }

            Collections.sort(list, new Comparator<Meeting>() {
                @Override
                public int compare(Meeting o1, Meeting o2) {
                    if(o1.end == o2.end) return o1.start - o2.start;
                    else return o1.end - o2.end;
                }
            });

            int count = 0 ;
            int finish = -1;
            for(int i=0; i<N; i++){
                if(list.get(i).start >= finish){
                    finish = list.get(i).end;
                    count++;
                }
            }

            System.out.println(count);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}