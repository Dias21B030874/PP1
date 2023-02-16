#include <bits/stdc++.h>
#include <stdio.h>
#include <string>
using namespace std;

void swap(string* a, string* b)
{
    string t = *a;
    *a = *b;
    *b = t;
}

void quickSort(string &str, int lb, int ub) {
    int low = lb, high = ub;
    int pivot = str[(low + high) / 2];

    do {
        while (str[low] < pivot) low++;

        while (str[high] > pivot) high--;

        if (low <= high) {
            swap(str[low], str[high]);
            low++; high--;
        }
    }while (low <= high);


    if (lb < high) quickSort(str, lb, high);

    if (low < ub) quickSort(str, low, ub);
}

int main()
{
    int n; cin >> n;
    string s, v="", c=""; cin >> s;
    for(int i = 0; i < s.size(); i++){
        if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')
            v += s[i];
        else
            c += s[i];
    }
    quickSort(v, 0, v.size() - 1);
    quickSort(c, 0, c.size() - 1);
    cout << v << c;
    return 0;
}