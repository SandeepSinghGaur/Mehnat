# Custom Sorting in Java – Complete Guide

This README explains **custom sorting in Java** using `Arrays`, `List`, `Map`, `PriorityQueue`, and `Collections.sort`, with **interview-focused patterns**, examples, and best practices.

---

## Table of Contents
1. [Sorting Arrays](#1-sorting-arrays)
2. [Sorting Lists](#2-sorting-lists)
3. [Sorting Maps](#3-sorting-maps)
4. [Sorting PriorityQueue](#4-sorting-priorityqueue)
5. [Collections.sort vs List.sort](#5-collectionssort-vs-listsort)
6. [Comparator vs Comparable](#6-comparator-vs-comparable)
7. [Common Mistakes](#7-common-mistakes)
8. [Best Practices](#8-best-practices)
9. [Interview Tips](#9-interview-tips)

---

## 1. Sorting Arrays

### 1.1 Primitive Array (`int[]`)
```java
int[] arr = {5, 2, 9, 1};
Arrays.sort(arr); // Ascending only
```

### 1.2 Object Array (`Integer[]`)
```java
Integer[] arr = {5, 2, 9, 1};
Arrays.sort(arr, (a, b) -> b - a); // Descending
```

### 1.3 2D Array (`int[][]`)
**Sort by column 1 ASC**
```java
Arrays.sort(arr, (a, b) -> a[1] - b[1]);
```

**Sort by column 1 DESC, column 0 DESC**
```java
Arrays.sort(arr, (a, b) -> {
    if (a[1] != b[1]) return b[1] - a[1];
    return b[0] - a[0];
});
```

## 2. Sorting Lists

### 2.1 List of Integers
```java
list.sort((a, b) -> b - a); // Descending
```

## 3. Sorting Maps

### 3.1 Sort Map by Key
```java
// TreeMap sorts by key naturally
Map<Integer, String> sorted = new TreeMap<>((a, b) -> b - a); // Descending Key
sorted.putAll(map);
```

### 3.2 Sort Map by Value
```java
List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

// Sort by value DESC
list.sort((a, b) -> b.getValue() - a.getValue());
```

### 3.3 Sort by Value DESC, Key ASC
```java
list.sort((a, b) -> {
    if (!a.getValue().equals(b.getValue()))
        return b.getValue() - a.getValue(); // Value DESC
    return a.getKey() - b.getKey();       // Key ASC
});
```

## 4. PriorityQueue Custom Sorting

### 4.1 Max Heap
```java
PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
```

### 4.2 PriorityQueue of `int[]`
```java
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
    if (a[1] != b[1]) return b[1] - a[1];
    return b[0] - a[0];
});
```

### 4.3 PriorityQueue of `Map.Entry`
```java
PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
    if (!a.getValue().equals(b.getValue()))
        return b.getValue() - a.getValue();
    return b.getKey() - a.getKey();
});
```

## 5. Collections.sort vs List.sort
- `Collections.sort(list)` is the older way (Java 7 and below).
- `list.sort(comparator)` is the method added in Java 8 directly on the `List` interface; it is preferred.

## 6. Comparator vs Comparable
- **Comparable**: Implemented by the class itself (`implements Comparable<T>`). Override `compareTo`. "Natural ordering".
- **Comparator**: External sorting logic. Functional interface (`(a, b) -> ...`). "Custom ordering".

## 7. Common Mistakes
- **Integer overflow**: When doing `a - b` if values are large negative/positive, it can overflow. Use `Integer.compare(a, b)` for safety.
- **Modifying collection while sorting**: Don't do it.
- **Comparator contract**: Must be transitive. `compare(a, b) > 0` and `compare(b, c) > 0` implies `compare(a, c) > 0`.

## 8. Best Practices
- Use `Comparator.comparing(...)` and `thenComparing(...)` for readable chains.
  ```java
  list.sort(Comparator.comparing(Person::getAge)
                      .reversed()
                      .thenComparing(Person::getName));
  ```
- Use `Integer.compare(a, b)` instead of `a - b` to avoid overflow.

## 9. Interview Tips
- Remember that `Arrays.sort` on primitives uses **Dual-Pivot Quicksort** ($O(n \log n)$ avg, $O(n^2)$ worst).
- `Arrays.sort` on Objects / `Collections.sort` uses **Timsort** (stable, $O(n \log n)$).
- Be comfortable writing lambdas for 2D arrays and Maps.
