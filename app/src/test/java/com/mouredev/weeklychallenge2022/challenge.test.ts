import { expect } from 'chai';
import { handleDetector } from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge49';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #49', () => {
        it('should return @malopezrom @mouredev #reto-semanal #reto49 #MoureDev #retosdeprogramacion https://mouredev.com https://retosdeprogramacion.com/semanales2022',
            () => {
            const respuest = handleDetector("Retos de programacion : (https://mouredev.com/discord) #reto-semanal #reto49 #MoureDev @malopezrom @mouredev https://mouredev.com .moure.es https://retosdeprogramacion.com/semanales2022 #retosdeprogramacion");
            expect(respuest).to.deep.equal(["@malopezrom", "@mouredev", "#reto-semanal", "#reto49", "#MoureDev", "#retosdeprogramacion", "https://mouredev.com/discord)","https://mouredev.com", "https://retosdeprogramacion.com/semanales2022"]);

        })
        it('should return @paula @juan @maria #feliz #sol#playa #friends #beachday #relax', () => {
            const respuest = handleDetector("Hola a todos! Hoy es un día hermoso y estoy muy emocionada. #feliz #sol #playa.Estoy disfrutando de un día de descanso en la playa con mis amigos @paula @juan @maria.No puedo esperar para compartir fotos en mis redes sociales con todos ustedes. #friends #beachday #relax");
            expect(respuest).to.deep.equal(["@paula", "@juan", "@maria", "#feliz", "#sol", "#playa", "#friends", "#beachday", "#relax"]);
        })
 })}
)

