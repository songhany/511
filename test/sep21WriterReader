// After add Semaphore entryProtocalQueue, this solution is far for Writer and Reader
Semaphore resource = new Semaphore(1)
int readers = 0
Semaphore mutexR = new Semaphore(1)
Semaphore entryProtocalQueue = new Semaphore(1, true)

10.times {
  Thread.start {  // Writer. When write, you cannot have reader to read
    entryProtocalQueue.acquire()
    resource.acquire()
    entryProtocalQueue.release()
    // write to resource
    resource.release()
  }
}

10.times {
  Thread.start {  // Reader. When a reader reads, you can have other readers to read at the same time.
    entryProtocalQueue.acquire()
    mutexR.acquire()
    readers++
    if (readers == 1 ) {
      resource.acquire()
    }
    mutexR.release()
    entryProtocalQueue.release()

    // read from resource

    mutexR.acquire()
    readers--
    if (readers == 0) {
      resource.release()
    }
    mutexR.release()
  }
}