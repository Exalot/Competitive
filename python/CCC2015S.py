def s1():
    k = int(input())
    nums = []
    for i in range(k):
        num = int(input())
        if num == 0:
            nums.pop()
        else:
            nums.append(num)
    print(sum(nums))


def processAthlete():
    sizeDict = {"S": 1, "M": 2, "L": 3}
    info = input().split()
    return [int(info[1]), sizeDict[info[0]]]


def s2():
    j = int(input())
    a = int(input())
    jourseys = {}
    atheles = []
    sizeDict = {"S": 1, "M": 2, "L": 3}
    for i in range(1, j+1):
        jourseys[i] = sizeDict[input()]
        # jourseynum, size
    for j in range(a):
        atheles.append(processAthlete())
        # jourseynum, size
    satisfied = 0
    for athele in atheles:
        if jourseys[athele[0]] >= athele[1]:
            satisfied += 1
            del jourseys[athele[0]]
    print(satisfied)


def s3():
    G = int(input())
    P = int(input())
    docks = {i: True for i in range(G)}
    planesDone = 0
    done = False
    for i in range(P):
        planeDock = int(input())
        if not done:
            planeLanded = False
            for j in range(planeDock-1, -1, -1):
                if docks[j] and not planeLanded:
                    docks[j] = False
                    planesDone += 1
                    planeLanded = True
            if not planeLanded:
                done = True
    print(planesDone)


def s4main(current_pos: int, destination: int, t: int, h: int, routes: dict, k: int) -> int:
    if h > k or len(routes) == 0:
        return -1
    routes_lst = [routes for i in range(len(routes))]
    returned_values = []
    route_available = False
    for route in routes:
        if current_pos in [route[0], route[1]]:
            route_available = True
            new_route_dict = routes_lst.pop()
            del routes[route]
            if current_pos == route[0]:
                routeValue = s4main([route][1], destination, t+routes[route][0], h+routes[route][1], new_route_dict)
                if routeValue != -1:
                    returned_values.append(routeValue)
            else:
                routeValue = s4main([route][1], destination, t+routes[route][0], h+routes[route][1], new_route_dict)
                if routeValue != -1:
                    returned_values.append(routeValue)
    if not route_available or len(returned_values) == 0:
        return -1
    return min(returned_values)


def s4():
    K, N, M = [int(i) for i in input().split()]
    routes = {}
    for i in range(M):
        values = [int(i) for i in input().split()]
        routes[(values[0], values[1])] = [values[2], values[3]]
    islands = [int(i) for i in input().split()]
    print(s4main(islands[0], islands[1], 0, 0, routes, K))


def s4_main_prime(pos: int, destination: int, t: int, h: int, routes: list, k: int, routes_covered=None) -> int:
    if routes_covered is None:
        routes_covered = []
    if pos == destination:
        return t
    routes_time = []
    for route_index in range(len(routes)):
        if route_index not in routes_covered:
            route = routes[route_index]
            if route[0] == pos and route[3] + h > k:
                routes_time.append(s4_main_prime(route[1], destination, t + route[2],
                                                 h + route[3], routes, k, routes_covered + [route_index]))
            if route[1] == pos and route[3] + h > k:
                routes_time.append(s4_main_prime(route[0], destination, t + route[2],
                                                 h + route[3], routes, k, routes_covered + [route_index]))
    routes_time = [route_time for route_time in routes_time if route_time != -1]
    if len(routes_time) == 0:
        return -1
    return t + min(routes_time)


def s4_prime():
    k, n, m = [int(i) for i in input().split()]
    routes = []
    for i in range(m):
        routes.append([int(i) for i in input().split()])
    island_pos_destin = [int(i) for i in input().split()]
    print(s4_main_prime(island_pos_destin[0], island_pos_destin[1], 0, 0, routes, k))


if __name__ == '__main__':
    # s1()
    # s2()
    # s3()
    # s4()
    s4_prime()
