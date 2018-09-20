package vn.com.famtech.driverecivemap.interfacea;

/**
 * Created by GIAVI on 5/5/2017.
 */

public interface OnRecyclerViewItemClickListener
{
    /**
     * Called when any item with in recyclerview or any item with in item
     * clicked
     *
     * @param position
     *            The position of the item
     * @param id
     *            The id of the view which is clicked with in the item or
     *            -1 if the item itself clicked
     */
    public void onRecyclerViewItemClicked(int position, int id);
}