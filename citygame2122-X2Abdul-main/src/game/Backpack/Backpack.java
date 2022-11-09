package game.Backpack;

import java.util.ArrayList;

public class Backpack {

    //creates an array to hold backpack items
    private ArrayList<BackpackItem> items;

    private int currentItem;

    public Backpack(){
        //adding items to array
        items = new ArrayList<BackpackItem>();
        currentItem = -1;
    }
    //add the item in the backpack
    public void addItem(BackpackItem item){
        items.add(item);
        currentItem = items.size()-1;
    }


    //toogle through items
    public void toggle(){
        currentItem++;
        if(currentItem == items.size()){
            currentItem =0;
        }
        System.out.println("currentItem: " + getCurrentItem().getType());
    }

    //Accessors
    public BackpackItem getCurrentItem(){
        return items.get(currentItem);
    }
}
