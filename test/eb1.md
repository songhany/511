# Paths

## Exercise 1

---
State Format - {$IP_P, IP_Q$}

```mermaid
  graph TD
  1(P2, Q2) --> |P - 'Hi'| 3(P3,Q2)
  1 --> |Q - 'Hey'| 2(P2, Q3)
    2 --> |P - 'Hi'| 7(P3, Q3)
      7 --> |Q - 'Bob'| 9
      7 --> |P - 'Alice'| 6
    2 --> |Q - 'Bob'| 4(P2, --)
      4 --> |P - 'Hi'| 9(P3, --)
        9 --> |P - 'Alice'| 11( --, --)
  3 --> |P - 'Alice'| 5( --, Q2)
    5 --> |Q - 'Hey'| 6( --, Q3)
      6 --> |Q - 'Bob'| 11
  3 --> |Q -- 'Hey'| 7
```

## Exercise 2.1

---
 $$\{IP_P, IP_Q, x, local_P, local_Q \}$$

```mermaid
graph 
0(P3, Q3, 0, ?, ?) --> |P| 1(P4, Q3, 0, 0, ?)
  1 --> |P| 6(P5, Q3, 0, 1, ?)
    6 --> |P| 10( --, Q3, 1, 1, ?)
      10 --> |Q| 12( --, Q4, 1, 1, 1)
      12 --> |Q| 13( --, Q5, 1, 1, 2)
      13 --> |Q| 14( --, --, 2, 1, 2)

    6 --> |Q| 11(P5, Q4, 0, 1, 0)
      11 --> |P| 22( --, Q4, 1, 1, 0)
        22 --> |Q| 23( --, Q5, 1, 1, 1)
          23 --> |Q| 24( --, --, 1, 1, 1)

      11 --> |Q| 25(P5, Q5, 0, 1, 1)
        25 --> |P| 23
        25 --> |Q| 26

  1 --> |Q| 5(P4, Q4, 0, 0, 0)
    5 --> |P| 11
    5 --> |Q| 7(P4, Q5, 0, 0, 1)
      7 --> |P| 25
      7 --> |Q| 19(P4, --, 1, 0, 1)
        19 --> |P| 26(P5, --, 1, 1, 1)
          26 --> |P| 24
        

0 --> |Q| 2(P3, Q4, 0, ?, 0)
  2 --> |P| 5

  2 --> |Q| 3(P3, Q5, 0, ?, 1)
    3 --> |P| 7

    3 --> |Q| 9(P3, --, 1, ?, 1)
      9 --> |P| 15(P4, --, 1, 1, 1)
      15 --> |P| 16(P5, --, 1, 2, 1)
      16 --> |P| 17( --, --, 2, 2, 1)

```

## Exercise 2.2

---
$$\{ IP_P, IP_Q, x \}$$

```mermaid
graph
0(P4, Q4, 0) --> |P| 1( --, Q4, 1)
  1 --> |Q| 3( --, --, 2)

0 --> |Q| 2(P4, --, 1)
  2 --> |P| 3
```

## Exercise 3.1

---

$$\{ IP_P, IP_Q, x, y \}$$

```mermaid
graph 
0(P4, Q4, 0, 0) --> |P| 1( --, Q4, 0, 1)
  1 --> |Q| 2( --, -- 2, 1)
```

## Exercise 3.2

---

No, there is not a path such that $x  = y = 1$

## Exercise 4

---

## Exercise 5

---

## Exercise 6

---

## Exercise 7

---

## Exercise 8

---
