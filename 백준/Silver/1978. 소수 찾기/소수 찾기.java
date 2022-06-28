import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int count=0;
        for(int i=0; i<N; i++){
            count += primeIdentification(s.nextInt()) ? 1 : 0;
        }
        System.out.println(count);
    }

    public static boolean primeIdentification(int num){
        if(num==1) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
 }