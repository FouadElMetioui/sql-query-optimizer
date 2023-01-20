package ma.fstt.service;

import ma.fstt.entities.planexe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Metier {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    String Tablename;
    ArrayList<String> columns;
    String index_name;

    public Metier() {
        columns = new ArrayList<>();
    }

    public List<planexe> getPlanExe(String sql) {
        List<Map<String, Object>> requestes = getXplanDisplay(sql);

        int i = 0;
        List ind = new ArrayList<Integer>();
        List plan = new ArrayList<planexe>();
        outerloop:
        for (Map<String, Object> mp : requestes) {
            for (String key : mp.keySet()) {
                if (i > 4) {
                    if (mp.get(key).equals("Note") || (((String) mp.get(key)).length() == 1)) break outerloop;
                    if (!(((String) mp.get(key)).charAt(0) == '-')) {
                        int taille = ((String) mp.get(key)).length();
                        String ligne = (String) mp.get(key);

                        if (ind.size() < 8) {
                            for (int j = 0; j < taille; j++) {
                                String car = ligne.substring(j, j + 1);
                                if (car.equals("|")) ind.add(j);
                            }
                        }
                        planexe p = new planexe(ligne.substring((int) ind.get(0) + 1, (int) ind.get(1)).trim(), ligne.substring((int) ind.get(1) + 1, (int) ind.get(2)).trim(), ligne.substring((int) ind.get(2) + 1, (int) ind.get(3)).trim(), ligne.substring((int) ind.get(3) + 1, (int) ind.get(4)).trim(), ligne.substring((int) ind.get(4) + 1, (int) ind.get(5)).trim(), ligne.substring((int) ind.get(5) + 1, (int) ind.get(6)).trim(), ligne.substring((int) ind.get(6) + 1, (int) ind.get(7)).trim());
                        plan.add(p);
                    }
                }
            }
            i++;
        }
        return plan;
    }

    public List<planexe> getPlanOptimise(String sql) {
        this.division(sql + ";");
        this.index_name = this.createsIndexes(sql);
        return getPlanExeOptimise(sql);
    }

    public List<planexe> getPlanExeOptimise(String sql) {
        List<Map<String, Object>> requestes = getXplanDisplayOptimise(sql);
        int i = 0;
        List ind = new ArrayList<Integer>();
        List plan = new ArrayList<planexe>();
        outerloop:
        for (Map<String, Object> mp : requestes) {
            for (String key : mp.keySet()) {
                if (i > 4) {
                    if (mp.get(key).equals("Note") || (((String) mp.get(key)).length() == 1)) break outerloop;
                    if (!(((String) mp.get(key)).charAt(0) == '-')) {
                        int taille = ((String) mp.get(key)).length();
                        String ligne = (String) mp.get(key);

                        if (ind.size() < 8) {
                            for (int j = 0; j < taille; j++) {
                                String car = ligne.substring(j, j + 1);
                                if (car.equals("|")) ind.add(j);
                            }
                        }
                        planexe p = new planexe(ligne.substring((int) ind.get(0) + 1, (int) ind.get(1)).trim(), ligne.substring((int) ind.get(1) + 1, (int) ind.get(2)).trim(), ligne.substring((int) ind.get(2) + 1, (int) ind.get(3)).trim(), ligne.substring((int) ind.get(3) + 1, (int) ind.get(4)).trim(), ligne.substring((int) ind.get(4) + 1, (int) ind.get(5)).trim(), ligne.substring((int) ind.get(5) + 1, (int) ind.get(6)).trim(), ligne.substring((int) ind.get(6) + 1, (int) ind.get(7)).trim());
                        plan.add(p);
                    }
                }
            }
            i++;
        }
        System.out.println(plan);
        dropIndex();
        return plan;

    }

    public List<Map<String, Object>> getXplanDisplayOptimise(String sql) {
        getExplainOptimiser(sql);
        return jdbcTemplate.queryForList("select * from table (DBMS_XPLAN.DISPLAY)");
    }

    public void getExplainOptimiser(String sql) {
        String nouvsql = "";
        String[] words = sql.split(" ");
        for (String word : words) {
            if (";".equals(word)) break;
            String mot = word;
            if (";".equals(mot.substring(mot.length() - 1, mot.length()))) mot = mot.substring(0, mot.length() - 1);
            nouvsql += " " + mot;
            if (("select".equalsIgnoreCase(word))) {
                nouvsql += " /*+ INDEX( " + this.Tablename + " " + this.index_name + ")" + "*/";
            }
        }
        jdbcTemplate.queryForList("explain plan for " + nouvsql);
    }

    public String createsIndexes(String sql) {

        String index_A_creer = "";
        String columns_indexs = " ( ";
        this.division(sql + ";");
        for (String word : this.columns) {
            columns_indexs += word + ",";
        }
        columns_indexs = columns_indexs.substring(0, columns_indexs.length() - 1);
        columns_indexs += " ) ";
        index_A_creer = "CREATE INDEX " + this.Tablename + "_indexes " + " ON " + this.Tablename.toUpperCase() + columns_indexs;
        jdbcTemplate.queryForList(index_A_creer);
        return this.Tablename + "_indexes";
    }

    public void dropIndex() {
        jdbcTemplate.queryForList("DROP INDEX " + index_name);
    }

    public String suggestIndexes(String sql) {
        this.division(sql + ";");
        String index = "ALTER TABLE " + this.Tablename + " ADD INDEX  " + this.Tablename + "_Indexes" + "(";
        for (int i = 0; i < this.columns.size(); i++) {
            index += this.columns.get(i);
            if (this.columns.size() == i + 1) {
                index += ");";
                break;
            } else index += ", ";
        }
        return index;
    }


    public void division(String requete) {
        this.columns = new ArrayList<>();
        this.Tablename = "";
        String[] words = requete.split(" ");
        String str1 = "";
        ArrayList<String> srtArray1 = new ArrayList<String>();
        String str2 = "";
        ArrayList<String> srtArray2 = new ArrayList<String>();
        String str3 = "";
        ArrayList<String> srtArray3 = new ArrayList<String>();
        String str4 = "";
        ArrayList<String> columnsTemp = new ArrayList<String>();
        int nbr = 0;
        int nbr2 = 0;
        for (String word : words) {
            if (("from".equalsIgnoreCase(word))) {
                nbr = 1;
            }
            if ("where".equalsIgnoreCase(word)) {
                nbr = 2;
            }
            if (nbr == 0) {
                str1 += word + " ";
                srtArray1.add(word);
            }
            if (nbr == 1) {
                str2 += word + " ";
                srtArray2.add(word);
            }
            if (nbr == 2) {
                str3 += word + " ";
                srtArray3.add(word);
            }
        }

        for (String word : srtArray2) {
            if (nbr2 == 1) {
                this.Tablename = word;
                nbr2 = 0;
                break;
            }
            nbr2 = 1;
        }
        int nbrWhere = 1;
        for (String word : srtArray3) {
            if (word.equals("and") || word.equals("or")) {
                nbrWhere++;
            }
        }

        for (String word : srtArray3) {
            if ("and".equalsIgnoreCase(word) || "or".equalsIgnoreCase(word) || word.contains(";") || ";".equals(word)) {
                if (word.contains(";"))
                    str4 += word;
                columnsTemp.add(str4);
                str4 = "";
            } else {
                if ("where".equalsIgnoreCase(word)) {
                } else {
                    str4 += word + " ";
                }
            }
        }
        for (String word : columnsTemp) {
            columns.add(ExtractColumn(word));
        }

        Set<String> set = new HashSet<>(columns);
        columns.clear();
        columns.addAll(set);
    }

    public static String ExtractColumn(String mot) {
        String m = "";
        List cara = new ArrayList<String>();

        for (int i = 0; i < mot.length(); i++) {
            if (mot.substring(i, i + 1).equals("=") || mot.substring(i, i + 1).equals("<") || mot.substring(i, i + 1).equals(">") || mot.substring(i, i + 1).equals(" ")) {
                break;
            }
            cara.add(mot.substring(i, i + 1));
        }
        for (int i = 0; i < cara.size(); i++) {
            m += cara.get(i);
        }
        return m;
    }

    public int validateQuery(String request) {
        try {
            String str = request;
            if (request.charAt(request.length() - 1) == ';') {
                str = request.substring(0, request.length() - 1);
            }
            jdbcTemplate.execute(str);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public List<Map<String, Object>> getXplanDisplay(String sql) {
        getExplain(sql);
        return jdbcTemplate.queryForList("select * from table (DBMS_XPLAN.DISPLAY)");
    }

    public void getExplain(String sql) {
        jdbcTemplate.queryForList("explain plan for " + sql);
    }

    public List<Map<String, Object>> getResult(String sql) {
        return jdbcTemplate.queryForList(sql);
    }
}
