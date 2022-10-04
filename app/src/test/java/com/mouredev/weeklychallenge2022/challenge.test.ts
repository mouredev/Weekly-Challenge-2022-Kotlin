import { expect } from 'chai';
import { sort } from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge39';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #39', () => {
        it('should return order list :  ', () => {
            const list = [28, 11, 96, -5, 21, 18, 12, 22, 30, 97, -1, -40, -500];
            var respuest = sort(list);
            const list_ordered = [-500,-40,-5,-1,11,12,18,21, 22 , 28 , 30 , 96 , 97]
            console.log(list_ordered)
            expect(respuest).deep.equal(list_ordered)
        })
        it('should return order list :  ', () => {
             const list = [1,5,6,2,4]
             var respuest = sort(list);
             const list_ordered = [ 1,2,4,5,6];
             expect(respuest).deep.equal(list_ordered)
         })
 })}
)