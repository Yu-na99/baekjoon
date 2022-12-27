import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static boolean isMove = true; // 이동 여부
    public static boolean[][] visited; // 방문 여부
    public static int[][] A; // 인구 수
    public static int N, L, R; // N: 크기, L<= 인구수 차이 <=R : 인구수 차이 L이상 R이하

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N=input[0]; L=input[1]; R=input[2];

            A = new int[N][N]; // 인구수가 당긴 2차원 배열
            for(int n=0; n<N; n++){
                A[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int dayCount = 0;
            while(true){
                isMove = false;
                visited = new boolean[N][N]; // 방문 여부 초기화(인구 이동 후, 처음부터 다시 탐색해야하므로)
                // 2중 for문 탐색 1번 = 하루
                for(int x=0; x<N; x++){
                    for(int y=0; y<N; y++){
                        if(visited[x][y]) continue;
                        BFS(x, y);
                    }
                }
                if(!isMove) break;
                dayCount+=1;
            }

            System.out.println(dayCount);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static Point[] UDLR = new Point[]{new Point(-1, 0), new Point(1, 0), new Point(0, -1), new Point(0, 1)}; // 상하좌우
    public static void BFS(int x, int y){
        Deque<Point> q = new ArrayDeque<>(); // 탐색할 좌표
        Deque<Point> position = new ArrayDeque<>(); // 연합 좌표 (추후, 해당 좌표의 인구수를 변경해야하므로)

        // [1] 연합 국가 구하기
        visited[x][y] = true; // 방문했다고 표기
        q.offer(new Point(x, y)); // 처음 좌표 큐에 넣기
        position.offer(new Point(x, y)); // 연합 좌표 넣기
        int totalPeople = A[x][y]; // 연합 인구 수 (이동할 전체 인구 수)
        while(!q.isEmpty()){
            Point xy = q.poll();
            for(Point point : UDLR){
                int newX = xy.getX() + point.getX();
                int newY = xy.getY() + point.getY();

                if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue; // 범위 넘어가면, 패스
                if(visited[newX][newY]) continue; // 방문했다면, 패스
                int diffPeople = Math.abs(A[xy.getX()][xy.getY()] - A[newX][newY]);
                if(diffPeople < L || diffPeople > R) continue; // 인구수 차이 범위 안이 아니라면, 패스

                visited[newX][newY] = true;
                q.offer(new Point(newX, newY));
                position.offer(new Point(newX, newY));
                totalPeople += A[newX][newY];
            }
        }

        // [2] 연합 국가 인구 수 분배하기
        if(position.size() > 1){ // 처음 넣은 좌표보다 더 많으면, 이동할 인구가 있다는 의미
            int division = totalPeople / position.size();
            while(!position.isEmpty()){
                Point p = position.poll();
                A[p.getX()][p.getY()] = division;
            }
            isMove = true; // 이동했다면
        }
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }
}