/**
 * @author Ido Gutman
 * @authorID 329200216
 * @description <p>
 * Maman 15
 * </p>
 */
public class Set {
    private IntNode _groupHead;

    public Set() { //Constructor
        this._groupHead = null;
    }

    /**
     * @Method : "isEmpty";
     * --------------------------------------------------
     * Time complexity : O(1);
     * No loops;
     * Space complexity : O(1);
     * Doesn't use any variables - a defined amount --> O(1);
     * --------------------------------------------------
     * @returns -Returns true if the set is empty , if not returns false;
     */
    public boolean isEmpty() {
        return this._groupHead == null;
    }

    /**
     * @param num  - An integer;
     * @Method : "isMember";
     * --------------------------------------------------
     * Time complexity : O(n);
     * There is a while loop that is not nested;
     * Space complexity : O(1);
     *  Uses only 1 variable - a defined amount --> O(1);
     * --------------------------------------------------
     * @returns - returns true if the number is part of set, if not returns false;
     */
    public boolean isMember(int num) {
        if (isEmpty()) {
            return false;
        }
        IntNode currNode = this._groupHead;
        while (currNode.getNext() != null) {
            if (currNode.getValue() == num) {
                return true;
            }
            currNode = currNode.getNext();
        }
        if (currNode.getValue() == num) {
            return true;
        }
        return false;
    }

    /**
     * @param other  - another set;
     * @Method : "equals";
     * --------------------------------------------------
     * Time complexity : O(n^2);
     * There is a while loop and inside it there is a function call to "isMember" that uses a while loop in it, therefore the while loop is nested --> O(n^2);
     * Space complexity : O(1);
     *  Uses only 1 variable - a defined amount --> O(1);
     * --------------------------------------------------
     * @returns - returns true if "this" set and the "other" set both contain the same elements;
     */
    public boolean equals(Set other) {
        if (isEmpty() && other.isEmpty()) {
            return true;
        } else {
            IntNode currNode = this._groupHead;
            while (currNode != null) {
                if (!other.isMember(currNode.getValue())) {
                    return false;
                }
                currNode = currNode.getNext();
            }
            currNode = other._groupHead;
            while (currNode != null) {
                if (!isMember(currNode.getValue())) {
                    return false;
                }
                currNode = currNode.getNext();
            }
            return true;
        }
    }

    /**
     * @Method : "numOfElements";
     * --------------------------------------------------
     * Time complexity : O(n);
     * There is a while loop that goes through an undefined amount of nodes in the set --> O(n);
     * Space complexity : O(1);
     *  Uses only 2 variable - a defined amount --> O(1);
     * --------------------------------------------------
     * @returns - returns the number of elements in the set;
     */
    public int numOfElements() {
        if (isEmpty()) {
            return 0;
        }
        int length = 0;
        IntNode currNode = this._groupHead;
        while (currNode != null) {
            length += 1;
            currNode = currNode.getNext();
        }
        return length;
    }

    /**
     * @param other  - another set;
     * @Method : "subSet";
     * --------------------------------------------------
     * Time complexity : O(n^2);
     * There is a while loop and inside it there is a function call to "isMember" that uses a while loop in it, therefore the while loop is nested --> O(n^2);
     * Space complexity : O(1);
     *  Uses only 1 variable - a defined amount --> O(1);
     * --------------------------------------------------
     * @returns - returns true if all the elements in "other" set are also inside "this" set;
     */
    public boolean subSet(Set other) {
        if (other.isEmpty()) {
            return true;
        }
        IntNode currNode = other._groupHead;
        while (currNode != null) {
            if (!isMember(currNode.getValue())) {
                return false;
            }
            currNode = currNode.getNext();
        }
        return true;
    }

    /**
     * @param x  - an integer;
     * @Method : "addToSet";
     * --------------------------------------------------
     * Time complexity : O(n);
     * There is a while loop that iterates through the set in case that the first IntNode is not null - an undefined amount of nodes that it iterates through --> O(n);
     * Space complexity : O(1);
     *  Uses only 1 variable - a defined amount --> O(1);
     * --------------------------------------------------
     * Receives an integer x and adds it to the set if it is an odd natural number;
     */
    public void addToSet(int x) {
        if (x % 2 == 1) { //If the number is an odd natural;
            if (isEmpty()) {
                this._groupHead = new IntNode(x, null);
            } else if (!isMember(x)) { //If it is already a member there is no point in adding it;
                IntNode currNode = this._groupHead;
                while (currNode.getNext() != null) {
                    currNode = currNode.getNext();
                }
                currNode.setNext(new IntNode(x, null));
            }
        }
    }

