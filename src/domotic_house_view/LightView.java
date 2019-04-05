/**
 * Contenido en el paquete que agrupa los componentes de la vista de la casa domótica.
 * Se importa la clase Model con el fin de acceder al modelo.
 * Se importa la clase Color con el fin de cambiar el fondo de la caja de texto que representa el color.
 */
package domotic_house_view;
import domotic_house_model.Model;
import java.awt.Color;
/**
 * Vista de la sala domótica de luces.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Pablo Martínez López
 * @author Ángel Moreno Calvo
 */
public class LightView extends javax.swing.JFrame {
    public boolean active = false;
    Model model;
    LightController controlador;
    /**
     * Se crea la nueva vista, cargando las imágenes inicales de los botones.
     * Las partes de la derecha están desactivadas inicialmente.
     */
    public LightView(Model m) {
        model = m;
        controlador=new LightController(this,model);
        initComponents();
        /*color_bulb1("GREY");
        color_bulb2("GREY");
        color_bulb3("GREY");
        color_bulb4("GREY");
        color_bulb5("GREY");*/
        for(int i=0;i<5;i++){
            controlador.change_state(i);
        }
        on_off.setEnabled(false);
        intensity.setEnabled(false);
        color_list.setEnabled(false);
        color_panel.setEnabled(false);
        all_on.setOpaque(true);
        all_off.setOpaque(true);
        ambiente.setOpaque(true);
        lectura.setOpaque(true);
        intensity.setValue(0);
        Thread x=new Thread(new Runnable(){
                public void run(){
                    while(true){
                        controlador.change_mode();

                    }
                    
                }
            });
        
        x.start();
        
    }
    //Creo que sobra.
    public String image_white(){
        return "/domotic_house_view/images/bombilla_opt.png";
    }
    /**
    * Cambia la imagen de la bombilla 1.
    *@param color Cadena de texto que representa la ruta hacia la imagen a cambiar.
    */
    public void color_bulb1(String color){
                bulb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domotic_house_view/images/bulbs/bombilla_"+color+".png"))); 

    }
    /**
    * Cambia la imagen de la bombilla 2.
    *@param color Cadena de texto que representa la ruta hacia la imagen a cambiar.
    */
    public void color_bulb2(String color){
                bulb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domotic_house_view/images/bulbs/bombilla_"+color+".png"))); 

    }
    /**
    * Cambia la imagen de la bombilla 3.
    *@param color Cadena de texto que representa la ruta hacia la imagen a cambiar.
    */
    public void color_bulb3(String color){
                bulb3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domotic_house_view/images/bulbs/bombilla_"+color+".png")));

    }
    /**
    * Cambia la imagen de la bombilla 4.
    *@param color Cadena de texto que representa la ruta hacia la imagen a cambiar.
    */
    public void color_bulb4(String color){
                bulb4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domotic_house_view/images/bulbs/bombilla_"+color+".png")));
    }
    /**
    * Cambia la imagen de la bombilla 5.
    *@param color Cadena de texto que representa la ruta hacia la imagen a cambiar.
    */
    public void color_bulb5(String color){
                bulb5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domotic_house_view/images/bulbs/bombilla_"+color+".png"))); 

    }
    
    /**
    *Activa el botón de encendido/apagado de la bombilla seleccionada. Muestra la información de los botones de la parte derecha respectivos a la información de cada bombilla. De haber sido pulsados anteriormente, recupera los valores anteriores.
    *@param i Número entero que representa la bombilla i, donde i tiene los valores entre 1 y 5.
    */
    public void show_info(int i){
        active = true;
        light_text.setText("LIGHT: " + (i + 1));
        on_off.setEnabled(true);
        String s=model.getColor( i );
        color_list.setSelectedIndex(model.get_number_color(s));
        switch(s){
            case "RED":
                changeColorRed();
                break;
            case "YELLOW":
                changeColorYellow();
                break;
            case "WHITE":
                changeColorWhite();
                break;
            case "GREEN":
                changeColorGreen();
                break;
            case "BLUE":
                changeColorBlue();
                break;
            default:
                changeColorGrey();
                break;
             
        
        }
        intensity.setValue(model.getIntensidad(i));
        IntNum.setText(String.valueOf(model.getIntensidad(i)));
        
    }
    /**
    *Activa las opciones de intensidad y color de la bombilla.
    */
    public void setOptionsTrue(){
        intensity.setEnabled(true);
        color_list.setEnabled(true);
    }
    
    /**
    *Bloquea las opciones de intensidad y color de la bombilla.
    *¿Hay que poner que esto ocurre cuando se marca la casilla?
    */
    public void setOptionsFalse(){
        intensity.setEnabled(false);
        color_list.setEnabled(false);
    }
    
    /**
    *Desactiva el botón de encendido/apagado de la parte derecha simulando apagar la bombilla seleccionada.
    */
    public void clear(){
        light_text.setText("LIGHT: ");
        on_off.setEnabled(false);
        color_list.setSelectedIndex(0);
        intensity.setValue(0);
        on_off.setSelected(false);
        color_panel.setBackground(Color.LIGHT_GRAY);
        active = false; 
    }
    
