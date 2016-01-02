
package Archivos;

import facilitylocation.Facility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 * Reads the file where data is stored. 
 * 
 * The file must have the next format:
 * 
 * NF NC                         // Where NF= the number of facilities. NC = the number of clients.
 * f1 f2 f3 .... fNF            //  This line must have the cost of each facility.
 * c1,1 c1,2 c1,3 ... c1,NC    //   This line and the above ones must have the cost of the path between each client and the facility.
 * c2,1 c2,2 c2,3 ... c2,NC   
 * .
 * .
 * cNF
 * 
 * e.g: 
 * 
 * 5 6
 * 6 5 11 9 5
 * 9 2 45 5 5 4 5 2 8 2 
 * 5 1 3 5 4 6 3 12  2 2
 * 6 3 1 4 45 5 6 4 8 6 
 * 6 9 4 3 6 5 3 7 5 3 24   
 * 5 4 4 2 5 4 1 7 5 9 
 * 
 */
public class Datos {
    private final Scanner archivo;
    private Scanner line;
    // Numero de facilidades y Numero de clientes
    private final int NF , NC;
    //Matriz de NF X NC que almacena el costo de la conexion entre facilidad y cliente
    private final int [][] c;
    private final Facility[] f;
    
    public Datos(File fName) throws FileNotFoundException
    {
        archivo = new Scanner(new FileReader(fName));
        line = new Scanner (archivo.nextLine());
        NF = line.nextInt();
        NC = line.nextInt();
        System.out.println("NF= "+NF);
        System.out.println("NC= "+NC);
        line = new Scanner (archivo.nextLine());
        f = new Facility[NF];
        c = new int [NF][NC];
        
        for (int i = 0; i <= NF-1 ; i++)
        {
            f[i] = new Facility(line.nextInt());
            System.out.println("f["+i+"] ="+f[i].getCost());
        }
        
        for (int j = 0; j < NF; j++)
        {
            line = new Scanner (archivo.nextLine());
            for (int i =0; i < NC; i++)
            {
                c[j][i] = line.nextInt();
                System.out.println("c["+j+"]"+"["+i+"]="+c[j][i]);
            }
        }
    }
    
    public int getNC() {
        return NC;
    }
    
    public int[][] getC() {
        return c;
    }

    public int getNF() {
        return NF;
    }
    
    public Facility[] getF() {
        return f;
    }
}
