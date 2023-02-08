import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            ArrayList<Integer> plusArr = new ArrayList<>();
            ArrayList<Integer> minusArr = new ArrayList<>();
            int one = 0;
            boolean zero = false;
            for(int i=0; i<N; i++){
                int num = Integer.parseInt(br.readLine());
                switch (num){
                    case 0: zero = true;
                        break;
                    case 1: one += 1;
                        break;
                    default:
                        if(num > 0) plusArr.add(num);
                        else minusArr.add(num);
                }
            }

            int total = one;

            Collections.sort(plusArr);
            for(int i=plusArr.size()-1; i>=0; i-=2){
                if(i == 0) total += plusArr.get(i);
                else total += (plusArr.get(i)*plusArr.get(i-1));
            }

            Collections.sort(minusArr, Comparator.reverseOrder());
            for(int i=minusArr.size()-1; i>=0; i-=2){
                if(i==0) total += zero? 0: minusArr.get(i);
                else total += (minusArr.get(i)*minusArr.get(i-1));
            }

            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}