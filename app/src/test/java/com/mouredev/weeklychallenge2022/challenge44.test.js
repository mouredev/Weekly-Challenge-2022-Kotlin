"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const chai_1 = require("chai");
const Challenge44_1 = require("../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge44");
describe('Test Challenge Moure dev', () => {
    describe('Challenge #44', () => {
        it('should return 2 boomerangs : [[2,1,2],[4,2,4] ', () => {
            const boomerangs = (0, Challenge44_1.findBoomerangs)([2, 1, 2, 3, 3, 4, 2, 4]);
            (0, chai_1.expect)(boomerangs).to.equal([[2, 1, 2], [4, 2, 4]]);
        });
        it('should return 2 boomerangs : [[2,1,2],[4,2,4] ', () => {
            const boomerangs = (0, Challenge44_1.findBoomerangs)(['a', 'b', 'a', 'c', 'c', 'd', 'a', 'd', 'd', 'd']);
            (0, chai_1.expect)(boomerangs).to.equal([[2, 1, 2], [4, 2, 4]]);
        });
    });
});
