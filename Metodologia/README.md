<p align="center">
  <img width="200" height="200" alt="Foto de Luiz Gustavo" src="https://github.com/user-attachments/assets/7b5e680e-c4c8-44ee-88ff-6d9d1793ff79" />
</p>

<h1 align="center">Luiz Gustavo dos Santos Oliveira</h1>

<p align="center">
  <a href="https://www.linkedin.com/in/luiz-gustavo-oliveira09/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"></a>
  <a href="https://github.com/oliveiraluizgustavo"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" alt="GitHub"></a>
</p>

<p align="center"><b>Engenheiro Mecatrônico | Estudante de Banco de Dados</b></p>

## Sobre mim

Sou formado em Engenharia Mecatrônica e atualmente estudo Banco de Dados na Fatec Professor Jessen Vidal. O aprofundamento em lógica e sistemas que tive na engenharia me mostrou uma oportunidade de transição de carreira para a área de dados. Também tenho sólida experiência na área comercial, em vendas, que me deu base em comunicação, entendimento do cliente e capacidade de lidar com desafios.

Ao longo do curso, percebi que tenho aptidão para a área de UI/UX, que tem chamado cada vez mais a minha atenção, pois gosto de criar soluções que atraiam as pessoas para o produto. Por isso, busco seguir esse caminho em conjunto com banco de dados. Neste ano, estagiei em suporte técnico de TI, atuando no atendimento inicial a usuários, na resolução de incidentes, na gestão de chamados e no controle do inventário de ativos. Foi uma experiência que reforçou a resolução de problemas, habilidade que a engenharia também me proporcionou.

### Tecnologias em aperfeiçoamento

- Java e Spring Boot
- MySQL
- JavaScript, HTML e CSS
- Git e GitHub
- UI/UX

## API Projetos

### 3º Semestre - 01/2026

<div align="center">
<img width="300" alt="Logo do IPEM" src="https://github.com/user-attachments/assets/cda133b9-37e6-42f0-9451-f1e7a9636539" />
</div>

### Empresa: [IPEM - Instituto de Pesos e Medidas](https://www.ipem.sp.gov.br/ipem)

### Repositório: [FLOWTRACK](https://github.com/LizardsDBA/API-2026-3)

### Desafio:
O projeto propõe o desenvolvimento de uma aplicação web para gerenciar e analisar os abastecimentos da frota do IPEM, Regional de São José dos Campos. Hoje, o controle é feito em pranchetas de papel deixadas dentro das viaturas, onde os técnicos anotam à mão a quilometragem, os litros, o valor pago e o número da nota fiscal. Esse modelo torna trabalhosa a consolidação mensal, impede comparar o desempenho entre os veículos e dificulta o acompanhamento do consumo médio.

### Solução
A solução proposta leva esse processo para o ambiente digital. O sistema permite registrar abastecimentos e controlar a saída e o retorno de cada viatura, guardando o histórico de quilometragem e consumo. Também reúne o cadastro de viaturas e usuários, emite avisos de manutenção preventiva conforme a quilometragem rodada e apresenta indicadores e relatórios consolidados. Com isso, a regional ganha organização e rastreabilidade no acompanhamento da frota, e os dados ficam prontos para serem lançados no SGI.

#### Contribuições pessoais e técnicas no projeto FlowTrack

**Git / GitHub**
- Trabalhei com branches por task, commits no padrão do grupo (com o ID do Jira), Pull Requests, merges e atualização de branch com pull e checkout (main e sprint-2).
- Corrigi pontos apontados na revisão com commits fix no mesmo PR e reabri um PR que havia sido fechado.
- Abri Pull Request seguindo o fluxo do grupo e usei o terminal (git checkout, git rebase, git push, git log), além do IntelliJ.
- Resolvi conflito de merge no schema.sql durante a atualização do projeto.
- Resolvi conflito de merge no VehicleUsageService ao trazer as atualizações da sprint para a minha task, mantendo as alterações do colega e as minhas.
- Reconectei a autenticação do GitHub quando o push falhou.
- Separei o que ia em cada commit, deixando o application.properties (credenciais locais) fora do commit para não expor dados sensíveis.

