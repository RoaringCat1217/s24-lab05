package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    // Write your implementation below with API documentation
    private SortedIntList delegated = new SortedIntList();
    private int nAdded = 0;

    @Override
    public boolean add(int num) {
        nAdded++;
        return delegated.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        nAdded += list.size();
        return delegated.addAll(list);
    }

    @Override
    public int get(int index) {
        return delegated.get(index);
    }

    @Override
    public boolean remove(int num) {
       return delegated.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
       return delegated.removeAll(list);
    }

    @Override
    public int size() {
        return delegated.size();
    }

    public int getTotalAdded() {
        return nAdded;
    }
}