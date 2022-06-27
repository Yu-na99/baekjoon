public class Main {
    static final int NUM = 10001;
    static final int TEN = 10;

    public static void main(String[] args) {
        boolean[] numbers = new boolean[NUM]; // false로 자동으로 초기화
        for(int i=1; i<NUM; i++){
            int num = divice(i);
            if(num>NUM-1) continue;
            numbers[num] = true;
        }

        for(int i=1; i<NUM; i++){
            if(numbers[i]) continue; // true라면 셀프넘버
            System.out.println(i);
        }
    }

    public static int divice(int num) {
        int sum = num;
        while(num >= TEN){
            sum += num % TEN;
            num /= TEN;
        }
        return sum+num;
    }
 }