**SQL / MySQL**
- Criei o schema.sql do FlowTrack, adaptado do projeto de referência (IPEM), com tabelas, chaves primárias e estrangeiras, tipos e restrições.
- Criei o banco no MySQL Workbench, conectei-o ao IntelliJ e corrigi erros de sintaxe do script que impediam a criação das tabelas.
- Sincronizei meu banco local com ALTER TABLE e CREATE TABLE no Workbench (colunas categoria_cnh e categoria_cnh_minima, tabela service_type e chave estrangeira em maintenance).
- Corrigi o erro de ADD COLUMN IF NOT EXISTS, que o MySQL 8 não suporta, e o erro de CREATE DATABASE duplicado, usando IF NOT EXISTS.
- Adicionei as colunas de controle de alertas na tabela maintenance (alert_sent, urgent_alert_sent, alert_read, urgent_alert_read) e a coluna destination em vehicle_usage, sincronizando meu banco local com o schema.sql.
- Diagnostiquei no Workbench, com consultas SELECT, por que as manutenções não apareciam, e entendi que o DataInitializer recria os dados a cada reinicialização.
- Adicionei a tabela maintenance_notification ao schema, com colunas de controle (id, maintenance_id, vehicle_id, type, message, is_read, created_at) e suas chaves estrangeiras.
- Corrigi o erro de foreign key no DataInitializer, identificando a ordem correta de deleção das tabelas e garantindo que as notificações fossem apagadas antes das manutenções.

**Java / Spring Boot**
- Atuei no back-end migrando para o FlowTrack as camadas de Usuário e Viatura: entities, repositories, services, controllers e DTOs, com injeção de dependência por construtor.
- Criei o DataInitializer para popular os usuários padrão e resolvi erros de dependência e de dialeto do Hibernate na versão 4.0.4 do Spring Boot.
- Implementei o cálculo automático da quilometragem percorrida (kmPercorrido = kmChegada - kmSaida) na resposta de uso de viatura.
- Criei o módulo de manutenção com as entities Maintenance e ServiceType (JPA com @ManyToOne), repositories com query JPQL de filtros opcionais e paginação, e o MaintenanceService com a regra de criar o tipo de serviço automaticamente quando ele ainda não existe (autocomplete).
- Identifiquei que o DataInitializer não limpava as tabelas maintenance e service_type antes das viaturas, o que gerava erro de chave estrangeira ao reiniciar o projeto, e preparei a correção.
- Implementei o sistema de alertas de manutenção preventiva: aviso aos 90% do intervalo até a próxima manutenção (calculada a partir do KM no registro) e aviso de urgência quando o KM atual ultrapassa o KM da próxima manutenção, com logs no console (@Slf4j).
- Integrei a verificação automática nos serviços de abastecimento, uso de viatura e viatura, disparada sempre que um novo KM é registrado.
- Adicionei os novos campos de alerta na entity Maintenance com valores padrão, uma query JPQL para buscar as manutenções preventivas por viatura e o record MaintenanceAlertResponse para retornar os dados.
- Corrigi o erro de compilação no toResponse do VehicleUsageService ao incluir o campo destination adicionado por um colega, e analisei o erro Unknown column do Hibernate causado por coluna ausente no banco.
- Implementei o sistema completo de notificações persistentes: entidade MaintenanceNotification, repositório com queries de busca por lidas e não lidas, NotificationService (salvar, listar, marcar como lida e marcar todas como lidas) e NotificationController com os endpoints REST correspondentes.
- Integrei o disparo automático de notificações ao MaintenanceService, salvando no banco cada vez que um alerta ou urgência é acionado pelo checkMaintenanceAlerts, com controle de duplicatas.
- Atualizei o DataInitializer para incluir o novo repositório na ordem correta de limpeza.

**APIs REST**
- Implementei os endpoints de CRUD de usuários e viaturas e o endpoint de autenticação (AuthController), validando o fluxo de login pelo front-end.
- Criei o MaintenanceController com listagem filtrada e paginada, POST, PUT, DELETE e endpoint de tipos de serviço para o autocomplete.
- Validei pelo DevTools (aba Rede) que a API retornava kmPercorrido e testei pela tela a regra de KM de chegada maior que o de saída.
- Criei o endpoint GET /api/maintenance/alerts/{vehicleId} para consultar o estado dos alertas de uma viatura (threshold, KM atual e flags de aviso), testando-o pelo navegador.
- Criei e validei quatro endpoints de notificações: GET /api/notifications, GET /api/notifications/unread, PATCH /api/notifications/{id}/read e PATCH /api/notifications/read-all.
- Testei via Workbench e confirmei o salvamento correto no banco ao disparar alertas.

**Front-end (HTML / JavaScript)**
- Criei o módulo de manutenção seguindo o padrão do módulo de abastecimento, com listagem, filtros, paginação, modal de registro e edição e campo com sugestões para o tipo de serviço.
- Adicionei "Manutenção" no menu do admin e do técnico e depurei erros de sintaxe pelo Console do navegador.
- Corrigi o campo de autocomplete "Tipo de Serviço" do modal de manutenção, que sobrepunha os outros campos, reorganizando o layout do formulário e extraindo a montagem do HTML para uma função única, eliminando duplicação de código.
- Implementei a verificação de quilometragem no modal: ao selecionar a viatura, o sistema busca e exibe o último KM, e o campo "KM Próxima Manutenção" é calculado automaticamente a partir do KM no registro somado ao intervalo informado (campo novo "Intervalo de KM").
- Refatorei o carregamento do sininho para uma única requisição ao endpoint /api/notifications/unread, substituindo o loop por viatura anterior.
- Criei a tela "Central de Avisos" com listagem separada entre não lidos e lidos, visual diferenciado por tipo (Atenção/Urgente), botão "Marcar todos como lidos" e redirecionamento para a tela de Manutenção já filtrada pelo prefixo da viatura ao clicar em um aviso.
- Adicionei o item "Central de Avisos" no menu lateral exclusivo para admins e ajustei o espaçamento do menu para caber todos os itens sem scroll.
- Implementei o bloqueio dos campos "Data Chegada" e "KM Chegada" no modal de edição de uso de viatura quando o status está em aberto, com label indicativo ao usuário.
- Adicionei validação para que o KM de chegada não seja menor que o KM de saída, com aviso inline vermelho no campo e toast de erro no envio, impedindo o salvamento indevido.

