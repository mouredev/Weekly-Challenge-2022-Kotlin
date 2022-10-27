"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const chai_1 = require("chai");
const Challenge42_1 = require("../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge42");
describe('Test Challenge Moure dev', () => {
    describe('Challenge #42', () => {
        it("should return 107.6°F (42°C) ", () => {
            const request = (0, Challenge42_1.convertTemperature)("42°C");
            (0, chai_1.expect)(request).to.equal("107.6°F");
        }),
            it("should return -20.11111111111111°C) ", () => {
                const request = (0, Challenge42_1.convertTemperature)("-4.2°F");
                (0, chai_1.expect)(request).to.equal("-20.11111111111111°C");
            });
    });
});
