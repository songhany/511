import java.util.concurrent.Semaphore
// This solution is fair for both dog and cat

Semaphore mutexC = new Semaphore(1)
Semaphore mutexD = new Semaphore(1)
Semaphore resource = new Semaphore(1)
Semaphore mutex = new Semaphore(1)
int c = 0
int d = 0

20.times {
  Thread.start {  // Cats
    mutex.acquire()
    mutexC.acquire()
    c++
    if (c == 1) {
      // grab source
      mutexD.acquire()
    }
    mutexC.release()
    mutex.release()

    // feed
    mutexC.acquire()
    c--
    if (c == 0) {
      mutexD.release()
    }
    mutexC.release()
  }
}

20.times {
  Thread.start {  // Dogs
    mutex.acquire()
    mutexD.acquire()
    d++
    if (d == 1) {
      // grab source
      mutexC.acquire()
    }
    mutexD.release()
    mutex.release()

    // feed
    mutexD.acquire()
    d--
    if (d == 0) {
      mutexC.release()
    }
    mutexD.release()
  }
}