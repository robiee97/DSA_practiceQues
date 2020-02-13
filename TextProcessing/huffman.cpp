#include <bits/stdc++.h>
using namespace std;
class Node
{
public:
	char data;
	int freq;
	Node *left = NULL;
	Node *right = NULL;

	Node(char data, int freq)
	{
		this->data = data;
		this->freq = freq;
	}
	Node(const Node &n)
	{
		this->data = n.data;
		this->freq = n.freq;
		this->left = n.left;
		this->right = n.right;
	}
	bool operator>(const Node &o) const
	{
		return this->freq > o.freq;
	}
};

class huffman
{
public:
	unordered_map<char, string> encoder;
	unordered_map<string, char> decoder;

	void traverse(Node *root, string asf)
	{
		if (root->left == NULL && root->right == NULL)
		{
			encoder[root->data] = asf;
			decoder[asf] = root->data;
			return;
		}
		traverse(root->left, asf + "0");
		traverse(root->right, asf + "1");
	}

	huffman(string str)
	{
		unordered_map<char, int> fmap;
		for (int i = 0; i < str.size(); i++)
		{
			fmap[str[i]] = fmap.count(str[i]) == 0 ? 1 : fmap[str[i]] + 1;
		}
		priority_queue<Node, vector<Node>,
					   greater<Node>>
			pq;
		for (auto itr = fmap.begin(); itr != fmap.end(); itr++)
		{
			Node n1(itr->first, itr->second);
			pq.push(n1);
		}

		while (pq.size() > 1)
		{
			Node n1 = pq.top();
			pq.pop();
			Node n2 = pq.top();
			pq.pop();

			Node n3('#', n1.freq + n2.freq);
			n3.left = new Node(n1);
			n3.right = new Node(n2);
			pq.push(n3);
		}
		Node root = pq.top();
		pq.pop();
		traverse(&root, "");
	}
	string encode(string str)
	{
		string ans = "";
		for (int i = 0; i < str.size(); i++)
		{
			ans += encoder[str[i]];
		}
		return ans;
	}
	string decode(string str)
	{
		string s = "";
		string ans = "";
		for (int i = 0; i < str.size(); i++)
		{
			s += str[i];
			if (decoder.count(s) == 1)
			{
				ans += decoder[s];
				s = "";
			}
		}
		return ans;
	}
};

int main()
{
	string str = "abcd";
	huffman hm(str);
	string str1 = "aabbcdd";
	cout << hm.encode(str1) << endl;
	cout << hm.decode("01011111100000");
}
