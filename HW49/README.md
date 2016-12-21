POSSIBLE CHANGES:

We can try to make bubbleSortV more efficient - if the input list is already sorted, we would only need to do 1 pass to check if it is completely sorted, instead of doing listsize - 1 passes.

For example, if we, by chance, have a 100-element list of integers that is sorted already, we wouldn't need to do 99 passes (which my current bubbleSortV method does). Only 1 is necessary - to check if it's sorted. 
