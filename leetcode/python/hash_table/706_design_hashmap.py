class MyHashMap:

    def __init__(self):
        self.map = {}

    def put(self, key: int, value: int) -> None:
        self.map[key] = value

    def get(self, key: int) -> int:
        try:
            return self.map[key]
        except KeyError:
            return -1
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """

    def remove(self, key: int) -> None:
        try:
            del(self.map[key])
        except KeyError:
            pass
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
