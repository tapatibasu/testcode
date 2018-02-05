#include <iostream>

int get_change(int m) {
  int a[3] = {10, 5, 1};
  int i = 0; 
  int n =  0; 
  while (i <= 2) 
  {
     int div = m / a[i];
     m = m % a[i]; 
     n += div; 
     i++;
  }

  return n;
}

int main() {
  int m;
  std::cin >> m;
  std::cout << get_change(m) << '\n';
}
