 import java.sql.*;

public class NavegadorDeRegistro {
    public static String[] primeiroRegistro(String db,String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        try{
        String strSqlPrimeiroRegistro = "select * from `" + db + "`.`" + tbl + "`order by `id` asc limit 1;";
        Statement stmSqlPrimeiroRegistro = conexao.createStatement();
        ResultSet rstSqlprimeiroRegistro = stmSqlPrimeiroRegistro.executeQuery(strSqlPrimeiroRegistro);
        rstSqlprimeiroRegistro.next();
        String[] resultado = {
            rstSqlprimeiroRegistro.getString("id"),
            rstSqlprimeiroRegistro.getString("nome"),
            rstSqlprimeiroRegistro.getString("email"),
            rstSqlprimeiroRegistro.getString("senha")
        };
            stmSqlPrimeiroRegistro.close();
            return resultado;
        } catch(Exception e) {
            return null;
        }
    }

    public static String[] ultimoRegistro(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        try{
        String strSqlUltimoRegistro = "select * from `" + db + "`.`" + tbl + "`order by `id` desc limit 1;";
        Statement stmSqlUltimoRegistro = conexao.createStatement();
        ResultSet rstSqlultimoRegistro = stmSqlUltimoRegistro.executeQuery(strSqlUltimoRegistro);
        rstSqlultimoRegistro.next();
        String[] resultado = {
            rstSqlultimoRegistro.getString("id"),
            rstSqlultimoRegistro.getString("nome"),
            rstSqlultimoRegistro.getString("email"),
            rstSqlultimoRegistro.getString("senha")
        };
        stmSqlUltimoRegistro.close();
        return resultado;
    }catch(Exception e) {
        return null;
    }

    } 

    public static String[] NextRegister(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        int idPerson = Integer.parseInt(id);
        int nextID = idPerson + 1;
        if (nextID >= 1) {
                String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` asc;";
                Statement stmNextRegister = conexao.createStatement();
                ResultSet rstSqlNextRegister = stmNextRegister.executeQuery(strSqlLastRegister);
                String[] result = {"", "", "", ""};

                while (rstSqlNextRegister.next()) {
                    if (id.equals(rstSqlNextRegister.getString("id"))) {
                        rstSqlNextRegister.next();
                        result[0] = rstSqlNextRegister.getString("id");
                        result[1] = rstSqlNextRegister.getString("nome");
                        result[2] = rstSqlNextRegister.getString("email");
                        result[3] = rstSqlNextRegister.getString("senha");
                        break;

                    }
                }
                rstSqlNextRegister.close();
                if (result[0] == "") {
                    return null;
                } else {
                    return result;
                }
        } else {
            return null;
        }
    }

    public static String[] anteriorRegistro(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        int idPessoa = Integer.parseInt(id);
        int proximoId = idPessoa - 1;
        if(proximoId >= 1) {
            String strSqlAnteriorRegistro = "select * from `" + db + "`.`" + tbl + "`order by `id` desc;";
            Statement stmSqlAnteriorRegistro = conexao.createStatement();
            ResultSet rstSqlanteriorRegistro = stmSqlAnteriorRegistro.executeQuery(strSqlAnteriorRegistro);
            String[] resultado = {"","","", ""};
            while (rstSqlanteriorRegistro.next()) {
            if (id.equals(rstSqlanteriorRegistro.getString("id"))) {
                rstSqlanteriorRegistro.next();
                resultado[0] = rstSqlanteriorRegistro.getString("id");
                resultado[1] = rstSqlanteriorRegistro.getString("nome");
                resultado[2] = rstSqlanteriorRegistro.getString("email");
                resultado[3] = rstSqlanteriorRegistro.getString("senha");
            break;
            }
            }
            stmSqlAnteriorRegistro.close();
            if (resultado[0] == ""){
                return null;
            } else {
                return resultado;
            }
        } else {
            return null;
        }
    }
}
