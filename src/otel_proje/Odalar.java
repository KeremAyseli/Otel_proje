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
public class Odalar {
    enum oda_türleri{
        tek_kişilik(100),
        çift_kişilik_normal(200),
        çift_kişilik_suit(500);
        private final int fiyat;
        oda_türleri(int fiyat){this.fiyat=fiyat;}
        public int veriGonder(){return fiyat;}
        public static oda_türleri rastGeleTür(){
            Random rnd = new Random();
            return values()[rnd.nextInt(values().length)];
        }
    }
    
    enum oda_yönleri{
        güney(30),
        kuzey(0),
        doğu(20),
        batı(10);
        private final int fiyat;
        oda_yönleri(int fiyat){this.fiyat=fiyat;};
        public int fiyatıGönder(){return fiyat;}
        public static oda_yönleri rastgeleYön(){
            Random rnd =  new Random();
            return values()[rnd.nextInt(values().length)];
        }
    }
    public enum oda_tipleri{
        klasik(0),
        bungalov(50),
        ağaç_ev(90);
        private final int fiyat;
        oda_tipleri(int fiyat){this.fiyat=fiyat;};
        public int fiyatGönder(){return fiyat;};   
        public static oda_tipleri rastgeleTip(){
            Random rnd = new Random();
            return values()[rnd.nextInt(values().length)];
        }
    }
    public enum oda_durumları{
        kirli(false),
        temiz(true),
        tamirde(false),
        dolu(false),
        boş(true);
        private final boolean durum;
        oda_durumları(boolean durum){this.durum=durum;};
        public boolean odaDurumu(){return durum;};
    }
    oda_türleri oda_türü;
    oda_yönleri oda_yönü;
    oda_tipleri oda_tipi;
    oda_durumları oda_durumu; 
  public  String oda_ismi;
  public String oda_sahibi=null;
  public int oda_id;
    public Odalar(oda_türleri oda_türü,oda_yönleri oda_yönü,oda_tipleri oda_tipi,int oda_id){
        this.oda_türü=oda_türü;
        this.oda_yönü=oda_yönü;
        this.oda_tipi=oda_tipi;
        this.oda_id=oda_id;
     oda_ismi=oda_türü.name()+" "+oda_tipi.name();
     oda_durumu=oda_durumları.temiz;
   }
    public void odayıTanıt(){
        System.out.println("Oda türü :"+this.oda_türü.name()+" Oda yönü :"+this.oda_yönü.name()+" Oda tipi :"+this.oda_tipi.name());
        System.out.println("Oda fiyatı :"+(this.oda_tipi.fiyatGönder()+this.oda_yönü.fiyatıGönder()+this.oda_türü.veriGonder()));
    }

   
    public  String odaİsmiNe(){
        return oda_ismi;
    }
    public oda_durumları odaDurumu(){
        return this.oda_durumu;
    }
    public void OdayaGir(String müsteri_ismi)
    {
        this.oda_sahibi=müsteri_ismi;
    }
    public String OdaSahibi(){
        return oda_sahibi;
    }
    public int OdaFiyat(){
        return this.oda_tipi.fiyatGönder()+this.oda_yönü.fiyatıGönder()+this.oda_türü.veriGonder();
    }
    public int odaİd(){
        return oda_id;
    }
}
