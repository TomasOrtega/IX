#include <bits/stdc++.h>
using namespace std;
typedef vector<double> V;

string exec(const char* cmd) {
    array<char, 128> buffer;
    string result;
    shared_ptr<FILE> pipe(popen(cmd, "r"), pclose);
    if (!pipe) throw runtime_error("popen() failed!");
    while (!feof(pipe.get())) {
        if (fgets(buffer.data(), 128, pipe.get()) != nullptr)
            result += buffer.data();
    }
    return result;
}

int main() {
    int size = 14;
    V vsize = V(size, 0);
    V vrtt = V(size, 0);
    for (int i = 0; i < size; ++i) {
        int bits = (i+1) * 100;
        vsize[i] = bits;
        string cmd = "ping google.com -c 50 -s " + to_string(bits);
        string res = exec(cmd.c_str());
        string delimiter = "rtt";
        res = res.substr(res.find(delimiter), string::npos);
        string num = "";
        int counter = 4;
        for (char c: res) {
            if (c == '/') counter--;
            else if (counter == 0) num += c;
            if (counter < 0) break;
        }
        vrtt[i] = atof(num.c_str());
    }
    for (int i = 0; i < size; ++i) {
        cout << vsize[i] << " " << vrtt[i] << endl;
    }
}
