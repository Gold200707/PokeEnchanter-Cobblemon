package name.modid;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Random;

public class PokeEnchanter implements ModInitializer {
    public static final String MOD_ID = "pokeenchanter";
    private final Random random = new Random();
    private static MinecraftServer serverInstance = null;

    @Override
    public void onInitialize() {
        // Captura a instância ativa do servidor de forma nativa do Minecraft (nunca quebra)
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            serverInstance = server;
        });

        // Conecta ao canal de eventos do Cobblemon por reflexão de forma 100% dinâmica
        try {
            Class<?> cobblemonEventsClass = Class.forName("com.cobblemon.mod.common.api.events.CobblemonEvents");
            java.lang.reflect.Field battleVictoryField = cobblemonEventsClass.getField("BATTLE_VICTORY");
            Object battleVictoryEventChannel = battleVictoryField.get(null);

            Method subscribeMethod = battleVictoryEventChannel.getClass().getMethod("subscribe", java.util.function.Consumer.class);

            subscribeMethod.invoke(battleVictoryEventChannel, (java.util.function.Consumer<Object>) (event) -> {
                if (serverInstance == null) return;
                try {
                    Method getWinnersMethod = event.getClass().getMethod("getWinners");
                    Collection<?> winners = (Collection<?>) getWinnersMethod.invoke(event);

                    for (Object winner : winners) {
                        Method getPlayerUUIDsMethod = winner.getClass().getMethod("getPlayerUUIDs");
                        Collection<UUID> uuids = (Collection<UUID>) getPlayerUUIDsMethod.invoke(winner);

                        for (UUID uuid : uuids) {
                            ServerPlayer serverPlayer = serverInstance.getPlayerList().getPlayer(uuid);
                            if (serverPlayer != null) {
                                aplicarEncantamentoAleatorio(serverPlayer);
                            }
                        }
                    }
                } catch (Exception e) {
                    // Ignora se alguma versão do Cobblemon alterar sutilmente a lógica interna da vitória
                }
            });
        } catch (Exception e) {
            System.out.println("[PokeEnchanter] Erro ao se conectar dinamicamente ao Cobblemon.");
        }
    }

    private void aplicarEncantamentoAleatorio(ServerPlayer player) {
        NonNullList<ItemStack> mainInventory = player.getInventory().items;
        List<ItemStack> itensValidos = new ArrayList<>();

        for (ItemStack item : mainInventory) {
            if (!item.isEmpty()) {
                itensValidos.add(item);
            }
        }

        if (itensValidos.isEmpty()) return;

        ItemStack itemSorteado = itensValidos.get(random.nextInt(itensValidos.size()));
        
        // Puxa o registro oficial de encantamentos do Minecraft 1.21.1 utilizando a chave correta
        var registroEncantamentos = player.registryAccess().registryOrThrow(Registries.ENCHANTMENT);
        List<Holder.Reference<Enchantment>> listaEncantamentos = registroEncantamentos.holders().toList();

        if (listaEncantamentos.isEmpty()) return;
        
        var encantamentoSorteado = listaEncantamentos.get(random.nextInt(listaEncantamentos.size()));

        // VERSÃO CAÓTICA: Sorteia níveis absurdos entre 1 e 2 Bilhões (Compatível com o EnchantmentLevelBreak)
        int nivelMinimo = 1;
        int nivelMaximoAbsoluto = 2147483647; 
        int nivelSorteado = random.nextInt(nivelMaximoAbsoluto) + nivelMinimo;

        itemSorteado.enchant(encantamentoSorteado, nivelSorteado);


        player.sendSystemMessage(net.minecraft.network.chat.Component.literal("§6[PokeEnchanter] §aVocê derrotou um Pokémon e um item do seu inventário foi encantado magicamente!"));
    }
}
