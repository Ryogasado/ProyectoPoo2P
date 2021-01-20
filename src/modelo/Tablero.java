/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Favia Elizalde
 */
public class Tablero {
    private ArrayList<CartaJuego> cartas;
    private ArrayList<Integer> listaNumCartas = new ArrayList<>();
    
    public Tablero(){
        cartas= new ArrayList<CartaJuego>();
        
        for(int i=1 ;i<=54;i++){
            listaNumCartas.add(i);
        }
        for(int j: listaNumCartas){
            Carta nueva = new Carta(j);  
        }
    }
    
    public void llenarCartasAzar(GridPane grid){
        
        int n = 0;
        Image img1 = null;
        Collections.shuffle(listaNumCartas);
        try{
            img1 = new Image(new FileInputStream("src/imagenes/"+listaNumCartas.get(n)+".png"));
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    ImageView img = new ImageView(img1);
                    grid.add(img,i,j);
                    n++;
                }
            }
        }catch(FileNotFoundException ex){
            System.out.println("No se encontro la imagen");
        }
    }
    
    
    
    
}