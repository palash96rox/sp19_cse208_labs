import sys

def to_bin(x,size=8):
  x = bin(x)[2:]
  if len(x) < size:
    x = '0'*(size-len(x)) + x
  return x

# b = b''
def divide_into_blocks(b,size=8):
    arr = []
    if size==8:
      for x in b: arr.append(to_bin(x,size))
    return arr

# ew.
def add_bin(a,b):
  size = len(a)
  s,c = ['0']*size,'0'
  a,b = a[::-1],b[::-1]
  for i in range(size):
    if c=='1' and a[i]=='1' and b[i]=='1': s[i],c = '1','1'
    elif c=='0' and a[i]=='1' and b[i]=='1': s[i],c = '0','1'
    elif c=='0' and a[i]=='0' and b[i]=='0': s[i],c = '0','0'
    elif c=='1' and (a[i]=='1' or b[i]=='1'): s[i],c = '0','1'
    else: s[i],c = '1','0'
  if c=='1':
    for i in range(size):
      if s[i] == '0': s[i] == '1'
      if i==size-1: s = ['0']*size
  return ''.join(x for x in s[::-1])

def sum(arr,size=8):
  sum = '0'*size
  for x in arr: sum = add_bin(sum,x)
  return sum

def complement(x):
  x = list(x)
  for i in range(len(x)):
    if x[i] == '0': x[i] = '1'
    else: x[i] = '0'
  return ''.join(m for m in x)

if __name__ == '__main__':
  f = None
  if len(sys.argv) > 1: 
    f = open(sys.argv[1],'rb')
    arr = divide_into_blocks(f.read())
    s = sum(arr)
    checksum = complement(s)
    print(int(checksum,2))