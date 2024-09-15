# WeatherAPP

O **WeatherAPP** é um aplicativo Java que permite obter e exibir informações climáticas em tempo real para qualquer cidade do mundo. Utiliza a [WeatherAPI](https://www.weatherapi.com/) para obter dados sobre temperatura, umidade, condição do tempo e mais.

## Funcionalidades

- **Consulta de Dados Climáticos**: Permite ao usuário inserir o nome de uma cidade e obter informações atualizadas sobre o clima.
- **Interface de Linha de Comando**: O aplicativo interage com o usuário através do terminal, pedindo o nome da cidade e exibindo os dados climáticos.
- **Configuração Simples**: Utiliza um arquivo de configuração `config.properties` para armazenar a chave da API de forma segura.

## Pré-requisitos

Antes de executar o projeto, você precisa configurar o ambiente:

1. **Java**: Certifique-se de ter o JDK 17 ou superior instalado em sua máquina.
2. **Maven**: É necessário para gerenciar dependências e construir o projeto.
3. **Configuração da API**: Adicione sua chave da API da WeatherAPI ao arquivo `config.properties`.

## Instalação
1. **Clone o Repositório**

   ```bash
   git clone https://github.com/HigorPereira10/WeatherAPP.git

2. **Acesse o Diretório do Projeto**

   Após clonar o repositório, entre no diretório do projeto com o seguinte comando:

   ```bash
   cd WeatherAPP

3. **Adicione a Chave da API**

   Crie um arquivo chamado `config.properties` no diretório raiz do projeto com o seguinte conteúdo:

   ```properties
   api_key=YOUR_API_KEY
   Substitua YOUR_API_KEY pela sua chave da WeatherAPI.

4. **Compile e Execute**

   Compile o projeto usando Maven:

   ```bash
   mvn clean install

5. **Execute o Aplicativo**

   Após compilar o projeto, você pode executar o aplicativo com o seguinte comando Maven:

   ```bash
   mvn exec:java -Dexec.mainClass="com.projeto.weatherapp.WeatherApp"


  ## Estrutura do Projeto

- `src/main/java`: Contém o código-fonte do projeto.
- `src/main/resources`: Contém arquivos de configuração e outros recursos.
- `src/test/java`: Contém classes de teste (atualmente vazias).

  ## Contribuição

Sinta-se à vontade para contribuir com o projeto. Se você encontrar algum problema ou tiver sugestões de melhorias, abra um issue ou envie um pull request.

## Licença

Distribuído sob a Licença Apache 2.0. Veja [LICENSE](LICENSE) para mais detalhes.
