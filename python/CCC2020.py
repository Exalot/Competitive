def j5s1():
    observations = int(input())

    def merge(lst1, lst2):
        """Return a sorted list with the elements in <lst1> and <lst2>.

        Precondition: <lst1> and <lst2> are sorted

        @type lst1: list
        @type lst2: list
        @rtype: list
        """
        index1 = 0
        index2 = 0
        merged = []
        while index1 < len(lst1) and index2 < len(lst2):
            if lst1[index1][0] <= lst2[index2][0]:
                merged.append(lst1[index1])
                index1 = index1 + 1
            else:
                merged.append(lst2[index2])
                index2 = index2 + 1

        # Now either index1 = len(lst1) or index2 = len(lst2).
        # The remaining elements of the other list
        # can all be added to the end.
        # Note that at most ONE of lst1[index1:] and lst2[index2:]
        # is non-empty.
        return merged + lst1[index1:] + lst2[index2:]

    def mergesort(lst: list):
        """Return a sorted list with the same elements as <lst>.

        @type lst: list
        @type: lst
        """
        if len(lst) < 2:
            return lst
        else:
            mid = len(lst) // 2 # This is the midpoint of lst
            left_sorted = mergesort(lst[:mid])
            right_sorted = mergesort(lst[mid:])
            # "merge" the two sorted halves (how?)
            return merge(left_sorted, right_sorted)

    valuesList = []

    for i in range(observations):
        valuesList.append(input().split())

    for item in range(len(valuesList)):
        valuesList[item] = [int(valuesList[item][0]), int(valuesList[item][1])]

    valuesList = mergesort(valuesList)

    maxDiff = 0
    for i in range(len(valuesList)-1):
        if abs((valuesList[i][1]-valuesList[i+1][1])/(valuesList[i][0]-valuesList[i+1][0])) > maxDiff:
            maxDiff = abs((valuesList[i][1]-valuesList[i+1][1])/(valuesList[i][0]-valuesList[i+1][0]))
    print(maxDiff)


def j5s2():
    height = int(input())
    base = int(input())
    valueList = []
    for y in range(height):
        row = []
        inp = input().split()
        for x in range(len(inp)):
            row.append([int(inp[x]), [x+1,y+1]])
        valueList.append(row)

    def escape(value = valueList[0][0][0], x = 1, y = 1, usedCordinates = []):
        if x == base and y == height:
            return True
        results = []
        for row in valueList:
            for item in row:
                alreadyUsed = [item[1][0], item[1][1]] in usedCordinates
                if item[1][0] * item[1][1] == value and not alreadyUsed:
                    if escape(item[0], item[1][0], item[1][1], usedCordinates + [[item[1][0], item[1][1]]]):
                        return True
        return False
    if escape():
        print("yes")
    else:
        print("no")


def j5s3():
    def subStrings(s: str):
        subs = [s]
        subString = ""
        for i in range(len(s)-1):
            for j in range(i+1,len(s)):
                subString = s[:i] + s[j] + s[i+1:j] + s[i] + s[j+1:]
                if subString not in subs:
                    subs.append(subString)
        return subs

    str1 = input()
    str2 = input()
    subs = subStrings(str1)
    count = 0
    for i in range(len(str2)-len(str1)+1):
        if str2[i:i+len(str1)] in subs:
            count += 1
            subs.remove(str2[i:i+len(str1)])
    print(count)


class LinkedBinaryTree(object):
    ''' Simulates a linked Binary Tree '''

    class Node(object):
        ''' Simulates the node of the Linked Binary Tree '''

        __slots__ = '_element', '_parent', '_left', '_right'

        def __init__(self, element, parent=None, children=None):
            self._element = element
            self._parent = parent
            self._children = children

        def __str__(self):
            return str(self._element)

    def __init__(self, element=None, parent=None, children=None):
        self._node = self.Node(element, parent, children)

    def __str__(self):
        return str(self._node)

    def __iter__(self):
        return self.pre_order()

    def __getitem__(self, key: int):
        return self._node._children[key]

    def __len__(self):
        size = 0
        for i in self.pre_order():
            size += 1
        return size

    def parent(self):
        return self._node._parent

    def sibling(self):
        for child in self._node._parent._
        if self._node._parent._left is self:
            return self._node._parent._right
        else:
            return self._node._parent._left

    def children(self):
        if self._node._left is not None:
            yield self._node._left
        if self._node._right is not None:
            yield self._node._right

    def root(self):
        if self.parent() is not None:
            return self.parent().root()
        return self

    def depth(self):
        if self.is_root():
            return 0
        return 1 + (self._node._parent.depth())

    def height(self):
        if self.is_leaf():
            return 0
        if self.right() is not None:
            right_height = 1 + self._node._right.height()
        else:
            right_height = 0
        if self.left() is not None:
            left_height = 1 + self._node._right.height()
        else:
            left_height = 0
        return max(right_height, left_height)

    def element(self):
        return self._node._element

    def add_left(self, value):
        self._node._left = LinkedBinaryTree(value, parent=self)

    def add_right(self, value):
        self._node._right = LinkedBinaryTree(value, parent=self)

    def remove_parent(self):
        parent = self._node._parent
        if parent.left() is self:
            parent.remove_left()
        else:
            parent.remove_right()

    def remove_left(self):
        self._node._left._parent = None
        self._node._left = None

    def remove_right(self):
        self._node._right._parent = None
        self._node._right = None

    def is_root(self):
        return self._node._parent is None

    def is_leaf(self):
        return self._node._left is None and self._node._right is None

    def attach(self, p):
        self._sentinel._node._child._parent = p
        p._node._child = self._sentinel._node._child

    def position(self, key: int):
        index = 0
        for node in self.pre_order():
            if index == key:
                return node
            index += 1

    def pre_order(self):
        if self.is_leaf():
            yield self.element()
        else:
            yield self._node._element
            for children in self.children():
                for child_element in children.pre_order():
                    yield child_element

    def post_order(self):
        if self.is_leaf():
            yield self.element()
        else:
            for children in self.children():
                for child_element in children.post_order():
                    yield child_element
            yield self._node._element

    def breath_first(self):
        from ArrayQueue import ArrayQueue
        fringe = ArrayQueue()
        fringe.enqueue(self.root())
        while not fringe.is_empty():
            p = fringe.dequeue()
            yield p
            for c in p.children():
                fringe.enqueue(c)

    def in_order(self):
        if self.is_leaf():
            yield self._node._element
        else:
            left_node, right_node = self.left(), self.right()
            if left_node is not None:
                for i in left_node.in_order():
                    yield i
            yield self._node._element
            if right_node is not None:
                for i in right_node.in_order():
                    yield i


if __name__ == '__main__':
    #j5s1()
    j5s2()
    #j5s3()