public class LinkedList {
    private Node content;

    public LinkedList addItem(String item) {
        if (this.content == null) {
            this.content = new Node(item);
            return this;
        }

        this.content.addItem(item);
        return this;
    }

    public int getSize() {
        if (this.content == null) {
            return 0;
        }

        return this.content.getSize();
    }

    public boolean contains(String item) {
        if (this.content == null) {
            return true;
        }

        return this.content.contains(item);
    }

    @Override
    public String toString() {
        return this.content.toString();
    }
}
