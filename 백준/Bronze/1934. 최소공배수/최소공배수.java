import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());

            StringTokenizer st;
            for(int i=0; i<T; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(b > a) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                System.out.println((a*b) / getLCM(a, b));

            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static int getLCM(int a, int b){
        int result = a % b;

        while(result != 0){
            a = b;
            b = result;
            result = a % b;
        }
        return b;
    }
}