# prise-bond-draw-bd
Bangladesh Bank Prise Bond Lottery Draw checking automation

### Build & make it ready
- Use maven command ```mvn clean compile```

### Steps to use : 
- You need to have any IDE (packaging with maven plugins is coming) 
- insert in your prisebond number in this file ```/src/main/resources/```
- Goto [APP](https://github.com/sarkershantonu/prise-bond-draw-bd/blob/main/src/main/java/org/automation/prisebond/App.java)
- Run This APP main class 
- You should see which prise bond number won the price and which is not in command line (result storing in file is coming)

### Optional 
There are two implementations, 
- ApacheClient
- JsoupClient

When you are running the APP, you can use any one of these. 
