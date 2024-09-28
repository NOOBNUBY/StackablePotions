package com.noobnuby.fabric.mixin

import net.minecraft.item.Item
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.ModifyVariable
import org.spongepowered.asm.mixin.injection.Slice

@Mixin(Item.Settings::class)
class MixinPotions {
	@ModifyVariable(
		method = ["maxCount"],
		at = At(value = "HEAD"),
		argsOnly = true,
		slice = Slice(
			from = At(value = "NEW", target = "Lnet/minecraft/item/PotionItem;")
		)
	)
	private fun maxCount(old: Int): Int {
		return Int.MAX_VALUE
	}
}