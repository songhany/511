//! Exercise: ensure that only aab... pattern is printed
import java.util.concurrent.Semaphore


Semaphore a = new Semaphore(2)
Semaphore b = new Semaphore(0)

Thread.start {
  while (true) {
    a.acquire()
    print "a"
    b.release()
  }
}

Thread.start {
  while (true) {
    b.acquire()
    b.acquire()
    print "b"
    a.release()
    a.release()
  }
}

// wait for P and Q to finish

