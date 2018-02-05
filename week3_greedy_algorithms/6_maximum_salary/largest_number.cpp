#include <algorithm>
#include <sstream>
#include <iostream>
#include <vector>
#include <string>

using std::vector;
using std::string;

int compare(string s1, string s2)
{
  string xy = s1 + s2;
  string yx = s2 + s1;
  
  int val = xy.compare(yx);
  return val >= 0 ? 1 : 0; 
  
}

string largest_number(vector<string> a) {
  //write your code here
  sort(a.begin(), a.end(), compare);
  //std::stringstream ret;
  string result = "";
  for (size_t i = 0; i < a.size(); i++) {
    result += a[i];
    std::cout << result << "\n";
  }
  return result;
}

int main() {
  int n;
  std::cin >> n;
  vector<string> a(n);
  for (size_t i = 0; i < a.size(); i++) {
    std::cin >> a[i];
  }
  std::cout << "here" << "\n";
  std::cout << largest_number(a);
}
