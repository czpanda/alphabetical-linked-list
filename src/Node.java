public class Node {
    private String content;
    private Node link;

    Node(String content) {
        this.content = content;
    }

    public void addItem(String item) {
        if (this.link == null) {
            this.link = new Node(item);
            return;
        }

        this.link.addItem(item);
    }

    public boolean contains(String item) {
        if (this.content.equals(item)) {
            return true;
        }

        if (this.link == null) {
            return false;
        }

        return this.link.contains(item);
    }

    public int getSize() {
        if (this.link == null) {
            return 1;
        }

        return 1 + this.link.getSize();
    }

    @Override
    public String toString() {
        if (this.link == null) {
            return this.content;
        }

        return this.content + " -> " + this.link;
    }
}
