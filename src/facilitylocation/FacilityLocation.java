package facilitylocation;
import Archivos.Datos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class FacilityLocation {
     String path;
     Scanner pathScan;
     Datos datos;
     int time ; 
     Client[] clientArr;
     Facility[] facilityArr;
     int [][] costosConArr;
     int [][] conexion;
     boolean firstConection;
    
    public static void main(String[] args)
    {
        FacilityLocation fl = new FacilityLocation();
        fl.imprimirResultado();
    }
    
    public FacilityLocation ()
    {
         try {
             time = 0;
             pathScan = new Scanner(System.in);
             path = pathScan.nextLine();
             datos = new Datos(new File(path));
             facilityArr = datos.getF();
             costosConArr = datos.getC();
             conexion= new int[datos.getNF()][datos.getNC()];
             clientArr = new Client[datos.getNC()];
             
             for (int i = 0; i < datos.getNC(); i++) {
                 clientArr[i] = new Client();
             }
             
             for (int i = 0; i < datos.getNF(); i++) {
                 for (int j = 0; j < datos.getNC(); j++) {
                     conexion[i][j]=0;
                 }
             }
             
             int totalBid;
             while (time < 10)
      {
          
          for (int i = 0; i < facilityArr.length; i++) //inicia for de facilities
          {
              System.out.println("|----------------|");
              System.out.println("Facilidad:"+i+ "Costo de apertura= "+facilityArr[i].getCost());
              totalBid = 0;
              for (int j = 0; j < clientArr.length; j++) //inicia for de clients
              {
                      clientArr[j].setBid(calcBid(i,j));
                      totalBid += clientArr[j].getBid();
                      System.out.println("El costo de la conexion es de:"+costosConArr[i][j]);
                      System.out.println("Oferta del cliente "+j + "es = "+clientArr[j].getBid());
                      if (clientArr[j].getBudget() == facilityArr[i].getCost() && facilityArr[i].isOpen())
                      {
                          conexion[i][j] = 1;
                      }
              }// fin de for clients
             
              if (totalBid == facilityArr[i].getCost())
              {
                  facilityArr[i].setOpen(true);
                  for (int j = 0; j < clientArr.length; j++) 
                  {
                      if(clientArr[j].getBid()>0)
                      {
                          conexion[i][j] = 1;                          
                      }                      
                  }
              }
              System.out.println("TotalBid = "+totalBid);
          }// fin for de facilities
          time++;
          //System.out.println("corrida #="+time);
      }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(FacilityLocation.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    public int calcBid(int i, int j)
    {
        int bid;
        if (conexion[i][j] == 0)
                  {  
                    bid = clientArr[j].getBudget() - costosConArr[i][j];
                    clientArr[j].setBudget(clientArr[j].getBudget()+1);
                    return Math.max(bid, 0);
                  }
                  else
                  {
                      bid = clientArr[j].getBid() - costosConArr[i][j];
                      return Math.max(bid, 0);
                  }
    }
    
    public void imprimirResultado()
    {
        for (int i = 0; i < datos.getNF(); i++) 
        {
            System.out.print("[");
            for (int j = 0; j < datos.getNC(); j++) 
            {
                System.out.print(conexion[i][j]);
            }
            System.out.println("]");
        }
    }
   
}
