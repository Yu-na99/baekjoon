"""
import copy
import operator

N=int(input()) #20개 > 20*20=400개 
arr=[list(map(int, input().split())) for _ in range(N*N)]
seat=[[0]*N for _ in range(N)] #확정지은 자리

seat[1][1]=arr[0][0] #맨 처음 학생은, (2,2) 자리에 앉기
dx=[-1, 0, 0, 1]; dy=[0, -1, 1, 0] #상, 좌, 우, 하

L_seat=[arr[0][0]]
D_seat={arr[0][0]:(1,1)}

for i in range(1, N*N):
    D_check={}
    FLAG=False
    check=copy.deepcopy(seat)
    m_num=-1
    for j in range(1,N+2):
        if arr[i][j] in L_seat: #앉은 학생 중에 좋아하는 학생이 있는 경우,
            FLAG=True
            px, py = D_seat[arr[i][j]] #앉은 학생 상, 좌, 우, 하 확인
            for x, y in zip(dx, dy):
                nx, ny = px+x, py+y
                if nx<0 or nx>=N or ny<0 or ny>=N or seat[nx][ny]!=0: continue
                check[nx][ny]+=1
                D_check[(nx, ny)]=check[nx][ny]

    if FLAG: #좋아하는 학생이 한명이라도 있었는 경우,
        D_check=sorted(D_check.items(), key=operator.itemgetter(1))
        pop0=D_check.pop(0) #맨 앞에꺼 들고오기
        if len(D_check)==0:
            D_seat[arr[i][0]]=pop0[0]
            seat[pop0[0][0]][pop0[0][1]]=arr[i][0]
            L_seat.append(arr[i][0])
        else:
            pop9=D_check.pop()#맨 뒤에꺼 들고오기
            if pop0[1]<pop9[1]: #좋아하는 학생이 있는 자리의 수가 가장 많은 곳이 있는 경우,
                D_seat[arr[i][0]]=pop9[0]
                seat[pop9[0][0]][pop9[0][1]]=arr[i][0]
                L_seat.append(arr[i][0])
            else: #좋아하는 학생이 있는 자리의 수가 모두 똑같을 경우,
                D_seat[arr[i][0]]=pop0[0]
                seat[pop0[0][0]][pop0[0][1]]=arr[i][0]
                L_seat.append(arr[i][0])
    else: #좋아하는 학생이 한명도 없는 경우,
        for i in range(N):
            for j in range(N):
                if seat[i][j]!=0: continue
                num=4
                for x, y in zip(dx, dy):
                    nx, ny = i+x, j+y
                    if nx<0 or nx>=N or ny<0 or ny>=N or seat[nx][ny]!=0: num-=1
                if m_num<num:
                    m_num=num
                    tx, ty=i, j
        seat[tx][ty]=arr[i][0]
        D_seat[arr[i][0]]=(tx, ty)
        L_seat.append(arr[i][0])
print(seat)
"""

from collections import defaultdict

""" 0. 입력 받기 및 초기화 """
N=int(input()) #20개 > 20*20=400개 400*20*20*4*4b = 2,560,000

student_list=[] #학생 리스트
student_dic = defaultdict(list)
for _ in range(N**2):
    student, *s_like = map(int,input().split())
    student_dic[student] = s_like #각각의 학생들이 좋아하는 학생들을 사전형식으로
    student_list.append(student)

seat=[[0]*N for _ in range(N)] #확정지은 자리
seat[1][1]=student_list[0] #맨 처음 학생 자리 고정(2,2)


""" 1. 자리 정하기 """
dx=[-1, 0, 0, 1]; dy=[0, -1, 1, 0] #상, 좌, 우, 하
for cnt in range(1, N*N): #학생 수만큼
    check=[[0]*N for _ in range(N)] #확정지은 자리
    m_num=-1
    for i in range(N):
        for j in range(N):
            if seat[i][j]: continue #비어있는 자리가 아니라면, 탐색하지 않음
            for x, y in zip(dx, dy): #비어있는 자리만 탐색
                nx, ny = i+x, j+y
                if nx<0 or nx>=N or ny<0 or ny>=N: continue
                if seat[nx][ny]==0: check[i][j]+=1 #빈 자리라면, 가치 1 추가
                if seat[nx][ny]!=0: #자리가 있다면,
                    for count in range(1, N+2): #그 자리가 해당 학생이 좋아하는 학생이라면, 가치 10 추가
                        if seat[nx][ny] in student_dic[student_list[cnt]]:
                            check[i][j]+=10

                """ 가치가 가장 큰 자리의 위치 저장 """
                if m_num<check[i][j]: #가치가 가장 큰 값
                    m_num=check[i][j]
                    px, py=i, j #처음으로 가치가 가장 큰 값의 위치 저장

    """ 자리 확정 """
    seat[px][py]=student_list[cnt] #자리 확정


""" 2. 학생 만족도 계산하기 """
total=0
for i in range(N):
    for j in range(N):
        number=0
        for x, y in zip(dx, dy):
            nx, ny = i+x, j+y
            if nx<0 or nx>=N or ny<0 or ny>=N: continue
            if seat[nx][ny] in student_dic[seat[i][j]]: number+=1 #좋아하는 학생과 앉았다면, 카운팅
        if number!=0: #만족도가 0이 아니라면,
            total+=10**(number-1)

print(total) #최종 학생 만족도 출력