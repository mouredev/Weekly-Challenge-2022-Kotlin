"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const chai_1 = require("chai");
const Challenge43_1 = require("../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge43");
describe('Test Challenge Moure dev', () => {
    describe('Challenge #43', () => {
        it('should return length treat array 40 : ', () => {
            const response = (0, Challenge43_1.trickOrTreat)(Challenge43_1.TrickOrTreat.TREAT, [new Challenge43_1.Person("Angel", 10, 145), new Challenge43_1.Person("Miguel Angel", 42, 178)]);
            (0, chai_1.expect)(response.length).to.equal(40);
        });
        it('should return length trick array 20 ', () => {
            const response = (0, Challenge43_1.trickOrTreat)(Challenge43_1.TrickOrTreat.TRICK, [new Challenge43_1.Person("Carmen", 7, 124), new Challenge43_1.Person("Brais", 38, 170)]);
            (0, chai_1.expect)(response.length).to.equal(20);
        });
    });
});
