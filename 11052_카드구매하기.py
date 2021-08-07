N = int(input()) #민규가 구매하려는 카드 개수
cost = list(map(int, input().split())) #카드 개수에 따른 카드 가격
dp = [0 for _  in range(N+1)] #N+1개 배열 초기화

cost.insert(0, 0) #0번째 인덱스에 0을 집어넣기, 기존 숫자들은 뒤로 밀려남
for i in range(1, N+1): #1부터 N까지
    for j in range(1, i+1): #1부터 i까지
        dp[i] = max(dp[i], dp[i-j]+cost[j]) #최대값 찾기

print(dp[N])