# LongestCommonConsecutiveString

It works like the [LCS](dynamic/LCS.md) except for the Backtracking part.

## Backtracking to find the actual contiguous subsequents

I'm comparing this two strings `sittin` and `kitten`.

So far we've calculated the length of every possible subsequence.
The length of the longest NON CONSECUTIVE subsequence is found in the bottom-right
corner of matrix, at `matrix[n+1][m+1]`.

 We want to find the longest CONSECUTIVE sub-sequence so we start from `matrix[n+1][m+1]` and
 every time we found that:

  - `matrix[n][m]` is equal to `matrix[n+1][m]`,  is equal to `matrix[n][m+1]` and
 it is smaller than `matrix[n+1][m+1]` we add inside the stack ether the element `sittin[n]` or `kitten[m]`.

 if `matrix[n][m]` is equal to `matrix[n+1][m+1]` we pop last element on the stack

 ```

 fun <T : Comparable<T>> backtrackConsecutive(
   s1: String,
   s2: String,
   matrix: Array<Array<T>>
 ): String {

   val stack: Deque<Char> = ArrayDeque<Char>()
   var i1 = s1.length
   var i2 = s2.length

   matrix.printMatrix()

   while (i1 > 1 && i2 > 1) {
     when {
     /**
      * Push in the stack
      */
       equals3( matrix[i1][i2 - 1], matrix[i1 - 1][i2], matrix[i1 - 1][i2 - 1]) &&
           matrix[i1][i2].hadIncrement(matrix[i1 - 1][i2 - 1]) -> {
         stack.push(s1[i1 - 1])
         i2 -= 1
         i1 -= 1
       }
       /**
        * Pop from the stack
        */
       equals3(matrix[i1][i2 - 1], matrix[i1 - 1][i2], matrix[i1 - 1][i2 - 1]) &&
           !matrix[i1][i2].hadIncrement(matrix[i1 - 1][i2 - 1]) -> {
         stack.pop()
         i2 -= 1
         i1 -= 1
       }
       /**
       * Move the cursors
       */
       matrix[i1][i2] == matrix[i1][i2 - 1] -> i2 -= 1
       matrix[i1][i2] == matrix[i1 - 1][i2] -> i1 -= 1
     }

   }
   return stack.toString()
 }

 ```

```
|   |  Ø|  K|  I|  T|  T|  E|  N|
| Ø |  0|  0|  0|  0|  0|  0|  0|
| S |  0|  0|  0|  0|  0|  0|  0|
| I |  0|  0|  1|  1|  1|  1|  1|
| T |  0|  0|  1|  2|  2|  2|  2|
| T |  0|  0|  1|  2|  3|  3|  3|
| I |  0|  0|  1|  2|  3|  3|  3|
| N |  0|  0|  1|  2|  3|  3|  4|
```

↖