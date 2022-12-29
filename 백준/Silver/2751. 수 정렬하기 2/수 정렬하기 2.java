import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine());

            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                list.add(new Integer(br.readLine()));
            }

            list.sort(Comparator.naturalOrder());

            list.stream().forEach(s -> {
                try {
                    bw.write(s+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            bw.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}