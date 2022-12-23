int_a = 1
int_b = 0
int_c = 0
""""" 
0+1=1
1+1=2
2+1=3
3+2=5
5+3=8
---------
formula
---------
a+b=c
b = a
a = c
"""""
print(int_c)
for i in range(49): #hace el bucle for con un rango de 0 a 50
    int_c = int_a + int_b
    print(int_c)
    int_b = int_a
    int_a = int_c
    pass