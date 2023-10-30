class EmptyQueue(Exception):
	""" custom Exception class for context """
	pass

class Queue:
	def __init__(self):
		"""The class "Queue" will have self.main as a normal Python list,
		self.size to track the size of the list, and self.front to track 
		the first element in the list. self.index is only for iteration purposes."""
		self.main = []
		self.size = 0
		self.index = 0
		self.front = None

	def enqueue(self,item):
		self.main.append(item)
		self.front = self.main[0] # self.main[0] is self.front every time an item is enqueued
		self.size += 1

	def dequeue(self):
		if not self.main:
			raise EmptyQueue('pop from an empty queue')
		popped = self.main.pop(0)
		if not self.main:
			self.front = None # set self.front to None if main is empty
		else:
			self.front = self.main[0] # set self.front to self.main[0] if main is not empty
		self.size -= 1
		return popped

	def peek_front(self):
		if not self.main:
			return None
		return self.front

	def clear(self):
		self.__init__()

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
	queue = Queue()
	queue.enqueue(1)
	queue.enqueue(2)
	queue.enqueue(3)
	queue.enqueue(4)
	print(queue) # returns the items in list format
	print(len(queue)) # returns the size of the queue
	print(queue.peek_front()) # returns the front element of the queue
	print(queue.is_empty()) # returns true if empty, false otherwise
	for item in queue: # __iter__ and __next__ makes the Queue class iterable
		print(item)
