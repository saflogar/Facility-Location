/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facilitylocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sergio
 */
public class FacilityLocation {
     int time;
     List<Facility> facilityList;
     List<Client> clientList;
     Map connected;
     

     
    //Lista que almacenara el conjunto de facilidades potenciales y su costo
    
    public static void main(String[] args) {
        
        // TODO code application logic here
        FacilityLocation solver = new FacilityLocation();
    }

    public FacilityLocation() 
    {
     
        connected = new HashMap<>();
        facilityList = new ArrayList<>();
        clientList = new ArrayList<>();
        time = 0;
        
        facilityList.add(new Facility(20));
        facilityList.add(new Facility(12));
        clientList.add(new Client());
        clientList.add(new Client());
        
    }
    
    
    
    
}
