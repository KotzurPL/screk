package pl.kotzur.screkapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.kotzur.screkapp.model.TabelaTestowa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TabelaTestowaDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TabelaTestowaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getColumnNames() {
        String query = "SELECT column_name FROM information_schema.columns WHERE table_name = 'tabela_testowa'";
        List<Map<String, Object>> lm = jdbcTemplate.queryForList(query);
        List<String> listS = new ArrayList<>();
        for (Map<String, Object> pos: lm) {
            String cn = pos.get("column_name").toString();
            listS.add(cn);
        }
        return listS;
    }

    public List<TabelaTestowa> showAll() {
        String query = "SELECT * FROM tabela_testowa";
        List<Map<String, Object>> lm = jdbcTemplate.queryForList(query);
        List<TabelaTestowa> listTT = new ArrayList<>();
        for (Map<String, Object> pos: lm) {
            long id = (long) pos.get("id");
            String kol1 = pos.get("kolumna1").toString();
            String kol2 = pos.get("kolumna2").toString();
            String kol3 = pos.get("kolumna3").toString();
            long kol4 = (long) pos.get("kolumna4");
            TabelaTestowa tt = new TabelaTestowa(id, kol1, kol2, kol3, kol4);
            listTT.add(tt);
        }
        return listTT;
    }

    public List<TabelaTestowa> showByColumnAndType(String colName, String type) {
        String sign = "";
        if (type.equals("D")) {
            sign = ">";
        } else if (type.equals("U")) {
            sign = "=";
        }

        String query =
                "SELECT * " +
                "FROM tabela_testowa " +
                "WHERE " + colName + " in (" +
                    "SELECT " + colName+ " " +
                    "FROM tabela_testowa " +
                    "GROUP BY " + colName + " " +
                    "HAVING count(" + colName + ") " + sign + " 1" +
                ")";
        System.out.println(query);
        List<Map<String, Object>> lm = jdbcTemplate.queryForList(query);
        List<TabelaTestowa> listTT = new ArrayList<>();
        for (Map<String, Object> pos: lm) {
            long id = (long) pos.get("id");
            String kol1 = pos.get("kolumna1").toString();
            String kol2 = pos.get("kolumna2").toString();
            String kol3 = pos.get("kolumna3").toString();
            long kol4 = (long) pos.get("kolumna4");
            TabelaTestowa tt = new TabelaTestowa(id, kol1, kol2, kol3, kol4);
            listTT.add(tt);
        }
        return listTT;
    }

}
