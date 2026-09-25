<div align="center">
  <img src="src/main/resources/assets/pokeenchanter/icon.png" width="180" height="180" alt="PokeEnchanter Logo">

  # PokeEnchanter-Cobblemon

  [![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-107C41?style=for-the-badge&logo=minecraft&logoColor=white)](https://minecraft.net)
  [![Mod Loader](https://img.shields.io/badge/Mod_Loader-Fabric-1B1A1E?style=for-the-badge&logo=fabric&logoColor=white)](https://fabricmc.net)
  [![Requirement](https://img.shields.io/badge/Requisito-Cobblemon-EE3E3D?style=for-the-badge)](https://cobblemon.com)
  [![License](https://img.shields.io/badge/Licen%C3%A7a-CC0--1.0-blue?style=for-the-badge)](https://creativecommons.org/publicdomain/zero/1.0/)

  *Uma mecânica de recompensa mágica e imprevisível integrada ao ecossistema Cobblemon.*

</div>

---

## Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Comparativo de Versões](#comparativo-de-versões-branches)
- [Mods Recomendados](#mods-recomendados-combo-caótico)
- [Instruções de Compilação](#instruções-de-compilação)
- [Instalação e Uso](#instalação-e-uso)
- [Licença](#licença)

---

## Sobre o Projeto

O **PokeEnchanter-Cobblemon** é um mod desenvolvido para **Minecraft 1.21.1 (Fabric)** que introduz um sistema dinâmico de sorteio e encantamento ao ecossistema do Cobblemon. 

Ao derrotar um Pokémon em uma batalha oficial, o sistema ativa uma roleta aleatória que seleciona um item válido no inventário do jogador e aplica um encantamento sorteado no momento da vitória.

---

## Critical Performance Note (Anti-Crash)

> [!IMPORTANT]
> As of **Version 1.2.0+**, the maximum enchantment limit for the Chaotic Edition is hard-capped at **255**.

### Technical Context
Minecraft's internal physics and calculation engines (specifically for attributes like **Knockback**, **Punch**, and **Sharpness**) cannot process enchantment levels in the millions during combat calculations. Attacking an entity with extreme values forces the server into an unrecoverable processing loop, triggering a `java.lang.ArithmeticException` or `java.lang.OutOfMemoryError: Java heap space` crash.

Capping all chaotic random enchantments at **255** maintains an overpowered gameplay experience while ensuring complete server stability and zero memory exhaustion.

---

## Comparativo de Versões (Branches)

O repositório está dividido em duas ramificações principais com regras e mecânicas distintas. Escolha a versão adequada ao seu perfil de jogo:

| Ramificação | Foco de Gameplay | Comportamento de Encantamento | Uso Recomendado |
| :--- | :--- | :--- | :--- |
| **`main`** | **Balanceada** | Respeita estritamente os limites padrão do Minecraft Vanilla (ex: Afiação I–V, Remendo I). | Servidores de sobrevivência, modpacks equilibrados e estilo vanilla+. |
| **`levelbreak`** | **Caótica** | Isenta de limites do Java, aplicando encantamentos de **nível 1 até 2.147.483.647**. | Testes de desempenho, mapas casuais e modos de jogo focados em poder extremo. |

---

## Mods Recomendados (Combo Caótico)

Para a melhor experiência na versão **`levelbreak`**, recomenda-se a utilização combinada dos seguintes mods Fabric (disponíveis no CurseForge e Modrinth):

| Mod | Função e Necessidade |
| :--- | :--- |
| **EnchantmentLevelBreak** | **Obrigatório.** Permite que o jogo processe níveis de encantamento superiores a V sem redefinir atributos. |
| **Fixed Anvil Repair Cost** | **Recomendado.** Remove o limite de custo de experiência na bigorna, prevenindo a mensagem "Muito Caro!". |
| **Universal Enchants** | **Recomendado.** Flexibiliza restrições de encantamentos entre categorias de itens diferentes (ex: arcos em espadas). |
| **Enchantment Descriptions** | **Opcional.** Exibe descrições informativas sobre os atributos de cada encantamento na interface do item. |

---

## Instruções de Compilação

Para clonar o repositório e compilar o projeto localmente gerando o artefato `.jar`, certifique-se de possuir o **JDK 21** instalado e configurado no ambiente.

### 1. Seleção de Branch
```bash
# Para a versão balanceada:
git checkout main

# Para a versão caótica:
git checkout levelbreak
```

### 2. Compilação via Gradle

**Windows (PowerShell ou CMD):**
```cmd
.\gradlew.bat clean build
```

**Linux / macOS:**
```bash
./gradlew clean build
```

O arquivo final `.jar` será gerado no seguinte diretório:
```text
build/libs/pokeenchanter-1.0.0.jar
```

---

## Instalação e Uso

1. Faça o download do artefato `.jar` já compilado na seção de **Releases** ou compile-o manualmente.
2. Certifique-se de que o **Fabric API** e o **Cobblemon** estejam presentes na pasta de mods do jogo.
3. Copie o arquivo `pokeenchanter-1.0.0.jar` para o diretório de mods correspondente ao seu sistema operacional:
   - **Windows:** `%appdata%\.minecraft\mods`
   - **Linux:** `~/.minecraft/mods`
   - **macOS:** `~/Library/Application Support/minecraft/mods`
4. Inicie o cliente no perfil Fabric referente à versão `1.21.1`.

---

## Licença

Este projeto está licenciado sob os termos da [CC0-1.0 Universal (Domínio Público)](https://creativecommons.org/publicdomain/zero/1.0/). Você possui total liberdade para utilizar, modificar e redistribuir este código fonte em modpacks ou projetos derivados sem restrições.
