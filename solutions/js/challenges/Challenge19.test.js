const getMiliseconds = require('./Challenge19.js');

test('should get ms', () => {
    expect(getMiliseconds(0, 0, 0, 0)).toBe(0);
    expect(getMiliseconds(1, 0, 0, 0)).toBe(24 * 60 * 60 * 1000);
    expect(getMiliseconds(1, 1, 0, 0)).toBe((24 * 60 * 60 * 1000) + (60 * 60 * 1000));
    expect(getMiliseconds(1, 1, 1, 0)).toBe((60 * 1000) + (24 * 60 * 60 * 1000) + (60 * 60 * 1000));
    expect(getMiliseconds(1, 1, 1, 1)).toBe((1000) + (60 * 1000) + (24 * 60 * 60 * 1000) + (60 * 60 * 1000));
});

test('should throw error', () => {
    expect(() => getMiliseconds(-1, 0, 0, 0)).toThrow('Bad date');
    expect(() => getMiliseconds(0, -1, 0, 0)).toThrow('Bad date');
    expect(() => getMiliseconds(0, 0, -1, 0)).toThrow('Bad date');
    expect(() => getMiliseconds(0, 0, 0, -1)).toThrow('Bad date');
});