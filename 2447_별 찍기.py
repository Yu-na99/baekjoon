THREE=3

def stars(arr, n):
    num=THREE**(n+1)
    matrix=[]
    if n==0:
        for i in range(num):
            if i<THREE:
                matrix.append(arr[i]*THREE)
    else:
        for i in range(num):
            if i<(num/THREE):
                matrix.append(arr[i]*num)
            elif (num/THREE)<=i<(num/THREE)*2:
                matrix.append(arr[i-int(num/THREE)]+" "*num+arr[i-int(num/THREE)])
            else:
                matrix.append(arr[i-int(num/THREE)*2]*THREE)
    return matrix

n=N=int(input())
star=["***", "* *", "***"] #기본 별
cnt=0
while n!=3: #3의 승수 세는 부분
  n=int(n/3)
  cnt+=1

for i in range(cnt): #3의 승수만큼 반복
  star=stars(star, i) #반복 재귀

for i in star: #최종 별 출력
  print(i)