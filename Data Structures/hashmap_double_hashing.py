class KeyError(Exception): pass

class AttributeError(Exception): pass

class Item:
	def __init__(self,k,v):
		self.k = k
		self.v = v

class Hashmap:
	def __init__(self):
		self.size = 256
		self.slots = [None] * self.size
		self.cnt = 0
		self.MAXLOADFACTOR = 0.65
		self.index = 0
		self.prime_num = 5
		
	def _hash(self,key):
		""" hash function, returns an index for insertion """
		mult = 1
		hv = 0
		for c in key:
			hv += ord(c) * mult
			mult += 1
		return hv % self.size

	def __setitem__(self,k,v):
		""" set items like the built-in dict type """
		item = Item(k,v)
		hv = self._hash(k)
		j = 1 # new variable
		while self.slots[hv] is not None:
			if self.slots[hv].k == k:
				break
			hv = (hv + j * (self.prime_num - (self._hash(key) % self.prime_num))) % self.size # double hashing
			j += 1 # then inrease by 1
		if self.slots[hv] is None:
			self.cnt += 1
		self.slots[hv] = item
		self.check_growth()

	def __getitem__(self,k):
		""" indexable using hashmap[key] notation """
		hv = self._hash(k)
		if self.slots[hv] is None:
			raise KeyError(f'key {k!r} not found.')
		return self.slots[hv].v

	def __len__(self):
		return self.cnt

	def __iter__(self):
		return self

	def __next__(self):
		""" turns Hashmap into an iterable """
		if self.index < self.cnt:
			item = self.keys()[self.index]
			self.index += 1
			return item
		else:
			self.index = 0
			raise StopIteration

	def __str__(self):
		string_builder = '{'
		for item in self:
			frmt_str = f'{item!r}: {self[item]!r}'
			string_builder += frmt_str + ', '
		return string_builder[:-2] + '}'

	def check_growth(self):
		""" resize if loadfactor is greater than MAXLOADFACTOR """
		lf = self.cnt / self.size
		if lf > self.MAXLOADFACTOR:
			self.growth()

	def growth(self):
		""" create a new hashmap instance if the call to the method self.check_growth is true """
		new_hash_map = Hashmap()
		new_hash_map.size = self.size * 2
		new_hash_map.slots = [None] * new_hash_map.size
		for i in range(self.size):
			if self.slots[i]:
				new_hash_map[self.slots[i].k] = self.slots[i].v
		self.size = new_hash_map.size
		self.slots = new_hash_map.slots

	def get(self,k,default=None):
		try:
			return self[k]
		except KeyError:
			return default

	def remove(self,k):
		hv = self._hash(k)
		popped = self.slots[hv] 
		if popped is None:
			raise KeyError(f'key {k!r} not found.')
		self.slots[hv] = None
		self.cnt -= 1
		return popped.k,popped.v

	def keys(self):
		return [key.k for key in self.slots if key]

	def values(self):
		return [val.v for val in self.slots if val]

	def items(self):
		return [(item.k,item.v) for item in self.slots if item]

hm = Hashmap()
hm['A'] = 'one'
hm['B'] = 'two'
hm['C'] = 'three'
hm['D'] = 'four'
hm['E'] = 'five'
hm['F'] = 'six'
print(hm) # prints in dictionary format
print(len(hm)) # returns the number of key-pair values in slots
print(hm['A']) # __getitem in use__, raises an exception if key not in slots
print(hm.get('E',-1)) # retrieves a value, returns the default value if key not in slots
print(hm.remove('E')) # removes and returns a key-value pair in tuple format, raises an exception if key not in slots
print(hm.keys(),hm.values(),hm.items()) # returns [key1,key2,keyn], [val1,val2,valn], [(kv1),(kv2),(kv3)]

for key in hm: # returns a key each iteration
	print(key) # or hm[key] to retrieve the value
	
