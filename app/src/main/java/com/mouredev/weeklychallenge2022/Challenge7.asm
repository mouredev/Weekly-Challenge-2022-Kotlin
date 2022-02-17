;Ingrese un texto e imprima la cantidad de palabras.
.8086
.model small
.stack 100h

.data
	salto db 0dh, 0ah, 24h
	consigna db "Ingrese un texto de hasta 255 caracteres y finalice con un salto de linea:", 0dh, 0ah, 3Eh, 24h
	cartel1 db "El texto ingresado es: ", 0dh, 0ah, 24h
	cartel2 db "Palabras: ", 24h
	usrTxt db 255 dup (24h), 24h
	palabras db "000", 0dh, 0ah, 24h

.code
	main proc
		mov ax, @data
		mov ds, ax

		mov ah, 9
		mov dx, offset consigna
		int 21h

		mov bx, 0
leer:
		cmp bx, 255
		je terminar

		mov ah, 1		;Leo un caracter
		int 21h

		mov usrTxt[bx], al

		cmp bx, 0		;Si estoy en el primer caracter
		je loopleer 	;Salteo lo que sigue

		cmp al, 0dh
		je check

		cmp al, 20h		;Si no es un espacio
		jne loopleer	;Salteo lo que sigue

	check:
		cmp usrTxt[bx-1], 20h	;Si antes habia un espacio
		je loopleer				;Salteo lo que sigue

	unidad:
		;Incremento el contador en ascii
		cmp palabras[2], 39h	;Si tengo un 9 en la unidad
		je decena				;Paso a la decena
		inc palabras[2]			;Si no, incremento la unidad
		jmp loopleer
	decena:
		mov palabras[2], 30h	;Pongo un 0 en la unidad
		cmp palabras[1], 39h
		je centena
		inc palabras[1]			;Incremento la decena
		jmp loopleer
	centena:
		mov palabras[1], 30h
		inc palabras[0]	

loopleer:
		cmp al, 0dh
		je terminar		;Si habia ingresado un salto me salgo del loop

		inc bx
		jmp leer

terminar:
		mov ah, 9
		mov dx, offset cartel1
		int 21h

		mov ah, 9
		mov dx, offset usrTxt
		int 21h

		mov ah, 9
		mov dx, offset salto
		int 21h

		mov ah, 9
		mov dx, offset cartel2
		int 21h

		mov ah, 9
		mov dx, offset palabras
		int 21h

		mov ax, 4c00h
		int 21h
	main endp
end main