    /**
     * @param x  - an integer;
     * @Method : "removeFromSet";
     * --------------------------------------------------
     * Time complexity : O(n);
     * There is a while loop that iterates through the set - an undefined amount of nodes that it iterates through --> O(n);
     * Space complexity : O(1);
     *  Uses only 1 variable - a defined amount --> O(1);
     * --------------------------------------------------
     * Receives an integer x and removes it from the sets if it exists in it;
     */
    public void removeFromSet(int x) {
        if (!isEmpty() && isMember(x)) { //The list isn't empty or the number doesn't exist in the set;
            IntNode prev = null;
            IntNode currNode = this._groupHead;

            while (currNode != null) {
                if (currNode.getValue() == x) { //We want to remove the current node from the set;
                    if (prev != null) {
                        IntNode temp = currNode.getNext();
                        currNode.setNext(null);
                        prev.setNext(temp);
                    } else {
                        IntNode temp = this._groupHead.getNext();
                        this._groupHead.setNext(null);
                        this._groupHead = temp;
                    }
                }
                prev = currNode;
                currNode = currNode.getNext();
            }
        }
    }
    /**
     * @Method : "toString";
     * --------------------------------------------------
     * Time complexity : O(n);
     * There is a while loop that iterates through the set - an undefined amount of nodes that it iterates through --> O(n);
     * Space complexity : O(1);
     *  Uses only 2 variables - a defined amount --> O(1);
     * --------------------------------------------------
     * The toString() method returns a string representing the set.
     */
    public String toString() {
        IntNode temp = this._groupHead;
        String set = "{";
        if (temp != null) {
            set += temp.getValue();
            temp = temp.getNext();
        }
        while (temp != null) {
            set += "," + temp.getValue();
            temp = temp.getNext();
        }
        set += "}";
        return set;
    }
    /**
     * @param other  - another set;
     * @Method : "intersection";
     * --------------------------------------------------
     * Time complexity : O(n^2);
     * There is a while loop and inside it there is a function call to "isMember" that uses a while loop in it, therefore the while loop is nested --> O(n^2);
     * Space complexity : O(1);
     *  Uses only 2 variable - a defined amount --> O(1);
     * --------------------------------------------------
     * @returns - Returns the intersection set of the "other" set with "this" set; The method returns a set New and does not change the set on which the method was applied nor the other set;
     */
    public Set intersection(Set other) {
        Set intersectionSet = new Set();
        if (isEmpty() || other.isEmpty()) {
            return intersectionSet;
        }
        IntNode currNode = this._groupHead;
        while (currNode != null) {
            if (other.isMember(currNode.getValue())) {
                intersectionSet.addToSet(currNode.getValue());
            }
            currNode = currNode.getNext();
        }
        return intersectionSet;
    }
    /**
     * @param other  - another set;
     * @Method : "union";
     * --------------------------------------------------
     * Time complexity : O(n^2);
     * There is a while loop and inside it there is a function call to "isMember" that uses a while loop in it, therefore the while loop is nested --> O(n^2);
     * Space complexity : O(1);
     *  Uses only 2 variable - a defined amount --> O(1);
     * --------------------------------------------------
     * @returns - Returns the union set of the "other" set with "this" set; The method returns a set New and does not change the set on which the method was applied nor the other set;
     */
    public Set union(Set other) {
        Set unionSet = new Set();
        if (isEmpty()) {
            return other;
        }
        if (other.isEmpty()) {
            return this;
        }
        IntNode currNode = this._groupHead;

        while (currNode != null) {
            if (!unionSet.isMember(currNode.getValue())) {
                unionSet.addToSet(currNode.getValue());
            }
            currNode = currNode.getNext();
        }

        currNode = other._groupHead;

        while (currNode != null) {
            if (!unionSet.isMember(currNode.getValue())) {
                unionSet.addToSet(currNode.getValue());
            }
            currNode = currNode.getNext();
        }
        return unionSet;
    }

    /**
     * @param other  - another set;
     * @Method : "difference";
     * --------------------------------------------------
     * Time complexity : O(n^2);
     * There is a while loop and inside it there is a function call to "isMember" that uses a while loop in it, therefore the while loop is nested --> O(n^2);
     * Space complexity : O(1);
     *  Uses only 2 variable - a defined amount --> O(1);
     * --------------------------------------------------
     * @returns - Returns the difference set of the "other" set with "this" set; The method returns a set New and does not change the set on which the method was applied nor the other set;
     */
    public Set difference(Set other) {
        Set differenceSet = new Set();
        IntNode currNode = this._groupHead;
        while (currNode != null) {
            if (!other.isMember(currNode.getValue())) {
                differenceSet.addToSet(currNode.getValue());
            }
            currNode = currNode.getNext();
        }
        return differenceSet;
    }
}
