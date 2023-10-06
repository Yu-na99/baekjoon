import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];     // 원본 배열
            int[] leftAcc = new int[N]; // 좌측 누적 배열
            arr[0] = Integer.parseInt(st.nextToken());
            leftAcc[0] = arr[0];
            int result = arr[0];
            for(int i=1; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                leftAcc[i] = Math.max(arr[i], arr[i]+ leftAcc[i-1]); // 현재 데이터와 이전 누적 데이터를 비교하여 더 큰 값을 넣게 되면, 시작을 현재위치에서할지 아니면 계속 이어나갈지 결정이 되는 것.
                result = Math.max(result, leftAcc[i]);
            }

            int[] rightAcc = new int[N];    // 우측 누적 배열
            rightAcc[N-1] = arr[N-1];
            for(int j=N-2; j>=0; j--){
                rightAcc[j] = Math.max(arr[j], arr[j]+rightAcc[j+1]);
            }

            for(int i=1; i<N-1; i++){
                int temp = leftAcc[i-1] + rightAcc[i+1];
                result = Math.max(result, temp);
            }
            System.out.println(result);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}