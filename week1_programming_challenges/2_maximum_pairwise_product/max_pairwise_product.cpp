#include <iostream>
#include <vector>

using std::vector;
using std::cin;
using std::cout;

unsigned long long MaxPairwiseProduct(const vector<int>& numbers) {
  int n = numbers.size();
  int max = 0;
  int sec = 0; 
  
  for (int i = 0; i < n; ++i) {
     if (numbers[i] > max) {
        sec = max; 
        max = numbers[i];
     }
     else if (numbers[i] > sec) 
     {
	sec = numbers[i];
     }

  }
    return (long)max * sec;  
}

int main() {
    int n;
    cin >> n;
    vector<int> numbers(n);
    for (int i = 0; i < n; ++i) {
        cin >> numbers[i];
    }

    unsigned long long  result = MaxPairwiseProduct(numbers);
    cout << result << "\n";
    return 0;
}
