package daniking.vinery.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class WinemakerArmorItem extends ArmorItem {
	public WinemakerArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
		super(material, slot, settings);
	}

//	@Override
//	public void appendTooltip(ItemStack stack, @Nullable World world, @NotNull List<Text> tooltip, TooltipContext context) {
//		PlayerEntity player = MinecraftClient.getInstance().player;
//		if (player == null) return;
//		ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
//		ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
//		ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
//		ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
//		tooltip.add(Text.of(""));
//		tooltip.add(Text.of(Formatting.AQUA + I18n.translate("vinery.tooltip.winemaker_armor")));
//		tooltip.add(Text.of((helmet != null && helmet.getItem() instanceof WinemakerArmorItem ? Formatting.GREEN.toString() : Formatting.GRAY.toString()) + "- [" + ObjectRegistry.STRAW_HAT.getName().getString() + "]"));
//		tooltip.add(Text.of((chestplate != null && chestplate.getItem() instanceof WinemakerArmorItem ? Formatting.GREEN.toString() : Formatting.GRAY.toString()) + "- [" + ObjectRegistry.VINEMAKER_APRON.getName().getString() + "]"));
//		tooltip.add(Text.of((leggings != null && leggings.getItem() instanceof WinemakerArmorItem ? Formatting.GREEN.toString() : Formatting.GRAY.toString()) + "- [" + ObjectRegistry.VINEMAKER_LEGGINGS.getName().getString() + "]"));
//		tooltip.add(Text.of((boots != null && boots.getItem() instanceof WinemakerArmorItem ? Formatting.GREEN.toString() : Formatting.GRAY.toString()) + "- [" + ObjectRegistry.VINEMAKER_BOOTS.getName().getString() + "]"));
//		tooltip.add(Text.of(""));
//		tooltip.add(Text.of(Formatting.GRAY + I18n.translate("vinery.tooltip.winemaker_armor2")));
//		tooltip.add(Text.of(Formatting.GRAY + I18n.translate("vinery.tooltip.winemaker_armor3")));
//	}
}