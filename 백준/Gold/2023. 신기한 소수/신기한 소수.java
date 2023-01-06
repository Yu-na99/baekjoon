import java.io.*;
import java.util.Arrays;

public class Main {
    static int limit;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int num = Integer.parseInt(br.readLine());
            int[] decimal = {2, 3, 5, 7};
            if(num==1) { Arrays.stream(decimal).forEach(a -> System.out.println(a)); ; return; }

            limit = (int)Math.pow(10, num);
            for(int d: decimal){
                dfs(d);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void dfs(int number){
        number *= 10; // 10배 증가
        if(number / limit > 0) { // 멈춰!!!
            System.out.println(number/10);
            return;
        }

        for(int j : new int[]{ 1, 3, 7, 9 }){
            int data = number+j;
            if(judgment(data)) dfs(data);
        }
    }

    static boolean judgment(int number){
        for(int i=2; i*i<=number; i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}