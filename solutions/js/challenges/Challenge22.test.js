const { getRelatedElements } = require('./Challenge22');

test('should return common elements', () => {
  expect(getRelatedElements([1, 2, 3, 4, 5], [2, 6, 4, 8, 10], true).sort()).toEqual([2, 4]);
  expect(getRelatedElements([1, 2, 1, 4, 5], [7, 1, 4], true).sort()).toEqual([1, 4]);
  expect(getRelatedElements([1, 2, 1, 4, 5], [7, 1, 4, 1, 7], true).sort()).toEqual([1, 1, 4]);
  expect(getRelatedElements([1, 2, 3, 4, 5], [3, 3, 3], true).sort()).toEqual([3]);
  expect(getRelatedElements([1, 2, 3, 4, 3], [3, 3, 3], true).sort()).toEqual([3, 3]);
  expect(getRelatedElements([1, 2, 3, 4, 5], [6, 7, 8, 9, 10], true).sort()).toEqual([]);
  expect(getRelatedElements([], [], true)).toEqual([]);
});

test('should return different elements', () => {
  expect(getRelatedElements([1, 2, 3, 4, 5], [6, 7, 8, 9, 10], false).sort((a, b) => a - b)).toEqual([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
  expect(getRelatedElements([1, 1, 2, 3, 4], [6, 7, 8, 9, 10], false).sort((a, b) => a - b)).toEqual([1, 1, 2, 3, 4, 6, 7, 8, 9, 10]);
  expect(getRelatedElements([1, 2, 3, 4, 5], [1, 2, 3, 4, 5], false).sort((a, b) => a - b)).toEqual([]);
  expect(getRelatedElements([1, 2, 3, 4, 5, 6], [1, 2, 3, 4, 5], false).sort((a, b) => a - b)).toEqual([6]);
  expect(getRelatedElements([1, 2, 3, 4, 5], [1, 2, 3, 4, 5, 6], false).sort((a, b) => a - b)).toEqual([6]);
  expect(getRelatedElements([1, 2, 4, 5], [1, 2, 3, 4, 5], false).sort((a, b) => a - b)).toEqual([3]);
  expect(getRelatedElements([], [], false)).toEqual([]);
});
