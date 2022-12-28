import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            
            String[] str = br.readLine().split("");
            Arrays.sort(str, Collections.reverseOrder());

            for(String s : str){
                bw.write(s);
            }
            bw.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}