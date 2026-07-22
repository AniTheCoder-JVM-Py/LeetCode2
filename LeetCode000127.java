/*A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord

Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

 

Constraints:

    1 <= beginWord.length <= 10
    endWord.length == beginWord.length
    1 <= wordList.length <= 5000
    wordList[i].length == beginWord.length
    beginWord, endWord, and wordList[i] consist of lowercase English letters.
    beginWord != endWord
    All the words in wordList are unique.*/

/*Algorithm
Step-1 = Store all words in a HashSet.
Step-2 = Push beginWord into queue.
Step-3 = While queue not empty,Take one word.
Step-4 = Generate every possible one-letter change.
Step-5 = If generated word equals endWord,return answer.
Step-6 = If generated word exists in HashSet, push into queue, remove from HashSet.

Removing prevents revisiting.*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                
                String word = q.poll();
                char[] arr = word.toCharArray();

                for(int j = 0; j < arr.length; j++){
                    char original = arr[j];

                    for(char ch = 'a'; ch <= 'z'; ch++){
                        arr[j] = ch;
                        String nextWord = new String(arr);

                        if(nextWord.equals(endWord))
                            return level+1;
                        
                        if(set.contains(nextWord)){
                            q.offer(nextWord);
                            set.remove(nextWord);
                        }
                    }
                    arr[j] = original;
                }
            }
            level ++;
        }
        return 0;
    }
}