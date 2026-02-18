from abc import ABC, abstractmethod

class Person(ABC):

    def __init__(self, name, age, code):
        self.name = name
        self.age = age
        self.code = code

    @abstractmethod
    def show_info(self):
        pass
