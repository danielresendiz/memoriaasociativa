package memoasoc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Ventana extends javax.swing.JFrame implements ActionListener{
    JButton calc;
    JButton entradas[][][][];
    MiBoton salidas[][][][];
    int matrices_entrada[][][][];
    int matrices_salida[][][][];
    
    
    public Ventana() {
        initComponents();
        
        this.setBounds(0, 0, 1000, 700);
        calc = new JButton("Calcular");
        calc.setBounds(30, 600, 150, 30);
        calc.addActionListener(this);
        this.add(calc);
        entradas = new JButton[4][2][5][5];
        salidas = new MiBoton[4][2][5][5];
        matrices_entrada = new int[4][2][5][5];
        matrices_salida = new int[4][2][5][5];
        
        int tx,ty;
        
        for(int a=0; a<4; a++){
            for(int b=0; b<2; b++){
                for(int c=0; c<5; c++){
                    for(int d=0; d<5; d++){
                        entradas[a][b][c][d] = new JButton();
                        entradas[a][b][c][d].setBackground(Color.WHITE);
                        entradas[a][b][c][d].setSize(20,20);
                        tx = d*(entradas[a][b][c][d].getWidth()+5);
                        ty = c*(entradas[a][b][c][d].getHeight()+5);                        
                        tx = tx + (b*(5*(entradas[a][b][c][d].getWidth()+5)+20));
                        ty = ty + (a*(5*(entradas[a][b][c][d].getHeight()+5)+20));
                        entradas[a][b][c][d].setLocation(tx+30,ty+30);
                        this.add(entradas[a][b][c][d]);
                        salidas[a][b][c][d] = new MiBoton();
                        matrices_entrada[a][b][c][d] = 0;
                        matrices_salida[a][b][c][d] = 0;
                        
                        entradas[a][b][c][d].addActionListener(this);
                    }
                }
            }
        }
        
        for(int a=0; a<4; a++){
            for(int b=0; b<2; b++){
                for(int c=0; c<5; c++){
                    for(int d=0; d<5; d++){
                        salidas[a][b][c][d] = new MiBoton();
                        salidas[a][b][c][d].setBackground(Color.WHITE);
                        salidas[a][b][c][d].setSize(20,20);
                        tx = d*(salidas[a][b][c][d].getWidth()+5);
                        ty = c*(salidas[a][b][c][d].getHeight()+5);                        
                        tx = tx + (b*(5*(salidas[a][b][c][d].getWidth()+5)+20));
                        ty = ty + (a*(5*(salidas[a][b][c][d].getHeight()+5)+20));
                        tx = tx + (2*(5*(salidas[a][b][c][d].getWidth()+5)+20)+30);
                        ty = ty + (0*(5*(salidas[a][b][c][d].getHeight()+5)+20));
                        salidas[a][b][c][d].setLocation(tx+30,ty+30);
                        this.add(salidas[a][b][c][d]);
                        
                    }
                }
            }
        }
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton tmp;
        Color col;
        boolean check=false;
        int patrones[][][] = new int[4][25][25];
        int maximos[][] = new int[25][25];
        int minimos[][] = new int[25][25];
        int tmin,tmax;
        int tmp1,tmp2;
        int i,j;
        if(e.getSource().equals(calc)){
            for(int a=0; a<4; a++){
                i=0;
                for(int ci=0; ci<5; ci++){
                    for(int di=0; di<5; di++){
                        j=0;                        
                        for(int cj=0; cj<5; cj++){
                            for(int dj=0; dj<5; dj++){
                                patrones[a][i][j] = alpha(matrices_entrada[a][0][ci][di],matrices_entrada[a][0][cj][dj]);
                                
                                j++;
                            }
                        }
                        
                        i++;
                    }
                }
                
                
                
            }
            for(int x=0; x<25; x++){
                for(int y=0; y<25; y++){
                    tmin=3;
                    tmax=-1;
                    for(int a=0; a<4; a++){                                
                        if(patrones[a][x][y]<tmin){
                            tmin=patrones[a][x][y];
                        }
                        if(patrones[a][x][y]>tmax){
                            tmax=patrones[a][x][y];
                        }
                    }
                    
                    maximos[x][y]=tmax;
                    minimos[x][y]=tmin;
                    
                }
                
            }
            
            for(int a=0; a<4; a++){
                i=0;
                for(int ci=0; ci<5; ci++){
                    for(int di=0; di<5; di++){
                        j=0;
                        tmin=3;
                        tmax=-1;
                        for(int cj=0; cj<5; cj++){
                            for(int dj=0; dj<5; dj++){
                                tmp1 = this.beta(maximos[i][j], matrices_entrada[a][1][cj][dj]);
                                tmp2 = this.beta(minimos[i][j], matrices_entrada[a][1][cj][dj]);
                                if(tmp1<tmin){
                                    tmin=tmp1;
                                }
                                if(tmp2>tmax){
                                    tmax=tmp2;
                                
                                }
                                j++;
                            }
                        }
                        
                        matrices_salida[a][0][ci][di]=tmin;
                        System.out.print("\t"+tmin);
                        matrices_salida[a][1][ci][di]=tmax;
                        if(tmin==1){
                            salidas[a][0][ci][di].setBackground(Color.BLACK);
                        }else{
                            salidas[a][0][ci][di].setBackground(Color.WHITE);
                        }
                        salidas[a][0][ci][di].repaint();
                        if(tmax==1){
                            salidas[a][1][ci][di].setBackground(Color.BLACK);
                        }else{
                            salidas[a][1][ci][di].setBackground(Color.WHITE);
                        }
                        salidas[a][1][ci][di].repaint();
                        
                        i++;
                    }
                    System.out.println("");
                    
                }
                System.out.println("");
                
            }
            
        }else{
            tmp = (JButton) e.getSource();
            col = tmp.getBackground();
            if(col.equals(Color.WHITE)){
                tmp.setBackground(Color.BLACK);
                for(int a=0; a<4 && !check; a++){
                    for(int b=0; b<2 && !check; b++){
                        for(int c=0; c<5 && !check; c++){
                            for(int d=0; d<5 && !check; d++){
                                if(tmp.equals(entradas[a][b][c][d])){
                                    check=true;
                                    matrices_entrada[a][b][c][d]=1;
                                }
                            }
                        }
                    }
                }           
            }else{
                tmp.setBackground(Color.WHITE);
                for(int a=0; a<4 && !check; a++){
                    for(int b=0; b<2 && !check; b++){
                        for(int c=0; c<5 && !check; c++){
                            for(int d=0; d<5 && !check; d++){
                                if(tmp.equals(entradas[a][b][c][d])){
                                    check=true;
                                    matrices_entrada[a][b][c][d]=0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public int alpha(int x, int y){
            int resultado=0;
            if(x==0 && y==0){
                resultado=1;
            }else if(x==0 && y==1){
                resultado=0;
            }else if(x==1 && y==0){
                resultado=2;
            }else if(x==1 && y==1){
                resultado=1;
            }
            return resultado;
    }
    
    public int beta(int x, int y){
        int resultado = -1;
        if(x==0 && y==0){
            resultado=0;
        }else if(x==0 && y==1){
            resultado=0;
        }else if(x==1 && y==0){
            resultado=0;
        }else if(x==1 && y==1){
            resultado=1;
        }else if(x==2 && y==0){
            resultado=1;
        }else if(x==2 && y==1){
            resultado=1;
        }
        return resultado;
    }
}
