# 🐦 Flappy Bird - Java Swing Edition

![Java Version](https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-green?style=for-the-badge)
![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)

Java Swing kütüphanesi kullanılarak geliştirilmiş, klasik Flappy Bird oyununun modern, optimize edilmiş ve Nesne Yönelimli Programlama (OOP) prensiplerine sadık kalınarak yazılmış bir klonudur.

Bu proje; oyun döngüsü (Game Loop), özel çizim (Custom Painting) ve çarpışma algılama (Collision Detection) mekaniklerini göstermek amacıyla geliştirilmiştir.

---

## 🎥 Önizleme (Demo)

Oyunun akıcı mekaniklerini aşağıda görebilirsiniz:

![Gameplay GIF](screenshots/gameplay.gif)

*(Ekran görüntüleri `screenshots` klasöründedir)*

---

## 🎮 Nasıl Oynanır? (Controls)

Oyun mekaniği tamamen refleks ve zamanlama üzerine kuruludur.

| Tuş | İşlev | Açıklama |
| :---: | :--- | :--- |
| **SPACE** | <kbd>Boşluk</kbd> | Kuşu zıplatır (Jump). Yerçekimine karşı koymak için kullanılır. |
| **ENTER** | <kbd>Enter</kbd> | Oyun bittiğinde (Game Over) oyunu anında yeniden başlatır. |

---

## 🚀 Özellikler

* ✅ **Java 25 Mimarisi:** En güncel Java sürümü ile geliştirilmiştir.
* ⚡ **Akıcı Fizik Motoru:** Gerçekçi yerçekimi ve zıplama hissiyatı.
* 🎯 **Piksel Hassasiyetinde Çarpışma:** Borulara ve zemine çarpma anında algılanır.
* 📊 **Skor Sistemi:** Anlık skor takibi ve oyun sonu ekranı.
* 🎨 **Swing Graphics2D:** Yüksek performanslı 2D çizim teknikleri.

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
git clone [https://github.com/](https://github.com/)[KULLANICI_ADIN]/flappy-bird-java.git

# 2. Proje dizinine girin
cd flappy-bird-java

# 3. Derleme klasörü oluşturun ve derleyin
mkdir -p bin
javac -d bin src/*.java

# 4. Oyunu başlatın (Ana sınıfınızın adı Main ise)
java -cp bin Main
