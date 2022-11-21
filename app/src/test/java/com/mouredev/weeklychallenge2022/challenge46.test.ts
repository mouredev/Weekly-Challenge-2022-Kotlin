import { expect } from 'chai';
import { Robot } from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge46';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #46', () => {
        it('should return x:-5 , y: 12 ', () => {
            const robot = new Robot();
            robot.move([10, 5, -2])
            const response =  robot.getCoordinates()
            expect(response).to.deep.equal({x : -5,y : 12})
        })
        it('should return x:0 , y: 10', () => {
            const robot = new Robot();
            robot.move([5,10,-5,10])
            const response =  robot.getCoordinates()
            expect(response).to.deep.equal({x : 0,y : 10})
        })
    })
})
