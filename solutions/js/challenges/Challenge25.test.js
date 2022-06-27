const { validateRockPaperScissors } = require('./Challenge25');

describe('Stone, Paper, Scissors', () => {
  test('should win player 1', () => {
    const movements = [['R', 'S'], ['S', 'R'], ['P', 'S']];
    expect(validateRockPaperScissors(movements)).toBe('Player 2');
  });

  test('should win player 2', () => {
    const movements = [['R', 'S'], ['S', 'R'], ['P', 'R']];
    expect(validateRockPaperScissors(movements)).toBe('Player 1');
  });
  test('should be tie', () => {
    const movements = [['R', 'S'], ['S', 'R']];
    expect(validateRockPaperScissors(movements)).toBe('Tie');
  });
});