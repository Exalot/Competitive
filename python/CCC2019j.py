def problem1():
    a3 = int(input())
    a2 = int(input())
    a1 = int(input())
    b3 = int(input())
    b2 = int(input())
    b1 = int(input())

    aT = a3 * 3 + a2 * 2 + a1 * 1
    bT = b3 * 3 + b2 * 2 + b1 * 1

    if(aT > bT):
        print("A")
    elif(aT < bT):
        print("B")
    else:
        print("T")


def problem2():
    messege = []
    for i in range(int(input())):
        messege.append(input().split())
        messege[i][0] = int(messege[i][0])
    for j in messege:
        print(j[0] * j[1])


def decodeLine(line: str):
    result = ""
    charCounter = 0
    currentChar = line[0]
    for char in line:
        if char == currentChar:
            charCounter += 1
        else:
            result += f"{charCounter} {currentChar} "
            charCounter = 1
            currentChar = char

    result += f"{charCounter} {currentChar} "
    
    return result + "\n"


def problem3():
    messege = ""
    for i in range(int(input())):
        messege += decodeLine(input())
    print(messege)


def problem4():
    nums = [1, 2, 3, 4]
    for i in input():
        if i == "H":
            nums[0], nums[1], nums[2], nums[3] = nums[2], nums[3], nums[0], nums[1]
        else:
            nums[0], nums[1], nums[2], nums[3] = nums[1], nums[0], nums[3], nums[2]
    print("{} {}\n{} {}".format(nums[0], nums[1], nums[2], nums[3]))


def mainProblem5(rules: list, num: int, initSeq: str, finalSeq: str, s, steps = ""):
    if num == 0 and initSeq == finalSeq:
        return steps
    rulesAvailable = [rule for rule in rules if rule[0] in initSeq]
    newSteps = ""
    if len(rulesAvailable) != 0:
        for rule in rulesAvailable:
            for index in range(len(initSeq)):
                if rule[0] == initSeq[index:index + len(rule[0])]:
                    newSteps = "{} {} {}\n".format(rule[-1], s - num, initSeq[:index] + rule[1] + initSeq[index + len(rule[0]):])
                    if(mainProblem5(rules, num - 1, initSeq[:index] + rule[1] + initSeq[index + len(rule[0]):], finalSeq, s, steps + newSteps)):
                        return mainProblem5(rules, num - 1, initSeq[:index] + rule[1] + initSeq[index + len(rule[0]):], finalSeq, steps + newSteps)


def problem5():
    rules = [input().split() + [1], input().split() + [2], input().split() + [3]]
    s, initSeq, finalSeq = input().split()
    s = int(s)
    mainProblem5(rules, s, initSeq, finalSeq, s, "")


if __name__ == "__main__":
    #problem1()
    #problem2()
    #problem3()
    #problem4()
    problem5()