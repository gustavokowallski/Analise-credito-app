# `analise-credito-app` | Serviço de Análise de Crédito Assíncrona

### **Descrição do Projeto**

Este é o segundo microsserviço da solução de análise de crédito. Ele é responsável por consumir as propostas de uma fila de mensageria, aplicar a lógica de negócio para a análise de risco e enviar o resultado de volta para o serviço de propostas. É o coração do sistema.

### **Funcionalidades**

* Consumir propostas de crédito da fila de mensageria (RabbitMQ).
* A análise de crédito é feita de forma randomica para cada proposta.
* Publicar o resultado da análise (aprovado ou negado) em outra fila.
* Implementar o padrão de projeto Strategy para gerenciar múltiplos algoritmos de análise.

### **🛠️ Tecnologias Utilizadas**

* **Linguagem:** Java 21
* **Framework:** Spring Boot
* **Mensageria:** RabbitMQ
* **Banco de Dados:** PostgreSQL
* **Contêineres:** Docker

### **Arquitetura de Comunicação**

Este microsserviço atua como um **`Consumer`** de propostas e como um **`Producer`** do resultado da análise, se comunicando de forma assíncrona com o serviço `proposta-app` através de filas no RabbitMQ.

