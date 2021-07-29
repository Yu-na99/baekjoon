#상하좌우
dx=[-1, 1, 0, 0]
dy=[0, 0, -1, 1]

def BFS():
    visited=[[0]*M for _ in range(N)] #방문한 곳들의 거리를 누적해서 계산하기 위해
    visited[0][0]=1 #시작지점 방문했으므로 거리 1로 추가
    q=[(0, 0)] #출발 위치 큐에 추가
    
    while q: #큐에 들어있을때까지
        i, j = q.pop(0) #큐의 첫번째 위치 꺼내기
        if i==N-1 and j==M-1: #최종도착했다면,
            print(visited[i][j]) #결과 출력
            break #그만
        for (v, w) in zip(dx, dy): #상하좌우 이동하면서 거리 측정
            nx, ny = i+v, j+w #상하좌우
            if 0 <= nx <N and 0 <= ny < M: #범위를 벗어나지 않는다면,
                if Arr[nx][ny] == 1 and visited[nx][ny] == 0: #방문하지 않았고, 길이라면,
                    visited[nx][ny] = visited[i][j] + 1 #이웃한 위치 값에서 1을 더한 거리를 입력
                    q.append((nx, ny)) #큐에 추가
    return True

def main():
    global N, M, Arr
    N, M = map(int, input().split())
    Arr = [list(map(int, input())) for _ in range(N)] #입력받는 수가 붙어있으므로 split()가 필요없이, list()를 사용

    BFS()

if __name__ == "__main__":
    main()