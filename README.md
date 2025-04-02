# Sistema Integrado de Gestão para Carinicultura

## 1. Arquitetura do Sistema

### 1.1 Visão Geral

O sistema é estruturado de forma modular, com interfaces intuitivas e banco de dados relacional para armazenamento das informações. A arquitetura é composta por módulos interconectados que compartilham informações entre si.

```mermaid
flowchart TD
    A[Sistema de Gestão Carinicultura] --> B[Módulo Produção]
    A --> C[Módulo Estoque]
    A --> D[Módulo Financeiro]
    A --> E[Módulo Comercial]
    A --> F[Módulo Relatórios]
    
    B --> G[Cadastros]
    C --> G
    D --> G
    E --> G
    F --> G
    
    B --> H[Controles]
    C --> H
    D --> H
    E --> H
    F --> H
    
    D --> I[Vendas]
    E --> I
    F --> I
    
    B --> J[RH]
    D --> J
    F --> J
    
    B --> K[Regulatório]
    F --> K
```

### 1.2 Banco de Dados

Estrutura relacional com as seguintes entidades principais:

```mermaid
erDiagram
    TANQUES ||--o{ CICLOS_PRODUCAO : possui
    CICLOS_PRODUCAO ||--o{ MONITORAMENTO : contem
    CICLOS_PRODUCAO ||--o{ ALIMENTACAO : registra
    TANQUES ||--o{ VENDAS : gera
    VENDAS }|--|| CLIENTES : atende
    ALIMENTACAO }o--|| INSUMOS : utiliza
    ALIMENTACAO }|--|| DESPESAS : gera
```

## 2. Módulos do Sistema

### 2.1 Módulo de Produção

#### 2.1.1 Gestão de Tanques/Viveiros
- Cadastro de tanques com especificações técnicas
- Histórico de uso de cada tanque
- Status atual (ativo, em manutenção, em preparação)
- Capacidade e dimensões

#### 2.1.2 Ciclos de Produção
- Registro de ciclos por tanque
- Data de início e previsão de término
- Densidade de estocagem
- Origem das pós-larvas/juvenis
- Quantidade inicial

#### 2.1.3 Monitoramento de Parâmetros
- Registro diário de parâmetros de qualidade da água
  - pH
  - Oxigênio dissolvido
  - Temperatura
  - Salinidade
  - Amônia
  - Nitrito
- Alertas para parâmetros fora do ideal
- Visualização gráfica de tendências

```mermaid
graph LR
    A[Tanque] --> B[Ciclo de Produção]
    B --> C[Monitoramento]
    C -->|Alerta| D[Parâmetros Críticos]
    C -->|Histórico| E[Gráficos e Tendências]
    B --> F[Alimentação]
    F --> G[Conversão Alimentar]
```

#### 2.1.4 Manejo Alimentar
- Planejamento de arraçoamento
- Registro de alimentação (tipo, quantidade, frequência)
- Cálculo automático da taxa de conversão alimentar
- Ajustes baseados no crescimento observado

#### 2.1.5 Saúde e Biossegurança
- Registro de ocorrências sanitárias
- Protocolo de tratamentos
- Histórico de doenças por tanque
- Medidas preventivas aplicadas

### 2.2 Módulo de Estoque

#### 2.2.1 Insumos
- Cadastro de todos os insumos (ração, produtos químicos, medicamentos)
- Controle de lotes e validade
- Histórico de entrada/saída
- Ponto de reposição e estoque mínimo

#### 2.2.2 Equipamentos
- Cadastro de equipamentos (aeradores, bombas, medidores)
- Histórico de manutenção
- Status de funcionamento
- Programação de manutenções preventivas

#### 2.2.3 Produto Final
- Controle de estoque de camarões para venda
- Classificação por tamanho/categoria
- Rastreabilidade (tanque de origem, ciclo)
- Histórico de processamento

### 2.3 Módulo Financeiro

