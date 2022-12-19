#include <iostream>
#include <cstring>

using namespace std;

bool anagrama (string w1, string w2) {

  if ((w1 == w2) || (strlen(w1) != strlen(w2)) || (w1.end() != w2.begin())) {
    return false;
  } else if (w1.end() == w2.begin()) {
    
  }
}

int main() {
  string p1, p2;

  cin >> p1;
  cin >> p2;

  anagrama(p1,p2);

return 0;
}