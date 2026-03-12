# Engenharia de Software

Repositório criado para inserção de atividades solicitadas em classe pelo professor Bertoti, da disciplina de Engenharia de Software.

## 1° ATIVIDADE -  Texto: Software engineering at google trecho 1

O texto mostra bem a diferença entre programar e realmente fazer engenharia de software. Diferentemente das demais engenharias, a Engenharia de Software é algo que produz muito, que esta presente em praticamente tudo do nosso dia a dia, porém é algo que não podemos tocar, algo intangível, dando uma complexidade a mais ao engenheiro. Por ser um código, isso traz uma dificuldade do engenheiro explicar seus custos e necessidades. Por isso, programar é escrever código, mas engenharia de software envolve pensar em todo o processo, na qualidade, na confiabilidade e na manutenção do que é feito. Eu concordo com a ideia de que o software deveria ser tratado com mais rigor, como acontece em outras engenharias, já que hoje ele tem um papel essencial em quase tudo. Também faz sentido o Google ter uma visão própria sobre isso, porque eles lidam com sistemas enormes e precisaram criar métodos mais sólidos para garantir que tudo funcione bem.

## 2° ATIVIDADE -  Texto: Software engineering at google trecho 2

### . Escala
Este princípio trata da evolução do software ao longo de seu ciclo de vida. A engenharia de software é vista como "programação integrada ao longo do tempo", focando em criar um código sustentável. O desafio é garantir que o software possa se adaptar a mudanças inevitáveis, como novos requisitos, atualizações ou correções, sem se tornar obsoleto ou impossível de manter.

### . Tempo  
Este princípio foca em como a organização e seus processos se adaptam ao crescimento. Não se refere apenas a mais usuários, mas ao aumento da complexidade e do tamanho da própria equipe de engenharia. As práticas e ferramentas precisam evoluir para que a organização consiga gerenciar sua base de código de forma eficaz à medida que a empresa cresça.

### . Tradeoffs 
Este princípio aborda o processo de tomada de decisão, que deve considerar as lições de Tempo e Escala. É impossível otimizar tudo; é preciso fazer escolhas conscientes. Por exemplo, uma solução rápida hoje (Tempo) pode não funcionar bem quando a equipe crescer (Escala). Trata-se de entender e equilibrar os custos e benefícios de cada decisão.

## 3° ATIVIDADE -  Exemplos de tradeoffs:

### Segurança vs. Estabilidade

Segurança e estabilidade são dois requisitos não funcionais que muitas vezes entram em conflito. Quando buscamos que um sistema seja altamente seguro, normalmente precisamos aplicar atualizações e patches constantes, implementar regras de acesso rigorosas e adicionar camadas de verificação, o que pode introduzir novos bugs ou conflitos que afetam o funcionamento. Por outro lado, manter o sistema estável, muitas vezes evitando mudanças bruscas para garantir a confiabilidade, facilita a operação previsível e contínua, mas pode limitar a proteção contra ameaças recentes, deixando-o vulnerável. Então, o trade-off está em encontrar um equilíbrio, implementando as atualizações de segurança necessárias, mas com um processo de teste e validação que garanta que a estabilidade do sistema não seja comprometida.


### Escalabilidade vs. Simplicidade

Escalabilidade e simplicidade são dois requisitos não funcionais que muitas vezes entram em conflito. Quando buscamos que um sistema seja altamente escalável, normalmente precisamos usar arquiteturas mais complexas, com várias camadas, servidores e ferramentas para lidar com grandes volumes de dados ou usuários. Por outro lado, manter o sistema simples facilita o entendimento, a manutenção e o desenvolvimento, mas pode limitar o crescimento no futuro. Então, o trade-off está em encontrar um equilíbrio, deixar o sistema simples o suficiente para ser prático no início, mas planejado para poder escalar quando for necessário.


### Portabilidade vs. Desempenho

Portabilidade e desempenho também costumam gerar um trade-off. Quando buscamos alta portabilidade, queremos que o software funcione bem em diferentes sistemas operacionais ou dispositivos, o que geralmente exige o uso de linguagens e bibliotecas mais genéricas. Isso pode reduzir o desempenho, já que o código não aproveita totalmente os recursos específicos de cada plataforma. Por outro lado, otimizar o desempenho pode exigir soluções mais específicas, que acabam limitando a portabilidade. Por isso, é preciso decidir o que é mais importante para o projeto, ter um sistema rápido em um ambiente específico ou ter um software que rode bem em vários lugares, mesmo que com um pouco menos de performance.

## 4° ATIVIDADE - Classes UML

<td><img src="https://github.com/oliveiraluizgustavo/bertoti/blob/main/EngenhariaDeSoftware/Docs/Assets/Diagrama_UML.png"></td>

## 5° ATIVIDADE - Java

### Estrutura do projeto

<td><img src="https://github.com/oliveiraluizgustavo/bertoti/blob/main/EngenhariaDeSoftware/Docs/Assets/EstruturaDasClasses.png"></td>

### Classe Hospital

<img width="489" height="414" alt="ClasseHospital" src="https://github.com/user-attachments/assets/758d9e2d-63cd-4dc8-ae0d-db4ec0af53f6" />


### Classe Paciente

<td><img src="https://github.com/oliveiraluizgustavo/bertoti/blob/main/EngenhariaDeSoftware/Docs/Assets/ClassePaciente.png"></td>

### Classe Medico

<td><img src="https://github.com/oliveiraluizgustavo/bertoti/blob/main/EngenhariaDeSoftware/Docs/Assets/ClasseMedico.png"></td>

## 6° ATIVIDADE - Testes automatizados

<td><img src="https://github.com/oliveiraluizgustavo/bertoti/blob/main/EngenhariaDeSoftware/Docs/Assets/ClasseTeste01.png"></td>
<td><img src="https://github.com/oliveiraluizgustavo/bertoti/blob/main/EngenhariaDeSoftware/Docs/Assets/ClasseTeste02.png"></td>
<td><img src="https://github.com/oliveiraluizgustavo/bertoti/blob/main/EngenhariaDeSoftware/Docs/Assets/ClasseTeste03.png"></td>

## 7° ATIVIDADE - Java -> SQLite

<td><img src="https://github.com/oliveiraluizgustavo/bertoti/blob/main/EngenhariaDeSoftware/Docs/Assets/ClasseDeConexaoComBancoDeDados01.png"></td>
<td><img src="https://github.com/oliveiraluizgustavo/bertoti/blob/main/EngenhariaDeSoftware/Docs/Assets/ClasseDeConexaoComBancoDeDados02.png"></td>
<td><img src="https://github.com/oliveiraluizgustavo/bertoti/blob/main/EngenhariaDeSoftware/Docs/Assets/ClasseDeConexaoComBancoDeDados03.png"></td>

## 8° ATIVIDADE - Usar ollama4j

<img width="705" height="533" alt="Atividade08Ollama" src="https://github.com/user-attachments/assets/c09c0c6f-f9a6-4594-bfd1-6b2bd39e767c" />

