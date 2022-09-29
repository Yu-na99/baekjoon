import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for(int i=1; i<=(2*N-1)+1; i++){
            if(i==N) continue;
            for(int star=Math.abs(2*N-2*i+1); star>0; star--) {
                System.out.print("*");
            }
            System.out.println();
            for(int space=(i/N)*3+(2*(i-N-1))*(i/N); space<i; space++){
                System.out.print(" ");
            }
        }
    }
}