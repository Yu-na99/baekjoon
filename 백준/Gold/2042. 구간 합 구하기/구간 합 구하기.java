import java.io.*;
import java.util.Arrays;

public class Main {
    static long[] tree;     // 트리
    static int treeHeight;  // 트리 높이
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n=input[0], m=input[1], k=input[2];

            // [1] 트리 높이 구하기 (= 2^k >= n, k의 최솟값)
            treeHeight = 1;
            int two = 2;
            while(two < n){
                two *= 2;
                treeHeight++;
            }

            // [2] 트리 구성하기
            int treeSize = (int)Math.pow(2, treeHeight+1);  // 트리 배열의 크기 구하기 (= 2^k * 2)
            int leftNodeStartIndex = treeSize / 2;    // 리프 노드 시작 인덱스
            tree = new long[treeSize];               // 트리 나무 구하기
            // [2-1] 트리 원본 데이터 삽입
            for(int i=leftNodeStartIndex; i<leftNodeStartIndex+n; i++){
                tree[i] = Long.parseLong(br.readLine());
            }
            // [2-2] 트리 구간합 데이터 삽입
            for(int i=leftNodeStartIndex-1; i>0; i--){
                tree[i] = tree[2*i] + tree[2*i + 1];
            }

            // [3] 변경 및 출력하기
            for(int i=0; i<m+k; i++){
                long[] datas = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
                int index = getTreeIndex((int)datas[1]);
                if(datas[0] == 1L){ // 변경
                    setTreeInput(index, datas[2]);
                } else { // 구간합 출력
                    outAccSum(index, getTreeIndex((int)datas[2]));
                }
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    // 트리 인덱스 구하기
    static int getTreeIndex(int index){
        return index + (int)Math.pow(2, treeHeight) - 1;
    }

    // 트리값 변경하기
    static void setTreeInput(int index, long num){
        long gap =  num - tree[index];
        while(index > 0){
            tree[index] += gap;
            index /= 2;
        }
    }

    // 트리 구간합 구하기
    static void outAccSum(int startIndex, int endIndex){
        long result = 0L;
        while(endIndex >= startIndex){
            // 조건식에 해당하면, 해당 인덱스 선택
            if(startIndex % 2 == 1){
                result += tree[startIndex];
            }
            if(endIndex % 2 == 0){
                result += tree[endIndex];
            }

            startIndex = (startIndex+1)/2;
            endIndex = (endIndex-1)/2;
        }
        System.out.println(result);
    }
}