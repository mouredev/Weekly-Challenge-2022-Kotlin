import { expect } from 'chai';
import {  calculateOhm } from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge41';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #35', () => {
        it('should return 0.10 ', () => {
            var respuest =  calculateOhm({V:1,R:10});
            expect(respuest).to.equal(0.10)
        }),
        it('should return 7.28 ', () => {
            var respuest = calculateOhm({ R: 1.4, I: 5.2 });
            expect(respuest).to.equal(7.28)
        })
 })}
)