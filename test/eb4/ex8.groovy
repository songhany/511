import java.util.concurrent.Semaphore;

Semaphore updatedN = new Semaphore(1);
Semaphore updatedN2 = new Semaphore(0);
Semaphore allowDec = new Semaphore(0);

int n2 = 0
int n = 50

P = Thread.start{
  while(n >= 0){
    updatedN2.acquire()
    n = n - 1
    updatedN.release()
  }
  // print("n2 = " + n2)
}

Thread.start {
  while(true){
    updatedN.acquire()
    n2 = n2 + 2*n + 1
    updatedN2.release()

    if (n == 0) {
      allowDec.release()
      break
    }
  }
}

P.join()
allowDec.acquire()
print(n2)