from ListsComparator import ListsComparator


def test_compare_lists_first_larger():
    """
    среднее значение первого списка должно быть больше среднего значения второго списка
    """
    list2 = [1, 2, 3, 4, 5]
    list1 = [6, 7, 8, 9, 10]
    comparator = ListsComparator(list1, list2)
    result = comparator.compare_lists()
    assert result == "Первый список имеет большее среднее значение."


def test_compare_lists_second_larger():
    """
    среднее значение второго списка должно быть больше среднего значения первого списка
    """
    list1 = [1, 2, 3]
    list2 = [4, 5, 6, 7, 8]
    comparator = ListsComparator(list1, list2)
    result = comparator.compare_lists()
    assert result == "Второй список имеет большее среднее значение."


def test_compare_lists_same_values():
    """
    средние значения каждого из списков должны быть равны
    """
    list1 = [1, 2, 3, 4]
    list2 = [1, 2, 3, 4]
    comparator = ListsComparator(list1, list2)
    result = comparator.compare_lists()
    assert result == "Средние значения равны."


def test_compare_lists_empty_lists():
    """
    Провера на пустых списках
    """
    list1 = []
    list2 = []
    comparator = ListsComparator(list1, list2)
    result = comparator.compare_lists()
    assert result == "Средние значения равны."


def test_compare_lists_one_empty_list():
    """
    проверка с одним пустым списком, среднее значение первого списка должно быть больше
    """
    list1 = [1, 2, 3]
    list2 = []
    comparator = ListsComparator(list1, list2)
    result = comparator.compare_lists()
    assert result == "Первый список имеет большее среднее значение."


def test_compare_lists_negative_values():
    """
    проверка списков с отрицательными числами
    """
    list1 = [-1, -2, -3]
    list2 = [2, -1, -3, -6]
    comparator = ListsComparator(list1, list2)
    result = comparator.compare_lists()
    assert result == "Средние значения равны."

