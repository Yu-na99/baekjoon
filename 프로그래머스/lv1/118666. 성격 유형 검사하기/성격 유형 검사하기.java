import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> score = new HashMap<String, Integer>();
        String[] category = new String[]{"R", "T", "C", "F", "J", "M", "A", "N"};

        // [1] dictionary 형태로 데이터 초기화
        for(String s : category){
            score.put(s, 0);
        }

        // [2] 성격 점수 넣기
        for(int i=0; i<survey.length; i++){
            String[] datas = survey[i].split("");
            int choice = choices[i]; // 선택한 점수
            if(choice/4 == 1 && choice%4 == 0) continue; // 잘모르겠음이면, 넘어감

            String idx = datas[choice/4]; // 123은 datas[0], 567은 datas[1]
            Integer s = 3/choice + (3%choice)*(3/choice)+(choice%4)*(choice/4);
            score.put(idx, score.get(idx) + s); // 해당 성격에 점수 증가
        }

        // [3] 성격 결과
        String result = "";
        for(int i=0; i< category.length; i=i+2){
            String left = category[i];
            String right = category[i+1];

            result += score.get(left) >= score.get(right) ? left : right;
        }
        
        return result;
    }
}