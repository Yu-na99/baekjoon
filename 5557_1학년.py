N=int(input())
arr=list(map(int, input().split()))

MIN=0; MAX=20
dp=[[-1]*(MAX+1) for _ in range(N)] # N-1행 21열 생성

def check(depth, total):
    print(depth)
    if total<MIN or total>MAX: return 0 #범위를 벗어난 곳은 0을 반환
    
    if dp[depth][total]!=-1: #이미 해당 값이 정답이 될 수 있는 행렬이면,
        return dp[depth][total] #해당 위치의 값을 반환하여 더해질 수 있게 만듦

    if depth==N-1: #깊이가 끝까지 왔다면,
        if total==arr[N-1]: #와중에 정답이랑 일치하면,
            return 1 #이건 되는 값이라고 알려주기
        return 0 #정답이랑 일치하지 않으면, 안된다고 알려주기

    dp[depth][total]=0 #들렸다고 표기, 만약 해당 값이 정답이 될 수 있는 행렬이면, 아래에서 값이 변함
    dp[depth][total]+=check(depth+1, total+arr[depth]) #최종 깊이까지 더하기
    dp[depth][total]+=check(depth+1, total-arr[depth]) #최종 깊이까지 빼기
    return dp[depth][total]

print(check(1, arr[0]))
