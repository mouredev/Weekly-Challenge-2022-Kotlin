import { expect } from 'chai';
import { mostCommonVowel } from '../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge47';

describe('Test Challenge Moure dev', () => {
    describe('Challenge #47', () => {
        it('should return \'a\': ', () => {
            const respuest =  mostCommonVowel("El ingenioso hidalgo Don Quijote de la Mancha\" En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredo");
            expect(respuest).to.equal("a")
        })

        it('should return \'e\': ', () => {
            const respuest =  mostCommonVowel("¿Son robos o sobornos?");
            expect(respuest).to.equal("o")
        })
    })}
)