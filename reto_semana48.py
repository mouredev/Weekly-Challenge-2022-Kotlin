from datetime import datetime, timedelta

while True:
    try:
        date = input("Introduzca la fecha deseada con el siguiente formato DD/MM/YYYY")
        hour = input("Introduzca la hora que es actualmente con el siguiente formato hh:mm:ss")

        client_datetime = date + " " + hour
        format_date = datetime.strptime(client_datetime, "%d/%m/%Y %H:%M:%S")

        first = datetime(2022, 12, 1)
        last = datetime(2022, 12, 25)

        dates_dic = {}
        gifts = ["Curso Python", "Pokemon escarlata", "Pokemon purpura", "Teclado mecánico", "Ratón Logitech", "Cascos HyperX",
                 "Pantalla Lenovo", "Disco duro SSD 1TB", "Portatil ASUS", "Raspberry Pi 4", "Mochila Portatil", "Cascos",
                 "Silla Secret Lab", "Base PC", "Hub USB", "Libro 'Curso intensivo de Python'", "Café para 1 año",
                 "Subscripción anual", "Sudadera", "Game Boy Advance morada", "Año de Spotify premium", "Año de Netflix",
                 "Smartwatch", "Cafetera Nespresso", "Monitor MSI"]

        date_list = [first + timedelta(days=d) for d in range((last - first).days + 1)]

        counter = 0

        for element in date_list:
            dates_dic["{}".format(element.date())] = "{}".format(gifts[counter])
            counter += 1

        if str(format_date.date()) in dates_dic:
            print("El regalo es: {}.\n".format(dates_dic[str(format_date.date())]))
            limit = datetime(year=format_date.year, month=format_date.month,
                             day=format_date.day + 1) - format_date
            print("Te quedan {} para participar".format(limit))

        # SI LA FECHA NO LLEGÓ TODAVÍA O SE PASO YA

        else:
            # Fechas del calendario
            calendar_start = datetime(2023, 12, 1, 00, 00, 00)
            calendar_end = datetime(2023, 12, 24, 23, 59, 59)

            if format_date < calendar_start:        # Si todavia no llegó la fecha
                tiempo = calendar_start - format_date
                print("Tiempo restante -> {}".format(tiempo))

            elif format_date > calendar_end:        # Si ya pasó la fecha
                tiempo = format_date - calendar_end
                print("Tiempo transcurrido -> {}".format(tiempo))
        break
    except ValueError:
        print("No son valores validos")