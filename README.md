# Mobile-Test-Automation-Poc-Java

# Projeto de Testes Mobile com Appium e JUnit

Este é um projeto de testes mobile para Android e iOS, utilizando Appium 2.2.2, JUnit Jupiter e Maven. O projeto inclui integração com Allure Report para geração de relatórios detalhados.

## Pré-requisitos

Certifique-se de ter os seguintes softwares instalados em seu sistema:

- Android SDK para testes em dispositivos Android
- Xcode e iOS Simulator ou dispositivo iOS para testes em dispositivos iOS

## Configuração do Ambiente / Projeto

1. Clone este repositório para o seu ambiente local.
2. Execute o script `checkDependencies.sh`
3. Siga a instrução do script! (Instalar o Intellij CE)
4. Abra o Intellij na pasta root deste repositório
5. Com o Intellij aberto, irá aparecer um warning no topo da janela (JDK is missing, clique em download)

## Execução dos Testes
Execute primeiramente o servidor appium num terminal
  ```bash
   appium
  ```
Aperte em `RUN` no topo direito do Intellij

#### Seu teste será executado!

## Geração de Relatórios com Allure

Este projeto está configurado para gerar relatórios detalhados com o Allure Report. Para gerar o relatório, siga estas etapas:

1. Instale o allure com o comando: 
```bash
  brew install allure
  ```
2. Após a execução dos testes, abra um terminal na raiz do projeto.
3. Execute o seguinte comando para gerar os relatórios:
```bash
  allure generate
  allure open
  ```

Isso irá gerar os relatórios na pasta `allure-report` e abrirá automaticamente o relatório no seu navegador padrão.


## Observação

Este projeto foi desenvolvido como uma Prova de Conceito (PoC) durante minha atuação em uma empresa na qual trabalhei. Ele demonstra uma solução técnica para um problema específico, não sendo um produto finalizado.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## Desenvolvedor

- **Carlos Bonfatti**  
  [LinkedIn](https://www.linkedin.com/in/carlosbonfatti)  
  Email: carlos@gmail.com

