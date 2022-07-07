package com.mouredev.weeklychallenge2022

/*
 * Reto #26
 * CUADRADO Y TRIÁNGULO 2D
 * Fecha publicación enunciado: 27/06/22
 * Fecha publicación resolución: 07/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 * - EXTRA: ¿Eres capaz de dibujar más figuras?
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

const n = 4

// square
for (let i = 1; i <= n; i++) {
  let row = ''
  for (let j = 1; j <=n; j++) {
  	row += ' * '
  }
  console.log(row)
}

' *  *  *  * '
' *  *  *  * '
' *  *  *  * '
' *  *  *  * '

// pyramid
for (let i = 1; i <=n; i++) {
  let emptyRow = ''
  for (let empty = 1; empty <= n-i; empty++) {
    emptyRow += ' '
  }

  let cellRow = ''
  for (let cell = 1; cell <= i; cell++) {
    cellRow += ' * '
  }
  console.log(emptyRow + cellRow + emptyRow)
}

'    *    '
'   *  *   '
'  *  *  *  '
' *  *  *  * '

// inverse pyramid
for (let i = n; i >= 1; i--) {
  let emptyRow = ''
  for (let empty = n-i; empty >=1; empty--) {
    emptyRow += ' '
  }

  let cellRow = ''
  for (let cell = i; cell >=1; cell--) {
    cellRow += ' * '
  }
  console.log(emptyRow + cellRow + emptyRow)
}

' *  *  *  * '
'  *  *  *  '
'   *  *   '
'    *    '