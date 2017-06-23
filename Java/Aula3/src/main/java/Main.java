public class Main {
    public static void main(String[] args) {
        
        //CidadeDaoImpl c = new CidadeDaoImpl();
        //Cidade cid = new Cidade();
        //cid.setId(5565L);
        //cid.setNome("Noya City");
       // cid.setIDEstado(12);
       // c.insert(cid);
       SQLUtilsImpl sui = new SQLUtilsImpl();
       sui.runFile("C:\\Users\\William\\Documents\\testarArquivo\\queryTeste.sql");
    }
}
