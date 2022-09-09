/**
 * Test Suite challenge36
 * Dependencias:
 * Mocha
 * Chai
 */

 import { expect } from 'chai';
 import * as challenge36 from '../../../../../main/java/com/mouredev/weeklychallenge2022/challenge36';

 describe('Test #Challenge36', () => {

     describe('Middle Earth Battle :(Harfoots,Dwarves) vs (Orcs,Trolls) : ', () => {
         it('Should return an BattleResult with DarkLegion winner', () => {
            var respuesta = challenge36.middleEarthBattle(
              [challenge36.FreeLegion.harfoots, challenge36.FreeLegion.dwarves],
              [challenge36.DarkLegion.orcs, challenge36.DarkLegion.trolls]
            );
            expect(respuesta).equal(challenge36.BattleResult.DarkLegion)
         });
     });

      describe("Middle Earth Battle :(númenóreans,elves,dwarves) vs (goblins,Trolls) : ", () => {
        it("Should return an BattleResult with FreeLegion winner", () => {
          var respuesta = challenge36.middleEarthBattle(
            [
              challenge36.FreeLegion.elves,
              challenge36.FreeLegion.númenóreans,
              challenge36.FreeLegion.dwarves,
            ],
            [challenge36.DarkLegion.goblins, challenge36.DarkLegion.trolls]
          );
          expect(respuesta).equal(challenge36.BattleResult.FreeLegion);
        });
      });


 });//describe controlador