import { expect, describe, it } from "vitest";
import { Robot } from "./Challenge46";

describe("Same structure", function () {
  it("should return the position of the robot after the steps sequence", function () {
    const Robotest = new Robot();

    expect(Robotest.move([10, 5, -2])).toMatchObject({ x: -5, y: 12 });
  });

  it("should return the position of the robot after the steps sequence", function () {
    const Robotest = new Robot();

    expect(Robotest.move([0, 0])).toMatchObject({ x: 0, y: 0 });
  });

  it("should return the position of the robot after the steps sequence", function () {
    const Robotest = new Robot();

    expect(Robotest.move([10, 10, 10, 10])).toMatchObject({ x: 0, y: 0 });
  });

  it("should return the position of the robot after the steps sequence", function () {
    const Robotest = new Robot();

    expect(Robotest.move([5, 10, -5, 10])).toMatchObject({ x: 0, y: 10 });
  });

  it("should return the position of the robot after the steps sequence", function () {
    const Robotest = new Robot();

    expect(Robotest.move([10, -5, 10, 5, 5, 0, 2])).toMatchObject({
      x: 10,
      y: 3,
    });
  });

  it("should return the position of the robot after the steps sequence", function () {
    const Robotest = new Robot();

    expect(Robotest.move([])).toMatchObject({ x: 0, y: 0 });
  });
});
