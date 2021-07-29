#상하좌우
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def BFS(x, y):
    q=[(x, y)] #초기 위치 queue에 넣음
    visited[x][y]=True #초기 위치 방문했다고 표기(중요!-반례로 하나의 단지에 한 집만 있을 수 있으므로)
    count=1 #초기 위치 집 카운팅

    while q:
        x, y = q.pop(0) #초기 위치 기준으로 상하좌우 탐색
        for (i, j) in zip(dx, dy): #상하좌우 확인
            nx, ny = x+i, y+j #상하좌우
            if 0<= nx < N and 0<= ny < N and Arr[nx][ny]==1 and visited[nx][ny]==False: #범위를 넘지 않으면서, 집이 있고, 방문한 적이 없는 곳을 들림
                visited[nx][ny]=True #방문 했다고 표기
                q.append((nx, ny)) #큐에 넣음
                count+=1 #집 수 카운팅
    return count #총 집 수 반환

def main():
    global N, Arr, visited
    N = int(input())
    Arr = [list(map(int, input())) for _ in range(N)]

    num=[] #각 단지내 집의 수 담기
    cnt=0 #총 단지 수 세기
    visited=[[False]*N for _ in range(N)] #방문 확인
    for i in range(N):
        for j in range(N):
            if Arr[i][j] == 0: #집이 없는 곳은 확인할 필요 없음
                visited[i][j]=True #방문 했다고 치는 걸로
                continue
            if visited[i][j] == True: continue #방문한 곳은 방문할 필요 없으므로
            num.append(BFS(i ,j)) #집이 있으며, 방문하지 않은 곳을 탐색
            cnt+=1 #총 단지 수 카운팅
    
    print(cnt) #총 단지 수 출력
    for i in sorted(num): #오름 차순으로 정렬하여 출력
        print(i)

if __name__ == "__main__":
    main()