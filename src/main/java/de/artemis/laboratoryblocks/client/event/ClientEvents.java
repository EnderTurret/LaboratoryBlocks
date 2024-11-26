package de.artemis.laboratoryblocks.client.event;

import de.artemis.laboratoryblocks.LaboratoryBlocks;
import de.artemis.laboratoryblocks.common.registration.ModKeyBindings;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@EventBusSubscriber(modid = LaboratoryBlocks.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientEvents {

    @SubscribeEvent
    public static void onRegisterKeyMappingEvent(RegisterKeyMappingsEvent event) {
        event.register(ModKeyBindings.REMOVE_REDSTONE_CONFIGURATION_TOOL_ACTION);
        event.register(ModKeyBindings.REMOVE_GLOWSTONE_CONFIGURATION_TOOL_ACTION);
        event.register(ModKeyBindings.SHOW_INFORMATION);
    }
}
