package utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;//properties sınıfını static olarak tanımladık ve static bloğunda properties sınıfından bir obje.
//bu değişken yapılandırma dosyasındaki değişkenleri depolayacak.
    static {
        String dosyaYolu= "configurations.properties"; //config.properties dosyasının yolunu tanımladık
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu); //path yolu.
            properties = new Properties();
            try { //yapılandırma dosyasını yüklediğimiz blok.
                properties.load(fis);
            } catch (IOException e) {
                throw new RuntimeException(e); //doğru yüklenemezse bir hata mesajı verdik.
            }

        } catch (FileNotFoundException e) {
            System.out.println("properties dosyası bulunamadı: " + dosyaYolu); //dosya yolu bulunamadıysa hata mesajı verdik.

        }
    }

   public static String getProperty(String key){
        return properties.getProperty(key); //verilen anahtarın karşılık gelen değerini döndüren metod.
   }


}
