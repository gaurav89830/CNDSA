import java.util.ArrayList;

class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode[] children;
    int childCount;

    TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}

class Trie {
    private TrieNode root;
    int wordCount;

    Trie() {
        root = new TrieNode('\0');
        wordCount = 0;
    }

    // add function
    public void add(TrieNode root, String word) {

        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';

        TrieNode child = root.children[childIndex];

        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        add(child, word.substring(1));
    }

    public void add(String word) {
        add(root, word);
        wordCount++;
    }

    // remove
    public void remove(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = false;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) { // already not found
            return;
        }

        remove(child, word.substring(1));

        // now at the leaf position this will execute (recursion)

        if (!child.isTerminating && root.childCount == 0) {
            // yeh root k putra k aur putra nhi hai & yeh terminating bhi
            // nhi hai
            root.children[childIndex] = null; // main array se uda dia refference , as baap ka ek putra is dead
            // child = null; no need to do this , i guess
            root.childCount--; // baap ka toh ek hi putra gya hai na
        }
        return;
    }

    public void remove(String word) {
        remove(root, word);
        wordCount--;
        System.out.println("Removed successfully");
    }

    // search function
    public boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminating;
        }

        int indexToLook = word.charAt(0) - 'a';

        TrieNode child = root.children[indexToLook];

        if (child == null) { // not found
            return false;
        }
        // found
        return search(child, word.substring(1));
    }

    public boolean search(String word) {
        boolean ans = search(root, word);
        if (ans) {
            System.out.println("Word Found");
            return true;
        } else {
            System.out.println("Word Not Found");
            return false;
        }

    }

    // public int countWords(TrieNode root) {
    // int ans = 0;
    // if (root.isTerminating) {
    // ans++;
    // }
    // for (int i = 0; i < 26; i++) {
    // if (root.children[i] != null) {
    // ans += countWords(root.children[i]);
    // }
    // }
    // return ans;
    // }
    public int countWords() {
        return wordCount;
    }

    /// for questions

    // pattern matching - add all substring and then search
    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        for (int i = 0; i < vect.size(); i++) {
            String word = vect.get(i);
            for (int j = 0; j < word.length(); j++) {
                add(word.substring(j));
            }
        }

        return search(pattern);
    }
}