# [Sorting Algorithms](https://brilliant.org/wiki/sorting-algorithms/)

**Stability**: A sorting algorithm is stable if it preserves the original order of elements with equal key values (where the key is the value the algorithm sorts by).

| Algorithm     | Best-case     | Worst-case    | Average-case  | Space Complexity  | Stable?       |
| ------------- | ------------- | ------------- | ------------- | -------------     | ------------- |
| Merge Sort    | O(nlogn)      | O(nlogn)      | O(nlogn)      | O(n)              | yes           |
| Insertion Sort| O(n)          | O(n^2)        | O(n^2)        | O(1)              | yes           |
| Bubble Sort   | ____________  | ____________  | ____________  | ____________      | ____________  |
| Quicksort     | O(nlogn)      | O(n^2)        | O(nlogn)      | logn best/n       | dep. version  |
| Heapsort      | ____________  | ____________  | ____________  | ____________      | ____________  |

## [Insertion Sort]()

Insertion sort is a comparison-based algorithm that builds a final sorted array one element at a time. It iterates through an input array and removes one element per iteration, finds the place the element belongs in the array, and then places it there.

![Gif of Insertion Sort](https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif)

## [Mergesort]()

Mergesort is a comparison-based algorithm that focuses on how to merge together two pre-sorted arrays such that the resulting array is also sorted.

![Gif of Merge Sort](https://ds055uzetaobb.cloudfront.net/image_optimizer/8c074d46d4c96077d11f9e8cab9ff5d95bdc3da0.gif)

## Quicksort