    /**
    * Vuelve a cambiar el botón de encendido/apagado después de haber sido cambiada la bombilla seleccionada.
    */
    public void refresh_on_off(){
        if(model.getState() == -1){
        }
        else{
            on_off.setSelected(model.getEncendido(model.getState()));
        }
    }
    /**
     * Actualiza la etiqueta que representa la intensidad de la bombilla.
     * @param n Número entero comprendido entre 0 y 100 que representa la intensidad de la bombilla seleccionada.
     */
    public void actInt(int n){
        IntNum.setText(Integer.toString(n));
    }
    
    /**
    *Cambia el color del panel derecho a rojo.
    */
    public void changeColorRed(){
         color_panel.setBackground(Color.RED);
    }
    /**
    *Cambia el color del panel derecho a amarillo.
    */
    public void changeColorYellow(){
        color_panel.setBackground(Color.YELLOW);
    }
    /**
    *Cambia el color del panel derecho a blanca.
    */
     public void changeColorWhite(){
        color_panel.setBackground(Color.WHITE);
    }
     
     /**
    *Cambia el color del panel derecho a gris.
    */
     public void changeColorGrey(){
        color_panel.setBackground(Color.GRAY);
    }
     /**
    *Cambia el color del panel derecho a verde.
    */
      public void changeColorGreen(){
        color_panel.setBackground(Color.GREEN);
    }
      /**
    *Cambia el color del panel derecho a azul.
    */
       public void changeColorBlue(){
        color_panel.setBackground(Color.BLUE);
    }
    
