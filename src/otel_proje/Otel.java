/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otel_proje;

import java.util.ArrayList;
import java.util.Random;
import otel_proje.Odalar.oda_yönleri;
import otel_proje.Odalar.oda_tipleri;
import otel_proje.Odalar.oda_türleri;
import otel_proje.Odalar.oda_durumları;
import otel_proje.Calisanlar.konum;

/**
 *
 * @author kerem ayseli
 */

public class Otel {
     public ArrayList<Odalar>otelinOdaları=new ArrayList<Odalar>();
     public ArrayList<Calisanlar>calisanlar=new ArrayList<Calisanlar>();
     public ArrayList<String>müsteriler=new ArrayList<String>();
     private int kasa=100000;
      public String[]isimler={"kerem","cemre","melih","alperen","alp","ayşe","fatma","hayriye","cengiz","talha","gülce","nigar","nazlı","ümran","elanur"};
   public String[]soyisimler={"ayseli","engin","Tarcan","şimşek","yekta","akkavak","tosun","yılmaz","çelik","yazıcı","göçmen","ışık","sağdıç","genç"};
   Random rnd = new Random();
    oda_türleri oda_türü;
    oda_yönleri oda_yönü;
    oda_tipleri oda_tipi;
    oda_durumları oda_durumu; 
    public Otel(int oda_adet,int eleman_sayısı){
        for(int x=0;x<eleman_sayısı;x++){        
            Calisanlar isci = new Calisanlar(isimler[rnd.nextInt(isimler.length)],soyisimler[rnd.nextInt(soyisimler.length)],konum.rastgeleKonum());
            calisanlar.add(isci);      
        }
       for(int i=0;i<oda_adet;i++){
           Odalar oda =new Odalar(oda_türleri.rastGeleTür(),oda_yönleri.rastgeleYön(),oda_tipleri.rastgeleTip(),i);
           oda.odayıTanıt();
          otelinOdaları.add(oda);
       }

}
    public int bosOdalar(){
        int bos_oda_sayısı=0;
    for(int i=0;i<otelinOdaları.size();i++)
    {
        if(otelinOdaları.get(i).oda_durumu==oda_durumları.temiz&&otelinOdaları.get(i).oda_sahibi==null)
      bos_oda_sayısı++;    System.out.println( otelinOdaları.get(i).odaİsmiNe()+" oda_numarası: "+i); 
 
    }  
    return bos_oda_sayısı;
}
     public void odaTut(int oda_numarası,String müsteri_ismi){
         if(otelinOdaları.get(oda_numarası).oda_durumu==oda_durumu.temiz&&otelinOdaları.get(oda_numarası).oda_sahibi==null)
         { otelinOdaları.get(oda_numarası).OdayaGir(müsteri_ismi);
       otelinOdaları.get(oda_numarası).oda_durumu=oda_durumları.dolu; 
       kasa+=otelinOdaları.get(oda_numarası).OdaFiyat();
       müsteriler.add(müsteri_ismi);
       System.out.println(müsteri_ismi+" Odayı tuttu.Oda numarası: "+oda_numarası);
         }
         else
         {
             System.out.println("Oda dolu başka bir oda deneyiniz.");
         }
       
    }
     public void odaCik(int oda_numarası,String müsteri_ismi){
         otelinOdaları.get(oda_numarası).oda_durumu=oda_durumu.kirli;
         otelinOdaları.get(oda_numarası).oda_sahibi=null;
         müsteriler.remove(müsteri_ismi);
     }
     
     public void odaTemizle(int oda_numarası){
        otelinOdaları.get(oda_numarası).oda_durumu=oda_durumları.temiz;
         System.out.println("Oda Temzilendi "+oda_numarası);
     }
     
    public void odaOnar(int oda_numarası){
        otelinOdaları.get(oda_numarası).oda_durumu=oda_durumları.temiz;
        System.out.println("Oda tamir edildi "+oda_numarası);
    }
    public void odaGetir(oda_yönleri odaYön,oda_tipleri odaTip,oda_türleri odaTür){
        for(int i=0;i<otelinOdaları.size();i++)
        {
           
         int oran=0;   
                if(otelinOdaları.get(i).oda_tipi==odaTip)
                {
                    oran++;
                }
                if(otelinOdaları.get(i).oda_türü==odaTür)
                {
                    oran++;
                }
                if(otelinOdaları.get(i).oda_yönü==odaYön)
                {
                    oran++;
                }
               
            if(oran>=2&&otelinOdaları.get(i).oda_durumu==oda_durumları.temiz)
            {
                System.out.println("Uygun odalar "+otelinOdaları.get(i).odaİsmiNe()+" Numaralı oda :"+i);
            }
            
        }
    }
    public void maasÖde(){
        for(int i=0;i<calisanlar.size();i++)
        {
       calisanlar.get(i).maasÖde(calisanlar.get(i).görev.maasNey());
       kasa-=calisanlar.get(i).görev.maasNey();
 
        }
    }
    public int olanPara(){
        System.out.println("Olan para: "+kasa);
        return this.kasa;
    }
     public void oteldeOlanMüsteriler()
     {
         for(int i=0;i<otelinOdaları.size();i++)
         {  if(otelinOdaları.get(i).OdaSahibi()!=null)
             System.out.println(otelinOdaları.get(i).OdaSahibi()+" "+otelinOdaları.get(i).odaİd()+" no'lu odada.");
         }
     }
     public int dolulukOrani(){
       int doluluk_orani=((otelinOdaları.size()-bosOdalar())*100)/otelinOdaları.size();
         System.out.println("otel doluluk oranı: %"+doluluk_orani);
         return doluluk_orani;
     }
    
}
