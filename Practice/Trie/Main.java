class Main {
    public static void main(String[] args) {
        Trie root = new Trie();
        root.add("hey");
        root.add("there");
        root.add("this");
        root.add("is");
        root.add("gaurav");
        // root.remove("hey");
        System.out.println("NO of Words : " + root.countWords());
        root.remove("gaurav");
        System.out.println("NO of Words : " + root.countWords());

    }

}
