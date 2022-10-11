import { describe, it, expect } from "vitest";
import { ohm } from "./Challenge41";

describe("Reto #41 - LA LEY DE OHM", () => {
  it("ohm is a function", () => {
    expect(ohm).toBeTypeOf("function");
  });

  it("returns message 'Invalid values' if the provided parameter is not an object", () => {
    expect(ohm({ v: 12, r: 220 })).not.toBe("Invalid values");
    expect(ohm()).toBe("Invalid values");
    expect(ohm(1, 2)).toBe("Invalid values");
    expect(ohm([1, 2])).toBe("Invalid values");
    expect(ohm("1, 2")).toBe("Invalid values");
  });

  it("returns message 'Invalid values' if the provided object has not two and only two properties", () => {
    expect(ohm({ v: 12 })).toBe("Invalid values");
    expect(ohm({ v: 12, r: 220 })).not.toBe("Invalid values");
    expect(ohm({ v: 12, r: 220, i: 0.05 })).toBe("Invalid values");
    expect(ohm({ v: 12, r: 220, i: 0.05, p: 0.82 })).toBe("Invalid values");
  });

  it.skip("returns message 'Invalid values' if the object provided has not the required shape", () => {});
});
