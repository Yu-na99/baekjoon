import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = input[0], M = input[1]; // N: 표의 크기, M: 합 구할 개수
            int[][] arr = new int[N][N];
            int[][] acc = new int[N+1][N+1]; // 누적합 배열

            for(int i=0; i<N; i++){
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 데이터 넣기
                int[] row = new int[N];

                for(int j=0; j<N; j++){ // 누적배열 만들기
                    if(i==0){
                        if(j==0) acc[i+1][j+1] = arr[0][0];
                        else acc[i+1][j+1] = acc[i+1][j] + arr[i][j];
                    }else{
                        if(j==0) {
                            row[j] = arr[i][j];
                            acc[i+1][j+1] = acc[i][j+1] + row[j];
                        } else {
                            row[j] = row[j-1] + arr[i][j];
                            acc[i+1][j+1] = acc[i][j+1] + row[j];
                        }
                    }
                }
            }

            for(int i=0; i<M; i++){
                int[] coor = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x1=coor[0], y1=coor[1], x2=coor[2], y2=coor[3];

                System.out.println(acc[x2][y2]-acc[x2][y1-1]-acc[x1-1][y2]+acc[x1-1][y1-1]);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}