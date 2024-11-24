# Calculadora Kotlin

Este é um projeto de calculadora simples desenvolvida em Kotlin para Android. 
Ele permite realizar operações matemáticas básicas como soma, subtração, multiplicação, divisão, além de suportar funções como cálculo de porcentagem, parênteses e mais.

## Tecnologias

- **Kotlin**: Linguagem principal do projeto.
- **Android SDK**: Utilizado para o desenvolvimento da interface gráfica e interação com o usuário.

## Funcionalidades

- **Entrada de números e operações**: O usuário pode inserir números e operadores para realizar cálculos.
- **Exibição de resultados**: O resultado da operação é exibido na tela.
- **Funções adicionais**:
  - Limpar a tela (`C`).
  - Função de retroceder (`⌫`).
  - Cálculo de porcentagem (`%`).
  - Utilização de parênteses para agrupar operações.
  - Botões para números de 0 a 9 e operadores (+, -, ×, ÷).

## Tela Inicial

A interface principal é dividida em duas seções:

1. **Área de Exibição**: Mostra os números inseridos e o resultado da operação.
2. **Botões de Entrada**: Uma matriz de botões para números e operações matemáticas.

## Estrutura do Projeto

### Arquivos principais:

- **MainActivity.kt**: Contém a lógica do aplicativo, como manipulação dos eventos dos botões e exibição de resultados.
- **activity_main.xml**: Layout da interface do usuário, onde os botões e a área de exibição são definidos.

### activity_main.xml (Layout da Interface)

A interface foi projetada com o seguinte:

- **LinearLayout**: Organiza os elementos de forma vertical.
- **GridLayout**: Organiza os botões em uma grade de 4 colunas e 5 linhas, representando os números e operações.
- **EditText**: Exibe os números e resultados de forma desabilitada para entrada, sendo somente para visualização.

### MainActivity.kt (Lógica)

A lógica da calculadora está definida em **MainActivity.kt**, onde cada botão é manipulado para realizar a operação matemática correspondente. O texto exibido é atualizado conforme os cálculos são realizados.

## Como Rodar

1. Clone este repositório para sua máquina local:
   ```bash
   git clone https://github.com/MVHespanholo/AppCalculadoraKotlin
2. **Abra o projeto no Android Studio.**
3. **Conecte um dispositivo Android ou inicie um emulador.**
4. **Clique em "Run"** para compilar e rodar o aplicativo.
   
