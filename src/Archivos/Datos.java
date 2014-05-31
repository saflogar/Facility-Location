/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author sergio
 */
public class Datos {
    private Scanner archivo;
    private Scanner line;
    // Numero de facilidades y Numero de clientes
    private int NF , NC;
    //Matriz de NF X NC que almacena el costo de la conexion entre facilidad y cliente
    private int [][] c;
    private int[] f;

 

    
    public Datos(File fName) throws FileNotFoundException
    {
            archivo = new Scanner(new FileReader(fName));
            line = new Scanner (archivo.nextLine());
            NF = line.nextInt();
            NC = line.nextInt();
            line = new Scanner (archivo.nextLine());
            f = new int[NF];
            c = new int [NC][NF];
            
            for (int i = 0; i < NF ; i++)
            {
               f[i] = line.nextInt();
            }
            

            for (int j = 0; j < NC; j++)
            {
                line = new Scanner (archivo.nextLine());
                for (int i =0; j < NF; i++)
                {
                    c[j][i] = line.nextInt();
                }
              
            }
    
    }
       public int[][] getC() {
        return c;
    }

    public void setC(int[][] c) {
        this.c = c;
    }

    public int[] getF() {
        return f;
    }

    public void setF(int[] f) {
        this.f = f;
    }
    
    
    
    
}
