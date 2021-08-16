from collections import deque #큐 사용

#상, 하, 좌, 우
dxs=[0, 0, -1, 1]
dys=[1, -1, 0, 0]

def BFS(x, y):
    global N, L, R, A, visited, flag
    q=deque() #큐로 생성
    position=[] #위치 저장

    q.append([x, y]) #큐에 초기 x, y 좌표값 추가
    position=[(x, y)] #초기 x, y 좌표값 등록
    visited[x][y]=True #전체 확인용

    total=A[x][y] #이동할 인구수 합
    while q: #큐가 비어질때까지
        nx, ny = q.popleft() #큐 맨앞에꺼 꺼내기
        for dx, dy in zip(dxs, dys): #상하좌우로 4번 탐색
            nextx, nexty = nx+dx, ny+dy #상하좌우 업데이트
            if nextx<0 or nextx>=N or nexty<0 or nexty>=N or visited[nextx][nexty] \
                or abs(A[nx][ny]-A[nextx][nexty])<L or abs(A[nx][ny]-A[nextx][nexty])>R: continue #범위 벗어나거나 방문했던 곳은 제외
            visited[nextx][nexty]=True #방문 표시
            q.append([nextx, nexty]) #큐 맨뒤에 추가
            position.append((nextx, nexty)) #위치 저장(추후 해당 위치의 인구수를 일괄 수정하기 위해서! 중요)
            total+=A[nextx][nexty] #이동할 인구 수 더하기

    if len(position) > 1: #저장된 위치가 2개 이상이라면,(1개는 초기 x, y 좌표 위치이므로)
        person=int(total/len(position)) #이동할 인구의 총 수에 나라 가짓 수 나누기
        for i, j in position: #position에 저장된 각 나라의 인구 수 변경
            A[i][j]=person #임의 변경
        flag=True #이동 유 표기

def main():
    global N, L, R, A, visited, flag

    N, L, R = map(int, input().split())
    A = [list(map(int, input().split())) for _ in range(N)]
    
    count=0 #이동 횟수 카운팅
    while True:
        flag=False #이동 유무 표기
        visited=[[False]*N for _ in range(N)] #방문 여부 확인용 및 이동 후 초기화(이동 후에는 인구 수가 변경되므로 다시 탐색이 필요한 부분! 중요)
        for i in range(N):
            for j in range(N):
                if visited[i][j] == True: continue #방문한 곳 이라면 탐색할 필요 없음
                BFS(i, j) #초기 x, y좌표에서 가지치기처럼 뻗어나가는 함수
        
        if not flag: #이동 무
            break
        count+=1 #이동 횟수 증가
    print(count) #최정 결과 출력
    
if __name__ =='__main__':
    main()
