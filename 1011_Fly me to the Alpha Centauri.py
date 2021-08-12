T = int(input()) #테스트케이스의 개수
for i in range(T): #테스트케이스 수만큼 반복
    first, second = map(int, input().split()) #출발지와 도착지
    distance = second - first #출발지와 도착지 차이 거리
    num=1 #제곱근 알아내기 위한 변수
    while True: #제곱근 범위에 포함되는 제곱근을 찾기 위해 반복
        if num**2 <= distance < (num+1)**2: #제곱근 범위에 해당하면,
            break #반복문 중단
        num+=1 #제곱근 범위에 해당 안된다면, num 증가
    if num**2 == distance: #제곱근의 제곱과 거리 차이가 같다면,
        print(num*2-1) #두배의 제곱근에 빼기 1
    elif num**2 < distance <=num**2+num: #제곱근의 제곱에 제곱근을 더한 수보다 작으면,
        print(num*2) #두배의 제곱근
    else:  #제곱근의 제곱에 제곱근을 더한 수보다 크면,
        print(num*2+1) #두배의 제곱근에 더하기 1