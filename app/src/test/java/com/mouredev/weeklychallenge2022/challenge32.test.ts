import { expect } from 'chai';
import { findSecondLargest } from '../../../../../main/java/com/mouredev/weeklychallenge2022/challenge32';


describe('Test Challenge Moure dev', () => {

    describe('Challenge #32', () => {
        it('should return the second largest number', () => {
            var respuest =  findSecondLargest([8,10,5,11]);
            expect(respuest).to.equal(10)
        }),
        it('should return the second largest number', () => {
            var respuest =  findSecondLargest([10,40,225,4441,1]);
            console.log(respuest);
            expect(respuest).to.equal(225)
        })
    })
})