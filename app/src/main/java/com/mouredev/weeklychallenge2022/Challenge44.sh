#!/usr/bin/env bash
# -*- coding: utf-8 -*-

# ==========================================================
# Reto #44
# BUMERANES
# Fecha publicación enunciado: 02/10/22
# Fecha publicación resolución: 07/11/22
# Dificultad: FÁCIL
#
# Enunciado: Crea una función que retorne el número total de bumeranes de un array de números
# enteros e imprima cada uno de ellos.
# - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números seguidos, en el que el
#   primero y el último son iguales, y el segundo es diferente. Por ejemplo [2, 1, 2].
# - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] y [4, 2, 4]).
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.
#  ==========================================================

# =======
# USAGE
# =======
function usage() {
    cat <<EOF
Usage: ./Challenge4.sh -l <listado> -f <fichero> [-h]
Reto #44 : BUMERANES
Busca bomeranes en un listado de numeros.

-h  Muestra la ayuda

-l  Listado de números enteros separados por cualquier caracter

-f  Listado de número enteros separados por salto de linea  

EOF
}

# =======
# Globales
# =======
function allocate() {
    export ch_listado=()
}

# ======
# Eliminar las globales
# ======
function deallocate() {
    unset ch_listado
}

# =======
# verificar fichero
# $1 ruta al fichero
# =======
function verificarFichero() {
    [ ! -f "$1" ] && echo -e "\e[1;41m ERROR \e[0m No se ha encontrado el fichero $1" >&2 && deallocate && exit 1
}
# =======
# Parsear datos
# $1 cadena de datos
# =======
function parsearDatos() {
    while IFS= read -r line; do
        ch_listado+=("$line")
    done <<<"$1"
}

# =======

# =======
# MAIN
# =======
# Parsear opciones
allocate
[ $# -eq 0 ] && usage && deallocate && exit 1

while getopts "hl:f:" opcion; do
    case "$opcion" in
    l)
        parsearDatos "$(echo "$OPTARG" | grep -Eo "[[:digit:]]+")"
        ;;
    f)
        verificarFichero "$OPTARG"
        parsearDatos "$(cat "$OPTARG")"
        ;;
    \?) # Opción invalida
        echo -e "\e[1;41m ERROR \e[0m Opción invalidad: -$OPTARG" >&2
        usage && deallocate && exit 1
        ;;
    :) # Falta argumento
        echo -e "\e[1;41m ERROR \e[0m -$OPTARG requiere de un argumento" >&2
        usage && deallocate && exit 1
        ;;
    h | *)
        usage && deallocate && exit 0
        ;;
    esac
done

#Contar boomeranes
cuenta=0

if [ "${#ch_listado[@]}" -ge "3" ]; then
    for ((start = 0; start < $((${#ch_listado[@]} - 2)); start++)); do
        middle=$((start + 1))
        end=$((start + 2))
        if [ "${ch_listado[$start]}" -eq "${ch_listado[$end]}" ] && [ "${ch_listado[$start]}" -ne "${ch_listado[$middle]}" ]; then
            cuenta=$((cuenta + 1))
            echo '🪃​  [ '"${ch_listado[$start]}"' , '"${ch_listado[$middle]}"' , '"${ch_listado[$end]}"' ]' >&2
        fi
    done
fi

deallocate

# Imprimir resultado
if [ "$cuenta" -gt "0" ]; then
    echo -e "\e[1;42m TOTAL $cuenta 🪃  \e[0m" >&2
else
    echo -e "\e[1;41m NO HAY BUMERANES \e[0m" >&2
fi
exit 0
