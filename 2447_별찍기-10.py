def RECT(start, mid1, mid2, end):
    global arr
    for i in range(end):
        for j  in range(end):
            if (i==start+1 or i==mid1+1, j==mid2+1) \
               and (j==start+1 or j==mid1+1, j==mid2+1): continue
            if (i==mid1 or i==mid1+1 or i==mid1+2) \
               and (j==mid1 or j==mid1+1 or j==mid1+2): continue
            print("hi")
            arr[i][j]='*'
        
def DEVICE(start, end, N): #입력 변수: 시작위치, 크기
    mid_1= int(N/3); mid_2=int(N/3)*2 #9(3,6), 27(9(3,6),18(21,24))
    mid_v1=start+mid_1; mid_v2=start+mid_2
    if mid_v2-mid_v1 == 3:
        RECT(start, mid_v1, mid_v2, end) #0, 3, 6, 9
    else:
        DEVICE(start, mid_v1, mid_v1-start)
        DEVICE(mid_v1, mid_v2, mid_v2-mid_v1)
        DEVICE(mid_v2, end, end-mid_v2)

N=int(input())
arr=[[' ']*N for _  in range(N)]
DEVICE(0, N, N)
print(arr)
