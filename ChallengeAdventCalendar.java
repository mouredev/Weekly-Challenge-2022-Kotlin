package com.pruebas.junior;


import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.util.HashMap;
import java.util.Map;

public class ChallengeAdventCalendar {

    public String adventCalendar(LocalDateTime dateTime) {

        String result;
        Map<Integer, String> mapGifts = new HashMap<Integer, String>();

        LocalDate date = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
        LocalTime time = LocalTime.of(dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond());

        ChronoLocalDate initialDayAdventCalendar = LocalDate.of(2022, Month.DECEMBER, 1);
        LocalTime initialTimeAdventCalendar = LocalTime.of(0, 0, 0);
        ChronoLocalDate lastDayAdventCalendar = LocalDate.of(2022, Month.DECEMBER, 24);
        LocalTime lastTimeAdventCalendar = LocalTime.of(23, 59, 59);

        if (date.isBefore(initialDayAdventCalendar)){

            Period beforeDate = Period.between(date, (LocalDate) initialDayAdventCalendar);

           LocalTime beforeTime = LocalTime.of(time.minusHours(initialTimeAdventCalendar.getHour()).getHour(),
                                    time.minusMinutes(initialTimeAdventCalendar.getMinute()).getMinute(),
                                    time.minusSeconds(initialTimeAdventCalendar.getSecond()).getSecond());

            result = "Falta " + beforeDate.getYears() + " Año " + beforeDate.getMonths() + " Meses  " + beforeDate.getDays() +
                    " Días " + beforeTime.getHour() + " Horas " + beforeTime.getMinute() + " Minutos  " + beforeTime.getSecond() +
                    " y Segundos para que inicie el calendario de adviento";

            return result;

        } else if (date.isAfter(lastDayAdventCalendar)){

            Period afterDate = Period.between((LocalDate) lastDayAdventCalendar, date);

            LocalTime afterTime = LocalTime.of(lastTimeAdventCalendar.minusHours(time.getHour()).getHour(),
                                    lastTimeAdventCalendar.minusMinutes(time.getMinute()).getMinute(),
                                    lastTimeAdventCalendar.minusSeconds(time.getSecond()).getSecond());

             result = " Oooow Ya se termino el calendario de adviento =(     " +
                    "Ha pasado " + afterDate.getYears() + " Año " + afterDate.getMonths() +
                    " Meses " + afterDate.getDays() + " Días " + afterTime.getHour() + " Horas " + afterTime.getMinute() +
                     " Minutos y " + afterTime.getSecond() + " Segundos";

             return result;

        } else {

            mapGifts.put(1, "Curso Java");
            mapGifts.put(2, "Curso Python");
            mapGifts.put(3, "Curso C#");
            mapGifts.put(4, "Curso AWS");
            mapGifts.put(5, "Curso Kotlin");
            mapGifts.put(6, "Curso React");
            mapGifts.put(7, "Curso PHP");
            mapGifts.put(8, "Curso Go");
            mapGifts.put(9, "Curso TypeScript");
            mapGifts.put(10, "Curso JavaScript");
            mapGifts.put(11, "Curso Swift");
            mapGifts.put(12, "Curso Dart");
            mapGifts.put(13, "Curso React Native");
            mapGifts.put(14, "Curso Cobol");
            mapGifts.put(15, "Curso Rust");
            mapGifts.put(16, "Curso SpringBoot");
            mapGifts.put(17, "Curso C++");
            mapGifts.put(18, "Curso .NET 6 Full Stack");
            mapGifts.put(19, "Curso Docker Kubernetes Cloud");
            mapGifts.put(20, "Curso Arquitecto DevOps");
            mapGifts.put(21, "Curso Azure Fundamentals & Architect Expert");
            mapGifts.put(22, "Curso MERN Full Stack");
            mapGifts.put(23, "Curso MongoDB");
            mapGifts.put(24, "Curso Node.js");

            Period actualDate = date.until(lastDayAdventCalendar);
            LocalTime actualTime = LocalTime.of(lastTimeAdventCalendar.minusHours(time.getHour()).getHour(),
                    lastTimeAdventCalendar.minusMinutes(time.getMinute()).getMinute(),
                    lastTimeAdventCalendar.minusSeconds(time.getSecond()).getSecond());

            result = "¡Felicidades obtuviste el " + mapGifts.get(date.getDayOfMonth()) + "! " +
                     " Todavía tienes " + actualDate.getDays()  + " días " + + actualTime.getHour() + " Horas " + actualTime.getMinute() +
                    " Minutos y " + actualTime.getSecond() + " Segundos para participar";

            return result;

        }
    }

    public static void main(String[] args){
        ChallengeAdventCalendar challengeAdventCalendar = new ChallengeAdventCalendar();
        LocalDateTime date = LocalDateTime.of(2022, Month.DECEMBER, 22, 0, 0,0);
        System.out.println(challengeAdventCalendar.adventCalendar(date));

    }
}
