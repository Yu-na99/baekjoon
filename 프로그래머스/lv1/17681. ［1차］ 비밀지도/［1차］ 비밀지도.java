class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        // for(int i=0; i<n; i++){
        //     answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        //     int ansLen = answer[i].length();
        //     for(int j=ansLen; j<n; j++){
        //         answer[i]="0"+answer[i];
        //     }
        //     answer[i] = answer[i].replace("1", "#").replace("0", " ");
        // }
        
        for(int i=0; i<n; i++){
            answer[i] = String.format("%"+n+"s", Integer.toBinaryString(arr1[i] | arr2[i]))
                .replace("1", "#").replace("0", " ");
        }
        
        return answer;
    }
}