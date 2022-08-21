import { expect } from 'chai';
import { sexagenarianCycle,Animal,Element } from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge33';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #33', () => {
        it('should return cycle sexagenarian 1984 : wood rat', () => {

            let year = 1984
            let yearElement = Element.WOOD
            let yearAnimal = Animal.RAT
            var respuest =  sexagenarianCycle(year);
            expect(respuest).to.equal(`${year} ${yearElement} ${yearAnimal}`)
        }),
         it('should return cycle sexagenarian 2011 : metal rabbit', () => {

            let year = 2011
            let yearElement = Element.METAL
            let yearAnimal = Animal.RABBIT
            var respuest =  sexagenarianCycle(year);

            expect(respuest).to.equal(`${year} ${yearElement} ${yearAnimal}`)
        })
    })
})