import java.util.concurrent.Semaphore;

Semaphore allowF = new Semaphore(0);
Semaphore allowC = new Semaphore(0);

Thread.start{ //P
  print("A")
  allowF.release()
  print("B")
  allowC.acquire()
  print("C")
}

Thread.start {
  print("E")
  allowF.acquire()
  print("F")
  allowC.release()
  print("G")
}