from collections import deque
M, N = map(int, input().split())
Arr = [list(map(int, input().split())) for _ in range(N)]

position=deque() #파이썬 라이브러리를 사용하지 않아, 시간초과에 늪에 빠졌었다
for i in range(N):
    for j in range(M):
        if Arr[i][j]==1: #익은 토마토의 위치만 표기하기 위해
            position.append((i, j))

#상하좌우
dx=[-1, 1, 0, 0]
dy=[0, 0, -1, 1]
while position: #익은 토마토만 탐색
    i, j = position.popleft()
    for (v, w) in zip(dx, dy):
        nx, ny=i+v, j+w
        if 0<=nx<N and 0<=ny<M: #범위 내에
            if Arr[nx][ny]==0: #익지 않은 토마토가 있다면,
                position.append((nx, ny)) #곧 익을 것이기 때문에 익은 토마토로 표기
                Arr[nx][ny] = Arr[i][j] + 1 #이전 값에 1을 더하여 며칠이 지났는지 확인할 수 있음

total = Arr[0][0] #최대값 기준 찾기
for i in range(N):
    for j in range(M):
        if Arr[i][j] == 0: #익지 않은 토마토가 있다면,
            print(-1) #모두 익지 못하는 상황이라고 출력
            exit() #시스템 종료
        total = max(Arr[i][j], total) #최대값 찾기
print(total-1) #익은 토마토가 1이기 때문에, 1이 하나 더해졌으므로 1을 빼줌
