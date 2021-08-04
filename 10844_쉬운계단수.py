N = int(input())
NUMBER=9; VALUE=1000000000
arr=[[0]*(NUMBER+1) for _ in range(N)] #자릿수에 맞게 다차원 배열 생성
result=0 #결과 담을 변수

for i in range(1, NUMBER+1): #수의 길이가 1일 경우, 0 빼고 전부 1로 만들기
    arr[0][i]=1 #첫번째 수로 0이 올 수 없으므로

for i in range(1, N): #1~N까지
    for j in range(NUMBER+1): #0~9까지
        if j==0: arr[i][j]=arr[i-1][1]; continue #0일때, 이전 행의 1열 값을 들고온다
        if j==9: arr[i][j]=arr[i-1][8]; continue #9일때, 이전 행의 8열 값을 들고온다
        arr[i][j]=(arr[i-1][j-1]+arr[i-1][j+1])%VALUE #1~8일때, 이전 행의 1작은 열 값과 1큰 열 값을 들고와 더한다. 1,000,000,000을 나누는 이유는 계산 도중 수가 너무 커지는 것을 대비

for j in arr[N-1]: #마지막 행의 값을 모두 더한다.
    result+=j

print(result%VALUE) #최종 값 출력할 때, 1,000,000,000을 나눈다