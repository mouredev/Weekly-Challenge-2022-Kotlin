# Ejercicio 32 en Go

Dado un listado de números, encuentra el SEGUNDO más grande.

Nota: 
1.- Como el slice no quise hacerlo, cree una función que lo genera.
2.- Los comentarios y nombres en Go los intento poner en inglés, porque es una buena práctica.

## Como ejecutar

En Go existen 2 formas de correr el programa y lo explico a continuación

1.- Modo normal, es el que genera un binario y luego lo corres como cualquier otra aplicación. Pero ojo en Windows puede que falle por bloquedo del antivirus, por eso debes tener ojo que tu carpeta **go** (que es donde está el compilar) tenga las excepciones necesarias. En Linux y Mac no tendrás problemas. 

Generas el binario
```bash
$ go build main.go
```

Ejecutas el binario (en caso de Windows ejecutas el .EXE y te aconsejo hacero desde consola), en Linux y Mac te lo dejo a continuación.
```bash 
$ ./main
```

2.- Modo desarrollo, que es el que más se usa para desarrollar, te genera el binario y lo ejecuta, una vez terminado el programa elimina el binario.

```bash 
$ go run main.go
```

Nota: es necesario tener definido el **GOPATH** y es buena practica definir el **GOROOT**.
