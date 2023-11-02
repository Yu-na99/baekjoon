import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            final int NUMBER = 1010000;
            boolean[] arr = new boolean[NUMBER];
            arr[0]=true; arr[1]=true; // 소수가 아님
            for(int i=2; i<=Math.sqrt(NUMBER); i++){
                if(arr[i]) continue;

                for(int j=i+i; j<NUMBER; j=j+i ){
                    arr[j]=true;
                }
            }

            for(int i=N; i<NUMBER; i++){
                if(arr[i]) continue;

                boolean FLAG = false;
                String[] st = String.valueOf(i).split("");
                for(int front=0, end=st.length-1; front <= end; front++, end--){
                    if(!st[front].equals(st[end])) {
                        FLAG = false;
                        break;
                    }
                    FLAG = true;
                }

                if(FLAG) {
                    System.out.println(i);
                    break;
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}