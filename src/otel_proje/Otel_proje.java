/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otel_proje;

/**
 *
 * @author kerem ayseli
 */
public class Otel_proje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Otel otel =new Otel(10,10);
        otel.bosOdalar();
        otel.odaTut(6,"Mehmet bey ve aylesi");
        System.out.println("******YENİ DURUM******");
        otel.bosOdalar();
        otel.odaTemizle(6);
        otel.odaGetir(Odalar.oda_yönleri.doğu, Odalar.oda_tipleri.klasik, Odalar.oda_türleri.tek_kişilik);
        otel.odaTut(7, "Ali bey");
        System.out.println("Boş odalar");
        otel.bosOdalar();
        otel.olanPara();
        System.out.println("Elemanların Paraları");
        otel.maasÖde();
        System.out.println("Kasada kalan para");
        otel.olanPara();
         System.out.println("Otelde olan müşteriler");
        otel.oteldeOlanMüsteriler();
        otel.odaTut(9, "Merhaba ");
        otel.dolulukOrani();
    }
    
}
