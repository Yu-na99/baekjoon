import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        try {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int M = sc.nextInt();

            trieNode tree = new trieNode();
            while(N-- > 0){
                String text = sc.next();
                trieNode now = tree;

                for(int i=0; i<text.length(); i++){
                    char c = text.charAt(i);

                    if(now.next[c - 'a'] == null) now.next[c - 'a'] = new trieNode();
                    now = now.next[c - 'a'];

                    if(i == text.length() - 1) now.isEnd = true;
                }
            }

            int count = 0;
            while(M-- > 0){
                String text = sc.next();
                trieNode now = tree;

                for(int i=0; i<text.length(); i++){
                    char c = text.charAt(i);
                    if(now.next[c - 'a'] == null) break;
                    now = now.next[c - 'a'];
                    if(i == text.length() - 1 && now.isEnd) count++;
                }
            }

            System.out.println(count);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static class trieNode {
        trieNode[] next = new trieNode[26];
        boolean isEnd;
    }
}