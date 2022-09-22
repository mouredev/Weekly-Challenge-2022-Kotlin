import { expect } from "chai";
import * as challenge36 from "../../../../../main/java/com/mouredev/weeklychallenge2022/challenge38";

describe("Test #Challenge38", () => {
  describe("Convert Binary to Decimal : ", () => {
    it("0012 -> Should return 0", () => {
      var respuesta = challenge36.binaryToDecimal("0012");
      expect(respuesta).equal(0);
    }),
      it("11101-> Should return 29", () => {
        var respuesta = challenge36.binaryToDecimal("11101");
        expect(respuesta).equal(29);
      }),
      it("010111101111100001-> Should return 97249", () => {
        var respuesta = challenge36.binaryToDecimal("010111101111100001");
        expect(respuesta).equal(97249);
      });
  });

});
