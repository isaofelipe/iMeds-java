package visao.areaCliente;

import controle.areaCliente.ConsultarMedicamentosControle;
import controle.areaCliente.SelecionarFarmaciaPedidoControle;
import dao.FarmaciaDAOJDBC;
import dao.FarmaciaMedicamentoDAOJDBC;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelo.Farmacia;
import modelo.FarmaciaMedicamento;
import modelo.Medicamento;
import modelo.Pedido;
import tools.Sessao;
import tools.Utilidades;

/*
 * ExemploJTable.java
 *
 * Created on 25 de Maio de 2004, 08:30
 */

/**
 *
 * @author  Almedson Ferreira
 */
public class SelecionarFarmaciaPedido extends javax.swing.JFrame {
    
    /** Creates new form ExemploJTable */
    public SelecionarFarmaciaPedido() {
        initComponents();
        carregar();
        this.setLocationRelativeTo(null);
    }
    public SelecionarFarmaciaPedido(List<Pair<Medicamento, Integer>> medicamentosCarrinho) {
        this.medicamentosQuantidadeCarrinho = medicamentosCarrinho;
        initComponents();
        carregar();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        bAdd = new javax.swing.JPanel();
        pnTable = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        tableOrcamentos = new javax.swing.JTable();
        bSelecionarFarmacia = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonFecharPedido = new javax.swing.JButton();
        scrollTable1 = new javax.swing.JScrollPane();
        tableDetalhesPedido = new javax.swing.JTable();
        jPanelEnviarReceita = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonEnviarReceita = new java.awt.Button();

        fileChooser.setDialogTitle("Selecione o arquivo da receita");

        setTitle("Exemplo JTable imasters");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        bAdd.setLayout(null);

        pnTable.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho"));
        pnTable.setLayout(new java.awt.GridLayout(1, 0));

        tableOrcamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Farmácia", "Orçamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableOrcamentos.getColumnModel().getColumn(0).setPreferredWidth(150);
        tableOrcamentos.getColumnModel().getColumn(0).setResizable(false);
        tableOrcamentos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableOrcamentos.getColumnModel().getColumn(1).setResizable(true);
        tableOrcamentos.getTableHeader().setReorderingAllowed(false);
        tableOrcamentos.setColumnSelectionAllowed(true);
        scrollTable.setViewportView(tableOrcamentos);
        tableOrcamentos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        pnTable.add(scrollTable);

        bAdd.add(pnTable);
        pnTable.setBounds(10, 10, 710, 290);
        pnTable.getAccessibleContext().setAccessibleDescription("");

        bSelecionarFarmacia.setText("Selecionar Farmácia");
        bSelecionarFarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelecionarFarmaciaActionPerformed(evt);
            }
        });
        bAdd.add(bSelecionarFarmacia);
        bSelecionarFarmacia.setBounds(730, 250, 150, 40);
        bAdd.add(jPanel1);
        jPanel1.setBounds(280, 280, 10, 10);

        jButtonFecharPedido.setText("Fechar Pedido");
        jButtonFecharPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharPedidoActionPerformed(evt);
            }
        });
        bAdd.add(jButtonFecharPedido);
        jButtonFecharPedido.setBounds(20, 720, 160, 40);

        scrollTable1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes do Pedido"));

        tableDetalhesPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicamento", "Preço Unitário", "Quantidade", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollTable1.setViewportView(tableDetalhesPedido);
        tableDetalhesPedido.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        bAdd.add(scrollTable1);
        scrollTable1.setBounds(20, 320, 690, 250);

        jPanelEnviarReceita.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelEnviarReceita.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelEnviarReceita.setVisible(false);

        jLabel1.setText("Algum dos Medicamentos do Pedido necessitam de receita médica. Favor enviar a receita digitalizada:");

        buttonEnviarReceita.setLabel("Enviar Receita");
        buttonEnviarReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnviarReceitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEnviarReceitaLayout = new javax.swing.GroupLayout(jPanelEnviarReceita);
        jPanelEnviarReceita.setLayout(jPanelEnviarReceitaLayout);
        jPanelEnviarReceitaLayout.setHorizontalGroup(
            jPanelEnviarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnviarReceitaLayout.createSequentialGroup()
                .addGroup(jPanelEnviarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnviarReceitaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(jPanelEnviarReceitaLayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(buttonEnviarReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
        );
        jPanelEnviarReceitaLayout.setVerticalGroup(
            jPanelEnviarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnviarReceitaLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEnviarReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bAdd.add(jPanelEnviarReceita);
        jPanelEnviarReceita.setBounds(30, 580, 680, 120);

        getContentPane().add(bAdd, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(911, 822));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSelecionarFarmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelecionarFarmaciaActionPerformed
        // TODO add your handling code here:
        int l = tableOrcamentos.getSelectedRow();
        farmaciaSelecionada = new FarmaciaDAOJDBC().buscarPorNome(tableOrcamentos.getModel().getValueAt(0, l).toString());
        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tableDetalhesPedido.getModel();
        listaFarmaciaMedicamento.clear();
        dtm.setRowCount(0);
        for (Pair<Medicamento, Integer> medicamentosQuantidade : medicamentosQuantidadeCarrinho)
        {
            FarmaciaMedicamento farmaciaMedicamento = new FarmaciaMedicamentoDAOJDBC().buscarPorIds(medicamentosQuantidade.getKey().getIdMedicamento(), farmaciaSelecionada.getIdFarmacia());
            listaFarmaciaMedicamento.add(farmaciaMedicamento);
            dtm.addRow(new Object[]{medicamentosQuantidade.getKey().getNome(), farmaciaMedicamento.getPreco(), medicamentosQuantidade.getValue(), farmaciaMedicamento.getPreco()*medicamentosQuantidade.getValue()});
        }
    }//GEN-LAST:event_bSelecionarFarmaciaActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void jButtonFecharPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharPedidoActionPerformed
        if (farmaciaSelecionada != null && (!pedido.getRequerReceita() || (!pedido.getRequerReceita() && arquivo != null))){
            JOptionPane.showMessageDialog(null, "Compra realizada com sucesso", "Sucesso", JOptionPane.PLAIN_MESSAGE, UIManager.getIcon("OptionPane.informationIcon"));
            pedido.setData(new Date());
            pedido.setFarmacia(farmaciaSelecionada);
            if (pedido.getRequerReceita())
            {
                try{
                    pedido.setImagemReceita(new javax.sql.rowset.serial.SerialBlob(Utilidades.lerArquivo(arquivo.getPath())));
                    
                    ConsultarPedidosCliente consultarPedidosCliente = new ConsultarPedidosCliente();
                    this.setVisible(false);
                    consultarPedidosCliente.setVisible(true);
                }
                catch (IOException e){
                    System.out.println(e.getMessage());
                }
                catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
            new SelecionarFarmaciaPedidoControle().fecharPedido(pedido, medicamentosQuantidadeCarrinho, listaFarmaciaMedicamento);
        }
    }//GEN-LAST:event_jButtonFecharPedidoActionPerformed

    private void buttonEnviarReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnviarReceitaActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            arquivo = fileChooser.getSelectedFile();
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_buttonEnviarReceitaActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new SelecionarFarmaciaPedido().show();
    }
    
    private Medicamento medicamento;
    private List<Pair<Medicamento, Integer>> medicamentosQuantidadeCarrinho;
    private List<FarmaciaMedicamento> listaFarmaciaMedicamento = new LinkedList<>();
    private Farmacia farmaciaSelecionada = null;
    private File arquivo = null;
    private Pedido pedido = new Pedido(Sessao.clienteLogado, Pedido.ABERTO);
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bAdd;
    private javax.swing.JButton bSelecionarFarmacia;
    private java.awt.Button buttonEnviarReceita;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButtonFecharPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelEnviarReceita;
    private javax.swing.JPanel pnTable;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JScrollPane scrollTable1;
    private javax.swing.JTable tableDetalhesPedido;
    private javax.swing.JTable tableOrcamentos;
    // End of variables declaration//GEN-END:variables
    void carregar() {
        Map<String, Double> orcamentos = new SelecionarFarmaciaPedidoControle().obterOrcamentos(medicamentosQuantidadeCarrinho);
        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tableOrcamentos.getModel();
        for (Map.Entry<String, Double> orcamento : orcamentos.entrySet())
        {
            dtm.addRow(new Object[]{orcamento.getKey(), orcamento.getValue()});
        }
        for (Pair<Medicamento, Integer> medicamentoQuantidade : medicamentosQuantidadeCarrinho){
            if (medicamentoQuantidade.getKey().getprescrito()){
                jPanelEnviarReceita.setVisible(true);
                pedido.setRequerReceita(true);
            }
        }
    }
}
