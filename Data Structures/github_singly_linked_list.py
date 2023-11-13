class EmptyListError(Exception):
	pass

class Node:
	__slots__ = ('data','next')
	def __init__(self,data):
		self.data = data
		self.next = None

class SinglyLinkedList:
	def __init__(self):
		self.head = None
		self.tail = None
		self.size = 0
		self._iter_list = self.head

	def peek_head(self):
		return self.head.data if self.head else None

	def peek_tail(self):
		return self.tail.data if self.tail else None

	def append(self,data):
		node = Node(data)
		if self.tail is None:
			self.tail = self.head = node
		else:
			self.tail.next = node
			self.tail = node
		self.size += 1

	def append_at_head(self,data):
		node = Node(data)
		if self.head is None:
			self.tail = self.head = node
		else:
			node.next = self.head
			self.head = node
		self.size += 1

	def append_at_tail(self,data):
		node = Node(data)
		if self.tail is None:
			self.tail = self.head = node
		else:
			self.tail.next = node
			self.tail = node
		self.size += 1

	def append_at_loc(self,data,loc):
		if loc == 0:
			raise IndexError(f'Insertion to the head ({loc}) can be done using {self.__class__.__name__}\'s {self.append_at_head.__name__!r} method instead')
		if loc >= len(self):
			raise IndexError(f'Insertion to the tail ({loc}) can be done using {self.__class__.__name__}\'s {self.append_at_tail.__name__!r} method instead')
		node = Node(data)
		position = 1
		current = self.head.next
		previous = self.head
		while current.next is not None:
			if position == loc:
				previous.next = node
				node.next = current
				break
			position += 1
			previous = current
			current = current.next
		self.size += 1

	def pop_tail(self):
		if self.tail is None:
			raise IndexError('pop from empty list')
		popped_node = None
		if len(self) == 1:
			popped_node = self.head
			self.tail = self.head = None
		else:
			current = self.head
			previous = None
			while current.next is not None:
				previous = current
				current = current.next
			popped_node = current
			previous.next = None
			self.tail = previous
		self.size -= 1
		return popped_node.data

	def pop_head(self):
		if self.head is None:
			raise IndexError('pop from empty list')
		popped_node = None
		if len(self) == 1:
			popped_node = self.head
			self.tail = self.head = None
		else:
			popped_node = self.head
			self.head = self.head.next
		self.size -= 1
		return popped_node.data

	def pop_at_loc(self,loc):
		if loc == 0:
			raise IndexError(f'Deletion at the head ({loc}) can be done using {self.__class__.__name__}\'s {self.pop_head.__name__!r} method instead')
		if loc >= (len(self)-1):
			raise IndexError(f'Deletion at the tail ({loc}) can be done using {self.__class__.__name__}\'s {self.pop_tail.__name__!r} method instead')
		popped_node = None
		position = 1
		current = self.head.next
		previous = self.head
		while current.next is not None:
			if position == loc:
				popped_node = current
				previous.next = current.next
				break
			position += 1
			previous = current
			current = current.next
		self.size -= 1
		return popped_node.data

	def replace_head(self,data):
		if self.head is None:
			raise EmptyListError(f'{self.__class__.__name__}\'s head is currently None. Can\'t replace on an empty list')
		node = Node(data)
		discarded_node = self.head.data
		node.next = self.head.next
		self.head = node
		return discarded_node

	def replace_tail(self,data):
		if self.tail is None:
			raise EmptyListError(f'{self.__class__.__name__}\'s tail is currently None. Can\'t replace on an empty list')
		node = Node(data)
		current = self.head
		previous = None
		while current.next is not None:
			previous = current
			current = current.next
		discarded_node = current.data
		previous.next = node
		self.tail = node
		return discarded_node

	def replace_node(self,node,new_node):
		if self.head is None:
			raise EmptyListError(f'{self.__class__.__name__} is currently empty. Can\'t replace on an empty list')
		if node == self.peek_head():
			raise KeyError(f'Function {self.replace_node.__name__!r} doesn\'t allow replacement at the head. Use {self.replace_head.__name__!r} instead')
		elif node == self.peek_tail():
			raise KeyError(f'Function {self.replace_node.__name__!r} doesn\'t allow replacement at the tail. Use {self.replace_tail.__name__!r} instead')
		current = self.head.next
		previous = self.head
		discarded_node = None
		while current.next is not None:
			if current.data == node:
				discarded_node = current.data
				current.data = new_node
			current = current.next
		if discarded_node is None:
			raise KeyError(f'Node {node!r} not found')
		return discarded_node

	def _get_index(self,i):
		index = None
		if i < 0:
			if i + len(self) < 0:
				raise IndexError('index out of bounds')
			else:
				index = i + len(self)
		else:
			if i >= len(self):
				raise IndexError('index out of bounds')
			else:
				index = i
		return index

	def __getitem__(self,i):
		if self.head is None:
			raise IndexError('index out of bounds')
		index = self._get_index(i)
		if index == 0:
			return self.peek_head()
		elif index == (len(self) - 1):
			return self.peek_tail()
		else:
			position = 1
			current = self.head.next
			while current.next is not None:
				if position == index:
					return current.data
				position += 1
				current = current.next

	def __len__(self):
		return self.size

	def __str__(self):
		current = self.head
		str_repr = '['
		if current is None:
			return '[]'
		while current:
			str_repr += f'{current.data!r}, '
			current = current.next
		return str_repr[:-2] + ']'

	def __iter__(self):
		self._iter_list = self.head
		return self

	def __next__(self):
		if self._iter_list:
			item = self._iter_list.data
			self._iter_list = self._iter_list.next
			return item
		else:
			raise StopIteration

	def __contains__(self,target):
		if target == self.peek_head() or target == self.peek_tail():
			return True
		current = self.head.next
		while current.next is not None:
			if target == current.data:
				return True
			current = current.next
		return False

sll = SinglyLinkedList()
sll.append('alpha')
sll.append('beta')
sll.append('delta')
sll.append('gamma')
sll.append_at_tail('epsilon')
print(sll)
sll.replace_node('beta','spam')
print(sll)
print(sll.peek_head(), sll.peek_tail())