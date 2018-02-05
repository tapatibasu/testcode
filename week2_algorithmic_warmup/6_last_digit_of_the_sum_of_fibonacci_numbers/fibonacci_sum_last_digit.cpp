#include <iostream>
long long get_pisano_period(long long m) {
    long long a = 0, b = 1, c = a + b;
    for (int i = 0; i < m * m; i++) {
        c = (a + b) % m;
        a = b;
        b = c;
        if (a == 0 && b == 1) return i + 1;
    }
    return 0; 
}

long long get_fibonacci_huge(long long n, long long m) {
    long long remainder = n % get_pisano_period(m);

    long long first = 0;
    long long second = 1;

    long long res = remainder;

    for (int i = 1; i < remainder; i++) {
        res = (first + second) % m;
        first = second;
        second = res;
    }
    if (res == 0) res = 9; 
    else res = res - 1;
    return res % 10; 

}

int fibonacci_sum_naive(long long n) {
    if (n <= 1)
        return n;
    return get_fibonacci_huge(n+2, 10);
    


}

int main() {
    long long n = 0;
    std::cin >> n;
    std::cout << fibonacci_sum_naive(n);
}
