"""
import copy

#상하좌우
dx=[-1, 1, 0, 0]
dy=[0, 0, -1, 1]

def BFS(x, y):
    q=[(x, y)] #익은 토마토만 담음
    visited[x][y]=True #방문 했다고 표기

    while q: #익은 토마토 주변만 탐색
        i, j = q.pop(0) #익은 토마토 위치 기준
        for (v, w) in zip(dx, dy): #주변 토마토 탐색
            nx, ny=i+v, j+w
            if 0<= nx < N and 0<= ny < M and visited[nx][ny]==False: #범위 안이며, 방문하지 않은(토마토가 없고, 이미 탐색한 곳을 제외한 부분)만 탐색
                if Arr[nx][ny]==1: #익은 토마토라면,
                    q.append((nx, ny)) #익은 토마토만 담기
                if Arr[nx][ny]==0: #안익은 토마토라면,
                    new_position.append((nx, ny)) #익은 토마토에 의해 새롭게 익게될 토마토의 위치 저장
                visited[nx][ny]=True #방문했다고 표기

def main():
    global N, M, Arr, visited, new_position
    M, N = map(int, input().split())
    Arr = [list(map(int, input().split())) for _ in range(N)]

    position=[] #익은 토마토 위치 탐기
    visited=[[False]*M for _ in range(N)] #방문 표시 하기
    count=0; pos=0
    for i in range(N): #처음 익은 토마토 위치 찾기
        for j in range(M):
            if Arr[i][j]==1: #토마토가 있는 곳만
                position.append((i, j)) #토마토 있는 곳 위치를 표기
                pos+=1 #토마토 있는 곳 세기
            if Arr[i][j]==-1: #토마토가 없는 곳은 확인할 필요없으므로
                visited[i][j]=True #방문했다고 처리
                count+=1 #토마토가 없는 곳 세기
    
    if pos == 0:
        print(-1)
        return True
    count+=pos
    if count==N*M:
        print(0)
        return True

    day_count=0
    new_position=[] #익은 토마토에 의해 새롭게 익게된 토마토의 위치 담기
    while position:
        for (i, j) in position: #익은 토마토만 탐색
            BFS(i, j)
            position.pop(0)
            if len(position)==0: #익은 토마토 위주로 탐색했다면,
                if len(new_position)!=0:
                    for (i, j) in new_position:
                        Arr[i][j]=1 #익은 토마토에 의해 익혔다고 표기
                        count+=1
                    day_count+=1
                position=copy.deepcopy(new_position) #익은 토마토에 의해 새롭게 익게된 토마토의 위치 업데이트
                new_position=[] #새롭게 익게된 토마토의 위치 초기화
    
    if count==M*N:
        print(day_count)
    else:
        print(-1)

if __name__ == "__main__":
    main()
"""
import copy

#상하좌우
dx=[-1, 1, 0, 0]
dy=[0, 0, -1, 1]

def BFS(x, y):
    q=[(x, y)] #익은 토마토만 담음
    visited[x][y]=True #방문 했다고 표기

    while q: #익은 토마토 주변만 탐색
        i, j = q.pop(0) #익은 토마토 위치 기준
        for (v, w) in zip(dx, dy): #주변 토마토 탐색
            nx, ny=i+v, j+w
            if 0<= nx < N and 0<= ny < M and visited[nx][ny]==False: #범위 안이며, 방문하지 않은(토마토가 없고, 이미 탐색한 곳을 제외한 부분)만 탐색
                visited[nx][ny]=True
                if Arr[nx][ny]==1: #익은 토마토라면,
                    q.append((nx, ny)) #익은 토마토만 담기
                if Arr[nx][ny]==0: #안익은 토마토라면,
                    new_position.append((nx, ny)) #익은 토마토에 의해 새롭게 익게될 토마토의 위치 저장

def main():
    global N, M, Arr, visited, new_position
    M, N = map(int, input().split())
    Arr = [list(map(int, input().split())) for _ in range(N)]

    position=[] #익은 토마토 위치 탐기
    visited=[[False]*M for _ in range(N)] #방문 표시 하기
    count=0
    for i in range(N): #처음 익은 토마토 위치 찾기
        for j in range(M):
            if Arr[i][j]==1: #토마토가 있는 곳만
                position.append((i, j)) #토마토 있는 곳 위치를 표기
                count+=1
            if Arr[i][j]==-1: #토마토가 없는 곳은 확인할 필요없으므로
                visited[i][j]=True #방문했다고 처리
                count+=1 #토마토가 없는 곳 세기

    if count==N*M:
        print(0)
        return True

    day_count=0
    new_position=[] #익은 토마토에 의해 새롭게 익게된 토마토의 위치 담기
    while position:
        for (i, j) in position: #익은 토마토만 탐색
            BFS(i, j)
            position.pop(0)
            if len(position)==0 and len(new_position) != 0:
                day_count+=1 #토마토 익은 날짜 세기
                for (i, j) in new_position:
                    Arr[i][j]=1 #익은 토마토에 의해 익혔다고 표기
                    count+=1
                position=copy.deepcopy(new_position) #익은 토마토에 의해 새롭게 익게된 토마토의 위치 업데이트
                new_position=[] #새롭게 익게된 토마토의 위치 초기화
    
    if count>=M*N:
        print(day_count)
    else:
        print(-1)

if __name__ == "__main__":
    main()