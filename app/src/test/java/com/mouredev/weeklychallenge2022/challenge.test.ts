import { expect } from 'chai';
import {pascalTriangle  } from "../../../../../main/java/com/mouredev/weeklychallenge2022/Challenge40";

describe('Test Challenge Moure dev', () => {
    describe('Challenge #40', () => {
        it("should return Pascal Triangle (3) : ", () => {
          let respuest = pascalTriangle(3);
          let expected = [1, 1, 1, 1, 2, 1];
          expect(respuest).deep.equal(expected);
        }),
        it("should return Pascal Triangle (7) : ", () => {
          let respuest = pascalTriangle(7);
          let expected = [1, 1, 1, 1, 2, 1, 1, 3, 3, 1, 1, 4, 6, 4, 1, 1, 5, 10, 10, 5, 1, 1, 6, 15, 20, 15, 6, 1];
          expect(respuest).deep.equal(expected);
          });
 })}
)