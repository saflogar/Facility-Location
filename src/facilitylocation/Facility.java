/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facilitylocation;

/**
 *
 * @author sergio
 */
public class Facility {
    private  int cost;
    private boolean open;

    public Facility(int cost)
    {
        this.cost = cost;
        
    }
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean connected) {
        this.open = connected;
    }
}
