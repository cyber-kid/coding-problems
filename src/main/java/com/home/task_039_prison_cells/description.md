# Prison Cells After N Days

https://leetcode.com/problems/prison-cells-after-n-days/

### Intuition

One important observation is that we would encounter some already-seen state over the time, simply due to the fact that there are limited number of states.

Given K number of cells, there could be at most 2^K possible states. If the number of steps is larger than all possible states (i.e. N > 2^K), we are destined to repeat ourselves sooner or later.

In fact, we would encounter the repetitive states sooner than the theoretical boundary we estimated above. For instance, with the initial state of [1,0,0,0,1,0,0,1], just after 15 steps, we would encounter a previously seen state. Once we encounter a state seen before, the history would then repeat itself again and again, assuming that time is infinite.

All states between two repetitive states form a cycle, which would repeat itself over the time. Therefore, based on this observation, we could fast-forward the simulation rather than going step by step, once we encounter any repetitive state.

### Algorithm

Here is the overall idea to implement our fast-forward strategy.

1. First of all, we record the state at each step and count the length of the cycle.
2. Once we discover a repetitive state, we can then determine the length (denoted as C) of the cycle.
3. Starting from this repetitive state, the prison cells would play out the states within the cycle over and over, until we run out of steps.
4. In other words, if the remaining steps is N, at least we could fast-forward to the step of N \mod C.
5. And then from the step of N \mod C, we continue the simulation step by step.