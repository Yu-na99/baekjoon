N = int(input())
Arr = [list(map(int, input().split())) for _ in range(N)]
nRGB=3 #열은 RGB로 구성되어 3개 있음
dist = [[0]*nRGB for _ in range(N)] #최소비용을 담을 2차원 리스트


dist[0][0]=Arr[0][0]; dist[0][1]=Arr[0][1]; dist[0][2]=Arr[0][2] #첫 행 값 담기
for n in range(1, N): #두번째 줄부터 끝까지 계산
    for i in range(nRGB): #RGB 전부 탐색
        if i == 0: dist[n][i]=min(dist[n-1][i+1], dist[n-1][i+2])+Arr[n][i] #0번째 열이라면, 이전 행의 1, 2번째 열 값 중 최소값을 선택하여 비용을 합산(이전 행의 0번째 열 값을 못넣는 이유는 이웃한 집은 같은 색을 칠할 수 없기 때문에)
        elif i == 1: dist[n][i]=min(dist[n-1][i-1], dist[n-1][i+1])+Arr[n][i] #1번째 열이라면, 이전 행의 0, 3번째 열 값 중 최소값을 선택하여 비용을 합산(이전 행의 0번째 열 값을 못넣는 이유는 이웃한 집은 같은 색을 칠할 수 없기 때문에)
        else: dist[n][i]=min(dist[n-1][i-2], dist[n-1][i-1])+Arr[n][i] #2번째 열이라면, 이전 행의 0, 1번째 열 값 중 최소값을 선택하여 비용을 합산(이전 행의 0번째 열 값을 못넣는 이유는 이웃한 집은 같은 색을 칠할 수 없기 때문에)

print(min(dist[N-1][0],dist[N-1][1], dist[N-1][2])) #마지막 N번째 행에서 최소비용 값을 출력