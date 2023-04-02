import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            long[] F = new long[N+1]; F[0]=1;
            for(int i=1; i<=N; i++){
                F[i] = F[i-1] * i;  // 팩토리얼 => 각 자리수에 만들 수 있는 경우의 수
            }

            int[] S = new int[N+1];
            boolean[] visited = new boolean[N+1];
            if(input[0] == 1L){ // K번째 해당하는 순열 출력
                for(int i=1; i<=N; i++){
                    for(int j=1, cnt=1; j<=N; j++){
                        if(visited[j]) continue; // 이미 사용한 숫자는 사용할 수 없으므로

                        if(input[1] <= cnt * F[N-i]){   // 주어진 input[1]에 따라 각 자리에 들어갈 수 있는 수 찾기
                            input[1] -= ((cnt - 1) * F[N-i]);
                            S[i]=j;
                            visited[j]=true;
                            break;
                        }
                        cnt++;
                    }
                }

                for(int i=1; i<=N; i++){
                    System.out.print(S[i]+" ");
                }
            } else { // 해당 순열이 몇번째인지 출력
                long K=1;
                for(int i=1; i<=N; i++){
                    long cnt=0;
                    for(int j=1; j<input[i]; j++){
                        if(!visited[j]) cnt++;
                    }
                    K += cnt * F[N-i];
                    visited[(int)input[i]]=true;
                }
                System.out.println(K);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}