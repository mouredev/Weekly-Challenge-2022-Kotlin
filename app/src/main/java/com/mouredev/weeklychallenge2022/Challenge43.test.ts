import { describe, it, expect } from "vitest";
import trucoOTrato from "./Challenge43";

describe("function trucoOTrato", () => {
  const sustos = ["🎃", "👻", "💀", "🕷", "🕸", "🦇"];

  const dulces = ["🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"];

  const list1 = [
    {
      name: "María",
      age: 9,
      height: 131,
    },
    {
      name: "Pepe",
      age: 8,
      height: 125,
    },
  ];

  const list2 = [
    {
      name: "María",
      age: 9,
      height: 131,
    },
    {
      name: "Pepe",
      age: 8,
      height: 125,
    },
    {
      name: "Carla",
      age: 10,
      height: 134,
    },
  ];

  it("trucoOTrato is a function", () => {
    expect(trucoOTrato).toBeTypeOf("function");
  });

  it.skip("if truco is requested, returns a scare every 2 letters of the name for each person", () => {
    expect(trucoOTrato("truco", list1)).toHaveLength(8);
  });

  it.skip("if truco is requested, returns a scare every 2 letters of the name for each person and 2 scares for every even age", () => {
    expect(trucoOTrato("truco", list1)).toHaveLength(12);
  });

  it("if truco is requested, returns a scare every 2 letters of the name for each person, 2 scares for every even age and 3 scares for every 100 cm of the sum of all heights", () => {
    expect(trucoOTrato("truco", list1)).toHaveLength(24);
    expect(trucoOTrato("truco", list2)).toHaveLength(38);
  });

  it.skip("if trato is requested, returns a sweet for every letter of the name for each person", () => {
    expect(trucoOTrato("trato", list1)).toHaveLength(18);
  });

  it.skip("if trato is requested, returns a sweet for every letter of the name for each person and a sweet for every 3 years with a maximum of 10 years for each person", () => {
    expect(trucoOTrato("trato", list1)).toHaveLength(28);
  });

  it("if trato is requested, returns a sweet for every letter of the name for each person, a sweet for every 3 years with a maximum of 10 years for each person and 2 sweets for every 50 cm of height with a maximum of 150 cm for each person", () => {
    expect(trucoOTrato("trato", list1)).toHaveLength(44);
  });
});
