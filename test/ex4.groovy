int turn = 1;

P = Thread.start {
  while (turn != 1) {};  // -> await (turn==1)  等待只有 turn == 1 我们才继续下面的code，否则 如果 turn !=1 会进入 while 循环，循环里没有任何的代码，一直空循环
  turn = 2;
}

Q = Thread.start {
  while (turn != 2) {};  // -> await (turn==2) true continue next section of code, false cause infinite loop 
  turn = 1;
}

P.join()
Q.join()
println turn