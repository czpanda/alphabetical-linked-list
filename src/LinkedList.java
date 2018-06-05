public class LinkedList {
    /**
     * Content of the list
     */
    private Node content;

    /**
     * Adds passed String to the list
     *
     * @param item String to be added to the list
     * @return LinkedList instance - used for chaining
     */
    public LinkedList addItem(String item) {
        // If the list is empty
        if (this.content == null) {
            // Create new node with a passed item
            this.content = new Node(item);

            // Return the current instance
            return this;
        }

        // If passed String needs be placed to the first position of the list
        if (this.content.getValue().compareTo(item) > 0) {
            // Store temporary value
            Node node = this.content;

            // Create a new Node and set the current as its link
            this.content = new Node(item, node);

            // Return the current instance
            return this;
        }

        // Pass the item to be added to the list link
        this.content.addItem(item);

        // Return the current instance
        return this;
    }

    /**
     * Returns size of the current list
     *
     * @return size of the list
     */
    public int getSize() {
        // If the list is empty
        if (this.content == null) {
            // Return 0
            return 0;
        }

        // Return the result of links getSize() method
        return this.content.getSize();
    }

    public boolean contains(String item) {
        // If the list is empty
        if (this.content == null) {
            // Item cannot be part of the list so return false
            return false;
        }

        // Return the result of the links contains() method
        return this.content.contains(item);
    }

    public void remove(int index) {
        // If the list is empty
        if (this.content == null) {
            // Do nothing
            return;
        }

        // Pass the remove command to the node's link
        this.content.remove(index);
    }

    @Override
    public String toString() {
        // If the list is empty
        if (this.content == null) {
            // Return
            return "Empty list!";
        }

        // Return the result of the links toString() method
        return this.content.toString();
    }
}
