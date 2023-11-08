/* NOAH A MORAN
[CS2401 - FA23]
This work is to be done individually. It is not permitted to share, reproduce, or alter any part of this
assignment for any purpose. Students are not permitted from sharing code, uploading this
assignment online in any form, or viewing/receiving/modifying code written from anyone else. This
assignment is part of an academic course at The University of Texas at El Paso and a grade will be
assigned for the work produced individually by the student. */

public class EarthquakeBinarySearchTree {
    private Earthquake root;

    /**
     * Adds an earthquake object to the tree
     * @param quake
     * @return True if the earthquake was added to the tree
     */
    public boolean add(Earthquake quake) {
        if(root == null){
            root = quake;
            return true;
        }
        Earthquake parent = null;
        Earthquake current = root;
        while(current != null){
            if(quake.getMagnitude() < current.getMagnitude()){
                parent = current;
                current = current.left;
            }
            else if(quake.getMagnitude() > current.getMagnitude()){
                parent = current;
                current = current.right;
            }
            else 
                return false;
        }
        if(quake.getMagnitude() < parent.getMagnitude())
            parent.left = quake;
        else
            parent.right = quake;
        return true;
        
    }

    /**
     * Iterative method: search and return the earthquake that matches the target
     * magnitude. If not earthquake is found, return null
     * 
     * @param targetMagnitude
     * @return An earthquake object or null
     */
    public Earthquake search(double targetMagnitude) {
        Earthquake current = root;
        while(current != null){
            if(targetMagnitude< current.getMagnitude())
                current = current.left;
            if(targetMagnitude > current.getMagnitude())
                current = current.right;

            else if(current.getMagnitude() == targetMagnitude)
                return current;
        } 
            return null;
    }

    /**
     * Display the tree. Don't modify this method
     */
    public void display() {
        if (root == null) {
            System.out.println("The tree is empty.");
        }
        inOrderTraversal(root);
    }

    /**
     * Helper recursive method: Use recursion to display the tree inOrder
     * @param current
     */
    private void inOrderTraversal(Earthquake current) {
        if(current !=null){
            inOrderTraversal(current.left);
            System.out.println("Earthquake "+ "{magnitude = " + current.getMagnitude() + ", place= " + current.getPlace() + ", date= " + current.getDate() + "}" );
            inOrderTraversal(current.right);
            
        }
    }
}