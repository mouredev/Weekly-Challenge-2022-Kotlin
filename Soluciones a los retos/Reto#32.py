# Get the second largest number in a list

# 1st method
numbers = [10, 15, 45, 25, 35, 20, 50, 70, 18, 30, 40, 60, 80]

def getSecondLargest(numbers):
    numbers.sort()
    return numbers[-2]

print(getSecondLargest(numbers))

# 2nd method
def bubble_sort(nums):
    for i in range(len(nums)):
        for j in range(len(nums)):
            if nums[i] > nums[j]:
                nums[i], nums[j] = nums[j], nums[i]

    return nums[1]

print(bubble_sort(numbers))