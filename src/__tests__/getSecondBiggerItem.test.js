import test from "node:test"
import assert from 'node:assert'
import getSecondBiggerItem from '../getSecondBiggerItem.js'

test('Should return null when list is less than two elements', async () => {
  const item = getSecondBiggerItem([1])

  assert.strictEqual(item, null)
})

test('Should return second bigger item', async () => {
  const item = getSecondBiggerItem([2, 3, 1, 4])

  assert.strictEqual(item, 3)
})
