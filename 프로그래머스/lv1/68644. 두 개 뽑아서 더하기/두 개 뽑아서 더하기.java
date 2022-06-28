import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int start = 0;
         int end = 1;

         Stack<Integer> stack = new Stack<Integer>();
         for(int i=0; i<times(numbers.length); i++){
             if(start == numbers.length-2) break;
             if(end == numbers.length){
                 ++start;
                 end=start+1;
             }
             int num = numbers[start]+numbers[end++];
             if(!stack.contains(num)){
                 stack.push(num);
             }
         }

         int[] answer = new int[stack.size()];
         for(int j=stack.size()-1; j>=0; j--){
             answer[j] = stack.pop();
         }
        Arrays.sort(answer);
         return answer;
    }
    
    int times(int numLength){
         return (numLength*(numLength-1))/2;
     }
}