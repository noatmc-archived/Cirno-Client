/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.features.module.modules.combat

import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction
import net.ccbluex.liquidbounce.event.AttackEvent
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.UpdateEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.value.IntegerValue

@ModuleInfo(name = "BlockHit", description = "BlockHit", category = ModuleCategory.COMBAT)
class BlockHit : Module() {

    @EventTarget
    fun onAttack(event: AttackEvent) {
        mc.gameSettings.keyBindUseItem.pressed = true
    }
    fun onUpdate(event: UpdateEvent) {
        if (mc.gameSettings.keyBindUseItem.pressed) {
            mc.gameSettings.keyBindUseItem.pressed = false
        }
    }

}