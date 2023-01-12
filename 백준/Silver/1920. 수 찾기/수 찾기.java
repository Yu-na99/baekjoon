import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
            Set<String> setData = new HashSet<>(Arrays.asList(br.readLine().split(" ")));

            int M = Integer.parseInt(br.readLine());
            String[] data = br.readLine().split(" ");

            for(int i=0; i<M; i++){
                System.out.println(setData.contains(data[i])?1:0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}