""" package com.mouredev.weeklychallenge2022

/*
 * Reto #48
 * EL CALENDARIO DE ADEVIENTO 2022
 * Fecha publicación enunciado: 28/11/22
 * Fecha publicación resolución: 05/12/22
 * Dificultad: FÁCIL
 *
 * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
 * 24 días, 24 regalos sorpresa relacionados con desarrollo de software, ciencia y tecnología desde el 1 de diciembre.
 *
 * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne lo siguiente:
 * - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
 * - Si la fecha es anterior: Cuánto queda para que comience el calendario.
 * - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
 *
 * Notas:
 * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00 y finaliza a las 23:59:59.
 * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos y segundos.
 * - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo del calendario de aDEViento hasta el día de su corrección (sorteo exclusivo para quien entregue su solución).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */ """


from datetime import datetime


def adviento_lottery(date: datetime) -> str:

    REWARDS: dict[int, str] = {
        1: "Taza de MoureDev", 2: "Camiseta de MoureDev", 3: "Calcetines de MoureDev",
        4: "Gorra de MoureDev", 5: "Pantalón de MoureDev", 6: "Calzones de MoureDev",
        7: "Sudadera de MoureDev", 8: "Sartén de MoureDev", 9: "Jarra de MoureDev",
        10: "Bolso de MoureDev", 11: "Botella de MoureDev", 12: "Mochila de MoureDev",
        13: "Funda de MoureDev", 14: "Sábanas de MoureDev", 15: "Almohada de MoureDev",
        16: "Colchón de MoureDev", 17: "Armario de MoureDev", 18: "Teclado de MoureDev",
        19: "Ratón de MoureDev", 20: "Stream Deck de MoureDev", 21: "Cámara de MoureDev",
        22: "Auriculares de MoureDev", 23: "Ordenador de MoureDev", 24: "MoureDev pa ti sólo!!!"
    }

    DATE_START: datetime = datetime(2022, 12, 1)
    DATE_END: datetime = datetime(2022, 12, 24)

    date: datetime = date.replace(microsecond=0)

    if date >= DATE_START and date <= DATE_END:

        return f"El premio de hoy es: {REWARDS[date.day]}. Y faltan {datetime(date.year, date.month, date.day + 1) - date} para terminar el evento"

    elif date < DATE_START:

        return f"Todavía faltan {DATE_START - date} para que empiezen los eventos"

    else:

        return f"Los eventos terminaron hace {date - DATE_END}"


print(adviento_lottery(datetime(2022, 12, 22, 23, 59, 59)))
print(adviento_lottery(datetime(2023, 11, 30, 22)))
print(adviento_lottery(datetime.now()))
print(adviento_lottery(datetime(2022, 12, 24 , 0, 0, 0)))