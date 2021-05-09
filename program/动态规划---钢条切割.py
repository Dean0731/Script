# 自底向上
def f(p,n,r):
    r[0] = 0
    for j in range(1,n+1):
        q = float("-inf")
        for i in range(1,j+1):
            q = max(q,p[i]+r[j-i])
        r[j]=q
    return r[n]
# 自顶向下
def f2(p,n,r):
    if r[n]>=0:
        return r[n]
    if n==0:
        q = 0
    else:
        q = float("-inf")
        for i in range(1,n+1):
            q = max(q,p[i]+f2(p,n-i,r))
    r[n] = q
    return q
if __name__ == '__main__':
    # 价格定义 长度为i的钢条售价为p[i]
    p = [0,1,5,8,9,10,17,17,20,24,30]
    # 钢条长度
    n = 9
    # 动态规划存储
    r = [float("-inf") for i in range(n+1)]
    f1 = f(p,n,r)
    f2 = f2(p,n,r)
    print(f1)
    print(f2)