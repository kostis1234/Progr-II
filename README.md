# Progr-II
Οδηγίες χρήσης.
1. Τρέχουμε την κλάση CreationOfFiles ώστε να δημιουργηθούν δύο txt files:usernames.txt & passwords.txt.
2.Τώρα είμαστε έτοιμοι να τρέξουμε την εφαρμογή μας μέσω του Controller .
3.Κάνουμε register,για τυχόν προβλήματα θα μας ενημερώσει η εφαρμογή καθοδόν(πχ αν χρησιμοποιείται ήδη το username).
4.Αφού κάνουμε εγγραφή έχουμε τις εξής δυνατότητες:να διαβάσουμε τυχόν μηνύματα και να στείλουμε μηνύματα.
5.Άμα τελειώσουμε την χρήση της εφαρμογής μπορούμε να αποσυνδεθούμε.
6.Η λειτουργία του like - από την στιγμή που μιλάμε για -chatting social media- περιορίζεται στα μηνύματα:
Άμα θέλει κάποιος user να κάνει Like σε ένα μήνυμα μπορεί αφού το διαβάσει να του κάνει like και ο user ο
οποίος δέχτηκε το Like θα το δει ως ένα νέο μήνυμα(με παρόμοιο τρόπο λειτουργούν τα like σε εφαρμογές όπως το TikTok).

MAVEN

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>groupId</groupId>
    <artifactId>uni</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>18</maven.compiler.source>
        <maven.compiler.target>18</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
</project>

Οδηγίες μεταγλώττισης:
javac CreationOfFiles.java & 
javac Controller.java

Οδηγίες εκτέλεσης:
java CreationOfFiles &
java Controller

Παρουσίασης δομής του repository:
Φάκελος:.idea 
Φάκελος:.src/main/java με περιεχόμενο τις κλάσεις και τον κώδικά μας
LICENSE για την πιστοποίηση του κώδικά μας
readMe με τεχνικές πληροφορίες του κώδικα
pom.xml αρχείο MAVEN

![umldiagramm](https://user-images.githubusercontent.com/117856133/212740652-82752e51-b523-44df-9b27-b046162f65e9.png)

Δομή δεδομένων:
Η αποθήκευση των δεδομένων μας γίνεται με χρήση φακέλων txt, ένα για τα usernames κι ένα για τα passwords(η δημιουργία γίνεται από την κλάση CreationOfFiles).Κατά την εγγρφή νέων users δημιουργείται μοναδικό txt κάθε user με όνομα φακέλου το όνομα του user.H χρήση των μοναδικών αυτών txt είναι για την αποστολή-ανάγνωση μηνυμάτων.



