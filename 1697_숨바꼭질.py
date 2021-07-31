from collections import deque
N, K = map(int, input().split())
MAX=10**5 #수빈이와 동생이 갈 수 있는 최대
distance=[0]*(MAX+1) #거리를 계산하는 용도(+1을 해줘야 index 오류가 안가기 때문)

q=deque()
q.append(N) #수빈이 위치 넣기
while q:
    x=q.popleft() #
    if x == K: #동생 위치와 
        print(distance[K]) #수빈이가 동생을 찾는 가장 빠른 시간
        break #멈춰!
    for nx in (x-1, x+1, x*2): #좌우로 가거나 순간이동
        if 0<= nx <= MAX and distance[nx]==0: #범위 안에서 방문하지 않은 곳만
            distance[nx]=distance[x]+1 #이전 거리에서 1초 더함
            q.append(nx) #해당 거리를 큐에 넣음