package visao.areaCliente;

import controle.areaCliente.ConsultarMedicamentosControle;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;
import modelo.Medicamento;

/*
 * ExemploJTable.java
 *
 * Created on 25 de Maio de 2004, 08:30
 */

/**
 *
 * @author  Almedson Ferreira
 */
public class ConsultarMedicamentos extends javax.swing.JFrame {
    
    /** Creates new form ExemploJTable */
    public ConsultarMedicamentos() {
        
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bAdd = new javax.swing.JPanel();
        pnTable = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButtonAdicionar = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldNomeMedicamento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jSpinnerQuantidade = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonFecharPedido = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelPrescrito = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setTitle("Exemplo JTable imasters");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        bAdd.setLayout(null);

        pnTable.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho"));
        pnTable.setLayout(new java.awt.GridLayout(1, 0));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Descrição", "Prescrito", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setResizable(true);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setResizable(true);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setResizable(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.setColumnSelectionAllowed(true);
        scrollTable.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        pnTable.add(scrollTable);

        bAdd.add(pnTable);
        pnTable.setBounds(20, 320, 710, 260);
        pnTable.getAccessibleContext().setAccessibleDescription("");

        jButtonAdicionar.setText("Adicionar ao carrinho");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });
        bAdd.add(jButtonAdicionar);
        jButtonAdicionar.setBounds(10, 280, 220, 23);

        bDelete.setText("Remover Item");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });
        bAdd.add(bDelete);
        bDelete.setBounds(740, 540, 130, 30);
        bAdd.add(jPanel1);
        jPanel1.setBounds(280, 230, 10, 10);

        jTextFieldNomeMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldNomeMedicamentoMouseClicked(evt);
            }
        });
        jTextFieldNomeMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeMedicamentoActionPerformed(evt);
            }
        });
        bAdd.add(jTextFieldNomeMedicamento);
        jTextFieldNomeMedicamento.setBounds(10, 70, 710, 20);

        jLabel1.setText("Nome Medicamento");
        bAdd.add(jLabel1);
        jLabel1.setBounds(10, 50, 120, 14);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        bAdd.add(jButtonBuscar);
        jButtonBuscar.setBounds(10, 100, 110, 23);

        jSpinnerQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));
        bAdd.add(jSpinnerQuantidade);
        jSpinnerQuantidade.setBounds(80, 250, 39, 20);

        jLabel3.setText("Quantidade:");
        bAdd.add(jLabel3);
        jLabel3.setBounds(10, 250, 80, 14);
        bAdd.add(jSeparator1);
        jSeparator1.setBounds(0, 130, 890, 10);
        bAdd.add(jSeparator2);
        jSeparator2.setBounds(0, 310, 880, 10);

        jButtonFecharPedido.setText("Fechar Pedido");
        jButtonFecharPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharPedidoActionPerformed(evt);
            }
        });
        bAdd.add(jButtonFecharPedido);
        jButtonFecharPedido.setBounds(20, 590, 160, 40);

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        bAdd.add(jButtonVoltar);
        jButtonVoltar.setBounds(550, 590, 130, 40);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição do medicamento"));

        jLabel4.setText("Nome:");

        jLabel5.setText("Descrição:");

        jLabel2.setText("Prescrito:");

        jLabelNome.setText("-");

        jLabelDescricao.setText("-");

        jLabelPrescrito.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelDescricao)
                    .addComponent(jLabelPrescrito))
                .addContainerGap(628, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelPrescrito))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        bAdd.add(jPanel2);
        jPanel2.setBounds(10, 140, 710, 100);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Comprar Medicamentos");
        bAdd.add(jLabel6);
        jLabel6.setBounds(280, 10, 190, 40);

        getContentPane().add(bAdd, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(899, 677));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // TODO add your handling code here:
        int[] l = table.getSelectedRows();
        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)table.getModel();

        for(int i = (l.length-1); i >= 0; --i)
        {
            Object nome = table.getModel().getValueAt(l[i], 0).toString();
            dtm.removeRow(l[i]);
            for (Pair<Medicamento, Integer> m : medicamentosQuantidadeCarrinho)
            {
                if (m.getKey().nome.equals(nome))
                    medicamentosQuantidadeCarrinho.remove(m);
            }
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)table.getModel();
        if (medicamentoBuscado != null){
            dtm.addRow(new Object[]{medicamentoBuscado.nome,medicamentoBuscado.descricao,medicamentoBuscado.prescrito,jSpinnerQuantidade.getValue()});
            medicamentosQuantidadeCarrinho.add(new Pair<Medicamento, Integer>(medicamentoBuscado, (Integer)jSpinnerQuantidade.getValue()));
            jLabelNome.setText("-");
            jLabelDescricao.setText("-");
            jLabelPrescrito.setText("-");
            medicamentoBuscado = null;
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        medicamentoBuscado = new ConsultarMedicamentosControle().buscarMedicamento(jTextFieldNomeMedicamento.getText());
        if (medicamentoBuscado != null){
            jLabelNome.setText(medicamentoBuscado.getNome());
            jLabelDescricao.setText(medicamentoBuscado.getDescricao());
            jLabelPrescrito.setText(medicamentoBuscado.getprescrito() ? "Sim" : "Não");
        }
        else{
            
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTextFieldNomeMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeMedicamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeMedicamentoActionPerformed

    private void jButtonFecharPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharPedidoActionPerformed
        this.setVisible(false);
        if (medicamentosQuantidadeCarrinho.size() > 0)
        {
            SelecionarFarmaciaPedido selecionarFarmaciaPedido = new SelecionarFarmaciaPedido(medicamentosQuantidadeCarrinho);
            selecionarFarmaciaPedido.setVisible(true);
        }
    }//GEN-LAST:event_jButtonFecharPedidoActionPerformed

    private void jTextFieldNomeMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNomeMedicamentoMouseClicked
        jLabelNome.setText("-");
        jLabelDescricao.setText("-");
        jLabelPrescrito.setText("-");
        medicamentoBuscado = null;
    }//GEN-LAST:event_jTextFieldNomeMedicamentoMouseClicked

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        this.setVisible(false);
        AreaCliente areaCliente = new AreaCliente();
        areaCliente.setVisible(true);
    }//GEN-LAST:event_jButtonVoltarActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new ConsultarMedicamentos().show();
    }
    private Medicamento medicamentoBuscado = null;
    private List<Pair<Medicamento, Integer>> medicamentosQuantidadeCarrinho = new LinkedList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bAdd;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonFecharPedido;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPrescrito;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinnerQuantidade;
    private javax.swing.JTextField jTextFieldNomeMedicamento;
    private javax.swing.JPanel pnTable;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    
}
