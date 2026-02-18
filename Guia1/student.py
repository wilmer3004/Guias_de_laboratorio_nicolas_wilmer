from person import Person

class Student(Person):

    def __init__(self, name, age, code):
        super().__init__(name, age, code)

    def show_info(self):
        print("Name:", self.name)
        print("Age:", self.age)
        print("Code:", self.code)
