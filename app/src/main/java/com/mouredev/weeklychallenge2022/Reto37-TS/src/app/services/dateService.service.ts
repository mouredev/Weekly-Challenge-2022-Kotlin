import { zeldaGames } from "../models/zeldaGames.model";

export class dateService {

    static getRelaseDate(game:zeldaGames):string{
        const monthArray = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
        const gameDate = new Date(game);
        const day = gameDate.getDate();
        const month = gameDate.getMonth();
        const year = gameDate.getFullYear();
        const res = `La fecha de salida del juego seleccionado es: ${day} de ${monthArray[month]} de ${year}`;
        console.log(res);     
        return res;
    }

    static getDateDiff(game1:zeldaGames, game2:zeldaGames):string{
        const date1 = new Date(game1).getTime()
        const date2 = new Date(game2).getTime()
        const diff = Math.abs((date2-date1) / 1000)
        const daysCalc = 24*60*60;
        const yearsInDays = 365.25;

        const years = Math.round(diff/daysCalc)/yearsInDays;
        const yearsDecimal = years - Math.floor(years);
        const yearsDiff = Math.floor(years);
        const daysDiff = Math.floor(yearsDecimal * yearsInDays);
        
        const res = `La diferencia entre es de ${yearsDiff} años y ${daysDiff} dias.`;
        console.log(res)
        return res
    }
}
