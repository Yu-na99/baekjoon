gems=["A", "B", "B", "C", "A"]


n_gems=len(set(gems)) #보석 종류 갯수 구하기(set은 리스트 중복 제거)

start=0; end=len(gems)
#보석의 모든 종류를 포함하는 끝 구간을 찾음
for e in range(end):
    check=gems[start:e] #시간 구간을 맨 처음으로 설정
    if len(set(check))==n_gems:
        end=e
        break
    
start=0
for s in range(end,start,-1):
    if len(set(check[s:end]))==n_gems:
        start=s
        break

print(start+1, end)
