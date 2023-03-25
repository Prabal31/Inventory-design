package manchapr;

import java.util.ArrayList;
import javafx.stage.Stage;

public final class InventoryList {
    public ArrayList<Inventory> invList = new ArrayList<>();
    private String id;
    private String name;
    private String qoh;
    private String rop;
    private String SellPrice;
    private Stage window;
    int answer=5;

    public int getAnswer() {
        return answer;
    }
    Inventory inventory;

    public InventoryList() {
    }
     
    InventoryList(String id,String name,String qoh,String rop,String SellPrice,Stage window) {
        this.id=id;
        this.name=name;
        this.qoh=qoh;
        this.rop=rop;
        this.SellPrice=SellPrice;
        this.window=window;
   
        inventory =new Inventory(id,name,qoh,rop,SellPrice);
        answer=inventory.Check(window);
        if(answer==0) {
            invList.add(inventory);
            print();
        } 
    }

    public void add(Inventory inventory) {
        invList.add(inventory);
    }

    public Inventory get(int index) {
        if (index < 0 || index >= invList.size()) {
            return null;
        }
        return invList.get(index);
    }

    public int length() {
        return invList.size();
    }
    public void print() {
        for (Inventory item: invList) {
            System.out.println(item.id);
            System.out.println(item.name);
            System.out.println(item.qoh);
            System.out.println(item.rop);
            System.out.println(item.SellPrice);
        }
    }
}