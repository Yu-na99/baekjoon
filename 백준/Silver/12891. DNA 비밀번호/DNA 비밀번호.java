import java.io.*;
import java.util.*;

public class Main {
    static int[] ACGT;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int S=input[0], P=input[1]; // S: DNA 문자열 길이, P: 부분 문자열 길이
            String DNA = br.readLine();
            ACGT = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0; i<P; i++){
                char dna = DNA.charAt(i);
                map.put(dna, map.containsKey(dna)? map.get(dna)+1 : 1);
            }
            int result = check(map); // 처음 시작! 비밀번호가 될 수 있는지 확인

            int start=0, end=P-1;
            for(int i=0; i<S-P; i++){ // start랑 end 포인트가 오른쪽으로 계속 이동하면서,
                // end는 비밀번호 문자에 추가하고, start는 비밀번호 문자에 빼는 형식으로 간다. (슬라이딩 윈도우 느낌? 아닐까?)
                char dnaStart = DNA.charAt(start++);
                char dnaEnd = DNA.charAt(++end);
                map.put(dnaStart, map.get(dnaStart)-1); // 이미 포함된 상태에서 빼기만 하기 때문에, 포함 여부 확인할 필요 X
                map.put(dnaEnd, map.containsKey(dnaEnd)? map.get(dnaEnd)+1 : 1);
                result += check(map);
            }
            System.out.println(result);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    // 비밀번호가 될 수 있는지 확인
    public static int check(HashMap<Character, Integer> m){
        char[] charACGT = new char[]{'A', 'C', 'G', 'T'};

        for(int i=0; i<4; i++){
            // 포함할때, 해당 ACGT 값 미만일 경우 탙락
            if(m.containsKey(charACGT[i]) && (m.get(charACGT[i]) < ACGT[i])) return 0;
            // 포함이 안되었다면, 해당 ACGT 값이 0이 아닐경우 탈락
            if(!m.containsKey(charACGT[i]) && (ACGT[i] != 0)) return 0;
        }
        return 1;
    }
}