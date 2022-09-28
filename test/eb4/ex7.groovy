
import java.util.concurrent.Semaphore;

Semaphore mutexA = new Semaphore(1);
Semaphore mutexB = new Semaphore(0);

Thread.start { // P
  while (true){
    mutexA.acquire();
    print "A"
    mutexB.release();
  }
}

Thread.start { // Q
  while (true){
    mutexB.acquire();
    print "B"
    mutexA.release();
  }
}