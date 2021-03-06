/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO.ComprobanteDAO;
import Vistas.Paneles.PanelEmisionComprobante;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;


/**
 *
 * @author MARIANA
 */
public class ControladorComprobante {
    
    PanelEmisionComprobante pec;
    DateFormat df = DateFormat.getDateInstance();
    
    public void setPanelEmisionComprobante(JInternalFrame jif) {
        this.pec = (PanelEmisionComprobante) jif;
    }
    
    public void insertarDatos() {
    
        String tipoComprobante = pec.jtfTipoComprobante.getSelectedItem().toString();
        int serie = Integer.parseInt(pec.jtfSerieComprobante.getText());
        int coorrelativo = Integer.parseInt(pec.jtfCorrelativoComprobante.getText());
        int igv = Integer.parseInt(pec.jtfIGV.getText());
        String fechaEmision = df.format(pec.jdcFechaEmisionComprobante.getDate());
        int codigoCliente = Integer.parseInt(pec.jtfDniRucCliente.getText());
        int codigoVenta = Integer.parseInt(pec.jtfCodigoVenta.getText());
        float subtotalComprobante = Float.parseFloat(pec.jtfSubtotalComprobante.getText());
        float totalComprobante = Float.parseFloat(pec.jtfTotalComprobante.getText());
              
        ComprobanteDAO comprobanteDao = new ComprobanteDAO();
        
        try {
            comprobanteDao.registrarDatosComprobante(tipoComprobante,serie,coorrelativo,igv,fechaEmision,codigoCliente,codigoVenta,subtotalComprobante,totalComprobante);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
}
