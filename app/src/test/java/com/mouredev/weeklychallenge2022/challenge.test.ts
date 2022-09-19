import { expect } from 'chai';
import { Zelda, calculateDaysBetweenZeldaGames, ZeldaGame } from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge37';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #37', () => {
        it('should return 26 years and 26 days', () => {
            var respuest = calculateDaysBetweenZeldaGames(
              ZeldaGame.BREATH_OF_THE_WILD,
              ZeldaGame.A_LINK_TO_THE_PAST
            );
            expect(respuest).to.equal({ days: 26 , years: 26 });
        })
    })}
)