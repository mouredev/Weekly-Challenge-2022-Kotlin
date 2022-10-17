import { expect } from 'chai';
import {  calculateOhm } from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge41';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #35', () => {
        it('should return 10.8 ', () => {
            var respuest =  calculateOhm(NaN,2,5.4);
            expect(respuest).to.equal(10.8)
        }),
        it('should return 0.17 ', () => {
            var respuest = calculateOhm(2,12);
            expect(respuest).to.equal(0.17)
        })
 })}
)