    /**
     * Cambia el iluminado del borde del botón que representa al modo seleccionado, bien pulsándo dicho botón o activando manualmente sus opciones.
     */
    public void change_color_button(){
        //System.out.println(model.getMode());
        switch (model.getMode()){
            case "ALL_ON":
               all_on.setBackground(Color.CYAN);
               all_off.setBackground(Color.LIGHT_GRAY);
               ambiente.setBackground(Color.LIGHT_GRAY);
               lectura.setBackground(Color.LIGHT_GRAY);
               break;
            case "ALL_OFF":
                all_off.setBackground(Color.CYAN);
                all_on.setBackground(Color.LIGHT_GRAY);
                ambiente.setBackground(Color.LIGHT_GRAY);
                lectura.setBackground(Color.LIGHT_GRAY);
                break;
            case "AMBIENTE":
                ambiente.setBackground(Color.CYAN);
                all_off.setBackground(Color.LIGHT_GRAY);
                all_on.setBackground(Color.LIGHT_GRAY);
                lectura.setBackground(Color.LIGHT_GRAY);
                break;
            case "LECTURA":
                lectura.setBackground(Color.CYAN);
                all_off.setBackground(Color.LIGHT_GRAY);
                ambiente.setBackground(Color.LIGHT_GRAY);
                all_on.setBackground(Color.LIGHT_GRAY);
                break;
            default:
                all_on.setBackground(Color.LIGHT_GRAY);
                all_off.setBackground(Color.LIGHT_GRAY);
                ambiente.setBackground(Color.LIGHT_GRAY);
                lectura.setBackground(Color.LIGHT_GRAY);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        all_off = new javax.swing.JButton();
        ambiente = new javax.swing.JButton();
        lectura = new javax.swing.JButton();
        all_on = new javax.swing.JButton();
        back_from_view = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        bulb1 = new javax.swing.JButton();
        bulb2 = new javax.swing.JButton();
        bulb3 = new javax.swing.JButton();
        bulb4 = new javax.swing.JButton();
        bulb5 = new javax.swing.JButton();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        light_text = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        on_off = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        intensity = new javax.swing.JSlider();
        IntNum = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        color_list = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        color_panel = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LIGHTS SYSTEM");
        setLocation(new java.awt.Point(80, 63));
        setPreferredSize(new java.awt.Dimension(1150, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setPreferredSize(new java.awt.Dimension(1150, 600));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIGHTS");

        all_off.setText("ALL OF");
        all_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                all_offActionPerformed(evt);
            }
        });

        ambiente.setText("AMBIENTE");
        ambiente.setToolTipText("");
        ambiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ambienteActionPerformed(evt);
            }
        });

        lectura.setText("LECTURA");
        lectura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturaActionPerformed(evt);
            }
        });

        all_on.setText("ALL ON");
        all_on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                all_onActionPerformed(evt);
            }
        });

        back_from_view.setBackground(new java.awt.Color(255, 51, 51));
        back_from_view.setText("BACK");
        back_from_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_from_viewActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(all_off, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(ambiente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lectura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(all_on, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(back_from_view, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(all_on)
                        .addGap(18, 18, 18)
                        .addComponent(all_off)
                        .addGap(18, 18, 18)
                        .addComponent(ambiente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lectura)
                        .addGap(18, 18, 18)
                        .addComponent(back_from_view)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLayeredPane2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {all_off, all_on, ambiente, back_from_view, lectura});

        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back_from_view, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(all_off)
                        .addComponent(ambiente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lectura)
                        .addComponent(all_on)))
                .addContainerGap())
        );

        jLayeredPane2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {all_off, all_on, ambiente, back_from_view, lectura});

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Light selection"));

        bulb1.setText("1");
        bulb1.setActionCommand("Button5");
        bulb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulb1ActionPerformed(evt);
            }
        });

        bulb2.setText("2");
        bulb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulb2ActionPerformed(evt);
            }
        });

        bulb3.setText("3");
        bulb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulb3ActionPerformed(evt);
            }
        });

        bulb4.setText("4");
        bulb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulb4ActionPerformed(evt);
            }
        });

        bulb5.setText("5");
        bulb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulb5ActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(bulb1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(bulb2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(bulb3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(bulb4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(bulb5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(bulb1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bulb2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bulb3))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(bulb4)
                        .addGap(18, 18, 18)
                        .addComponent(bulb5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bulb1, bulb2, bulb3, bulb4, bulb5});

        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bulb1)
                    .addComponent(bulb2)
                    .addComponent(bulb3))
                .addGap(77, 77, 77)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bulb4)
                    .addComponent(bulb5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jLayeredPane3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bulb1, bulb2, bulb3, bulb4, bulb5});

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Light characteristics"));

        light_text.setText("LIGHT:");

        jLabel3.setText("On/Off");

        on_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                on_offActionPerformed(evt);
            }
        });

        jLabel4.setText("Intensity");

        intensity.setMajorTickSpacing(10);
        intensity.setPaintTicks(true);
        intensity.setValue(0);
        intensity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                intensityStateChanged(evt);
            }
        });

        IntNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IntNum.setText("0");
        IntNum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel6.setText("Color");

        color_list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "WHITE", "RED", "YELLOW", "GREEN", "BLUE" }));
        color_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color_listActionPerformed(evt);
            }
        });

        color_panel.setBackground(new java.awt.Color(192, 192, 192));
        jScrollPane1.setViewportView(color_panel);

        jLayeredPane4.setLayer(light_text, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(on_off, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(intensity, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(IntNum, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(color_list, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(light_text))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(intensity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IntNum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(on_off))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(color_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {color_list, jLabel6, jScrollPane1});

        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(light_text)
                .addGap(33, 33, 33)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(on_off))
                .addGap(43, 43, 43)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(intensity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IntNum))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(color_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jLayeredPane4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {IntNum, intensity, jLabel4});

        jLayeredPane4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {color_list, jLabel6, jScrollPane1});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLayeredPane3, jLayeredPane4});

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bulb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulb2ActionPerformed
        controlador.activate(1);
    }//GEN-LAST:event_bulb2ActionPerformed

    private void bulb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulb3ActionPerformed
        controlador.activate(2);
    }//GEN-LAST:event_bulb3ActionPerformed

    private void bulb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulb4ActionPerformed
        controlador.activate(3);
    }//GEN-LAST:event_bulb4ActionPerformed

    private void bulb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulb5ActionPerformed
        controlador.activate(4);
    }//GEN-LAST:event_bulb5ActionPerformed

    private void bulb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulb1ActionPerformed
         controlador.activate(0);
         //IntNum.setText(String.valueOf(intensity.getValue()));
        
    }//GEN-LAST:event_bulb1ActionPerformed

    private void all_onActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_all_onActionPerformed
        controlador.all_on();
        
    }//GEN-LAST:event_all_onActionPerformed

    private void all_offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_all_offActionPerformed
        controlador.all_off();
    }//GEN-LAST:event_all_offActionPerformed

    private void ambienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ambienteActionPerformed
        controlador.ambiente();
    }//GEN-LAST:event_ambienteActionPerformed

    private void lecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturaActionPerformed
        controlador.lectura();
    }//GEN-LAST:event_lecturaActionPerformed

    private void on_offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_on_offActionPerformed
        controlador.on_off();
    }//GEN-LAST:event_on_offActionPerformed

    private void color_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color_listActionPerformed
        controlador.color((String)color_list.getSelectedItem());
    }//GEN-LAST:event_color_listActionPerformed

    private void intensityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_intensityStateChanged
        controlador.intensidad(intensity.getValue());
    }//GEN-LAST:event_intensityStateChanged

    private void back_from_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_from_viewActionPerformed
        controlador.back_to_login();
    }//GEN-LAST:event_back_from_viewActionPerformed
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IntNum;
    private javax.swing.JButton all_off;
    private javax.swing.JButton all_on;
    private javax.swing.JButton ambiente;
    private javax.swing.JButton back_from_view;
    private javax.swing.JButton bulb1;
    private javax.swing.JButton bulb2;
    private javax.swing.JButton bulb3;
    private javax.swing.JButton bulb4;
    private javax.swing.JButton bulb5;
    private javax.swing.JComboBox<String> color_list;
    private javax.swing.JEditorPane color_panel;
    private javax.swing.JSlider intensity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lectura;
    private javax.swing.JLabel light_text;
    private javax.swing.JCheckBox on_off;
    // End of variables declaration//GEN-END:variables
}
