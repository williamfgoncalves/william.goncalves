import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest{

    @Test
    public void vestirArmaduouraDeixaArmaduraVestida()throws Exception{
        Saint milo = new GoldSaint("milo","Câncer");
        milo.vestirArmadura();
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception{
        Saint yuoga = new BronzeSaint ("Hyoga", "Andromeda");
        assertEquals(false, yuoga.getArmaduraVestida());
    }

    @Test
    public void verificaGenero()throws Exception{
        Saint groot = new BronzeSaint("Groot","Leão");
        assertEquals(Genero.NAO_INFORMADO, groot.getGenero());
    }

    @Test
    public void verificaSaintPodeAlterarGenero() throws Exception{
        Saint groot = new BronzeSaint("Groot","Aries");

        groot.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, groot.getGenero());  

        groot.setGenero(Genero.NAO_INFORMADO);
        assertEquals(Genero.NAO_INFORMADO, groot.getGenero());
    }

    @Test
    public void verificaSaintNasceVIVO()throws Exception{
        Saint groot = new BronzeSaint("Groot","Capricornio");
        assertEquals(Status.VIVO, groot.getStatus()); 
    }

    @Test
    public void verificarSaintNasceCom100deVida()throws Exception{
        Saint Seya = new SilverSaint("Seya","DragonBorn");
        assertEquals(100.0, Seya.getVida(), 0.1);
    }

    @Test
    public void verificaPerdaVida16()throws Exception{
        Saint Seya = new SilverSaint("Seya","Virgem");
        Seya.perderVida(16.0);
        assertEquals(84.0, Seya.getVida(), 0.1);
    }

    @Test
    public void verificarSaintPerder100() throws Exception{
        Saint Seya = new SilverSaint("Seya","Touro");
        Seya.perderVida(100.0);
        assertEquals(0.0, Seya.getVida(), 0.1);
    }

    @Test
    public void verificarSaintPerder1000() throws Exception{
        Saint Seya = new SilverSaint("Seya","Andromeda");
        Seya.perderVida(1000.0);
        assertEquals(0, Seya.getVida(), 0.1);
    }

    @Test(expected=InvalidParameterException.class)
    public void verificarSaintPerder5000Negativos() throws Exception{
        Saint Seya = new SilverSaint("Seya","Libra");
        Seya.perderVida(-5000.0);
        assertEquals(5100.0, Seya.getVida(), 0.1);
    }

    @Test
    public void verificaSaintBronzeNasceComCincoSentidos()throws Exception{
        BronzeSaint Seya = new BronzeSaint("Seya", "Lyra");
        assertEquals(5, Seya.getQtdSentidosDespertados());
    }

    @Test
    public void verificaSaintPrataNasceComSeisSentidos()throws Exception{
        SilverSaint Seya = new SilverSaint("Seya","Sculum");
        assertEquals(6, Seya.getQtdSentidosDespertados());
    }

    @Test
    public void verificaSaintOuroNasceComSeteSentidos()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        assertEquals(7, Seya.getQtdSentidosDespertados());
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaParaCategoriaOuro()throws Exception{
        Saint dino = new GoldSaint("Dino", "Dinossauro");
    }

    @Test
    public void verificaSaintPerdeVidaMorre()throws Exception{
        Constelacao sagitario = new Constelacao("Sagitário");
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Seya.perderVida(100);
        assertEquals(Status.MORTO, Seya.getStatus());
        assertEquals(0, Seya.getVida(), 0.1);
    }

    @Test
    public void verificaSaintMortoPerdeVida()throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Seya.perderVida(100);
        Seya.perderVida(100);
        assertEquals(Status.MORTO, Seya.getStatus());
        assertEquals(0, Seya.getVida(), 0.1);
    }

    @Test
    public void saintAprenderGolpeAdicionaNaLista() throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Golpe hadukem = new Golpe("Hadukem", 20);
        Seya.aprenderGolpes(hadukem);
        assertEquals(hadukem, Seya.getArmadura().getConstelacao().getGolpes().get(0));
    }

    @Test
    public void saintAprenderDoisGolpesAdicionaNaLista() throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Golpe hadukem = new Golpe("Hadukem", 20);
        Golpe chuteDoDragao = new Golpe("Chute Do Dragao", 35);
        Seya.aprenderGolpes(hadukem);
        Seya.aprenderGolpes(chuteDoDragao);
        assertEquals(hadukem, Seya.getArmadura().getConstelacao().getGolpes().get(0));
        assertEquals(chuteDoDragao, Seya.getArmadura().getConstelacao().getGolpes().get(1));
    }

    @Test
    public void saintAprenderTresGolpesAdicionaNaLista() throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Golpe hadukem = new Golpe("Hadukem", 20);
        Golpe chuteDoDragao = new Golpe("Chute Do Dragao", 35);
        Golpe socoDoDragao = new Golpe("Soco Do Dragao", 45);
        Seya.aprenderGolpes(hadukem);
        Seya.aprenderGolpes(chuteDoDragao);
        Seya.aprenderGolpes(socoDoDragao); 
        assertEquals(hadukem, Seya.getArmadura().getConstelacao().getGolpes().get(0));
        assertEquals(chuteDoDragao, Seya.getArmadura().getConstelacao().getGolpes().get(1));
        assertEquals(socoDoDragao, Seya.getArmadura().getConstelacao().getGolpes().get(2));
    }

    @Test
    public void saintAprenderQuatroGolpesAdicionaNaLista() throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Golpe hadukem = new Golpe("Hadukem", 20);
        Golpe chuteDoDragao = new Golpe("Chute Do Dragao", 35);
        Golpe socoDoDragao = new Golpe("Soco Do Dragao", 45);
        Golpe explosaoDeFogo = new Golpe("Explosao De Fogo", 20);
        Seya.aprenderGolpes(hadukem);
        Seya.aprenderGolpes(chuteDoDragao);
        Seya.aprenderGolpes(socoDoDragao);
        Seya.aprenderGolpes(explosaoDeFogo);
        assertEquals(hadukem, Seya.getArmadura().getConstelacao().getGolpes().get(0));
        assertEquals(chuteDoDragao, Seya.getArmadura().getConstelacao().getGolpes().get(1));
        assertEquals(socoDoDragao, Seya.getArmadura().getConstelacao().getGolpes().get(2));
        assertEquals(explosaoDeFogo, Seya.getArmadura().getConstelacao().getGolpes().get(3));
    }

    @Test
    public void saintProximoGolpeCorretoComUmaRequisicoes() throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Golpe hadukem = new Golpe("Hadukem", 20);
        Seya.aprenderGolpes(hadukem);
        assertEquals(hadukem, Seya.getProximoGolpe());
    }

    @Test
    public void saintProximoGolpeCorretoComDuasRequisicoes() throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Golpe hadukem = new Golpe("Hadukem", 20);
        Golpe kamehameha = new Golpe("kamehameha", 80);
        Seya.aprenderGolpes(hadukem);
        Seya.aprenderGolpes(kamehameha);
        assertEquals(hadukem, Seya.getProximoGolpe());
        assertEquals(kamehameha, Seya.getProximoGolpe());
    }

    @Test
    public void saintProximoGolpeCorretoComTresRequisicoes() throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Golpe hadukem = new Golpe("Hadukem", 20);
        Golpe kamehameha = new Golpe("kamehameha", 80);
        Golpe meteoroPegaso = new Golpe("Meteoro Pegaso", 90);
        Seya.aprenderGolpes(hadukem);
        Seya.aprenderGolpes(kamehameha);
        Seya.aprenderGolpes(meteoroPegaso);
        assertEquals(hadukem, Seya.getProximoGolpe());
        assertEquals(kamehameha, Seya.getProximoGolpe());
        assertEquals(meteoroPegaso, Seya.getProximoGolpe());
    }

    @Test
    public void saintProximoGolpeCorretoComQuatroRequisicoes() throws Exception{
        GoldSaint Seya = new GoldSaint("Seya","Sagitário");
        Golpe hadukem = new Golpe("Hadukem", 20);
        Golpe kamehameha = new Golpe("kamehameha", 80);
        Golpe meteoroPegaso = new Golpe("Meteoro Pegaso", 90);
        Seya.aprenderGolpes(hadukem);
        Seya.aprenderGolpes(kamehameha);
        Seya.aprenderGolpes(meteoroPegaso);
        assertEquals(hadukem, Seya.getProximoGolpe());
        assertEquals(kamehameha, Seya.getProximoGolpe());
        assertEquals(meteoroPegaso, Seya.getProximoGolpe());
        assertEquals(hadukem, Seya.getProximoGolpe());
    }

    @Test
    public void getCSV()throws Exception{
        Saint Goku = new GoldSaint("Goku","Áries");
        String esperado = "Goku,100.0,Áries,OURO,VIVO,NAO_INFORMADO,false";
        assertEquals(esperado, Goku.getCSV());
    }

    @Test
    public void getCSVComGeneroTrocado()throws Exception{
        Saint Goku = new GoldSaint("Goku","Áries");
        Goku.setGenero(Genero.FEMININO);
        String esperado = "Goku,100.0,Áries,OURO,VIVO,FEMININO,false";
        assertEquals(esperado, Goku.getCSV());
    }

    @Test
    public void getCSVComPerdeVida()throws Exception{
        Saint Goku = new GoldSaint("Goku","Áries");
        Goku.perderVida(16.0);
        String esperado = "Goku,84.0,Áries,OURO,VIVO,NAO_INFORMADO,false";
        assertEquals(esperado, Goku.getCSV());
    }

    @Test
    public void getCSVComNomeNulo()throws Exception{
        Saint Goku = new GoldSaint(null,"Áries");
        String esperado = "null,100.0,Áries,OURO,VIVO,NAO_INFORMADO,false";
        assertEquals(esperado, Goku.getCSV());
    }

    @Test
    public void proximoMovimentoManeiraCircular()throws Exception{
        GoldSaint Aldeibaran = new GoldSaint("Aldeibaran", "Touro");
        GoldSaint Shiryu = new GoldSaint("Shiryu", "Libra");
        Golpe Hadukem = new Golpe("Hadukem", 10);
        Aldeibaran.aprenderGolpes(Hadukem);

        Golpear lutchaLibre = new Golpear (Aldeibaran, Shiryu);
        Aldeibaran.adicionarMovimento(lutchaLibre);
        Aldeibaran.getProximoMovimento().executar();
        assertEquals(90.0,Shiryu.getVida(),0.1);

        VestirArmadura colocaCasaco = new VestirArmadura(Aldeibaran);
        Aldeibaran.adicionarMovimento(colocaCasaco);
        Aldeibaran.getProximoMovimento().executar();
        assertEquals(true,Aldeibaran.getArmaduraVestida());

        Aldeibaran.getProximoMovimento().executar();
        assertEquals(50.0,Shiryu.getVida(),0.1);
    }

    @Test
    public void verificarQuantidadeDeSaints()throws Exception{
        int saintsAtuais = Saint.getQuantidadeDeSaints();
        Saint seya = new GoldSaint("Seya","Touro");
        Saint Aldebaran = new GoldSaint("Aldebaran","Touro");
        Saint Ikki = new BronzeSaint("Seya","Andromeda");
        assertEquals(saintsAtuais+3, Saint.getQuantidadeDeSaints());
    }

    @Test
    public void verificarQuantidadeDeSaintsSemAdicionarSaint()throws Exception{
        int saintsAtuais = Saint.getQuantidadeDeSaints();
        assertEquals(saintsAtuais, Saint.getQuantidadeDeSaints());
    }

    @Test
    public void verificarSaintNasceComIdAdicionarApenasUmNovoSaints()throws Exception{
        int saintsAtuais = Saint.getQuantidadeDeSaints();
        Saint seya = new GoldSaint("Seya","Touro");
        assertEquals(saintsAtuais+1, seya.getId());
    }
    
    @Test
    public void verificarSaintNasceComId()throws Exception{
        int saintsAtuais = Saint.getQuantidadeDeSaints();
        Saint seya = new GoldSaint("Seya","Touro");
        Saint Aldebaran = new GoldSaint("Aldebaran","Touro");
        Saint Ikki = new BronzeSaint("Seya","Andromeda");
        assertEquals(saintsAtuais+1, seya.getId());
        assertEquals(saintsAtuais+2, Aldebaran.getId());
        assertEquals(saintsAtuais+3, Ikki.getId());
    }

}