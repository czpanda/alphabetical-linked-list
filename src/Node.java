public class Node {
    /**
     * Value of the node
     */
    private String value;

    /**
     * Link of the node
     */
    private Node link;

    /**
     * Node constructor
     *
     * @param value Value of the node
     */
    Node(String value) {
        this.value = value;
        this.link = null;
    }

    /**
     * Node constructor
     *
     * @param value Value of the node
     * @param link Link of the node
     */
    Node(String value, Node link) {
        this.value = value;
        this.link = link;
    }

    /**
     * Adds passed String to the node
     *
     * @param item String to be added to the node
     */
    public void add(String item) {
        // If the node doesn't have a link
        if (this.link == null) {
            // Set the link as new Node containing the item
            this.link = new Node(item);

            // Break
            return;
        }

        // If the passed item needs to be placed in front of current value
        if (this.value.compareTo(item) > 0) {
            // Store temporary value
            String temp = this.value;

            // Set the node value to passed value
            this.value = item;

            // Set the link as the current Node
            this.link = new Node(temp, this.link);

            // Break
            return;
        }

        // Pass the item to be added to the Node link
        this.link.add(item);
    }

    /**
     * Checks whether passed item is present in the node or its link
     *
     * @param item Item to be found
     * @return Information whether passed item is present in the node or its link
     */
    public boolean contains(String item) {
        // If the value of a current node is equal to a passed item
        if (this.value.equals(item)) {
            // Node contains the value
            return true;
        }

        // If current node doesnt have a link
        if (this.link == null) {

            // Node doesn't contain the value
            return false;
        }

        // Return the result of Node link's contains() method
        return this.link.contains(item);
    }

    /**
     * Returns size of a current Node
     *
     * @return Size of a current Node
     */
    public int getSize() {
        // If the node doesn't have a link
        if (this.link == null) {
            // Return 1
            return 1;
        }

        // Return 1 + the size of the Node's link
        return 1 + this.link.getSize();
    }

    /**
     * Returns a value of current Node
     *
     * @return Value of current Node
     */
    public String getValue() {
        return value;
    }

    /**
     * Removes item at given index
     *
     * @param index Index at which should item be removed
     */
    public void remove(int index) {
        // If index isn't 0 and current node doesn't link
        if (index != 0 && this.link == null) {
            // Break
            return;
        }

        // If current value should be removed
        if (index == 0) {
            // Store temporary value
            Node link = this.link;

            // Set value of current Node to value of its link
            this.value = link.value;

            // Set link of current Node to link of its link
            this.link = link.link;

            // Break
            return;
        }

        // Pass the remove command to the node's link
        this.link.remove(index - 1);
    }

    /**
     * Returns item at given index or throws error if index is greater than list's size
     *
     * @param index Index at which should item be returned
     * @return Found item
     */
    public String get(int index) {
        // If index is 0
        if (index == 0) {
            // Current value should be returned
            return this.value;
        }

        // Pass the get command to the node's link
        return this.link.get(index - 1);
    }

    @Override
    public String toString() {
        // If the node doesn't have a link
        if (this.link == null) {
            // Return just its value
            return this.value;
        }

        // Return node's value followed by -> and the result of this.link.toString() method
        return this.value + " -> " + this.link;
    }
}
