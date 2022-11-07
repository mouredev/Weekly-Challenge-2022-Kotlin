import { expect } from 'chai';
import { findBoomerangs } from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge44';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #44', () => {
        it('should return 2 boomerangs : [[2,1,2],[4,2,4] ', () => {
            const boomerangs = findBoomerangs([2, 1, 2, 3, 3, 4, 2, 4]);
            expect(boomerangs).to.eql([[2, 1, 2], [4, 2, 4]])
        })
        it('should return 3 boomerangs :[ [ \'a\', \'b\', \'a\' ], [ \'d\', \'a\', \'d\' ], [ \'d\', \'b\', \'d\' ] ] ', () => {
            const boomerangs = findBoomerangs(['a', 'b', 'a', 'c', 'c', 'd', 'a', 'd', 'b', 'd']);
            expect(boomerangs).to.eql([ [ 'a', 'b', 'a' ], [ 'd', 'a', 'd' ], [ 'd', 'b', 'd' ] ]
            )
        })

 })}
)