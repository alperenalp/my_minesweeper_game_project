/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev1_mayintarlasi;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ALPEREN
 */
public class Odev1_MayinTarlasi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //adım 1 oyun alani oluşturma

        int satir, sutun;
        Scanner scan = new Scanner(System.in);
        System.out.print("Satir sayisi girin: ");
        satir = scan.nextInt();
        System.out.print("Sutun sayisi girin: ");
        sutun = scan.nextInt();
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

        //adım 2 zorluk derecesi olusturma
        int zorlukDerecesi, mayinSatiri, mayinSutunu, mayinSayisi;
        int[][] mayinliYerler = new int[satir][sutun];
        System.out.println("Lütfen 20 ile 80 arasında zorluk derecesi giriniz: ");
        zorlukDerecesi = scan.nextInt();
        double zorluk = zorlukDerecesi * 0.01;
        mayinSayisi = (int) (satir * sutun * zorluk);
        Random rnd = new Random();
        for (int i = 0; i < mayinSayisi; i++) {
            mayinSatiri = rnd.nextInt(satir);
            mayinSutunu = rnd.nextInt(sutun);
            if (mayinliYerler[mayinSatiri][mayinSutunu] == 1) {
                try {
                    mayinliYerler[mayinSatiri - 1][mayinSutunu - 1] = 1;
                } catch (Exception e) {
                    System.out.println("hata=" + e);
                }
            } else {
                mayinliYerler[mayinSatiri][mayinSutunu] = 1;
            }
        }
        System.out.println("Mayinlar yerlestirildn");
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                System.out.print(mayinliYerler[i][j] + " ");
            }
            System.out.println("");
        }

        //adım 3 Oyunu oynama
        System.out.println("OYUN BAŞLASIN");
        int puan = 0;
        String[][] cevap = new String[satir][sutun];
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                cevap[i][j] = "*";
            }
        }
        while (true) {
            System.out.print("Lütfen oyun satir değerini giriniz: ");
            int cevapSatir = scan.nextInt();
            System.out.print("Lütfen oyun sutun değerini giriniz: ");
            int cevapSutun = scan.nextInt();
            if (mayinliYerler[cevapSatir][cevapSutun] == 1) {
                System.out.print("Oyun Bitti!!!\nToplam puanınız= " + puan + "\n");
                for (int i = 0; i < satir; i++) {
                    for (int j = 0; j < sutun; j++) {
                        System.out.print(mayinliYerler[i][j] + " ");
                    }
                    System.out.println("");
                }
                break;
            } 
            else {
                cevap[cevapSatir][cevapSutun] = "0";
                puan += 5;
                for (int i = 0; i < satir; i++) {
                    for (int j = 0; j < sutun; j++) {
                        System.out.print(cevap[i][j] + " ");
                    }
                    System.out.println("");
                }
            }
        }

    }
    
}
