import { expect } from 'chai';
import { waterCount } from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge45';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #45', () => {
        it('should return 7 Blocks of water:', () => {
            const response =  waterCount([3, 1, 6, 3, 0, 4]);
            expect(response).to.equal(7)
        }),
            it('should return 7 Blocks of water:', () => {
                const response =  waterCount([1,0,3,4,0,0,2,1,0,1,2,1,0,1,0,3,2,1,2,1]);
                expect(response).to.equal(27)
            })
    })}
)