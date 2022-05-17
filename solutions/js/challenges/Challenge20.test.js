const asyncAddition = require('./Challenge20');


describe('test challenge 20', () => {

    beforeAll(() => {
        jest.useFakeTimers();
        jest.spyOn(global, 'setTimeout');
    });

    afterAll(() => {
        jest.useRealTimers();
        jest.restoreAllMocks();
    });

    test('should wait passed seconds and resolve addition', () => {
        const result = asyncAddition(2, 9, 1, 7);
        jest.runAllTimers();
        expect(setTimeout).toHaveBeenCalledTimes(1);
        expect(setTimeout).toHaveBeenLastCalledWith(expect.any(Function), 2000);
        expect(result).resolves.toBe(17);
    });

    test('shold wait passed seconds and resolve addition when there is only one operand', () => {
        const result = asyncAddition(0, 9);
        jest.runAllTimers();
        expect(setTimeout).toHaveBeenCalledTimes(1);
        expect(setTimeout).toHaveBeenLastCalledWith(expect.any(Function), 0);
        expect(result).resolves.toBe(9);
    });

    test('should return null if missing operands', () => {
        const result = asyncAddition(2);
        jest.runAllTimers();
        expect(setTimeout).toHaveBeenCalledTimes(1);
        expect(setTimeout).toHaveBeenLastCalledWith(expect.any(Function), 2 * 1000);
        expect(result).resolves.toBeNull();
    });
});


