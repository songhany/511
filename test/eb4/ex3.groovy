import java.util.concurrent.Semaphore;

Semaphore printedR = new Semaphore(0);
Semaphore printedI = new Semaphore(0);
Semaphore printedO = new Semaphore(0);
Semaphore printOKs = new Semaphore(0);

Thread.start { //P
  print('R')
  printedR.release()

  printOKs.acquire()
  print('OK')
  printOKs.release()
}

Thread.start { //Q
  printedR.acquire()
  print('I')
  printedR.release()
  printedI.release()
  
  printOKs.acquire()
  print('OK')
  printOKs.release()
}

Thread.start { //R
  printedR.acquire()
  printedI.acquire()
  print('O')

  printOKs.release()

  printOKs.acquire()
  print('OK')
  printOKs.release()
}