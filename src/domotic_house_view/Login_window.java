/**
 * Contenido en el paquete que agrupa los componentes de las vistas de la casa domótica, sus respectivos controladores y la máquina de estados.
 * Se importa la clase Model con el fin de acceder al modelo.
 * Se importa la clase Color con el fin de cambiar el fondo de la caja de texto que representa el color.
 * Se importa la clase Calendar con el fin de mostrar la fecha en el panel inicial.
 */
package domotic_house_view;
import domotic_house_model.Model;
import java.awt.Color;
import java.util.Calendar;

/**
 * Vista del panel principal de la casa domótica. En esta vista podemos acceder a las demás secciones de la casa domótica.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Pablo Martínez López
 * @author Ángel Moreno Calvo
 */
public class Login_window extends javax.swing.JFrame {
    private controllerLoginWindow controller;
    private static Model model;
    
    /**
     * Creación de la vista mostrando los parámetros actuales de las distintas partes de la casa domótica.
     * @param m Modelo del sistema que se transfiere al cambiar de vista.
     */
    public Login_window(Model m) {
        model = m;
        initComponents();
        controller = new controllerLoginWindow(this,model);
        information_text();
        actInt(model.getHeating());
        
        
        Thread clock=new Thread(new Runnable(){
                public void run(){
                    while(true){
                        Calendar calendar=Calendar.getInstance();
                        date.setText(calendar.getTime().toString());

                    }
                    
                }
            });
        
        clock.start();
    }
    
    /**
     * Actualiza la etiqueta referente a la temperatura. Dependiendo del valor de la temperatura la etiqueta adopta un valor determinado.
     * @param n Número entero que representa el valor de la temperatura.
     */
    public void actInt(int n){
        heat_value_text.setText(Integer.toString(n)+"º C");
        if(n>=10 && n<15){
            heat_value_text.setForeground(Color.BLUE);
        }else if(n>=15 && n<=19){
            heat_value_text.setForeground(Color.CYAN);
        }else if(n==20){
            heat_value_text.setForeground(Color.GREEN);
        }
        else if(n>=21 && n<25){
            heat_value_text.setForeground(Color.ORANGE);
        }else{
            heat_value_text.setForeground(Color.RED);
        }
    }
    
    /**
     * Actualiza los valores de los datos de la casa domótica mostrados en el menú.
     */
    public void information_text(){
        
        // Datos termostatos.
        lights_text.setText("LIGHTS STATE: ");
        heating_text.setText("HEATING STATE: ");
        heat_value_text.setText(Integer.toString(model.getHeating())+"º C");
       
        // Datos persianas
        blinds_text.setText("BLINDS STATE: ");
        if(model.getBlindValue(1)==100){
            blind1_value.setText("Blind one: closed");
        }else if(model.getBlindValue(1)==0){
            blind1_value.setText("Blind one: open");
        }else{
            blind1_value.setText("Blind one: "+Integer.toString(Math.abs(model.getBlindValue(1)-100))+"% open");
        }
        
        if(model.getBlindValue(2)==100){
            blind2_value.setText("Blind two: closed");
        }else if(model.getBlindValue(2)==0){
            blind2_value.setText("Blind two: open");
        }else{
            blind2_value.setText("Blind two: "+Integer.toString(Math.abs(model.getBlindValue(2)-100))+"% open");
        }
        
        if(model.getBlindValue(3)==100){
            blind3_value.setText("Blind three: closed");
        }else if(model.getBlindValue(3)==0){
            blind3_value.setText("Blind three: open");
        }else{
            blind3_value.setText("Blind three: "+Integer.toString(Math.abs(model.getBlindValue(3)-100))+"% open");
        }
        
        
        //blind2_value.setText("Blind two: "+Integer.toString(Math.abs(model.getBlindValue(2)-100))+"% open");
        //blind3_value.setText("Blind three: "+Integer.toString(Math.abs(model.getBlindValue(3)-100))+"% open");
        
        // Datos bombillas
        bulb_state.setText("Configuration: " + model.getMode() );
        bulb1.setText("Bulb one: " + on_off_string(0));
        bulb2.setText("Bulb two: " + on_off_string(1));
        bulb3.setText("Bulb three: " + on_off_string(2));
        bulb4.setText("Bulb four: " + on_off_string(3));
        bulb5.setText("Bulb five: " + on_off_string(4));
    }
    
