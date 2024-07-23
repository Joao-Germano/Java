import java.sql.*;

public class InserirRegistro {
    public static void main(String[] args) throws Exception {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlInserirRegistro = "insert into `db_texte`.`tbl_texte` (`nome`, `email`, `senha`) values ('Texte', 'texte@texte.texte', 'senhaTexte');";
            Statement stmSqlInserirRegistro = conexao.createStatement();
            stmSqlInserirRegistro.addBatch(strSqlInserirRegistro);
            stmSqlInserirRegistro.executeBatch();
            stmSqlInserirRegistro.close();        
            System.out.println("Registro inserido com sucesso !");
      } catch (Exception e) {
        System.out.println("Ops! Ocorreu o erro:" + e);
      }
    }
    
}