#include <bits/stdc++.h>
using namespace std;
typedef vector<double> V;

string exec(const char* cmd) {
    array<char, 128> buffer;
    string result = "";
    shared_ptr<FILE> pipe(popen(cmd, "r"), pclose);
    if (!pipe) throw runtime_error("popen() failed!");
    while (!feof(pipe.get())) {
        if (fgets(buffer.data(), 128, pipe.get()) != nullptr)
            result += buffer.data();
    }
    return result;
}

int main() {
    int size; // longest size of ping will be size * 100
    cin >> size;
    for (int i = 0; i < size; ++i) {
        int bits = (i + 1) * 100;
        string cmd = "ping google.com -c 10 -s " + to_string(bits) + " | grep rtt";
        cout << cmd << endl;
        string res = exec(cmd.c_str());
        cout << res;
    }
}
