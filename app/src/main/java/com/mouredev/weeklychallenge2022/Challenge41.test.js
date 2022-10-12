import { describe, it, expect } from "vitest";
import { ohm } from "./Challenge41";

const errorMsg = "Invalid values";

describe("Reto #41 - LA LEY DE OHM", () => {
  it("ohm is a function", () => {
    expect(ohm).toBeTypeOf("function");
  });

  it("returns message 'Invalid values' if the provided parameter is not an object", () => {
    expect(ohm({ v: 12, r: 220 })).not.toBe(errorMsg);
    expect(ohm()).toBe(errorMsg);
    expect(ohm(1, 2)).toBe(errorMsg);
    expect(ohm([1, 2])).toBe(errorMsg);
    expect(ohm("1, 2")).toBe(errorMsg);
  });

  it("returns message 'Invalid values' if the provided object has not two and only two properties", () => {
    expect(ohm({ v: 12 })).toBe(errorMsg);
    expect(ohm({ v: 12, r: 220 })).not.toBe(errorMsg);
    expect(ohm({ v: 12, r: 220, i: 0.05 })).toBe(errorMsg);
    expect(ohm({ v: 12, r: 220, i: 0.05, p: 0.82 })).toBe(errorMsg);
  });

  it("returns message 'Invalid values' if any of the keys of the provided objects is not recognized", () => {
    expect(ohm({ v: 12, r: 220 })).not.toBe(errorMsg);
    expect(ohm({ r: 220, i: 0.05 })).not.toBe(errorMsg);
    expect(ohm({ v: 12, i: 0.05 })).not.toBe(errorMsg);
    expect(ohm({ i: 0.05, v: 12 })).not.toBe(errorMsg);
    expect(ohm({ v: 12, x: 220 })).toBe(errorMsg);
    expect(ohm({ volt: 12, resistance: 220 })).toBe(errorMsg);
  });

  it("returns message 'Invalid values' if any of the values of the provided objects is not a number", () => {
    expect(ohm({ v: 12, r: 220 })).not.toBe(errorMsg);
    expect(ohm({ v: "1", r: 220 })).toBe(errorMsg);
    expect(ohm({ v: 12, r: true })).toBe(errorMsg);
    expect(ohm({ v: [1], r: 220 })).toBe(errorMsg);
    expect(ohm({ v: 12, r: { value: 220 } })).toBe(errorMsg);
    expect(ohm({ v: null, r: 220 })).toBe(errorMsg);
    expect(ohm({ v: 12, r: NaN })).toBe(errorMsg);
  });

  it("returns a number", () => {
    expect(ohm({ v: 12, r: 220 })).toBeTypeOf("number");
  });

  it("returns the result of the ohm's law", () => {
    expect(ohm({ v: 12, r: 120 })).toBe(0.1);
    expect(ohm({ v: 12, i: 0.1 })).toBe(120);
    expect(ohm({ i: 0.1, r: 120 })).toBe(12);
  });

  it("the result is rounded to two decimal digits", () => {
    expect(ohm({ v: 12, r: 120 })).toBe(0.1);
    expect(ohm({ v: 12, r: 220 })).toBe(0.05);
    expect(ohm({ v: 12, r: 220 })).not.toBe(12 / 220);
    expect(ohm({ v: 12, i: 5.35 })).toBe(2.24);
    expect(ohm({ v: 12, i: 5.35 })).not.toBe(12 / 5.35);
  });
});
