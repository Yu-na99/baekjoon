import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            ArrayList<String> result = new ArrayList<>();

            Stack<Integer> stack = new Stack<>();
            int start = 1;
            boolean flag = false;
            for(int i=0; i<n; i++){
                int pos = Integer.parseInt(br.readLine());
                if(flag) continue;
                for(int j=start; j<=pos; j++){
                    stack.push(j);
                    result.add("+");
                }
                if(start <= pos) start = pos+1;
                if(stack.pop() != pos) {
                    flag= true;
                }
                result.add("-");
            }

            if(!flag){
                for(int i=0; i<result.size(); i++){
                    System.out.println(result.get(i));
                }
            }else{
                System.out.println("NO");
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}