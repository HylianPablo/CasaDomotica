/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domotic_house_view;
import domotic_house_model.Model;
import java.awt.Color;
/**
 * Vista del termostato de la sala domótica.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Angel Moreno Calvo
 * @author Pablo Martinez Lopez
 */
public class HeatingView extends javax.swing.JFrame {
    Model model;
    HeatingController controlador;
    
    
    /**
     * Constructor de la vista del termostato.
     * inicialmente la temperatura estara a 20 grados.
     * Se necesita el modelo para poder guardar los estados.
     * @param m modelo utilizado en la implementación.
     */
    public HeatingView(Model m) {
        model = m;
        controlador=new HeatingController(this,m);
        initComponents();
        temperature_text.setText(Integer.toString(model.getHeating()));
        Heating_slider.setValue(model.getHeating());
        temperature_text.setForeground(Color.GREEN);
        actInt(model.getHeating());
    }
    
    
    /**
     * Realiza los cambios continuos asignados al texto referentes al color.
     * 
     * Por ejemplo si el slider baja de 20 pasara a un color azul.
     * @param n valor de la temperatura.
     */
    public void actInt(int n){
        temperature_text.setText(Integer.toString(n)+"º C");
        if(n>=10 && n<15){
            temperature_text.setForeground(Color.BLUE);
        }else if(n>=15 && n<=19){
            temperature_text.setForeground(Color.CYAN);
        }else if(n==20){
            temperature_text.setForeground(Color.GREEN);
        }
        else if(n>=21 && n<25){
            temperature_text.setForeground(Color.ORANGE);
        }else{
            temperature_text.setForeground(Color.RED);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        temperature_text = new javax.swing.JLabel();
        Heating_slider = new javax.swing.JSlider();
        exit_heting = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HEATING SYSTEM");

        temperature_text.setFont(new java.awt.Font("Lucida Grande", 0, 60)); // NOI18N
        temperature_text.setText("20º C");

        Heating_slider.setMajorTickSpacing(1);
        Heating_slider.setMaximum(30);
        Heating_slider.setMinimum(10);
        Heating_slider.setPaintTicks(true);
        Heating_slider.setValue(20);
        Heating_slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Heating_sliderStateChanged(evt);
            }
        });

        exit_heting.setBackground(new java.awt.Color(255, 51, 51));
        exit_heting.setText("Back");
        exit_heting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_hetingActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("HEATING");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(343, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(temperature_text, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(472, 472, 472))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(exit_heting, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(519, 519, 519))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Heating_slider, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(298, 298, 298))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(temperature_text, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(Heating_slider, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(exit_heting, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Heating_sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Heating_sliderStateChanged
    //TODO esto hay que terminarlo    
    controlador.slider(Heating_slider.getValue());
    }//GEN-LAST:event_Heating_sliderStateChanged

    private void exit_hetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_hetingActionPerformed
        controlador.back_to_login();
    }//GEN-LAST:event_exit_hetingActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider Heating_slider;
    private javax.swing.JButton exit_heting;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel temperature_text;
    // End of variables declaration//GEN-END:variables
}
