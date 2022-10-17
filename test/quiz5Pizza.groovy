// Exercise 7  eb6
// In a local pizza shop two types of pizzas are produced: small and large. 
// The cook places the pizzas on a counter, so that the clients can help themselves and then pay at the register. 
// Clients may either buy a small pizza or a large pizza. 
// In the case of large pizzas, if there are no large pizzas, they reluctantly accept two small pizzas. Complete the following stub:

class Pizza {
  // Variables declared here
  private int s;  // small pizza
  private int l;  // large pizza

  void purchaseSmallPizza() {
    while (s == 0) {
      wait();
    }
    s--;
  }

  void purchaseLargePizza() {
    while (l == 0 && s < 2) {
      wait();
    }
    if (l > 0) {
      l--;
    } else {
      s = s - 2;
    }
  }

  void bakeSmallPizza() {
    s++;
    notifyAll();
  }

  void bakeLargePizza() {
    l++;
    notifyAll();
  } 
}