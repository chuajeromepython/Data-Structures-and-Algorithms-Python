class StackUnderflow(Exception): 
	""" custom Exception class for context """
	pass

class Stack:
	def __init__(self):
		"""The class "Stack" will have self.main as a normal Python list,
		self.size to track the size of the list, and self.top to track 
		the current topmost element in the list. self.index is only for
		iteration purposes."""
		self.main = []
		self.size = 0
		self.index = 0
		self.top = None

	def push(self,item):
		self.main.append(item)
		self.top = item # self_top is every new item pushed into the stack
		self.size += 1
		
	def pop(self):
		if not self.main:
			raise StackUnderflow('pop from an empty stack') 
		popped = self.main.pop()
		self.size -= 1
		if not self.main:
			self.top = None # set self._top to None if stack is empty
		else:
			self._top = self.main[len(self)-1] # set self._top to the current top of the stack
		return popped

	def clear(self):
		"""calling the __init__ constructor will create a fresh instance of Stack"""
		self.__init__()

	def peek_top(self):
		if not self.main:
			return None
		return self.top

	def is_empty(self):
		return not bool(self)
		
	def __bool__(self):
		return self.size > 0

	def __len__(self):
		return self.size

	def __str__(self):
		return str(self.main)

	def __iter__(self):
		return self

	def __next__(self):
		if self.index < self.size:
			result = self.main[self.index]
			self.index += 1
			return result
		else:
			self.index = 0 
			raise StopIteration

if __name__ == '__main__':
	stack = Stack()
	stack.push(1)
	stack.push(2)
	stack.push(3)
	stack.push(4)
	print(stack) # returns the items in list format
	print(len(stack)) # returns the size of the stack
	print(stack.peek_top()) # returns the top item of the stack
	print(stack.is_empty()) # returns true if empty, false otherwise
	for item in stack: # __iter__ and __next__ makes the Stack class iterable
		print(item)
