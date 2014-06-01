/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Archivos;

import facilitylocation.Client;
import facilitylocation.Facility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author sergio
 */
public class Datos {
    private final Scanner archivo;
    private Scanner line;
    // Numero de facilidades y Numero de clientes
    private int NF , NC;
    //Matriz de NF X NC que almacena el costo de la conexion entre facilidad y cliente
    private int [][] c;
    private Facility[] f;

    public int getNC() {
        return NC;
    }

 

    
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
            c = new int [NC][NF];
            
            for (int i = 0; i <= NF-1 ; i++)
            {
               f[i] = new Facility(line.nextInt());
                
                System.out.println("f["+i+"] ="+f[i]);
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
