# Ollama Chat (Eclipse-ready Maven project)

**O que tem aqui**
- Aplicação JavaFX que conversa com o Ollama via `http://localhost:11434/api/chat`.
- Interface em estilo "chat moderno" com bolhas; tema azul-bebê.
- Projeto Maven pronto para importar no Eclipse: `File -> Import -> Existing Maven Projects`.

**Como usar**
1. Tenha Java 17 instalado.
2. Tenha o Ollama rodando localmente em `http://localhost:11434`.
3. Importe o projeto no Eclipse como *Existing Maven Project*.
4. Rode `MainApp` ou `mvn javafx:run`.

**Observações**
- A comunicação com o Ollama usa o mesmo JSON/endpoint do seu colega.
- Arquivos importantes: `src/main/java/com/example/ollama/app/*` e `src/main/resources/com/example/ollama/app/*`.
