import { expect } from 'chai';
import {
    Person,
    TrickOrTreat,
    trickOrTreat
} from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge43';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #43', () => {
        it('should return length treat array 40 : ', () => {
            const response =  trickOrTreat(TrickOrTreat.TREAT, [new Person("Angel", 10, 145), new Person("Miguel Angel", 42, 178)])
            expect(response.length).to.equal(40)
        })
        it('should return length trick array 20 ', () => {
            const response =  trickOrTreat(TrickOrTreat.TRICK, [new Person("Carmen", 7, 124), new Person("Brais", 38, 170)])
            expect(response.length).to.equal(20)
        })
 })}
)