def problemS1():
    grid = [1, 2, 3, 4]

    hf = 0
    vf = 0

    inp = input()
    for i in inp:
        if i == "H":
            hf += 1
        elif i == "V":
            vf += 1

    hf = hf % 2
    vf = vf % 2

    if vf:
        for i in [0, 2]:  
            grid[i], grid[i+1] = grid[i+1], grid[i]

    if hf:
        for i in [0, 1]:
            grid[i], grid[i + 2] = grid[i + 2], grid[i]

    print(f"{grid[0]} {grid[1]}\n{grid[2]} {grid[3]}")


def isPrime(num: int) -> bool:
    for i in range(2,num):
        if num % i == 0:
            return False
    return True


def factors(num: int) -> list:
    factorList = [i for i in range(3, num*2 - 2) if isPrime(i)]
    return factorList


def findOutput(n: int) -> (int, int):
    lst = factors(n)
    for i in range(len(lst) - 1):
        for j in range(i, len(lst)):
            if (lst[i] + lst[j])/2 == n:
                return lst[i], lst[j]


def problemS2():
    t = int(input())
    output = []
    for i in range(t):
        n = int(input())
        if isPrime(n):
            output.append(f"{n} {n}")
        else:
            output.append(f"{findOutput(n)[0]} {findOutput(n)[1]}")

    for i in output:
        print(i)


def nums(lst: list) -> int:
    i = 0
    for obj in lst:
        if obj is not None:
            i += 1
    return i


def findDeltaT(g: list):
    if nums(g) not in [0, 1]:
            for i in range(2):
                for j in range(i + 1, 3):
                    if None not in [g[i], g[j]]:
                        return (g[j] - g[i]) / j - i


def findDeltaDeltaT(g: [list, list, list]):
    return findDeltaT([findDeltaT(g[0]), findDeltaT(g[1]), findDeltaT(g[2])])


def problemS3():
    grid = [[int(i) if i != "X" else None for i in input().split()],
            [int(i) if i != "X" else None for i in input().split()],
            [int(i) if i != "X" else None for i in input().split()]]
    print(findDeltaDeltaT(grid))


'''
def roundUp(num: float):
    if num % 1 == 0:
        return num
    if num % 1 >= 0.5:
        return round(num)
    else:
        return(round(num) + 1)


def findMaxNums(days: int, attractions: list):
    maxNums = []
    for i in range(days):
        maxNums.append(max(attractions))
        attractions.remove()


def problemS4():
    n, k = (int(i) for i in input().split())
    attractions = [int(i) for i in input().split()]
    days = roundUp(attractions/k)
'''


class Triangle:


    def __init__(self, values: list, size: int) -> None:
        self.values = []
        self.size = size
        for value in values:
            self.values.append(value)


    def __getTriangle(self, rowNum: int, colNum: int) -> list:
        triangle = []
        for rowIndex in range(rowNum, rowNum + self.size):
            row = []
            for colIndex in range(colNum, colNum + (rowIndex - rowNum) + 1):
                row.append(self.values[rowIndex][colIndex])
            triangle.append(row)
            row = []
        return triangle


    def __getTriangles(self) -> list:
        triangles = []
        for rowIndex in range(len(self.values) - self.size + 1):
            for col in range(len(self.values[rowIndex])):
                triangles.append(self.__getTriangle(rowIndex, col))
        return triangles


    def getSum(self) -> int:
        triangles = self.__getTriangles()
        print(triangles)
        totalSum = 0
        for triangle in triangles:
            triangleMax = 0
            for row in triangle:
                for item in row:
                    if item > triangleMax:
                        triangleMax = item
            totalSum += triangleMax
        return totalSum


def problemS5() -> None:
    triangleValues = []
    file = open("inputText.txt")
    n, k = (int(i) for i in file.readline().split())
    for i in range(n):
        triangleValues.append([int(i) for i in file.readline().split()])
    tri = Triangle(triangleValues, k)
    sum = tri.getSum()
    print(sum)
    

if __name__ == '__main__':
    #problemS1()
    #problemS2()
    #problemS3()
    problemS5()