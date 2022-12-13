import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            StringTokenizer st = new StringTokenizer(br.readLine());

            ArrayDeque<MyNode> deque = new ArrayDeque<>();
            for(int i=0; i<input[0]; i++){
                int data = Integer.parseInt(st.nextToken());
                if(!deque.isEmpty() && deque.peek().index <= i-input[1]) deque.removeFirst();
                while(!deque.isEmpty() && deque.peekLast().value > data) deque.removeLast();
                deque.offer(new MyNode(data, i));
                bw.write(deque.peek().value+" ");
            }
            bw.flush();
            bw.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}

class MyNode {
    int value;
    int index;

    MyNode(int value, int index) {
        this.value = value;
        this.index = index;
    }
}