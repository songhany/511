
int x = 0

P = Thread.start {
  10.times {
    x = x + 1;
  }
}

Q = Thread.start {
  10.times {
    x = x + 1;
  }
}

P.join()
Q.join()
println x
