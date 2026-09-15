<div align="center">
  <img src="src/main/resources/assets/pokeenchanter/icon.png" width="256" height="256" alt="PokeEnchanter Logo">
</div>

# 🔮 PokeEnchanter-Cobblemon

> [!NOTE]
> **Versão do Minecraft:** `1.21.1`

> [!IMPORTANT]
> **Mod Loader:** `Fabric`

> [!TIP]
> **Requisito Obrigatório:** `Cobblemon`

---


Um mod autêntico para **Minecraft 1.21.1 (Fabric)** que adiciona uma mecânica de recompensa mágica e imprevisível ao ecossistema do **Cobblemon**. Toda vez que você derrotar um Pokémon em uma batalha oficial, a roleta divina será ativada, selecionando um item válido do seu inventário e aplicando um encantamento completamente aleatório!

---

## 🌿 Escolha a sua Versão (Branches)

Este projeto foi estruturado de forma profissional e possui duas ramificações independentes na aba de branches do GitHub. Escolha a que melhor se adapta ao seu estilo de jogo:

### 1. Versão Balanceada (`main`)
* **O que faz:** Respeita rigorosamente os limites nativos do Minecraft Vanilla (ex: sorteia Sharpness do nível I ao V, ou Mending I).
* **Indicado para:** Gameplay de sobrevivência tradicional, servidores survival dedicados e modpacks balanceados.

### 2. Versão Caótica (`levelbreak`)
* **O que faz:** Remove todas as amarras de nível do Java, permitindo que a roleta sorteie e aplique encantamentos absurdos que vão **do nível 1 até o limite de 2 Bilhões (2.147.483.647)**.
* **Indicado para:** Diversão pura, testes extremos e mapas focados em apelação total.

---

## ⚡ O Combo Perfeito (Mods Recomendados)

Se você optar por jogar na versão **Caótica (`levelbreak`)**, é altamente recomendado colocar estes mods adicionais (disponíveis para Fabric 1.21.1 no CurseForge) na sua pasta de jogos para abrir a porteira do caos na bigorna:

* **EnchantmentLevelBreak:** Obrigatório para fazer o Minecraft aceitar e processar os níveis acima de 5 sem rebaixar o item ou quebrar os atributos.
* **Fixed Anvil Repair Cost:** Remove o limite oculto de uso da bigorna, congelando o custo de experiência e impedindo que o jogo exiba o aviso de "Muito Caro!". Permite modificar o mesmo item infinitas vezes.
* **Universal Enchants:** Altera as regras de restrição do jogo, permitindo que encantamentos de arco funcionem em espadas ou picaretas, tornando a gameplay totalmente imprevisível.
* **Enchantment Descriptions:** Adiciona uma janela de texto explicativa abaixo de cada item para você entender o que as novas magias desconhecidas fazem.

---

## 🚀 Como Compilar o Mod do Zero

Se você quiser clonar este repositório e gerar o arquivo `.jar` no seu computador utilizando o VS Code, certifique-se de ter o **JDK 21** instalado e siga os comandos abaixo no terminal:

```bash
# 1. Escolha a ramificação desejada
git checkout main         # Para a versão balanceada
# OU
git checkout levelbreak   # Para a versão caótica

# 2. Limpe os caches e compile o projeto
.\gradlew clean build
```

O arquivo compilado final estará pronto para uso dentro do diretório:
📁 `build/libs/pokeenchanter-1.0.0.jar`

---

## 🎮 Como Instalar e Jogar

1. Baixe ou compile o arquivo `.jar` correspondente à versão desejada.
2. Certifique-se de ter o **Fabric API** e o **Cobblemon** instalados na sua pasta de mods.
3. Copie o arquivo `pokeenchanter-1.0.0.jar` e cole-o no diretório:
   `%appdata%\.minecraft\mods`
4. Inicie o jogo pelo launcher no perfil do Fabric 1.21.1 e divirta-se!

---

## 🪪 Licença

Este projeto está sob a licença **CC0-1.0 (Domínio Público)**. Você é totalmente livre para usar, modificar, distribuir ou adicionar este código em seus próprios modpacks sem restrições!
