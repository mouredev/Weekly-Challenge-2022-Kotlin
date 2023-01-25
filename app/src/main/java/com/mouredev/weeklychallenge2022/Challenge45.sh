#!/usr/bin/env bash
# -*- coding: utf-8 -*-

# ==========================================================
# Reto #45
# CONTENEDOR DE AGUA
# Fecha publicación enunciado: 07/11/22
# Fecha publicación resolución: 14/11/22
# Dificultad: MEDIA
#
# Enunciado: Dado un array de números enteros positivos, donde cada uno
# representa unidades de bloques apilados, debemos calcular cuantas unidades
# de agua quedarán atrapadas entre ellos.
#
# - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
#
#   ⬛⬛⬛🟧​⬛⬛
#   ⬛⬛⬛🟧​⬛⬛
#   🟧​💧💧🟧​⬛⬛
#   🟧​💧🟧​🟧​💧🟧​
#   🟧​💧🟧​🟧​💧🟧​
#   🟧​💧🟧​🟧​🟧​🟧​
#
#   Representando bloque con 🟧​︎, vacío con ⬛ y agua con 💧, quedarán atrapadas 7 unidades
#   de agua. Suponemos que existe un suelo impermeable en la parte inferior
#   que retiene el agua.
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
Usage: ./Challenge45.sh -l <listado> -f <fichero> [-h]
Reto #45 : CONTENEDOR DE AGUA
Devuelve cuantos espacios de agua quedan atrapados entre los bloques apilados indicados en el listado

-h  Muestra la ayuda

-l  Listado de contenedores apilados separados por cualquier caracter

-f  Listado de contenedores apilados separados por salto de linea  

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
# Verificar fichero
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
# Contar agua en una fila
# $1 fila
# =======
function getAgua() {
    local fila="$1"
    local resultado=()
    local agua=0
    local last=-1
    local colLength=${#ch_listado[@]}
    local col=0
    while [ $col -lt $colLength ]; do
        #echo $((${#ch_listado[@]} - 1)) >&2
        if [ "${ch_listado["$col"]}" -ge "$fila" ]; then
            resultado["$col"]="🟧​︎"
            if [ $last -eq "-1" ]; then
                last=$col
            else
                empty=$((last + 1))
                while [ $empty -lt $col ]; do
                    resultado["$empty"]="💧"
                    agua=$((agua + 1))
                    empty=$((empty + 1))
                done
                last=$col
            fi
        else
            resultado["$col"]="⬛"
        fi
        col=$((col + 1))
    done
    echo "${resultado[@]}" >&2
    echo "$agua"
}

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

# Numero de filas
fila=$(IFS=$'\n' && echo "${ch_listado[*]}" | sort -nr | head -n1)

# Contar agua
cuentaAgua=0

while [ "$fila" -gt "0" ]; do
    agua=$(getAgua "$fila")
    cuentaAgua=$((cuentaAgua + agua))
    fila=$((fila - 1))
done

deallocate

# Imprimir resultado
if [ "$cuentaAgua" -gt "0" ]; then
    echo -e "\e[1;42m TOTAL $cuentaAgua 💧  \e[0m" >&2
else
    echo -e "\e[1;41m NO HAY AGUA \e[0m" >&2
fi
exit 0
