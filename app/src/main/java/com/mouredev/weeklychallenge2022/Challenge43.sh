#!/usr/bin/env bash
# -*- coding: utf-8 -*-

# ==========================================================
# Reto #43
# TRUCO O TRATO
# Fecha publicación enunciado: 24/10/22
# Fecha publicación resolución: 02/11/22
# Dificultad: FÁCIL
#
# Enunciado: Este es un reto especial por Halloween.
# Deberemos crear un programa al que le indiquemos si queremos realizar "Truco o Trato" y
# un listado (array) de personas con las siguientes propiedades:
# - Nombre de la niña o niño
# - Edad
# - Altura en centímetros
#
# Si las personas han pedido truco, el programa retornará sustos (aleatorios)
# siguiendo estos criterios:
# - Un susto por cada 2 letras del nombre por persona
# - Dos sustos por cada edad que sea un número par
# - Tres sustos por cada 100 cm de altura entre todas las personas
# - Sustos: 🎃 👻 💀 🕷 🕸 🦇
#
# Si las personas han pedido trato, el programa retornará dulces (aleatorios)
# siguiendo estos criterios:
# - Un dulce por cada letra de nombre
# - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
# - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
# - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.
#
#  ==========================================================

# =======
# USAGE
# =======
function usage() {
    cat <<EOF
Usage: ./Challenge43.sh -t <Tipo> -f <fichero de personas> [-h]
Reto #43 : TRUCO O TRATO
Imprime dulces o sustos.

-h  Muestra la ayuda

-t  Selecciona el tipo de interación
        TRUCO: Imprimir sustos
        TRATO: Imprimir dulces
        PLANTILLA: Crea una plantilla para especificar las personas

-f  Ruta al fichero csv con los datos de la personas con línea de cabecera.
        Nombre,Edad,Altura
        Jose,10,110
        Lucia,9,100     

EOF
}

# =======
# Globales
# =======
export ch_tipo=DEFAULT
export ch_fichero=DEFAULT
export ch_csv=()
export ch_loc_col_nombre
export ch_loc_col_edad
export ch_loc_col_altura
export ch_persona
export ch_nombre
export ch_edad
export ch_altura

# ======
# Eliminar las globales
# ======
function deallocate() {
    unset ch_tipo
    unset ch_fichero
    unset ch_csv
    unset ch_loc_col_nombre
    unset ch_loc_col_edad
    unset ch_loc_col_altura
    unset ch_persona
    unset ch_nombre
    unset ch_edad
    unset ch_altura
}

# =======
# verificar fichero
# =======
function verificarFichero() {
    [ ! -f "$ch_fichero" ] && echo -e "\e[1;41m ERROR \e[0m No se ha encontrado el fichero $ch_fichero" >&2 && deallocate && exit 1
}
# =======
# Parsear fichero
# =======
function parsearFichero() {
    ch_loc_col_nombre=$(head -1 $ch_fichero | tr ',' '\n' | nl | grep -w "Nombre" | tr -d " " | awk -F " " '{print $1}')
    ch_loc_col_edad=$(head -1 $ch_fichero | tr ',' '\n' | nl | grep -w "Edad" | tr -d " " | awk -F " " '{print $1}')
    ch_loc_col_altura=$(head -1 $ch_fichero | tr ',' '\n' | nl | grep -w "Altura" | tr -d " " | awk -F " " '{print $1}')
    while IFS= read -r line; do
        ch_csv+=("$line")
    done < <(tail -n +2 $ch_fichero)

}

# ======
# Parsear persona
# ======
function parsearPersona() {
    while IFS="," read -r nombre edad altura; do
        ch_nombre=$nombre
        ch_edad=$edad
        ch_altura=$altura
    done < <(echo "$ch_persona" | cut -d "," -f"$ch_loc_col_nombre","$ch_loc_col_edad","$ch_loc_col_altura")
}

# =======
# MOSTRAR Sustos o dulces
# $1 numero de sustos o dulces
# $2 sustos o dulces posibles
# =======
function imprimir() {
    pendiente=$1
    posibles=$2
    resultado=""
    while [ "$pendiente" -ne 0 ]; do
        resultado="$resultado$(echo "$posibles" | grep -o "." | shuf -n1) "
        pendiente=$((pendiente - 1))
    done
    echo "$resultado" && deallocate && exit 0
}

# =======
# TRUCO
# =======
function truco() {
    verificarFichero
    parsearFichero
    sumAltura=0
    sustos=0

    for persona in "${ch_csv[@]}"; do
        ch_persona=$persona
        parsearPersona
        sustos=$((sustos + $(echo "$ch_nombre" | grep -o "\w" | wc -l) / 2))
        [ $((ch_edad % 2)) -eq 0 ] && sustos=$((sustos + 2))
        sumAltura=$((sumAltura + ch_altura))
    done

    sustos=$((sustos + 3 * sumAltura / 100))

    imprimir $sustos "🎃👻💀🕷🕸🦇"
}

# =======
# TRATO
# =======
function trato() {
    verificarFichero
    parsearFichero
    dulces=0

    for persona in "${ch_csv[@]}"; do
        ch_persona=$persona
        parsearPersona
        dulces=$((dulces + $(echo "$ch_nombre" | grep -o "\w" | wc -l)))
        [ "$ch_edad" -gt 10 ] && ch_edad=10
        dulces=$((dulces + ch_edad / 3))
        [ "$ch_altura" -gt 150 ] && ch_altura=150
        dulces=$((dulces + 2 * ch_altura / 50))
    done

    imprimir $dulces "🍰🍬🍡🍭🍪🍫🧁🍩"
}

# =======
# MAIN
# =======
# Parsear opciones
[ $# -eq 0 ] && usage && deallocate && exit 1

while getopts "ht:f:" opcion; do
    case "$opcion" in
    t)
        ch_tipo=$(echo "$OPTARG" | tr '[:lower:]' '[:upper:]')
        ;;
    f)
        ch_fichero=$OPTARG
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

# Verificar opciones
case "$ch_tipo" in
TRUCO)
    truco
    ;;
TRATO)
    trato
    ;;
PLANTILLA)
    {
        echo Nombre,Edad,Altura
        echo José,10,110
        echo Lucia,9,100
    } >>./platilla.csv
    echo -e "\e[1;42m EXITO \e[0m plantilla crea." >&2
    deallocate && exit 0
    ;;
DEFAULT)
    echo -e "\e[1;41m ERROR \e[0m El tipo de interacción no se ha indicado" >&2
    usage && deallocate && exit 1
    ;;
*)
    echo -e "\e[1;41m ERROR \e[0m Tipo de interacción invalida: -$ch_tipo" >&2
    usage && deallocate && exit 1
    ;;
esac
