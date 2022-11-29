import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            double N = Double.parseDouble(br.readLine());
            if(N <= 2) {
                System.out.println(1);
                return;
            }
            int halfN = (int)Math.ceil(N/2.0);

            int start=1, end=2, count=1, sum=3;
            while(start != end) {
                if(sum > N){
                    sum -= start;
                    start += 1;
                } else if(sum < N){
                    end += 1;
                    sum += end;
                } else { // sum == N
                    count += 1;
                    sum -= start;
                    start += 1;
                    end += 1;
                    sum += end;
                }
                if(end > halfN) break;
            }
            System.out.println(count);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}