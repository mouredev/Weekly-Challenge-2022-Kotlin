import { expect } from 'chai';
import { convertTemperature } from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge42';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #42', () => {
        it("should return 107.6°F (42°C) ", () => {
          var respuest = convertTemperature("42°C");
          expect(respuest).to.equal("107.6°F");
        }),
          it("should return -20.11111111111111°C) ", () => {
            var respuest = convertTemperature("-4.2°F");
            expect(respuest).to.equal("-20.11111111111111°C");
          });
 })}
)