import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main
{
    static int[][] tree;
    public static void main(String args[])
    {
        try {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt(); sc.nextLine();
            tree = new int[26][2];

            for(int i=0; i<N; i++){
                String[] data = sc.nextLine().split(" ");
                int node = data[0].charAt(0) - 'A';
                char left = data[1].charAt(0);
                char right = data[2].charAt(0);

                if(left == '.') tree[node][0] = -1;
                else tree[node][0] = left - 'A';

                if(right == '.') tree[node][1] = -1;
                else tree[node][1] = right - 'A';
            }

            preOrder(0);
            System.out.println();
            inOrder(0);
            System.out.println();
            postOrder(0);
            System.out.println();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // 전위순회
    static void preOrder(int node){
        if(node == -1) return;

        System.out.print((char)(node+'A'));
        preOrder(tree[node][0]);
        preOrder(tree[node][1]);
    }

    // 중위순회
    static void inOrder(int node){
        if(node == -1) return;

        inOrder(tree[node][0]); // 왼쪽부터
        System.out.print((char)(node+'A'));
        inOrder(tree[node][1]); // 오른쪽
    }

    // 후위순회
    static void postOrder(int node){
        if(node == -1) return;

        postOrder(tree[node][0]); // 왼쪽
        postOrder(tree[node][1]); // 오른쪽
        System.out.print((char)(node+'A'));
    }
}