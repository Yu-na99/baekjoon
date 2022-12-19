import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Stack<Integer> stack = new Stack<>();
            int[] result = new int[N]; Arrays.fill(result, -1);
            for(int i=0; i<N; i++){
                while(!stack.isEmpty() && i != N) {
                    if(arr[stack.peek()] < arr[i]){
                        result[stack.pop()] = arr[i];
                    } else {
                        stack.push(i);
                        i+=1;
                    }
                }
                stack.push(i);
            }

            for(int r : result){
                bw.write(r+" ");
            }
            bw.flush();
            bw.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}