```mermaid
flowchart TD
    A[Módulo Financeiro] --> B[Despesas]
    A --> C[Receitas]
    A --> D[Fluxo de Caixa]
    A --> E[Custo de Produção]
    
    B --> F[Fornecedores]
    B --> G[Categorias de Despesas]
    C --> H[Vendas]
    C --> I[Previsão de Receitas]
    D --> J[Conciliação]
    D --> K[Projeções]
    E --> L[Cálculo por kg]
    E --> M[Margem de Contribuição]
    E --> N[Ponto de Equilíbrio]
```

#### 2.3.1 Despesas
- Cadastro de fornecedores
- Registro de despesas fixas e variáveis
- Categorização (ração, energia, mão de obra, etc.)
- Previsão de despesas por ciclo

#### 2.3.2 Receitas
- Registro de vendas
- Categorização por cliente/tipo de produto
- Previsão de receitas

#### 2.3.3 Fluxo de Caixa
- Projeção para os próximos ciclos
- Conciliação entre receitas e despesas
- Relatórios de desempenho financeiro

#### 2.3.4 Custo de Produção
- Cálculo do custo por quilo produzido
- Análise de margem de contribuição
- Ponto de equilíbrio por ciclo

### 2.4 Módulo Comercial

#### 2.4.1 Clientes
- Cadastro completo de clientes
- Histórico de compras
- Preferências (tamanho, quantidade, frequência)
- Classificação (restaurantes, distribuidores, varejo)

#### 2.4.2 Vendas
- Registro de pedidos
- Emissão de notas fiscais
- Programação de entregas
- Condições de pagamento

#### 2.4.3 Marketing
- Registro de ações promocionais
- Avaliação de efetividade
- Gestão de relacionamento com clientes

### 2.5 Módulo de Recursos Humanos

#### 2.5.1 Funcionários
- Cadastro de funcionários
- Funções e responsabilidades
- Escalas de trabalho
- Registro de horas trabalhadas

#### 2.5.2 Capacitação
- Registro de treinamentos
- Controle de certificações
- Planejamento de capacitações necessárias

### 2.6 Módulo Regulatório

#### 2.6.1 Licenças
- Cadastro de licenças e autorizações
- Controle de validades
- Alertas para renovação
- Armazenamento de documentos digitalizados

#### 2.6.2 Certificações
- Registro de certificações de qualidade
- Procedimentos para conformidade
- Auditorias e inspeções

### 2.7 Módulo de Relatórios e Indicadores

```mermaid
flowchart LR
    A[Dashboard Gerencial] --> B[Indicadores-Chave]
    A --> C[Status Atual]
    A --> D[Alertas]
    
    E[Relatórios Operacionais] --> F[Produtividade]
    E --> G[Taxa Conversão]
    E --> H[Taxa Sobrevivência]
    E --> I[Crescimento Semanal]
    
    J[Relatórios Financeiros] --> K[Rentabilidade]
    J --> L[Comparativos]
    J --> M[Projeções]
```

#### 2.7.1 Dashboard Gerencial
- Visão consolidada de indicadores-chave
- Status atual da produção
- Alertas e notificações importantes

#### 2.7.2 Relatórios Operacionais
- Produtividade por tanque
- Taxa de conversão alimentar
- Taxa de sobrevivência
- Crescimento semanal

#### 2.7.3 Relatórios Financeiros
- Rentabilidade por ciclo
- Custos comparativos
- Projeções de resultado

## 3. Interfaces do Sistema

### 3.1 Interface Principal
- Dashboard com visão geral do negócio
- Acesso rápido a todas as funcionalidades
- Alertas e notificações

### 3.2 Interface Mobile
- Aplicativo para registro de dados em campo
- Monitoramento remoto de parâmetros
- Alertas em tempo real

### 3.3 Interface de Relatórios
- Geração de relatórios customizados
- Exportação em diversos formatos
- Visualização gráfica de indicadores

## 4. Implementação e Requisitos Técnicos

```mermaid
graph TD
    A[Sistema] --> B[Backend: Java/Spring Boot]
    A --> C[Frontend: Angular]
    A --> D[Banco de Dados: PostgreSQL]
    
    B --> E[API RESTful]
    C --> E
    E --> D
    
    B --> F[Autenticação JWT]
    B --> G[Validação de Dados]
    
    C --> H[Componentes Reutilizáveis]
    C --> I[Gráficos e Visualizações]
```

