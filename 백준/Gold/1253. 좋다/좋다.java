import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            long[] data = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            // 정렬
            Arrays.sort(data);

            // 투포인터
            int count=0;
            long prePoint=0;
            boolean flag = false;
            for(int idx=0; idx<N; idx++){
                int left=0, right=N-1;
                long point = data[idx];

                if(prePoint == point && flag){
                    count++;
                    continue;
                }

                flag=false;
                while(left < right){
                    if(left == idx) left++;
                    if(right == idx) right--;
                    if(left >= right) break;

                    long sumN = data[left] + data[right];
                    if(sumN > point){
                        right--;
                    }else if(sumN < point){
                        left++;
                    }else{
                        count++; flag=true;
                        break;
                    }
                }
                prePoint=point;
            }

            System.out.println(count);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}