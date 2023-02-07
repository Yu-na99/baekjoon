import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }

            mergeSort(arr, 0, N-1);
            Arrays.stream(arr).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void mergeSort(int[] a, int left, int right){
        if(left==right) return;

        int mid = (left + right)/2;

        mergeSort(a, left, mid);
        mergeSort(a, mid+1, right);

        merge(a, left, mid, right);
    }

    static void merge(int[] a, int left, int mid, int right){
        int l=left;     // 왼쪽 부분리스트의 시작점
        int r=mid+1;    // 오른쪽 부분리스트의 시작점
        int idx=left;   // 채워넣을 배열의 인덱스

        int[] sorted = new int[a.length];
        while(l<= mid && r <= right){
            if(a[l] <= a[r]){
                sorted[idx]=a[l];
                idx++; l++;
            }else{
                sorted[idx]=a[r];
                idx++; r++;
            }
        }

        if(l > mid){
            while(r <= right){
                sorted[idx]=a[r];
                idx++; r++;
            }
        }else{
            while(l <= mid){
                sorted[idx]=a[l];
                idx++; l++;
            }
        }

        for(int i=left; i<=right; i++){
            a[i]=sorted[i];
        }
    }
}