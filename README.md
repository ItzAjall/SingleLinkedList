# SingleLinkedList

A simple implementation of a **Singly Linked List** in Java. This class provides basic operations like adding, removing, accessing, and updating elements. It also supports using the index `-1` to access the last element.

---

## Features

- Add elements to the beginning (`addFirst`) or end (`addLast`) of the list
- Add element at a specific index (`add(index, value)`)
- Remove elements from the beginning (`removeFirst`) or end (`removeLast`)
- Remove element at a specific index (`remove(index)`)
- Access element (`get(index)`) and update it (`set(index, value)`)
- Support for negative index `-1` to access the last element
- Check if the list is empty (`isEmpty()`)
- Get the size of the list (`getSize()` or `length()`)
- Print the list using `toString()`

---

## Classes

### `SingleLinkedList`
The main class that manages the list and provides methods:

- `SingleLinkedList()` : Creates an empty list
- `SingleLinkedList(int... args)` : Creates a list from an array of numbers
- `addFirst(int number)` : Add to the beginning
- `addLast(int number)` / `add(int number)` / `push(int number)` : Add to the end
- `add(int index, int number)` : Add at a specific index
- `removeFirst()` : Remove the first element
- `removeLast()` / `pop()` : Remove the last element
- `remove(int index)` : Remove element at a specific index
- `get(int index)` : Get the value at a specific index
- `set(int index, int number)` : Set the value at a specific index
- `isEmpty()` : Check if the list is empty
- `getSize()` / `length()` : Get the list size
- `toString()` : Display the list as a string

### `ListNode`
Internal class representing each node in the list:
- `int data` : Node value
- `ListNode next` : Reference to the next node

### `EmptyListException`
Custom exception thrown when performing operations on an empty list.

---

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList(1, 2, 3);

        list.addFirst(0);
        list.addLast(4);
        list.add(2, 10);

        System.out.println(list); // [0, 1, 10, 2, 3, 4]

        list.removeFirst();
        list.removeLast();
        list.remove(1);

        System.out.println(list); // [1, 2, 3]

        System.out.println(list.get(0)); // 1
        list.set(1, 20);
        System.out.println(list); // [1, 20, 3]
    }
}
