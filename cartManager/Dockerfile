
			#cartManager

#Installazione del sistema operativo e ambiente di esecuzione della nostra immagine dal Docker Hub
FROM openjdk:17-alpine

COPY ./target/cartManager-0.0.1-SNAPSHOT.jar .

EXPOSE 8084

ENV HISTORY_MANAGER_URL = http://history-manager-container:8084/historyManager/processOrder

CMD java -jar cartManager-0.0.1-SNAPSHOT.jar
