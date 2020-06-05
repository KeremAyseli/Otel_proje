/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otel_proje;

import java.util.Random;


/**
 *
 * @author kerem ayseli
 */
public class Calisanlar {
    public enum konum{
        resepsiyonist(500),
        vale(300),
        belboy(600),
        temizlik_görevlisi(550),
        müdür(10000);
        private final int maas;
        konum(int maas){this.maas=maas;};
        public int maasNey(){
            return maas;
        }
          public static konum rastgeleKonum(){
            Random rnd = new Random();
            return values()[rnd.nextInt(values().length)];
        }
    }
  
    String isim;
    String soyisim;
    konum görev;
    int maas;
   private int para=2440;
    public Calisanlar(String isim,String soyisim,konum görev){
        System.out.println("Çalışan ismi: "+isim+" Çalışan soyismi: "+soyisim+" Çalışan konumu: "+görev.name()+" Çalışan maaşı: "+görev.maasNey());
        this.isim=isim;
        this.soyisim=soyisim;
        this.görev=görev;
        this.maas=görev.maasNey();
    }
    public void görevDeğistir(konum yeni_görev){
        görev=yeni_görev;
    }
    public String isminNey(){
        return isim;
    }
    public void maasZam(int zam){
        maas+=zam;
    }
   public void maasÖde(int maas){
      para+=maas;
   }
   protected int neKadarParanVar(){
       return para;
   }
}
