global _start
section .text

_start:
    mov rax, [rsp]
    cmp rax, 0x5
    je continue

    mov rdi, 123
    mov rax, 0x3c
    syscall

continue:
    mov rdi, [rsp+40]
    call atoi
    mov r11, rax ; defensa pokemon 2
    mov rdi, [rsp+32]
    call atoi
    mov r10, rax ; ataque pokemon 1
    mov rdi, [rsp+24]
    call atoi
    mov r9, rax ; tipo pokemon 2
    mov rdi, [rsp+16]
    call atoi
    mov r8, rax ; tipo pokemon 1
    
    mov rax, r10 ;rax = 60
    xor rdx, rdx ;rdx = 0
    div r11      ;rax = rax / rbx = 60 / 25 = 2, rdx = 10
    mov rbx, 50  ;rbx = 50
    mul rbx

    call get

    mov rdi, rax
    mov rax, 0x3c
    syscall 

get:
    mov rdx, r8
    cmp r8,r9
    jl  less
    jg   greater
    minus:
        shr rax, 0x1
        ret
    less:
        cmp r9, 0x3
        jne skip
        ret
    skip:
        sub r9, r8
        cmp r9, 0x1
        jne minus
    plus:
        shl rax, 0x1
        ret
    greater:
        sub rdx, r9
        cmp rdx, 0x1
        je minus
        cmp r9, 0x0
        je plus
        ret

atoi:
    mov rax, 0            
     
convert:
    movzx rsi, byte [rdi] 
    test rsi, rsi         
    je done
    
    cmp rsi, 48          
    jl error
    
    cmp rsi, 57          
    jg error
     
    sub rsi, 48          
    imul rax, 10          
    add rax, rsi          
    
    inc rdi              
    jmp convert

error:
    mov rax, -1           
 
done:
    ret                   