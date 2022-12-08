import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); // A의 개수
            Integer[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            if(A.length <= 2){
                System.out.println(0);
                return;
            }

            // 데이터 중복 개수 작성 (ex. {{0: 2}, {2: 3}, {5: 1}} ==> 0이 2개, 2가 3개, 5가 1개 )
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<N; i++){
                // 해당 키 A[i]가 map에 존재하는지
                if(map.containsKey(A[i])){ // 존재 O
                    map.put(A[i], map.get(A[i]) + 1); // 개수 증가
                }else{ // 존재 X
                    map.put(A[i], 1);
                }
            }

            int result = 0;
            Integer[] newArr =  Arrays.stream(A).distinct().toArray(Integer[]::new); // 중복제거 배열
            int len = newArr.length;
            if((len == 1) && (newArr[0] == 0)){
                System.out.println(map.get(0));
                return;
            }
            for(int i=0; i< len; i++){
                int data = newArr[i]; // 기준 데이터
                for(int j=0; j< len; j++){
                    if(i == j) continue; // 기준 데이터를 건너뜀

                    int findNum = data - newArr[j]; // 찾아야할 데이터

                    // 찾아야할 데이터가 포함되어있지 않다면, 볼 필요가 없음
                    if(!map.containsKey(findNum)) continue;

                    // 기준 데이터에 뺀 데이터가 현재 찾아야할 데이터라면,
                    // 적어도 2개 이상이여야 함 (두 개의 수의 합이 기준데이터가 되어야하므로)
                    if(newArr[j] == findNum && map.get(newArr[j]) <= 1) continue;

                    // 기준 데이터가 현재 찾아야할 데이터라면, (이런 경우는 0과 뺄셈을 한 경우임)
                    // 적어도 2개 이상이여야함 (0 4일 경우는 답이 될 수 없고, 0 4 4 일 경우 답이 될 수 있기 때문에)
                    if(data == findNum && map.get(data) <= 1) continue;

                    result += map.get(data); // 조건에 만족한다면, 기준데이터는 전부 좋은 수가 되므로 중복 개수 더하기
                    break;
                }
            }

            System.out.println(result);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}