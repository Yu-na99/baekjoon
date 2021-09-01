N, H = map(int, input().split()) # 동굴 길이, 동굴 높이

# 석순과 종유석 배열에 담기
down=[0]*(H+1); up=[0]*(H+1)
for i in range(N):
    data=int(input())
    if i%2==0: down[data]+=1 # 석순
    else : up[data]+=1 # 종유석
downSum=sum(down)

result=[0]*(H+1)
upAdd=up[H]; downAdd=down[1]
result[1]=(downSum+upAdd)

for i in range(2, H+1): # 2, 3, 4, 5
    upAdd+=up[H-i+1]
    result[i]+=(downSum-downAdd)+(upAdd)
    downAdd+=down[i]
del result[0]
print(result)