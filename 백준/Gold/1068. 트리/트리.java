import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
    static LinkedList<Integer>[] list;
    static int remove;
    static int tailCnt = 0;
    public static void main(String args[])
    {
        try {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt(); sc.nextLine();

            int root = 0;
            list = new LinkedList[N];
            for(int i=0; i<N; i++) {
                int n = sc.nextInt();

                if(n == -1) {
                    root = i;
                    continue;
                }

                if(list[n] == null) list[n] = new LinkedList<>();
                list[n].add(i);
            } sc.nextLine();

            remove = sc.nextInt();
            if(list[root] == null) System.out.println(0);
            else {
                DFS(root, list[root].size());
                System.out.println(tailCnt);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static void DFS(int now, int childrenCnt){
        if(now == remove){
            if(childrenCnt == 1) tailCnt++;
            return;
        }
        if(list[now] == null) {
            tailCnt++;
            return;
        }

        for(int l : list[now]) {
            DFS(l, list[now].size());
        }
    }
}