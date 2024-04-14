Brainf**k program that prints "Hello World!" using 4 registers
printing the visible ASCII characters and a new line character (ASCII 10);

===========================
    Hello World Program
===========================

>               || Move to Cell 2
+++++++++       || Set Cell 2 to 9
[           (Start of Loop) Repeats 9 times until cell 1 equals 72
    <           || Move to cell 1
    ++++++++    || Increment cell 1 by 8
    >           || Move to cell 2
    -           || Decrement cell 2 by 1
]           (End of Loop)
<               || Move to cell 1
.               || Prints 'H' (ASCII 72)
>               || Moves to cell 2
+++++++         || Set cell 2 to 7
[           (Start of Loop) Repeats 7 times until cell 1 equals 100
    <           || Move to cell 1
    ++++        || Increment cell 1 by 4
    >           || Move to cell 2
    -           || Decrement cell 2 by 1
]           (End of Loop)
<               || Move to cell 1
+               || Increment cell 1 by 1
.               || Prints 'e' (ASCII 101)
+++++++         || Increment cell 1 by 7
..              || Prints 'll' (Both ASCII 108)
+++             || Increments cell 1 by 3
.               || Prints 'o' (ASCII 111)
>>>             || Switch to cell 3
++++++++        || Set cell 3 to 8
[           (Start of Loop) Repeats 8 times until cell 2 equals 32
    <           || Switch to cell 2
    ++++        || Increment cell 2 by 4
    >           || Switch to cell 3
    -           || Decrement cell 3 by 1
]           (End of Loop)
<               || Switch to cell 2
.               || Prints ' ' (ASCII 32)
>>>             || Switch to cell 5
++++++++++      || Set cell 5 to 10
[           (Start of Loop) Repeats 10 times until cell 4 equals 90
    <           || Switch to cell 4
    +++++++++   || Increment cell 4 by 9
    >           || Switch to cell 5
    -           || Decrement cell 5 by 1
]           (End of Loop)
<               || Switch to cell 4
---             || Decrement cell 4 by 3
.               || Prints 'W' (ASCII 87)
<<<<            || Switch to cell 1
.               || Prints 'o' (ASCII 111)
+++             || Increment cell 1 by 3
.               || Prints 'r' (ASCII 114)
------          || Decrement cell 1 by 6
.               || Prints 'l' (ASCII 108)
--------        || Decrements cell 1 by 8
.               || Prints 'd' (ASCII  57)
>>              || Switch to Register 3
+               || Increment cell 3 by 1
.               || Prints '!' (ASCII 32)
>               || Switches to cell 4
++++++++++      || Sets cell 4 to 10
.               || Prints '\n' (ASCII 10)