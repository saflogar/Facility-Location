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


public class Client {
    private boolean connected;
    private int budget;
    private int connectionCost;
    private int bid;
    
    
    
    public Client()
    {
        connected = false;
        budget = 0;
    
    }
    
    public int getBid() {
        
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getConnectionCost() {
        return connectionCost;
    }

    public void setConnectionCost(int connectionCost) {
        this.connectionCost = connectionCost;
    }
    
    
    
}
