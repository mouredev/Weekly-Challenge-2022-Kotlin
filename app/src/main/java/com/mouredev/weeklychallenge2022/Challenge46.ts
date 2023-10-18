// The robot has 4 orientations, starting for +Y, -X, -Y, +X.

export class Robot {
  X: number;
  Y: number;
  direction: number;

  constructor() {
    this.X = 0;
    this.Y = 0;
    this.direction = 0;
  }

  moveTo(steps: number) {
    if (this.direction === 0) this.Y += steps;
    else if (this.direction === 1) this.X -= steps;
    else if (this.direction === 2) this.Y -= steps;
    else if (this.direction === 3) this.X += steps;
  }

  changeDirection() {
    this.direction < 3 ? this.direction++ : (this.direction = 0);
  }

  move(movement: number[]) {
    movement.forEach((mov: number) => {
      this.moveTo(mov);
      this.changeDirection();
    });

    return { x: this.X, y: this.Y };
  }
}
