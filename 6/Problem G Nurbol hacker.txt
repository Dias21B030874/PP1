#include <bits/stdc++.h>
#include <string>
#include <vector>
using namespace std;
pair<string, string> p;
vector<pair<string, string>> v;

void quicksort ( vector< pair<string, string> >& v ){
    if(v.size() > 1){
        vector<pair< string, string> > a,b;
        pair<string, string> pivot = v[0];
        for(int i=1; i<v.size(); i++)
            if(v[i].first <= pivot.first)
                a.push_back(v[i]);
            else if(v[i].first > pivot.first)
                b.push_back(v[i]);
        if(a.size() > 0) quicksort(a);
        if(b.size() > 0) quicksort(b);
        for(int i=0; i<a.size(); i++) v[i] = a[i];
        v[a.size()] = pivot;
        for(int i=0; i<b.size(); i++)
        v[i+a.size()+1] = b[i];
    }
}


int main()
{
    bool flag;
    int n;
    string s1, s2;
    p = make_pair("", "");
    v.push_back(p);
    cin >> n;
    for(int i = 0; i < n; i++){
         flag = false;
        cin >> s1 >> s2;
        for(int j = 1; j < v.size(); j++) {
            if(v[j].second == s1) {
            p = make_pair(v[j].first, s2);
            v[j] = p;
            flag = true;
            break;
            } 
        }
    if(flag) continue;
    p = make_pair(s1, s2);
    v.push_back(p);
  }
  quicksort(v);
  cout << v.size() - 1 << "\n";
  for(int i = 1; i < v.size(); i++) cout << v[i].first << " " << v[i].second << "\n";
    return 0;
}