    /**
     * Cambio de string, permite el transformar el (@code{true}) por On y 
     * el (@code{false}) por Off.
     * @param i Número entero que representa la bombilla de la que se quiere conocer el estado.
     * @return Cadena de caracteres que representa el valor de la bombilla seleccionada.
     */
    private String on_off_string(int i){
        return (model.getEncendido(i) ? "On" : "Off");
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        light_button = new javax.swing.JButton();
        heating = new javax.swing.JButton();
        blinds = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        lights_text = new javax.swing.JLabel();
        heating_text = new javax.swing.JLabel();
        blinds_text = new javax.swing.JLabel();
        heat_value_text = new javax.swing.JLabel();
        blind1_value = new javax.swing.JLabel();
        blind2_value = new javax.swing.JLabel();
        blind3_value = new javax.swing.JLabel();
        bulb1 = new javax.swing.JLabel();
        bulb2 = new javax.swing.JLabel();
        bulb3 = new javax.swing.JLabel();
        bulb4 = new javax.swing.JLabel();
        bulb5 = new javax.swing.JLabel();
        bulb_state = new javax.swing.JLabel();
        date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DOMOTIC HOUSE");
        setPreferredSize(new java.awt.Dimension(1024, 569));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 500));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DOMOTIC HOUSE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 24))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 814));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        light_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domotic_house_view/images/bulbs/bombilla_inicio.png"))); // NOI18N
        light_button.setActionCommand("light_button");
        light_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                light_buttonActionPerformed(evt);
            }
        });

        heating.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domotic_house_view/images/termo.png"))); // NOI18N
        heating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heatingActionPerformed(evt);
            }
        });

        blinds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domotic_house_view/images/blind/blinds_draw.png"))); // NOI18N
        blinds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blindsActionPerformed(evt);
            }
        });

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domotic_house_view/images/exit.png"))); // NOI18N
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        lights_text.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lights_text.setText("LIGHTS STATE:");

        heating_text.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        heating_text.setText("HEATING STATE:");

        blinds_text.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        blinds_text.setText("BLINDS STATE:");

        heat_value_text.setFont(new java.awt.Font("Roboto Condensed", 1, 64)); // NOI18N
        heat_value_text.setText("Value");

        blind1_value.setText("Blind1");

        blind2_value.setText("Blind2");

        blind3_value.setText("Blind3");

        bulb1.setText("Bulb1");

        bulb2.setText("Bulb2");

        bulb3.setText("Bulb3");

        bulb4.setText("Bulb4");

        bulb5.setText("Bulb5");

        bulb_state.setText("STATE:");

        date.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lights_text, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bulb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bulb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bulb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bulb4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bulb5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(bulb_state))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(heating_text, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(heat_value_text, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(109, 109, 109)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(blinds_text, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(blind2_value)
                                            .addComponent(blind1_value, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(blind3_value)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(932, 932, 932))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(light_button, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(heating, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(blinds, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {blind1_value, blind2_value, blind3_value});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(blinds, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(heating)
                                .addComponent(light_button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lights_text, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bulb_state, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bulb1)
                                .addGap(15, 15, 15)
                                .addComponent(bulb2)
                                .addGap(18, 18, 18)
                                .addComponent(bulb3)
                                .addGap(18, 18, 18)
                                .addComponent(bulb4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(blinds_text, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(blind1_value, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(blind2_value, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(blind3_value, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(heating_text, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(heat_value_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bulb5)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {blinds, exit, heating, light_button});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {heat_value_text, heating_text});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void light_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_light_buttonActionPerformed
        controller.process_light();
    }//GEN-LAST:event_light_buttonActionPerformed

    private void heatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heatingActionPerformed
        controller.process_heating();
    }//GEN-LAST:event_heatingActionPerformed

    private void blindsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blindsActionPerformed
        controller.process_blinds();
    }//GEN-LAST:event_blindsActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blind1_value;
    private javax.swing.JLabel blind2_value;
    private javax.swing.JLabel blind3_value;
    private javax.swing.JButton blinds;
    private javax.swing.JLabel blinds_text;
    private javax.swing.JLabel bulb1;
    private javax.swing.JLabel bulb2;
    private javax.swing.JLabel bulb3;
    private javax.swing.JLabel bulb4;
    private javax.swing.JLabel bulb5;
    private javax.swing.JLabel bulb_state;
    private javax.swing.JLabel date;
    private javax.swing.JButton exit;
    private javax.swing.JLabel heat_value_text;
    private javax.swing.JButton heating;
    private javax.swing.JLabel heating_text;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton light_button;
    private javax.swing.JLabel lights_text;
    // End of variables declaration//GEN-END:variables
}
