import { describe, it, expect } from "vitest";
import tempConverter from "./Challenge42";

describe("function tempConverter", () => {
  it("tempConverter is a function", () => {
    expect(tempConverter).toBeTypeOf("function");
  });

  it("throws an error with specific message if the provided parameter is not a string", () => {
    expect(() => tempConverter()).toThrowError(/string/);
    expect(() => tempConverter(1)).toThrowError(/string/);
    expect(() => tempConverter([1])).toThrowError(/string/);
    expect(() => tempConverter({ input: "1°C" })).toThrowError(/string/);
    expect(() => tempConverter("1\u00B0C")).not.toThrowError(/string/);
  });

  it("throws an error with specific message if the input string has not the correct format", () => {
    expect(() => tempConverter("1")).toThrowError(/format/);
    expect(() => tempConverter("1\u00B0")).toThrowError(/format/);
    expect(() => tempConverter("1C")).toThrowError(/format/);
    expect(() => tempConverter("1F")).toThrowError(/format/);
    expect(() => tempConverter("1\u00B0C")).not.toThrowError(/format/);
    expect(() => tempConverter("1\u00B0F")).not.toThrowError(/format/);
    expect(() => tempConverter(" 1\u00B0C ")).not.toThrowError(/format/);
    expect(() => tempConverter(" 1\u00B0F ")).not.toThrowError(/format/);
  });

  it("throws an error if first part of the string has non numeric characters", () => {
    expect(() => tempConverter("1a\u00B0C")).toThrowError(/number/);
    expect(() => tempConverter("1\u00B0C")).not.toThrowError(/number/);
    expect(() => tempConverter("1.5\u00B0C")).not.toThrowError(/number/);
  });

  it("returns a string", () => {
    expect(tempConverter("1\u00B0C")).toBeTypeOf("string");
  });

  it.skip("checks if input unit is C or F", () => {
    expect(tempConverter("1\u00B0C")).toBe("F");
    expect(tempConverter("1\u00B0F")).toBe("C");
    expect(() => tempConverter("1\u00B0X")).toThrow;
  });

  it("converts C to F and returns in the correct format", () => {
    expect(tempConverter("0\u00B0C")).toBe("32\u00B0F");
    expect(tempConverter("5\u00B0C")).toBe("41\u00B0F");
    expect(tempConverter("32\u00B0F")).toBe("0\u00B0C");
    expect(tempConverter("41\u00B0F")).toBe("5\u00B0C");
  });
});
