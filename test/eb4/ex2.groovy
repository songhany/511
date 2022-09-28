import java.util.concurrent.Semaphore;

Semaphore allowA = new Semaphore(0);
Semaphore allowS = new Semaphore(0);
Semaphore allowE = new Semaphore(0);
Semaphore allowR = new Semaphore(0);

Thread.start {
  allowA.acquire();
  print("A")
  // allowS.release();
  // allowS.acquire();
  print("S")
  allowE.release();
}

Thread.start {
  print("L")
  allowA.release();
  allowE.acquire();
  print("E")
  allowR.release();
  print("R")
}