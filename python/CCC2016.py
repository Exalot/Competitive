inp1 = input()
inp2 = input()


def isAnagram(inp1: str, inp2: str):
    charDict1 = {}
    charDict2 = {}
    specialChars = 0
    commonChars = 0
    for char in inp1:
        if char not in charDict1:
            charDict1[char] = 1
        else:
            charDict1[char] += 1
    for char in inp2:
        if char == "*":
            specialChars += 1
        else:
            if char not in charDict2:
                charDict2[char] = 1
            else:
                charDict2[char] += 1
    for key in charDict2:
        commonChars += charDict1[key] - abs(charDict1[key] - charDict2[key])
    if commonChars + specialChars == len(inp1):
        return True
    return False


def s1():
    inp1 = input()
    inp2 = input()
    if isAnagram(inp1, inp2):
        print("A")
    else:
        print("C")


def modified_max(lst: list, num: int):
    if len(lst) == 1:
        return lst[0]
    newlst = copy.deepcopy(lst)
    for i in range(num):
        newlst.remove(max(newlst))
    return max(newlst)


def modified_min(lst: list, num: int):
    if len(lst) == 1:
        return lst[0]
    newlst = copy.deepcopy(lst)
    for i in range(num):
        newlst.remove(min(newlst))
    return min(newlst)


def s2():
    import copy
    question = int(input())
    n = int(input())
    dmojistan = [int(num) for num in input().split()]
    pegland = [int(num) for num in input().split()]
    totalspeed = 0

    if question == 1:
        for i in range(n):
            totalspeed += max(modified_max(dmojistan, i), modified_max(pegland, i))
        print(totalspeed)

    else:
        for i in range(n):
            totalspeed += max(modified_max(dmojistan, i), modified_min(pegland, i))
        print(totalspeed)


class Empty(Exception):
    '''Error attempting to access an element from an empty container.'''
    pass


class ArrayQueue:
    def __init__(self,capacity: int = 10):
        self._data = [None] * capacity
        self._size = 0
        self._front = 0


    def __len__(self):
        return(self._size)


    def __str__(self):
        if self._front + self._size  >= len(self._data):
            return(str(self._data[self._front:] + self._data[:self._size-self._front]))
        return(str(self._data[self._front:self._front+self._size]))


    def is_empty(self):
        return(self._size == 0)


    def first(self):
        if self.is_empty():
            raise Empty
        return self._data[self._front]


    def dequeue(self):
        if self.is_empty():
            raise Empty
        answer = self._data[self._front]
        self._data[self._front] = None
        self._front = (self._front + 1) % len(self._data)
        self._size -= 1
        if 0 < self._size < len(self._data) // 4:
            self._resize(len(self._data) // 2)
        return answer


    def enqueue(self,e):
        if self._size == len(self._data):
            self._resize(2 * len(self._data))
        avail = (self._front + self._size) % len(self._data)
        self._data[avail] = e
        self._size += 1


    def _resize(self, cap):
        old = self._data
        self._data = [None] * cap
        walk = self._front
        for i in range(self._size):
            self._data[i] = old[walk]
            walk = (1 + walk) % len(old)
        self._front = 0


class BaseTree(object):
    ''' Simulates a linked Binary Tree '''


    class Node(object):
        ''' Simulates the node of the Linked Binary Tree '''


        __slots__ = '_element', '_parent', '_left', '_right'
        def __init__(self, element, parent= None, children= []):
            self._element = element
            self._parent = parent
            self._children = children


        def __str__(self):
            return str(self._element)


    def __init__(self, element= None, parent= None, children= []):
        self._node = self.Node(element, parent, children)


    def __str__(self):
        return str(self._node)


    def __iter__(self):
        return self.pre_order()


    def __getitem__(self, key: int):
        index = 0
        for node in self.pre_order():
            if index == key:
                return node
            index += 1

    def __len__(self):
        size = 0
        for i in self.pre_order():
            size += 1
        return size


    def children(self):
        for child in self._node._children:
            yield child


    def parent(self):
        return self._node._parent


    def sibling(self):
        for child in self._node._parent._node._children:
            if child is not self:
                yield child


    def children(self):
        for child in self._node._children:
            yield child


    def root(self):
        if self.parent() is not None:
            self.parent().root()
        return self


    def depth(self):
        if self.is_root():
            return 0
        return 1 + (self._node._parent.depth())


    def height(self):
        if self.is_leaf():
            return 0
        values = []
        for child in self._node._children:
            values.append(1 + child.height())
        return max(values)


    def element(self):
        return self._node._element


    def add_child(self, value):
        self._node._children.append(LinkedBinaryTree(value, parent= self))

    
    def remove_child(self, index: int):
        self._node._children.pop(index)


    def remove_parent(self):
        self._node._parent._children.remove(self)
        self._node._parent = None


    def is_root(self):
        return self._node._parent is None


    def is_leaf(self):
        return self._node._left is None and self._node._right is None


    def attach(self, p):
        self._node._parent = p
        self._node._parent._children.append(self)


    def position(self, key: int):
        index = 0
        for node in self.pre_order():
            if index == key:
                return node
            index += 1


    def _delete_subtree(self, p: int):
        subtree = self.__getitem__(p)
        subtree._node._parent.remove_child(subtree._node._parent._children.index(self))


    def swap(self, p: int, q: int):
        tree_p = self.position(p)
        tree_q = self.position(q)
        tree_p._node._parent,  tree_p._node._children, \
        tree_q._node._parent, tree_q._node._children   \
        = tree_q._node._parent, tree_q._node._children,\
        tree_p._node._parent, tree_p._node._children  


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
        fringe = ArrayQueue()
        fringe.enqueue(self.root())
        while not fringe.is_empty():
            p = fringe.dequeue()
            yield p
            for c in p.children():
                fringe.enqueue(c)


def s3():
    n, m = [int(i) for i in input().split()][0],[1]


if __name__ == '__main__':
    #s1()
    #s2()
    s3()