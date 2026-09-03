/*Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:
WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 
Example:
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]
Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 
Constraints:
1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 104 calls will be made to addWord and search. */

class WordDictionary {

    class TrieNode{
        TrieNode[] children;
        boolean isWord;

        TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';

            if(curr.children[index] == null)
                curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null)
            return false;

        if (index == word.length())
            return node.isWord;

        char ch = word.charAt(index);

        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child))
                    return true;
            }
            return false;
        }
        return dfs(word, index + 1, node.children[ch - 'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */