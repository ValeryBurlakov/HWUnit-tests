class ListsComparator:
    """A class for comparing two lists."""

    def __init__(self, list1, list2):
        """Initialize the ListsComparator class."""
        self.list1 = list1
        self.list2 = list2

    def calculate_average(self, lst):
        """Calculate the average of a list."""
        return sum(lst) / len(lst) if len(lst) > 0 else 0

    def compare_lists(self):
        """Compare the average values of the two lists."""
        average1 = self.calculate_average(self.list1)
        average2 = self.calculate_average(self.list2)

        if average1 > average2:
            return "Первый список имеет большее среднее значение."
        if average2 > average1:
            return "Второй список имеет большее среднее значение."
        return "Средние значения равны."
