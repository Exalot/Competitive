def s1():
    n = int(input())
    swifts = [int(x) for x in input().split()]
    semas = [int(x) for x in input().split()]
    print(findK(swifts, semas, n))


def findK(swifts: list, semas: list, n: int):
    k = 0
    for i in range(0, n + 1):
        if sum(swifts[:i]) == sum(semas[:i]):
            k = i
    return k


def s2():
    n = int(input())
    nums = [int(x) for x in input().split()]
    medianIndex = int(len(nums)/2)
    resultNums = []
    nums.sort()
    for i in range(medianIndex):
        print(nums[medianIndex - 1 - i], end=" ")
        print(nums[medianIndex + i], end=" ")


def s3():
    n = int(input())
    nums = [int(x) for x in input().split()]
    nums.sort()
    result1 = 1
    result2 = len(nums)
    lenSum = 0
    for i in range(len(nums)):
        for j in range(len(nums) - i):
            if find_largest_length(i, j) > result1:
                result1 = find_largest_length()



def find_largest_length(index1: int, index2: int):
    pass


if __name__ == '__main__':
    #s1()
    #s2()
    s3()