**Metodologia ágil (Jira)**
- Acompanhei as tasks da sprint no Jira e analisei o burndown, identificando que a falta de story points nas subtasks causava o padrão "escada" no gráfico.
- Analisei as diretrizes do cliente (registro de uso de viatura, categoria de CNH e fluxo de manutenção) e confirmei o escopo antes de implementar.
- Defini com o time as regras de negócio dos alertas (percentual de 90%, aviso de urgência, fluxos em que o KM é verificado e onde armazenar os dados) antes de implementar.
- Respeitei a divisão de escopo entre tasks, deixando os alertas visuais do front-end para outra task.

### Desenvolvimento Pessoal

Este projeto contribuiu para o meu desenvolvimento técnico e para a minha atuação em equipe. No back-end, aprofundei meus conhecimentos em Java e Spring Boot ao implementar módulos completos, como manutenção e notificações, com regras de negócio próprias, a exemplo dos alertas preventivos por quilometragem. No front-end, evoluí ao criar telas, modais e validações integradas à API. Em banco de dados, passei a enxergar o schema como parte viva do sistema: mantive o modelo sincronizado com as mudanças do time e aprendi a diagnosticar problemas como chaves estrangeiras e colunas ausentes. Também ganhei mais domínio do Git e do GitHub, lidando com conflitos de merge e organizando o trabalho em tarefas.

No aspecto pessoal e profissional, o desafio exigiu comunicação constante e alinhamentos frequentes com a equipe, principalmente para definir regras de negócio antes de implementá-las e para respeitar a divisão de escopo entre tarefas. Isso fortaleceu minha comunicação e a forma como analiso um problema antes de colocá-lo em prática. 

### Soft skills

-  Comunicação
-  Trabalho em equipe
-  Pensamento analítico
-  Resolução de problemas

### Hard Skills

- **Java / Spring Boot:** sei fazer com ajuda
- **MySQL:** sei fazer com autonomia
- **JavaScript, HTML e CSS:** sei fazer com ajuda
- **Git / GitHub:** sei fazer com autonomia

### Tecnologias Utilizadas

- **Java 21 e Spring Boot 4:** base do back-end, organizado em camadas (entity, repository, service e controller) com as regras de negócio, como alertas de manutenção e verificação dos abastecimentos.
- **Spring Data JPA / Hibernate e Spring Validation:** acesso ao banco por mapeamento objeto-relacional, com consultas filtradas e paginadas, e validação dos dados recebidos.
- **MySQL:** banco de dados relacional, com modelagem e script de criação (schema.sql).
- **API REST:** comunicação entre front-end e back-end, com endpoints de login, cadastros, abastecimentos, manutenção e notificações.
- **JavaScript, HTML e CSS:** interface do usuário, com telas, modais, filtros, validações, tema claro e escuro e layout adaptável.
- **Chart.js:** gráficos do dashboard.
- **OpenLayers, Nominatim, OSRM e Google Maps:** mapa de destinos, geocodificação dos endereços e traçado de rotas a partir da sede.
- **ViaCEP e AwesomeAPI:** preenchimento automático de endereço a partir do CEP.
- **Spring Mail (SMTP Gmail):** envio de e-mail de boas-vindas aos novos usuários.
- **Maven:** gerenciamento de dependências e build do projeto.
- **Git, GitHub e Jira:** controle de versão, trabalho em equipe e acompanhamento das sprints.
- **Ferramentas de apoio:** IntelliJ IDEA, MySQL Workbench e Lombok.

## Experiência profissional

**Engelmig | Estagiário Suporte Técnico | Fev/2026 – Ago/2026** 

- **Suporte Nível 1:** Atendimento inicial a usuários e resolução de incidentes de baixa 
complexidade.
- **Gestão de Ativos:** Controle, atualização e organização do inventário de hardware e 
ativos de TI.
- **Gestão de Chamados:** Registro e acompanhamento de atendimentos e atualização 
da base de ativos.
- **Suporte a Sistemas:** Orientação a usuários e suporte aos sistemas internos para 
continuidade operacional.

