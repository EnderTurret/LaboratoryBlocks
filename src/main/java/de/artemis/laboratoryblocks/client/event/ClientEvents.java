package de.artemis.laboratoryblocks.client.event;

import de.artemis.laboratoryblocks.LaboratoryBlocks;
import de.artemis.laboratoryblocks.common.registration.ModKeyBindings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LaboratoryBlocks.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {

    @SubscribeEvent
    public static void onRegisterKeyMappingEvent(RegisterKeyMappingsEvent event) {
        event.register(ModKeyBindings.REMOVE_REDSTONE_CONFIGURATION_TOOL_ACTION);
        event.register(ModKeyBindings.REMOVE_GLOWSTONE_CONFIGURATION_TOOL_ACTION);
        event.register(ModKeyBindings.SHOW_INFORMATION);
    }
}
