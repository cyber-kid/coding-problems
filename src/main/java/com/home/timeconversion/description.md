# Time Conversion

Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

**Note:** Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.

**Function Description**

Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.

timeConversion has the following parameter(s):

* s: a string representing time in 12 hour format

**Input Format**

A single string s containing a time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM), where 01<=hh<=12 and 00<=mm, ss<=59.

**Constraints**

All input times are valid

**Output Format**

Convert and print the given time in 24-hour format, where 00<=hh<=23.

### Complexity:

### Space complexity:

### Test cases:
1. in: 12:04:05AM out: 00:04:05
2. in: 12:07:45PM out: 12:07:05
3. in: 07:15:50PM out: 19:15:50

### Notes:
Taken from HackerRank. URL: https://www.hackerrank.com/challenges/time-conversion/problem