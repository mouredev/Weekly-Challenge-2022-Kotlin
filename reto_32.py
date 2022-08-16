
print("Ingrese números; para terminar <exit>: ")

num_list = [] 
try:
    while True: 
        num_list.append(float(input()))        
# si no es un número 
except:
    num_list.sort() 
    print(num_list[len(num_list) -2])


