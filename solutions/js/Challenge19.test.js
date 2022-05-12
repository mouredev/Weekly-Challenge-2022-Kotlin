import test from 'node:test';
import assert from 'node:assert';

import {getMiliseconds} from './Challenge19.js';

test('should get ms', () => {
    assert.equal(getMiliseconds(0, 0, 0, 0), 0);
    assert.equal(getMiliseconds(1, 0, 0, 0), 24 * 60 * 60 * 1000);
    assert.equal(getMiliseconds(1, 1, 0, 0), (24 * 60 * 60 * 1000) + (60 * 60 * 1000));
    assert.equal(getMiliseconds(1, 1, 1, 0), (60 * 1000) + (24 * 60 * 60 * 1000) + (60 * 60 * 1000));
    assert.equal(getMiliseconds(1, 1, 1, 1), (1000) + (60 * 1000) + (24 * 60 * 60 * 1000) + (60 * 60 * 1000));
})