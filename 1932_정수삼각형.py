n = int(input())
arr =[list(map(int, input().split())) for _ in range(n)]

for i in range(1, n): #두번째 행부터 끝까지
    for j in range(len(arr[i])): #해당 행의 열의 갯수만큼
        if j==0: arr[i][j]+=arr[i-1][j]; continue #첫번째 열은 이전 행의 첫번째 열밖에 대각선으로 이어져있으므로
        if j==len(arr[i])-1: arr[i][j]+=arr[i-1][j-1]; continue #마지막 열은 이전 행의 마지막 열밖에 대각선으로 이어져있으므로
        arr[i][j]+=max(arr[i-1][j-1], arr[i-1][j]) #중간 열은 이전 행의 대각선에 해당하는 값들 중 최대값을 선택

print(max(arr[n-1])) #마지막 행 중에서 가장 큰 값을 선택하여 출력