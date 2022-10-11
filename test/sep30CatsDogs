import java.util.concurrent.Semaphore


Semaphore mutexC = new Semaphore(1)
Semaphore mutexD = new Semaphore(1)
Semaphore resource = new Semaphore(1)
int c = 0
int d = 0

20.times {
  Thread.start {  // Cat
    mutexC.acquire()
    c++
    if (c == 1) {
      // grab source
      resource.acquire()
    }
    mutexC.release()

    // feed
    mutexC.acquire()
    c--
    if (c == 0) {
      resource.release()
    }
    mutexC.release()
  }
}

20.times {
  Thread.start {  // Dogs
    mutexD.acquire()
    d++
    if (d == 1) {
      // grab source
      resource.acquire()
    }
    mutexD.release()

    // feed
    mutexD.acquire()
    d--
    if (d == 0) {
      resource.release()
    }
    mutexD.release()
  }
}