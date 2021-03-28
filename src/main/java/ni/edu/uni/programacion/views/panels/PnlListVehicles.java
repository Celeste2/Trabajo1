/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views.panels;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.VehicleSubModel;
import ni.edu.uni.programacion.controllers.PnlListVehicleController;
import ni.edu.uni.programacion.controllers.PnlVehicleController;

/**
 *
 * @author jahp0
 */
public class PnlListVehicles extends javax.swing.JPanel {

    /**
     * Creates new form PnlListVehicles
     */
    private Gson gson;
    private JsonVehicleDaoImpl jvdao;
    private List<VehicleSubModel> vehicleSubModels;
    
    private static final Logger logger = Logger.getLogger(PnlListVehicles.class.getName());

    public PnlListVehicles() {
        initComponents();
        try {
        llenartabla();
        }
        catch (Exception e) 
        {
            logger.severe("Ocurrio un error".concat(e.toString()));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Digite el texto a buscar:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
        PnlListVehicleController cont= new PnlListVehicleController();
        if (jTextField1.getText().length()>0)
             filtrar(jTextField1.getText());
             jTable1.repaint();
        }
        catch (Exception e)
        {
            logger.severe("Ocurrio una exception".concat(e.toString()));
            JOptionPane.showMessageDialog(jButton1, e.toString());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public void llenartabla() throws FileNotFoundException {
        try {
//            gson = new Gson();
//            jvdao = new JsonVehicleDaoImpl();
//            JsonReader jreader = new JsonReader(new BufferedReader(
//                    new InputStreamReader(getClass().getResourceAsStream("/jsons/vehicleData.json"))
//            ));
//
//            Type listType = new TypeToken<ArrayList<VehicleSubModel>>() {
//            }.getType();
//            vehicleSubModels = gson.fromJson(jreader, listType);
PnlListVehicleController cont = new PnlListVehicleController();
vehicleSubModels = cont.listartodos();
         
            
            //[{"make":"Pontiac","model":"Grand Am","year":1986,"color":"Fuscia"},
            String[] Columnas={"Make", "Model", "Year", "Color"};
            DefaultTableModel tabla = new DefaultTableModel();
            for (String i : Columnas)
                tabla.addColumn(i);
            
            
                        
            
            for (VehicleSubModel m :vehicleSubModels) 
            {
                Object[] item = {m.getMake(), m.getModel(), m.getYear(), m.getColor()};
               tabla.addRow(item);
               // logger.info(m.toString());
            }
            this.jTable1.setModel(tabla);

        } catch (Exception e) {
            logger.severe("Ocurrio una exepcion".concat(e.toString()));
            throw new RuntimeException(e);
        }
    }

      public void filtrar(String filtro) throws FileNotFoundException {
        try {
//            gson = new Gson();
//            jvdao = new JsonVehicleDaoImpl();
//            JsonReader jreader = new JsonReader(new BufferedReader(
//                    new InputStreamReader(getClass().getResourceAsStream("/jsons/vehicleData.json"))
//            ));
//
//            Type listType = new TypeToken<ArrayList<VehicleSubModel>>() {
//            }.getType();
//            vehicleSubModels = gson.fromJson(jreader, listType);
PnlListVehicleController cont = new PnlListVehicleController();
vehicleSubModels = cont.ListaFiltrada(filtro);
logger.info("Se encontraron ".concat(Integer.toString(vehicleSubModels.size())));
            
            
            //[{"make":"Pontiac","model":"Grand Am","year":1986,"color":"Fuscia"},
            String[] Columnas={"Make", "Model", "Year", "Color"};
            DefaultTableModel tabla = new DefaultTableModel();
            for (String i : Columnas)
                tabla.addColumn(i);
            
            
                        
            
            for (VehicleSubModel m :vehicleSubModels) 
            {
                Object[] item = {m.getMake(), m.getModel(), m.getYear(), m.getColor()};
               tabla.addRow(item);
             //   logger.info(m.toString());
            }
            if (vehicleSubModels.size()==0)
                JOptionPane.showMessageDialog(jButton1, "¡No existen datos para ese criterio!");
            logger.info("Datos filtrados son".concat(Integer.toString(vehicleSubModels.size())));
            tabla.fireTableDataChanged();
            this.jTable1.setModel(tabla);
 
        } catch (Exception e) {
            logger.severe("Ocurrio una exepcion".concat(e.toString()));
            throw new RuntimeException(e);
        }
    }
    
    
    
}