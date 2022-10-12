int x = 0

P = Thread.start {
  10.times {
    int temp = x
    x = temp + 1
  }
}

Q = Thread.start {
  10.times {
    int temp = x
    x = temp + 1
  }
}

P.join()
Q.join()
println x