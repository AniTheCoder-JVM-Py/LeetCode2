/*Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]

Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []

 

Constraints:

    1 <= s.length <= 20
    1 <= wordDict.length <= 1000
    1 <= wordDict[i].length <= 10
    s and wordDict[i] consist of only lowercase English letters.
    All the strings of wordDict are unique.
    Input is generated in a way that the length of the answer doesn't exceed 105.*/

class Solution {
    HashSet<String> set;
    HashMap<Integer, List<String>> memo;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memo = new HashMap<>();
        return dfs(s, 0);
    }

    public List<String> dfs(String s, int index){

        if(memo.containsKey(index))
            return memo.get(index);
        
        List<String> result = new ArrayList<>();

        if(index == s.length()){
            result.add("");
            return result;
        }

        for(int end = index+1; end <= s.length(); end++){

            String word = s.substring(index, end);
            if(set.contains(word)){
                List<String> suffixes = dfs(s, end);

                for(String suffix : suffixes){

                    if(suffix.isEmpty())
                        result.add(word);
                    else
                        result.add(word+" "+suffix);
                }
            }
        }
        memo.put(index, result);
        return result;
    }
}