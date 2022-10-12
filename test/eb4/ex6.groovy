import java.util.concurrent.Semaphore;

Semaphore printC = new Semaphore(0);

Thread.start { 
  println 'opA'
  printC.release()
}

Thread.start {
  println 'opB'
  printC.release()
}

Thread.start {
  printC.acquire()
  printC.acquire()
  println 'opC'
}