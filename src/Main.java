import javax.swing.*;

public class Main {

    static int gecerliSoru = 0;
    static int dogruSayisi = 0, yanlisSayisi = 0;

    public static void main(String[] args) {


        String[] sorular = {
                "Türkiyenin başkenti nersidir?",
                "İstiklal Marşımızın yazarı kimdir?",
                "Atatürk'ün nüfusa kayıtlı olduğu il hangisidir?",
                "Müslümanların kutsal günü hangisidir?",
                "Yüzölçümü en büyük olan ilimiz hangisidir?"
        };
        String[][] secenekler = {
                {"Bursa", "Erzurum", "Ankara", "Çanakkale", "Sivas"},
                {"Osman Zeki Üngör ", "Cemal Süreyya", "Atilla İlhan", "Mehmet Akif Ersoy"},
                {"Ankara", "Çanakkale", "İstanbul ", "Gaziantep"},
                {"Perşembe", "Cuma", "Pazar", "Salı"},
                {"Konya", "İstanbul", "Manisa", "Tunceli"}
        };
        String[] dogruCevaplar = {
                "C", "D", "D", "B", "A"
        };

        JFrame frame = new JFrame();
        frame.setSize(800, 500);


        JRadioButton aSecenegi = new JRadioButton(secenekler[0][0]);
        JRadioButton bSecenegi = new JRadioButton(secenekler[0][1]);
        JRadioButton cSecenegi = new JRadioButton(secenekler[0][2]);
        JRadioButton dSecenegi = new JRadioButton(secenekler[0][3]);
        JLabel soruMetni = new JLabel(sorular[0]);
        JButton sonrakiSoru = new JButton("SONRAKİ");

        aSecenegi.setBounds(110, 150, 300, 25);
        bSecenegi.setBounds(110, 200, 300, 25);
        cSecenegi.setBounds(110, 250, 300, 25);
        dSecenegi.setBounds(110, 300, 300, 25);
        soruMetni.setBounds(100, 70, 750, 50);
        sonrakiSoru.setBounds(650, 400, 120, 50);



        ButtonGroup secenek = new ButtonGroup();
        secenek.add(aSecenegi);
        secenek.add(bSecenegi);
        secenek.add(cSecenegi);
        secenek.add(dSecenegi);


        frame.add(aSecenegi);
        frame.add(bSecenegi);
        frame.add(cSecenegi);
        frame.add(dSecenegi);
        frame.add(soruMetni);
        frame.add(sonrakiSoru);


        sonrakiSoru.addActionListener(e -> {

            if (aSecenegi.isSelected() || bSecenegi.isSelected() || cSecenegi.isSelected() || dSecenegi.isSelected()) {
                String secim = null;
                if (aSecenegi.isSelected()) secim = "A";
                else if (bSecenegi.isSelected()) secim = "B";
                else if (cSecenegi.isSelected()) secim = "C";
                else if (dSecenegi.isSelected()) secim = "D";
                if(secim != null) {
                    if (secim.equals(dogruCevaplar[gecerliSoru])) {
                        dogruSayisi++;
                        JOptionPane.showMessageDialog(null, "Tebrikler! Doğru cevap verdiniz...", "Doğru Cevap", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!dogruCevaplar[gecerliSoru].equals(secim)) {
                        yanlisSayisi++;
                        JOptionPane.showMessageDialog(null, "Maalesef yanlış cevap verdiniz...\n Doğru cevap: " + dogruCevaplar[gecerliSoru] , "Yanlış Cevap...", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            gecerliSoru++;
            if (gecerliSoru == 4) {
                sonrakiSoru.setText("Sonuçlar");
            } else if (gecerliSoru == 5) {
                JOptionPane.showMessageDialog(null, "Oyun Bitti.\nDoğru Sayısı : " + dogruSayisi + "\nYanlış Sayısı : " + yanlisSayisi);
                System.exit(0);
            }

            soruMetni.setText(sorular[gecerliSoru]);
            aSecenegi.setText(secenekler[gecerliSoru][0]);
            bSecenegi.setText(secenekler[gecerliSoru][1]);
            cSecenegi.setText(secenekler[gecerliSoru][2]);
            dSecenegi.setText(secenekler[gecerliSoru][3]);

        });
        frame.setLayout(null);
        frame.setVisible(true);
    }
}