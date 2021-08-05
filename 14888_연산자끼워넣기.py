def DFS(depth, total, plus, minus, multiply, divide):
    global max_v, min_v
    if depth==N: #깊이가 숫자 갯수만큼 증가했다면,
        max_v= max(max_v, total) #최대값 넣기
        min_v=min(min_v, total) #최소값 넣기
        return #중단
    
    if plus: #더하기 연산에 값이 있다면,
        DFS(depth+1, total+arr[depth], plus-1, minus, multiply, divide) #깊이를 하나 증가시키고, 더하기 갯수 하나 빼기, total에 더하기 연산 실행(초기 total에는 첫번째 숫자가 들어있고, arr[depth]은 두번째 숫자를 가리킴)
    if minus:
        DFS(depth+1, total-arr[depth], plus, minus-1, multiply, divide) #깊이를 하나 증가시키고, 빼기 갯수 하나 빼기, total에 빼기 연산 실행(초기 total에는 첫번째 숫자가 들어있고, arr[depth]은 두번째 숫자를 가리킴)
    if multiply:
        DFS(depth+1, total*arr[depth], plus, minus, multiply-1, divide) #깊이를 하나 증가시키고, 곱하기 갯수 하나 빼기, total에 곱하기 연산 실행(초기 total에는 첫번째 숫자가 들어있고, arr[depth]은 두번째 숫자를 가리킴)
    if divide:
        DFS(depth+1, int(total/arr[depth]), plus, minus, multiply, divide-1) #깊이를 하나 증가시키고, 나누기 갯수 하나 빼기, total에 나누기 연산 실행(초기 total에는 첫번째 숫자가 들어있고, arr[depth]은 두번째 숫자를 가리킴)

N = int(input()) #숫자 갯수
arr=list(map(int, input().split())) #숫자 리스트 형태로 저장
oper=list(map(int, input().split())) #연산자 리스트 형태로 저장

max_v=-1e9
min_v=1e9

DFS(1, arr[0], oper[0], oper[1], oper[2], oper[3]) #깊은 탐색
print(max_v) #최대값 출력
print(min_v) #최소값 출력