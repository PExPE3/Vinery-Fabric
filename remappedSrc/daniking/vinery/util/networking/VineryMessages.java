package daniking.vinery.util.networking;

import daniking.vinery.VineryIdentifier;
import daniking.vinery.util.networking.packet.ItemStackSyncS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.resources.ResourceLocation;

public class VineryMessages {

    public static final ResourceLocation ITEM_SYNC = new VineryIdentifier("item_sync");

    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC, ItemStackSyncS2CPacket::receive);
    }

}