### 4.1 Requisitos de Hardware
- Servidor local ou solução em nuvem
- Dispositivos móveis para coleta de dados em campo
- Sensores automatizados para monitoramento (opcional)

### 4.2 Requisitos de Software
- Sistema operacional: Windows ou Linux
- Banco de dados: PostgreSQL
- Backend: Java com Spring Boot
- Frontend: Angular

### 4.3 Segurança
- Controle de acesso por usuário
- Backup diário automático
- Registro de logs de operação

## 5. Plano de Implementação

### 5.1 Fases de Implementação
```mermaid
gantt
    title Fases de Implementação
    dateFormat YYYY-MM-DD
    
    section Fase 1
    Módulos de Produção e Estoque    :2023-01-01, 3M
    
    section Fase 2
    Módulos Financeiro e Comercial   :after Fase 1, 3M
    
    section Fase 3
    Módulos de RH e Regulatório      :after Fase 2, 2M
    
    section Fase 4
    Relatórios e Integrações         :after Fase 3, 2M
```

### 5.2 Treinamento
- Capacitação inicial da equipe
- Materiais de referência (manuais)
- Suporte contínuo

## 6. Classe de Domínio

```mermaid
classDiagram
    class Tanque {
        +Integer id
        +String nome
        +double capacidade
        +String localizacao
        +String especieCultura
    }
    
    class CicloProducao {
        +Integer id
        +Tanque tanque
        +LocalDate dataInicio
        +LocalDate dataFim
        +double quantidadePescado
        +double racaoGasta
        +double calcularFCA()
    }
    
    class RegistroQualidadeAgua {
        +Integer id
        +Tanque tanque
        +double amonia
        +double nitrito
        +double salinidade
        +double turbidez
        +double temperatura
        +double ph
        +double oxigenacao
        +LocalDate data
    }
    
    class Alimentacao {
        +Integer id
        +CicloProducao cicloProducao
        +LocalDate data
        +LocalTime horario
        +String tipoRacao
        +double quantidade
        +String observacao
    }
    
    class Venda {
        +Integer id
        +Tanque tanque
        +double quantidadePescado
        +double valorTotal
        +LocalDate data
    }
    
    class Compra {
        +Integer id
        +String descricao
        +double valor
        +LocalDate data
        +TipoCompra tipo
    }
    
    Tanque "1" -- "many" CicloProducao : possui
    Tanque "1" -- "many" RegistroQualidadeAgua : monitora
    CicloProducao "1" -- "many" Alimentacao : registra
    Tanque "1" -- "many" Venda : produz
```

## 7. Evolução Futura do Sistema

### 7.1 Integrações Potenciais
- Sistemas de automação para monitoramento
- Plataformas de comércio eletrônico
- Sistemas contábeis
- Aplicativos de previsão climática

### 7.2 Funcionalidades Avançadas
- Modelo preditivo de crescimento
- Otimização de arraçoamento baseada em IA
- Previsão de demanda
- Rastreabilidade completa para o consumidor final

```mermaid
graph LR
    A[Sistema Atual] --> B[Automação]
    A --> C[E-commerce]
    A --> D[Sistemas Contábeis]
    A --> E[Previsão Climática]
    
    A --> F[IA para Crescimento]
    A --> G[IA para Arraçoamento]
    A --> H[Previsão de Demanda]
    A --> I[Rastreabilidade]
```

## 8. Arquitetura de Software

```mermaid
flowchart TD
    subgraph "Camada de Apresentação"
        A[Angular Web App]
        B[Mobile App]
    end
    
    subgraph "Camada de Aplicação"
        C[Controllers]
        D[Services]
        E[DTOs]
    end
    
    subgraph "Camada de Domínio"
        F[Models]
        G[Business Logic]
    end
    
    subgraph "Camada de Persistência"
        H[Repositories]
        I[Database]
    end
    
    A --> C
    B --> C
    C --> D
    D --> F
    D --> G
    F --> H
    G --> H
    H --> I
```
