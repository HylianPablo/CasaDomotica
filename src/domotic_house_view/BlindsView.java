/**
 * Contenido en el paquete que agrupa los componentes de las vistas de la casa domótica.
 * Se importa la clase Model con el fin de acceder al modelo.
 */
package domotic_house_view;

import domotic_house_model.CasaDomotica;

/**
 * Vista de las persianas de la sala domótica.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Pablo Martínez López
 * @author Ángel Moreno Calvo
 */
public class BlindsView extends javax.swing.JFrame {
    private static CasaDomotica model;
    BlindsController controller;
    static final String IMAGE_PATH = "/domotic_house_view/images/blind/";
    
    /**
     * Se crea la nueva vista, cargando las imágenes inicales y los valores de los sliders.
     * Inicialmente se encuentran cerradas.
     * @param m Modelo del sistema que se transfiere al cambiar de vista.
     */
    public BlindsView(CasaDomotica m) {
        model=m;
        controller=new BlindsController(this,m);
        initComponents();
        intAct();
        upgrade_slider();
    }
    
    /**
     * Actualiza los valores de los sliders al mismo valor que tiene el modelo.
     */
    public void upgrade_slider(){
        blind1.setValue(model.getBlindValue(1));
        blind2.setValue(model.getBlindValue(2));
        blind3.setValue(model.getBlindValue(3));
    }
    
    /**
     * Actualiza las imágenes en función de su valor en el modelo.
     */
    public void intAct(){
        int valor1 = model.getBlindValue(1);
        int valor2 = model.getBlindValue(2);
        int valor3 = model.getBlindValue(3);
        exit_from_blinds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domotic_house_view/images/back.png")));
        if(valor1%10 == 0 )
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(IMAGE_PATH +valor1+".png")));
        if(valor2%10 == 0 )
            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(IMAGE_PATH +valor2+".png")));
        if(valor3%10 == 0 )
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(IMAGE_PATH +valor3+".png")));    
    }
    
    /**
     * Consulta el porcentaje en que está abierta la primera persiana.
     * 
     * @return Número entero que representa el porcentaje en que está abierta la persiana.
     */
    public int getIntensity1(){
        return blind1.getValue();
    }
    
    /**
     * Consulta el porcentaje en que está abierta la segunda persiana.
     * 
     * @return Número entero que representa el porcentaje en que está abierta la persiana.
     */
    public int getIntensity2(){
        return blind2.getValue();
    }
    
    /**
     * Consulta el porcentaje en que está abierta la tercera persiana.
     * 
     * @return Número entero que representa el porcentaje en que está abierta la persiana.
     */
    public int getIntensity3(){
        return blind3.getValue();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blind1 = new javax.swing.JSlider();
        blind2 = new javax.swing.JSlider();
        blind3 = new javax.swing.JSlider();
        exit_from_blinds = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BLINDS_SYSTEM");
        setPreferredSize(new java.awt.Dimension(1024, 569));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 500));

        blind1.setMajorTickSpacing(10);
        blind1.setMinorTickSpacing(10);
        blind1.setPaintTicks(true);
        blind1.setSnapToTicks(true);
        blind1.setToolTipText("");
        blind1.setValue(100);
        blind1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                blind1StateChanged(evt);
            }
        });

        blind2.setMajorTickSpacing(10);
        blind2.setMinorTickSpacing(10);
        blind2.setPaintTicks(true);
        blind2.setSnapToTicks(true);
        blind2.setValue(100);
        blind2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                blind2StateChanged(evt);
            }
        });

        blind3.setMajorTickSpacing(10);
        blind3.setMinorTickSpacing(10);
        blind3.setPaintTicks(true);
        blind3.setSnapToTicks(true);
        blind3.setValue(100);
        blind3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                blind3StateChanged(evt);
            }
        });

        exit_from_blinds.setBackground(new java.awt.Color(255, 102, 102));
        exit_from_blinds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_from_blindsActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4.setText("BLINDS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addComponent(exit_from_blinds, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(413, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(blind1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(blind2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(blind3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(371, 371, 371))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(blind3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(blind2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(blind1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(exit_from_blinds, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exit_from_blindsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_from_blindsActionPerformed
        controller.back_to_login();
    }//GEN-LAST:event_exit_from_blindsActionPerformed

    private void blind1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_blind1StateChanged
        controller.blind1();
    }//GEN-LAST:event_blind1StateChanged

    private void blind2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_blind2StateChanged
        controller.blind2();
    }//GEN-LAST:event_blind2StateChanged

    private void blind3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_blind3StateChanged
        controller.blind3();
    }//GEN-LAST:event_blind3StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider blind1;
    private javax.swing.JSlider blind2;
    private javax.swing.JSlider blind3;
    private javax.swing.JButton exit_from_blinds;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
