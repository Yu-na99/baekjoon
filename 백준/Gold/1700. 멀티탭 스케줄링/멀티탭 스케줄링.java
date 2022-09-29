import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(); // 멀티탭 구멍의 개수 N
        int K = s.nextInt(); // 전기 용품의 총 사용횟수 K

        // 사용할 자료 Queue에 담기
        int[] arr = new int[K];
        for(int i=0; i<K; i++){
            arr[i] = s.nextInt();
        }

        // 멀티탭 사용하기
        Set<Integer> tab = new HashSet<>();
        int changeCnt = 0; // 변경 횟수
        for(int i=0; i<K; i++){
            if(tab.size()>=N){ // 멀티탭 구멍이 가득 차면,
                if(tab.contains(arr[i]))
                    continue; // 현재 사용중인 전기제품일 경우, 그대로
                tab.remove(changeElectron(tab, arr, i, K));
                changeCnt++;
            }
            tab.add(arr[i]); // 2, 2, 2 이렇게 계속 들어올떄 Set 이여서 중복 제거된다
        }

        System.out.println(changeCnt);
    }

    public static int changeElectron(Set<Integer> tab, int[] arr, int idx, int arrLength){
        HashMap<Integer, Boolean> check = new HashMap<>();
        int falseCnt = 0;

        // 전기제품 세팅
        for(Integer i : tab) { // tab에 [1,2,3] 전기제품이 있다면,
            check.put(i, false); // [1:false, 2:false, 3:false]
            falseCnt++;
        }

        // 뒤에 사용할 전기제품인거 확인하기
        for(int i=idx; i<arrLength; i++){ // arr=[5, 1, 2]라면,
            if(falseCnt == 1) break;
            if(check.containsKey(arr[i]) && check.get(arr[i]) == false){
                check.put(arr[i], true);
                falseCnt--;
            }
        }

        // 사용하지 않는 전기제품 반환하기
        for(Integer i : check.keySet()){
            if(check.get(i)==false){
                return i;
            }
        }

        return arr[idx];
    }
}