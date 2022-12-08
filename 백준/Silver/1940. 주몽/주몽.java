import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean[] visited = new boolean[N]; // arr 개수

            // end ---> start
            int result = 0;
            for(int end=0; end<N; end++){
                if(visited[end]) continue;
                int pos = M - arr[end];
                for(int start=end+1; start<N; start++){
                    if(visited[start]) continue;
                    if(arr[start] == pos) {
                        visited[start] = true;
                        result++;
                    }
                }
            }

            System.out.println(result);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}