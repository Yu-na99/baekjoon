n = int(input())
arr = [int(input()) for _ in range(n)]
result = [0]*n #결과를 담기 위해서

if n==1: print(arr[0]); exit() #포도주가 1잔 이라면, 그 한잔만 출력 및 시스템 종료
if n==2: print(arr[0]+arr[1]); exit() #포도주가 2잔이라면, 두잔 더한 값 출력 및 시스템 종료

#포도주가 3잔 이상이라면,
result[0]=arr[0] #첫번째 결과에 첫번째 포도주 값 대입
result[1]=arr[0]+arr[1] #두번째 결과에 첫번째 포도주와 두번째 포도주 합한 값 대입
result[2]=max(arr[2]+arr[1], arr[2]+arr[0], result[1]) #세번째 결과에 세번째와 두번째 포도주, 세번째와 첫번째 포도주, 세번쨰 포도주를 선택하지 않은 값 중에 최대값을 대입
for i in range(3, n):
    #현재 결과에 현재 포도주를 선택하지 않은 경우, 현재 포도주와 이전전 포도주를 선택할 경우, 현재 포도주와 이전 포도주 그리고 이전전전 포도주를 선택할 경우 중에 최대값을 대입
    result[i]=max(result[i-1], result[i-2]+arr[i], result[i-3]+arr[i-1]+arr[i])

print(result[n-1]) #최종적으로 최대값으로 도출된 마지막 열을 출력
