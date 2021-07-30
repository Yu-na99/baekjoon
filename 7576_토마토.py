from collections import deque
M, N = map(int, input().split())
Arr = [list(map(int, input().split())) for _ in range(N)]

position=deque()
for i in range(N):
    for j in range(M):
        if Arr[i][j]==1:
            position.append((i, j))

dx=[-1, 1, 0, 0]
dy=[0, 0, -1, 1]
while position:
    i, j = position.popleft()
    for (v, w) in zip(dx, dy):
        nx, ny=i+v, j+w
        if 0<=nx<N and 0<=ny<M:
            if Arr[nx][ny]==0:
                position.append((nx, ny))
                Arr[nx][ny] = Arr[i][j] + 1

total = Arr[0][0]
for i in range(N):
    for j in range(M):
        if Arr[i][j] == 0:
            print(-1)
            exit()
        total = max(Arr[i][j], total)
print(total-1)
