import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            Point[] point = new Point[N];
            for(int i=0; i<N; i++){
                point[i] = new Point(Integer.parseInt(br.readLine()), i);
            }

            Arrays.sort(point, 0, N);

            int max = 0;
            for(int i=0; i<N; i++){
                max = Math.max(max, point[i].index - i);
            }

            System.out.println(max+1);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}

class Point implements Comparable<Point> {
    int num;
    int index;

    Point(int num, int index){
        this.num = num;
        this.index = index;
    }

    @Override
    public int compareTo(Point o) {
        return this.num - o.num;
    }
}