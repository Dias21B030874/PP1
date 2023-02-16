#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;
int main()
    {
        int n, i, tv = 0;
        cin >> n;
        bool on = true;
        vector <int> k;
 
        k.push_back(0);
        for (int i = 1; i <= n; i++)
        {
           cin >> i;
           k.push_back(i);
        }

        if (k.back() != 90)
            k.push_back(90);

        for (unsigned int i = 0; i < k.size(); i++)
        {
            if (on)
            {
                int l = k[i] - k[i - 1];

                if (l >= 15)
                {
                    tv += 15;
                    on = false;
                }
                else
                {
                    tv += l + 1; 
                }
            }
        }

        cout << tv;
        return 0;
  }