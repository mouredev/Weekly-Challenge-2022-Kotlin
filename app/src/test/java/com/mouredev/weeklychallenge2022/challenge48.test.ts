import { expect } from 'chai';
import { getGift,daysLeft} from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge48';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #48', () => {
        it('should return 10 days :', () => {
            var respuest =  daysLeft(new Date("2022-12-11T00:00:00"),new Date("2022-12-01T00:00:00"));
            expect(respuest).to.equal(10)
        }),
        it('should return -44 days', () => {
            var respuest =  daysLeft(new Date("2022-11-11T00:00:00"),new Date("2022-12-24T23:59:59"));
            expect(respuest).to.equal(-44)
        })
        it('should return gift:"🤶"', () => {
            var respuest =  getGift(new Date("2022-12-02T00:00:00"));
            expect(respuest).to.equal("🤶")
        })
        it('should return "⌚" : No gift ', () => {
            var respuest =  getGift(new Date("2022-12-26T00:00:00"));
            expect(respuest).to.equal("⌚")
        })
    })}
)