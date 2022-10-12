int x = 0
P = Thread.start { //P
 x = 1
}
Q = Thread.start { //Q
 x = 2
}

P.join()
Q.join()
println x