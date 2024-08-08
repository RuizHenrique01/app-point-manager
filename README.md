<h1 align="center">
App Point Manager
</h1>

Este repositório contém o código para o projeto **App Point Manager**, uma aplicação web desenvolvida com a estrutura **Nx** para gerenciar pontos de usuários em um sistema específico. 

**Funcionalidades:**

* **Gerenciamento de Usuários:** Permite adicionar, editar, excluir e visualizar usuários.
* **Gerenciamento de Pontos:** Permite adicionar, remover e consultar os pontos dos usuários.
* **Interface Web Interativa:** Fornece uma interface web amigável para interagir com as funcionalidades da aplicação.

**Tecnologias:**

* **Nx:** Framework de desenvolvimento para criar aplicações complexas, facilitando a organização de projetos multi-plataforma e a execução de tarefas em paralelo.
* **Angular:** Framework JavaScript para desenvolvimento web, conhecido por sua estrutura robusta, componentes reutilizáveis e capacidade de criar aplicações escaláveis e performantes.
* **Spring Boot:** Framework Java para desenvolvimento de aplicações back-end, simplificando a criação de serviços RESTful e APIs com configuração mínima.
* **Bootstrap:** Framework CSS para estilização de interfaces web, oferecendo componentes prontos e responsivos para criar layouts modernos e adaptáveis a diversos dispositivos.
* **TypeScript:** Linguagem de programação com tipagem estática, proporcionando segurança, organização e código mais fácil de entender e manter.
* **Java:** Linguagem de programação utilizada para o desenvolvimento do back-end da aplicação, aproveitando a robustez, performance e vasta comunidade da plataforma Java.

**Estrutura do Projeto:**

O projeto é dividido em dois módulos:

* **web-point-manager:** Interface web da aplicação desenvolvida com Angular e Bootstrap.
* **api-point-manager:** API RESTful desenvolvida com Spring Boot para gerenciar os dados.

**Instalação e Execução:**

1. **Clone o repositório:** 
```
git clone https://github.com/RuizHenrique01/app-point-manager.git
```
2. **Acesse o diretório do projeto:** 
```
cd app-point-manager
```
3. **Instale as dependências:** 
```
npm run install:all
```
4. **Execute a aplicação:** 
```
npm run start:all
```

**Scripts:**

O arquivo `package.json` define os seguintes scripts:

* **start:all** Inicia a aplicação web e a API.
* **install:all:** Instala as dependências dos módulos web e api.
* **start:api-point-manager:** Inicia apenas a API.
* **start:web-point-manager:** Inicia apenas a aplicação web.
