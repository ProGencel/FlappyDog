# 🐶 Flappy Dog - Java Swing Edition

![Java Version](https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-green?style=for-the-badge)
![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)

Java Swing kütüphanesi kullanılarak geliştirilmiş, efsanevi Flappy Bird oyunundan esinlenen **Flappy Dog**, modern, optimize edilmiş ve Nesne Yönelimli Programlama (OOP) prensiplerine sadık kalınarak yazılmış bir oyundur.

Bu proje; oyun döngüsü (Game Loop), özel çizim (Custom Painting) ve çarpışma algılama (Collision Detection) mekaniklerini göstermek amacıyla geliştirilmiştir.

---

## 🎥 Önizleme (Demo)

Oyunun akıcı mekaniklerini aşağıda görebilirsiniz:

<img width="958" height="479" alt="Flappy Dog Gameplay" src="https://github.com/user-attachments/assets/c5c57516-64ca-40f6-acac-803b09b3bae1" />

---

## 🎮 Nasıl Oynanır? (Controls)

Oyun mekaniği tamamen refleks ve zamanlama üzerine kuruludur.

| Tuş | İşlev | Açıklama |
| :---: | :--- | :--- |
| **SPACE** | <kbd>Boşluk</kbd> | Köpeği zıplatır (Jump). Yerçekimine karşı koymak için kullanılır. |
| **R** | <kbd>R</kbd> | Oyun bittiğinde (Game Over) oyunu anında yeniden başlatır. |

---

## 🚀 Özellikler

* ✅ **Java 25 Mimarisi:** En güncel Java sürümü ile geliştirilmiştir.
* ⚡ **Akıcı Fizik Motoru:** Gerçekçi yerçekimi ve zıplama hissiyatı.
* ⚖️ **Affedici Hitbox Sistemi (Forgiving Hitboxes):** Daha akıcı ve adil bir oyun deneyimi sunmak için çarpışma alanları (collision boxes) görselden hafifçe daha küçük ayarlanmıştır.
* 📊 **Skor Sistemi:** Anlık skor takibi ve oyun sonu ekranı.
* 🎨 **Swing Graphics2D:** Yüksek performanslı 2D çizim teknikleri.

---

## 📥 İndir ve Oyna (Hazır Sürüm)

Kodlarla uğraşmadan oyunu hemen oynamak için **[Releases (Sürümler)](https://github.com/ProGencel/FlappyDog/releases/latest)** sayfasına giderek işletim sisteminize uygun paketi indirebilirsiniz.

**Nasıl Çalıştırılır?**
İndirdiğiniz ZIP dosyasını klasöre çıkardıktan sonra:

* **🪟 Windows:** Klasör içindeki `StartWin.bat` dosyasına çift tıklayın.
* **🍎 macOS / 🐧 Linux:** Terminalden `StartMacLinux.sh` dosyasına yetki verip (`chmod +x`) çalıştırın.

> **🛠️ Geliştiriciler İçin:** Eğer sadece **`.jar`** dosyasına ihtiyacınız varsa, Releases kısmında `FlappyDog.jar` tek başına da sunulmuştur.

---

## 🛠️ Kurulum ve Çalıştırma (Build & Run)

Bu proje **Java 25** özelliklerini kullanmaktadır. Lütfen JDK sürümünüzün güncel olduğundan emin olun.

### Gereksinimler
* [Java Development Kit (JDK) 25](https://jdk.java.net/25/) veya üzeri.
* Git (Opsiyonel, klonlamak için).

### Yöntem 1: Terminal / Komut Satırı (Önerilen)

Herhangi bir IDE'ye bağımlı olmadan oyunu şu şekilde çalıştırabilirsiniz:

```bash
# 1. Repoyu klonlayın
git clone [https://github.com/ProGencel/FlappyDog.git](https://github.com/ProGencel/FlappyDog.git)

# 2. Proje dizinine girin
cd FlappyDog

# 3. Derleme klasörü oluşturun ve derleyin
mkdir -p bin
javac -d bin src/*.java

# 4. Oyunu başlatın
java -cp bin Main
