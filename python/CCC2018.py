def problem1():
    n = int(input())
    villages = []
    for i in range(n):
        villages.append(int(input()))
        villages.sort()

    smallestVillageSize = None
    for index in range(1, len(villages) - 1):
        size = (villages[index + 1] - villages[index])/2 + (villages[index] - villages[index-1])/2 
        if smallestVillageSize is None or size < smallestVillageSize:
            smallestVillageSize = size
    print(smallestVillageSize)

'''
n = int(input())
flowers = []
for i in range(n):
    flowers.append([int(j) for j in input().split()])


def rotate(lst: list):
    newLst = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
    for x in range(len(lst)):
        for y in range(len(lst)):
'''

