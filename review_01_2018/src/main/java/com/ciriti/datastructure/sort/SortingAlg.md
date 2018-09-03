# [Sorting Algorithms](https://brilliant.org/wiki/sorting-algorithms/)

**Stability**: A sorting algorithm is stable if it preserves the original order of elements with equal key values (where the key is the value the algorithm sorts by).

| Algorithm     | Best-case     | Worst-case    | Average-case  | Space Complexity  | Stable?       |
| ------------- | ------------- | ------------- | ------------- | -------------     | ------------- |
| Merge Sort    | O(nlogn)      | O(nlogn)      | O(nlogn)      | O(n)              | yes           |
| Insertion Sort| O(n)          | O(n^2)        | O(n^2)        | O(1)              | yes           |
| Bubble Sort   | O(n)          | O(n^2)        | O(n^2)        | O(1)              | yes           |
| Quicksort     | O(nlogn)      | O(n^2)        | O(nlogn)      | logn best/n       | dep. version  |
| Heapsort      | O(nlogn)      | O(nlogn)      | O(nlogn)      | O(1)              | no            |

## [Insertion Sort]()

Insertion sort is a comparison-based algorithm that builds a final sorted array one element at a time. It iterates through an input array and removes one element per iteration, finds the place the element belongs in the array, and then places it there.

![Gif of Insertion Sort](https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif)

## [Mergesort]()

Mergesort is a comparison-based algorithm that focuses on how to merge together two pre-sorted arrays such that the resulting array is also sorted.

![Gif of Merge Sort](https://ds055uzetaobb.cloudfront.net/image_optimizer/8c074d46d4c96077d11f9e8cab9ff5d95bdc3da0.gif)

## Quicksort

![Gif of Quicksort](https://ds055uzetaobb.cloudfront.net/image_optimizer/904290ba2b43687554b1d074d091367f370a0c08.gif)

Quicksort is a comparison-based algorithm that uses divide-and-conquer to
sort an array. The algorithm picks a pivot element, *A[q]*, and then
rearranges the array into two subarrays *A[p...q-1]*,
such that all elements are less than *A[q]*, and *A[q+1...r]*, such that
all elements are greater than or equal to *A[q]*.

## Bubblesort

Bubble sort is a comparison​-based algorithm that compares each pair of
elements in an array and swaps them if they are out of order until the
entire array is sorted. For each element in the list, the algorithm
compares every pair of elements.

![Gif of Bubblesort](https://ds055uzetaobb.cloudfront.net/image_optimizer/4f60337caedcc96ffeb08692e4f8d00f5cb3fd58.gif)
