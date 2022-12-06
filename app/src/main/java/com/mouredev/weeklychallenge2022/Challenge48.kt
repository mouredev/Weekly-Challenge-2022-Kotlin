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
 */
import { sub , set, secondsToMilliseconds } from 'date-fns'

function generarRegalos():any{

    let regalos=[{"fecha":new Date("2022-12-01T00:00:00"),"regalo":"libro 1"},
                 {"fecha":new Date("2022-12-02T00:00:00"),"regalo":"libro 2"},
                 {"fecha":new Date("2022-12-03T00:00:00"),"regalo":"libro 3"},
                 {"fecha":new Date("2022-12-04T00:00:00"),"regalo":"libro 4"},
                 {"fecha":new Date("2022-12-05T00:00:00"),"regalo":"libro 5"},
                 {"fecha":new Date("2022-12-06T00:00:00"),"regalo":"curso 1"},
                 {"fecha":new Date("2022-12-07T00:00:00"),"regalo":"curso 2"},
                 {"fecha":new Date("2022-12-08T00:00:00"),"regalo":"curso 3"},
                 {"fecha":new Date("2022-12-09T00:00:00"),"regalo":"curso 4"},
                 {"fecha":new Date("2022-12-10T00:00:00"),"regalo":"curso 5"},
                 {"fecha":new Date("2022-12-11T00:00:00"),"regalo":"suscripcion 1"},
                 {"fecha":new Date("2022-12-12T00:00:00"),"regalo":"suscripcion 2"},
                 {"fecha":new Date("2022-12-13T00:00:00"),"regalo":"suscripcion 3"},
                 {"fecha":new Date("2022-12-14T00:00:00"),"regalo":"suscripcion 4"},
                 {"fecha":new Date("2022-12-15T00:00:00"),"regalo":"suscripcion 5"},
                 {"fecha":new Date("2022-12-16T00:00:00"),"regalo":"gadget 1"},
                 {"fecha":new Date("2022-12-17T00:00:00"),"regalo":"gadget 2"},
                 {"fecha":new Date("2022-12-18T00:00:00"),"regalo":"gadget 3"},
                 {"fecha":new Date("2022-12-19T00:00:00"),"regalo":"gadget 4"},
                 {"fecha":new Date("2022-12-20T00:00:00"),"regalo":"gadget 5"},
                 {"fecha":new Date("2022-12-20T00:00:00"),"regalo":"gadget 5"},
                 {"fecha":new Date("2022-12-21T00:00:00"),"regalo":"mentoria 1"},
                 {"fecha":new Date("2022-12-22T00:00:00"),"regalo":"mentoria 2"},
                 {"fecha":new Date("2022-12-23T00:00:00"),"regalo":"mentoria 3"},
                 {"fecha":new Date("2022-12-24T00:00:00"),"regalo":"mentoria 4"},
                ];
   
    return regalos; //arreglo de objetos
}


function buscarRegalo(date:Date):string{
    let sorteo:string="";
    if(date<new Date("2022-12-01T00:00:00")){
        sorteo=earlierDate(date);
        return sorteo;
    }
    if(date>new Date("2022-12-24T23:59:59")){
        sorteo=laterDate(date);
        return sorteo;
    }
    if(date>=new Date("2022-12-01T00:00:00") && date<=new Date("2022-12-24T23:59:59")){
        sorteo=matchDate(date);
        return sorteo;
    }
    return sorteo;
}

function matchDate(date:Date):string{
    
    let regalos:string=generarRegalos();
    let sorteo:string="";

    for(let i=0;i<regalos.length;i++){
        
        let dateArr=new Date(regalos[i]["fecha"]);

        if(dateArr.getDate()==date.getDate()){

            let endTime=set(dateArr,{hours:23,minutes:59,seconds:59});

            //calcular tiempo faltante
            let restTime=sub(endTime,{days:date.getDay(),hours:date.getHours(),minutes:date.getMinutes(),seconds:date.getSeconds()});

            //retornar regalos y tiempo faltante
            sorteo="Regalo del dia: "+regalos[i]["regalo"]+" 🎁"+"\n"+"El sorteo finalizará en: "+restTime.getDay()+" dias, "+restTime.getHours()+" horas, "+restTime.getMinutes()+" minutos, "+restTime.getSeconds()+" segundos.";
        }
    }
    return sorteo;
}


function earlierDate(date:Date):string{
    let startDate=new Date("2022-12-01T00:00:00");
 
    let restTime=sub(startDate,{days:date.getDay(),hours:date.getHours(),minutes:date.getMinutes(),seconds:date.getSeconds()});

    let sorteo:string="El sorteo comenzará en: "+restTime.getDay()+" dias, "+restTime.getHours()+" horas, "+restTime.getMinutes()+" minutos, "+restTime.getSeconds()+" segundos.";
    
    return sorteo;
    
    
}

function laterDate(date:Date):string{
    let endDate:Date=new Date("2022-12-24T23:59:59");

    let restTime=sub(date,{days:endDate.getDay(),hours:endDate.getHours(),minutes:endDate.getMinutes(),seconds:endDate.getSeconds()});
   
    let sorteo:string="El sorteo terminó hace: "+restTime.getDay()+" dias, "+restTime.getHours()+" horas, "+restTime.getMinutes()+" minutos, "+restTime.getSeconds()+" segundos.";
    
    return sorteo;
}

//main
console.clear();

let date:Date=new Date("2022-12-25T00:01:00");
let sorteo:string=buscarRegalo(date);
console.log(sorteo);

let date1:Date=new Date("2022-11-30T23:59:00");
let sorteo1:string=buscarRegalo(date1);
console.log(sorteo1);

let date2:Date=new Date();//today date
let sorteo2:string=buscarRegalo(date2);
console.log(sorteo2);