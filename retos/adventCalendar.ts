
const adventCalendar2022 = {
    firstDay: new Date(Date.UTC(2022, 11, 1, 0, 0, 0)),
    lastDay: new Date(Date.UTC(2022, 11, 24, 23, 59, 59))
}
export function getGift(day: number): string {
    switch (day) {
        case 1 - 6:
            return "chocolate";
        case 7 - 12:
            return "candy";
        case 13 - 18:
            return "🎅";
        case 19 - 24:
            return '🎁';
        default:
            return "404 gift no found";
    }
}
export function dateDifference(datems1: number, datems2: number): string {
    return (datems1 - datems2) / 1000 / 60  + " minutes";

}

export function adventCalendar(date: Date) {
    const timeDate = date.getTime();
    const timeFirstDay = adventCalendar2022.firstDay.getTime();
    const timeLastDay = adventCalendar2022.lastDay.getTime();
    if (timeDate >= timeFirstDay || timeDate <= adventCalendar2022.lastDay.getTime()) {
        return getGift(date.getUTCDate());
    }
    else if (timeDate < timeFirstDay) {
        return "too early for gifts wait by: " + dateDifference(timeFirstDay, timeDate);
    }
    else {
        return "too late u are late by " + dateDifference(timeDate, timeLastDay);
    }
}
